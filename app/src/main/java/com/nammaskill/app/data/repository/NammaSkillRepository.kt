package com.nammaskill.app.data.repository

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.nammaskill.app.data.model.Application
import com.nammaskill.app.data.model.Course
import com.nammaskill.app.data.model.SuccessStory
import com.nammaskill.app.data.model.UserProfile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NammaSkillRepository @Inject constructor(
    private val db: NammaSkillDatabase,
    private val courseDao: CourseDao,
    private val profileDao: UserProfileDao,
    private val appDao: ApplicationDao,
    private val storyDao: StoryDao,
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
) {
    // Courses
    fun getAllCourses(): LiveData<List<Course>> = courseDao.getAllCourses()

    suspend fun getCourseById(id: Int): Course? = courseDao.getCourseById(id)

    suspend fun addCourse(course: Course) = courseDao.insert(course)

    suspend fun updateCourse(course: Course) = courseDao.update(course)

    suspend fun deleteCourse(course: Course) = courseDao.delete(course)

    // Profile
    fun getProfile(): LiveData<UserProfile?> = profileDao.getProfile()

    suspend fun getProfileOnce(): UserProfile? = profileDao.getProfileOnce()

    suspend fun saveProfile(profile: UserProfile) {
        profileDao.insertOrUpdate(profile)
        // Back up to Firestore if logged in
        auth.currentUser?.uid?.let { uid ->
            try {
                firestore.collection("users").document(uid).set(profile).await()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // Applications
    fun getAllApplications(): LiveData<List<Application>> = appDao.getAllApplications()

    suspend fun submitApplication(application: Application) {
        // Save locally
        appDao.insert(application)
        
        // Save to Firestore if user is logged in
        val userId = auth.currentUser?.uid
        if (userId != null) {
            try {
                firestore.collection("users").document(userId)
                    .collection("applications").document(application.referenceId)
                    .set(application).await()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // Stories
    fun getAllStories(): LiveData<List<SuccessStory>> = storyDao.getAllStories()

    // Firestore Sync
    suspend fun syncCoursesFromFirestore() = withContext(Dispatchers.IO) {
        try {
            val snapshot = firestore.collection("courses").get().await()
            val remoteCourses = snapshot.toObjects(Course::class.java)
            if (remoteCourses.isNotEmpty()) {
                courseDao.insertAll(remoteCourses)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // Seed
    suspend fun ensureSeeded() = withContext(Dispatchers.IO) {
        SeedData.seedDatabase(db)
    }

    fun getCoursesByTrade(trade: String) = courseDao.getCoursesByTrade(trade)
}
