package com.nammaskill.app.data.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nammaskill.app.data.model.Application
import com.nammaskill.app.data.model.Course
import com.nammaskill.app.data.model.SuccessStory
import com.nammaskill.app.data.model.UserProfile

@Dao
interface CourseDao {
    @Query("SELECT * FROM courses WHERE isActive = 1 ORDER BY startDate ASC")
    fun getAllCourses(): LiveData<List<Course>>

    @Query("SELECT * FROM courses WHERE isActive = 1 AND durationType = :type ORDER BY startDate ASC")
    fun getCoursesByDuration(type: String): LiveData<List<Course>>

    @Query("SELECT * FROM courses WHERE isActive = 1 AND trade LIKE '%' || :trade || '%' ORDER BY startDate ASC")
    fun getCoursesByTrade(trade: String): LiveData<List<Course>>

    @Query("SELECT * FROM courses WHERE isActive = 1 AND trade LIKE '%' || :trade || '%' AND durationType = :duration ORDER BY startDate ASC")
    fun getCoursesByTradeAndDuration(trade: String, duration: String): LiveData<List<Course>>

    @Query("SELECT * FROM courses WHERE id = :id")
    suspend fun getCourseById(id: Int): Course?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(courses: List<Course>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: Course)

    @Update
    suspend fun update(course: Course)

    @Delete
    suspend fun delete(course: Course)

    @Query("SELECT COUNT(*) FROM courses WHERE isActive = 1")
    suspend fun getCourseCount(): Int
}

@Dao
interface UserProfileDao {
    @Query("SELECT * FROM user_profile WHERE id = 1")
    fun getProfile(): LiveData<UserProfile?>

    @Query("SELECT * FROM user_profile WHERE id = 1")
    suspend fun getProfileOnce(): UserProfile?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(profile: UserProfile)
}

@Dao
interface ApplicationDao {
    @Query("SELECT * FROM applications ORDER BY id DESC")
    fun getAllApplications(): LiveData<List<Application>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(application: Application)

    @Query("SELECT COUNT(*) FROM applications")
    suspend fun getCount(): Int
}

@Dao
interface StoryDao {
    @Query("SELECT * FROM success_stories ORDER BY id ASC")
    fun getAllStories(): LiveData<List<SuccessStory>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(stories: List<SuccessStory>)

    @Query("SELECT COUNT(*) FROM success_stories")
    suspend fun getCount(): Int
}
