package com.nammaskill.app.utils

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("namma_skill_prefs", Context.MODE_PRIVATE)

    fun isOnboardingDone() = prefs.getBoolean("onboarding_done", false)
    fun setOnboardingDone() = prefs.edit().putBoolean("onboarding_done", true).apply()

    fun isProfileDone() = prefs.getBoolean("profile_done", false)
    fun setProfileDone() = prefs.edit().putBoolean("profile_done", true).apply()

    fun getNotifBatches() = prefs.getBoolean("notif_batches", true)
    fun setNotifBatches(v: Boolean) = prefs.edit().putBoolean("notif_batches", v).apply()

    fun getNotifStatus() = prefs.getBoolean("notif_status", true)
    fun setNotifStatus(v: Boolean) = prefs.edit().putBoolean("notif_status", v).apply()

    fun getNotifJobs() = prefs.getBoolean("notif_jobs", false)
    fun setNotifJobs(v: Boolean) = prefs.edit().putBoolean("notif_jobs", v).apply()
}
