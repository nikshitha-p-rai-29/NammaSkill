package com.nammaskill.app.ui.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nammaskill.app.R
import com.nammaskill.app.data.model.Course
import com.nammaskill.app.databinding.FragmentAddCourseBinding
import com.nammaskill.app.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddCourseFragment : Fragment() {
    private var _binding: FragmentAddCourseBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAddCourseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Trade spinner
        ArrayAdapter.createFromResource(
            requireContext(), R.array.trade_options, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerTrade.adapter = adapter
        }

        // Duration type spinner
        ArrayAdapter.createFromResource(
            requireContext(), R.array.duration_types, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerDurationType.adapter = adapter
        }

        // District spinner
        ArrayAdapter.createFromResource(
            requireContext(), R.array.districts, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerCourseDistrict.adapter = adapter
        }

        binding.btnBack.setOnClickListener { findNavController().popBackStack() }

        binding.btnSaveCourse.setOnClickListener {
            val title = binding.etCourseTitle.text.toString().trim()
            val center = binding.etCenterName.text.toString().trim()
            val duration = binding.etDuration.text.toString().trim()
            val fee = binding.etFee.text.toString().trim()
            val eligibility = binding.etEligibility.text.toString().trim()
            val startDate = binding.etStartDate.text.toString().trim()
            val seats = binding.etSeats.text.toString().trim()
            val desc = binding.etDescription.text.toString().trim()
            val trainerName = binding.etTrainerName.text.toString().trim()
            val trainerPhone = binding.etTrainerPhone.text.toString().trim()
            val address = binding.etCenterAddress.text.toString().trim()
            val language = binding.etLanguage.text.toString().trim().ifEmpty { "Kannada" }
            val syllabusRaw = binding.etSyllabus.text.toString().trim()

            if (title.isEmpty() || center.isEmpty() || duration.isEmpty() || startDate.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val syllabusList = syllabusRaw.split("\n").map { it.trim() }.filter { it.isNotEmpty() }
            val trade = binding.spinnerTrade.selectedItem.toString()
            val durationType = if (binding.spinnerDurationType.selectedItem.toString() == "Short Term (< 6 months)") "short" else "long"
            val district = binding.spinnerCourseDistrict.selectedItem.toString()

            val course = Course(
                title = title,
                centerName = center,
                trade = trade,
                duration = duration,
                durationType = durationType,
                fee = fee.ifEmpty { "Free" },
                eligibility = eligibility.ifEmpty { "Class 8 Pass" },
                startDate = startDate,
                seatsLeft = seats.toIntOrNull() ?: 20,
                totalSeats = seats.toIntOrNull() ?: 20,
                jobGuarantee = "Placement Support",
                language = language,
                description = desc.ifEmpty { "Government certified vocational training course." },
                syllabus = syllabusList.ifEmpty { listOf("Module 1", "Module 2", "Module 3", "Practical Training", "Assessment", "Placement") },
                trainerName = trainerName.ifEmpty { "TBD" },
                trainerPhone = trainerPhone.ifEmpty { "Contact Center" },
                districtName = district,
                centerAddress = address.ifEmpty { district },
                iconEmoji = getEmojiForTrade(trade),
                bannerColor = getColorForTrade(trade)
            )

            viewModel.addCustomCourse(course)
            Toast.makeText(requireContext(), "Course added successfully!", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
    }

    private fun getEmojiForTrade(trade: String) = when {
        trade.contains("Electrical") -> "⚡"
        trade.contains("Welding") -> "🔥"
        trade.contains("Sewing") -> "🧵"
        trade.contains("Coding") -> "💻"
        trade.contains("Mobile") -> "📱"
        trade.contains("Plumbing") -> "🔧"
        trade.contains("Mechanic") -> "🏍️"
        trade.contains("Beauty") -> "💄"
        else -> "🎓"
    }

    private fun getColorForTrade(trade: String) = when {
        trade.contains("Electrical") -> "#FFF8E1"
        trade.contains("Welding") -> "#E8F5E9"
        trade.contains("Sewing") -> "#FCE4EC"
        trade.contains("Coding") -> "#E3F2FD"
        trade.contains("Mobile") -> "#FFF0E5"
        else -> "#F3E5F5"
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
