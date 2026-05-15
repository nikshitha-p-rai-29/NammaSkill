package com.nammaskill.app.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.textfield.TextInputEditText
import com.nammaskill.app.R
import com.nammaskill.app.data.model.UserProfile
import com.nammaskill.app.ui.MainActivity
import com.nammaskill.app.ui.MainViewModel
import com.nammaskill.app.utils.PrefManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserProfileSetupActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile_setup)

        val etName = findViewById<TextInputEditText>(R.id.etFullName)
        val etAge = findViewById<TextInputEditText>(R.id.etAge)
        val etPhone = findViewById<TextInputEditText>(R.id.etPhone)
        val etVillage = findViewById<TextInputEditText>(R.id.etVillage)
        val etAadhaar = findViewById<TextInputEditText>(R.id.etAadhaar)
        val spinnerGender = findViewById<Spinner>(R.id.spinnerGender)
        val spinnerDistrict = findViewById<Spinner>(R.id.spinnerDistrict)
        val spinnerEducation = findViewById<Spinner>(R.id.spinnerEducation)
        val chipGroupTrades = findViewById<ChipGroup>(R.id.chipGroupTrades)
        val btnSave = findViewById<Button>(R.id.btnSaveProfile)
        val tvTitle = findViewById<TextView>(R.id.tvSetupTitle)

        // Gender spinner
        ArrayAdapter.createFromResource(
            this, R.array.genders, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerGender.adapter = adapter
        }

        // District spinner
        ArrayAdapter.createFromResource(
            this, R.array.districts, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerDistrict.adapter = adapter
        }

        // Education spinner
        ArrayAdapter.createFromResource(
            this, R.array.education_levels, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerEducation.adapter = adapter
        }

        // Trade chips
        val trades = listOf("⚡ Electrical", "🔥 Welding", "🧵 Sewing", "💻 Coding",
            "📱 Mobile Repair", "🔧 Plumbing", "🏍️ Mechanic", "💄 Beauty")
        trades.forEach { trade ->
            val chip = Chip(this).apply {
                text = trade
                isCheckable = true
                chipBackgroundColor = getColorStateList(R.color.chip_selector)
                setTextColor(getColorStateList(R.color.chip_text_selector))
            }
            chipGroupTrades.addView(chip)
        }

        // If profile already exists, pre-fill
        viewModel.userProfile.observe(this) { profile ->
            profile?.let {
                if (it.isProfileComplete) {
                    etName.setText(it.fullName)
                    etAge.setText(it.age)
                    etPhone.setText(it.phone)
                    etVillage.setText(it.village)
                    etAadhaar.setText(it.aadhaarLast4)
                    tvTitle.text = "Edit My Profile"
                    btnSave.text = "Update Profile"
                    
                    setSpinnerValue(spinnerGender, R.array.genders, it.gender)
                    setSpinnerValue(spinnerDistrict, R.array.districts, it.district)
                    setSpinnerValue(spinnerEducation, R.array.education_levels, it.education)
                    
                    val preferred = it.preferredTrades.split(",")
                    for (i in 0 until chipGroupTrades.childCount) {
                        val chip = chipGroupTrades.getChildAt(i) as Chip
                        if (preferred.contains(chip.text.toString())) {
                            chip.isChecked = true
                        }
                    }
                }
            }
        }

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val age = etAge.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val village = etVillage.text.toString().trim()
            val aadhaar = etAadhaar.text.toString().trim()

            if (name.isEmpty()) { etName.error = "Name is required"; return@setOnClickListener }
            if (phone.isEmpty() || phone.length < 10) { etPhone.error = "Valid phone required"; return@setOnClickListener }
            if (age.isEmpty()) { etAge.error = "Age is required"; return@setOnClickListener }
            if (village.isEmpty()) { etVillage.error = "Village is required"; return@setOnClickListener }

            // Collect selected trades
            val selectedTrades = mutableListOf<String>()
            for (i in 0 until chipGroupTrades.childCount) {
                val chip = chipGroupTrades.getChildAt(i) as Chip
                if (chip.isChecked) selectedTrades.add(chip.text.toString())
            }

            val profile = UserProfile(
                id = 1,
                fullName = name,
                age = age,
                gender = spinnerGender.selectedItem.toString(),
                phone = phone,
                district = spinnerDistrict.selectedItem.toString(),
                village = village,
                education = spinnerEducation.selectedItem.toString(),
                preferredTrades = selectedTrades.joinToString(","),
                aadhaarLast4 = aadhaar,
                isProfileComplete = true
            )
            viewModel.saveProfile(profile)
            PrefManager(this).setProfileDone()
            
            // If editing, just go back
            if (intent.getBooleanOf("is_edit", false)) {
                finish()
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
    
    private fun setSpinnerValue(spinner: Spinner, arrayResId: Int, value: String) {
        val array = resources.getStringArray(arrayResId)
        val index = array.indexOf(value)
        if (index >= 0) spinner.setSelection(index)
    }
    
    private fun Intent.getBooleanOf(key: String, default: Boolean): Boolean {
        return getBooleanExtra(key, default)
    }
}
