package com.nammaskill.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.nammaskill.app.utils.Converters

@Entity(tableName = "courses")
@TypeConverters(Converters::class)
data class Course(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String = "",
    val centerName: String = "",
    val trade: String = "",
    val duration: String = "",
    val durationType: String = "",      // "short" or "long"
    val fee: String = "",
    val eligibility: String = "",
    val startDate: String = "",
    val seatsLeft: Int = 0,
    val totalSeats: Int = 0,
    val jobGuarantee: String = "",
    val language: String = "",
    val description: String = "",
    val syllabus: List<String> = emptyList(),
    val trainerName: String = "",
    val trainerPhone: String = "",
    val districtName: String = "",
    val centerAddress: String = "",
    val iconEmoji: String = "",
    val bannerColor: String = "",
    val isActive: Boolean = true
)

@Entity(tableName = "user_profile")
data class UserProfile(
    @PrimaryKey val id: Int = 1,
    val fullName: String = "",
    val age: String = "",
    val gender: String = "",
    val phone: String = "",
    val district: String = "",
    val village: String = "",
    val education: String = "",
    val preferredTrades: String = "",   // comma-separated
    val aadhaarLast4: String = "",
    val isProfileComplete: Boolean = false
)

@Entity(tableName = "applications")
data class Application(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val courseId: Int = 0,
    val courseTitle: String = "",
    val centerName: String = "",
    val appliedDate: String = "",
    val status: String = "Pending",   // Pending / Shortlisted / Confirmed / Rejected
    val referenceId: String = ""
)

@Entity(tableName = "success_stories")
data class SuccessStory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val personName: String = "",
    val age: Int = 0,
    val location: String = "",
    val trade: String = "",
    val courseTaken: String = "",
    val currentJob: String = "",
    val monthlySalary: String = "",
    val quote: String = "",
    val iconEmoji: String = "",
    val bannerColor: String = ""
)

data class SkillCenter(
    val id: Int = 0,
    val name: String = "",
    val address: String = "",
    val district: String = "",
    val phone: String = "",
    val activeCourses: Int = 0,
    val distanceKm: Double = 0.0,
    val iconEmoji: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)
