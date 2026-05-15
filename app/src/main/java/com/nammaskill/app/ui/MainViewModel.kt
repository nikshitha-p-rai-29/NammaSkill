package com.nammaskill.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nammaskill.app.data.model.Application as AppModel
import com.nammaskill.app.data.model.Course
import com.nammaskill.app.data.model.SuccessStory
import com.nammaskill.app.data.model.UserProfile
import com.nammaskill.app.data.repository.NammaSkillRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: NammaSkillRepository
) : ViewModel() {

    // Filter state
    private val _selectedTrade = MutableLiveData("All")
    val selectedTrade: LiveData<String> = _selectedTrade

    private val _selectedDuration = MutableLiveData("all")
    val selectedDuration: LiveData<String> = _selectedDuration

    // Data streams
    val allCourses = repo.getAllCourses()
    val allApplications = repo.getAllApplications()
    val allStories = repo.getAllStories()
    val userProfile = repo.getProfile()

    // Current detail course
    private val _currentCourse = MutableLiveData<Course?>()
    val currentCourse: LiveData<Course?> = _currentCourse

    private val _applyResult = MutableLiveData<String?>()
    val applyResult: LiveData<String?> = _applyResult

    private val _pingResult = MutableLiveData<Boolean>()
    val pingResult: LiveData<Boolean> = _pingResult

    init {
        viewModelScope.launch { repo.ensureSeeded() }
    }

    fun setCurrentCourse(course: Course) { _currentCourse.value = course }

    fun setTradeFilter(trade: String) { _selectedTrade.value = trade }

    fun setDurationFilter(dur: String) { _selectedDuration.value = dur }

    fun getFilteredCourses(courses: List<Course>): List<Course> {
        val trade = _selectedTrade.value ?: "All"
        val dur = _selectedDuration.value ?: "all"
        return courses.filter { c ->
            val tradeMatch = trade == "All" || c.trade.contains(trade, ignoreCase = true)
            val durMatch = dur == "all" || c.durationType == dur
            tradeMatch && durMatch
        }
    }

    fun submitApplication(course: Course, profile: UserProfile) {
        viewModelScope.launch {
            val refId = "NS-" + UUID.randomUUID().toString().take(8).uppercase()
            val today = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date())
            val app = AppModel(
                courseId = course.id,
                courseTitle = course.title,
                centerName = course.centerName,
                appliedDate = today,
                status = "Pending",
                referenceId = refId
            )
            repo.submitApplication(app)
            _applyResult.value = refId
        }
    }

    fun clearApplyResult() { _applyResult.value = null }

    fun sendPing() {
        viewModelScope.launch {
            kotlinx.coroutines.delay(800)
            _pingResult.value = true
        }
    }

    fun clearPingResult() { _pingResult.value = false }

    fun saveProfile(profile: UserProfile) {
        viewModelScope.launch { repo.saveProfile(profile) }
    }

    fun addCustomCourse(course: Course) {
        viewModelScope.launch { repo.addCourse(course) }
    }

    fun updateCourse(course: Course) {
        viewModelScope.launch { repo.updateCourse(course) }
    }

    fun deleteCourse(course: Course) {
        viewModelScope.launch { repo.deleteCourse(course) }
    }
}
