package com.nammaskill.app.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nammaskill.app.R
import com.nammaskill.app.data.model.Course
import com.nammaskill.app.databinding.FragmentCourseDetailBinding
import com.nammaskill.app.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseDetailFragment : Fragment() {
    private var _binding: FragmentCourseDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCourseDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentCourse.observe(viewLifecycleOwner) { course ->
            course?.let { populateUI(it) }
        }

        binding.btnBack.setOnClickListener { findNavController().popBackStack() }
    }

    private fun populateUI(course: Course) {
        binding.tvDetailTitle.text = course.title
        binding.tvDetailCenter.text = "🏛️ ${course.centerName}"
        binding.tvDetailEmoji.text = course.iconEmoji
        binding.tvDetailDuration.text = course.duration
        binding.tvDetailFee.text = course.fee
        binding.tvDetailStartDate.text = course.startDate
        binding.tvDetailEligibility.text = course.eligibility
        binding.tvDetailJobGuarantee.text = "✅ ${course.jobGuarantee}"
        binding.tvDetailLanguage.text = course.language
        binding.tvDetailDistrict.text = course.districtName
        binding.tvDetailAddress.text = course.centerAddress
        binding.tvDetailTrainer.text = course.trainerName
        binding.tvDetailTrainerPhone.text = course.trainerPhone
        binding.tvDetailDescription.text = course.description
        binding.tvDetailSeats.text = "${course.seatsLeft} of ${course.totalSeats} seats remaining"

        try {
            binding.headerBanner.setBackgroundColor(Color.parseColor(course.bannerColor))
        } catch (e: Exception) {}

        // Syllabus
        binding.llSyllabus.removeAllViews()
        course.syllabus.forEachIndexed { index, item ->
            val tv = TextView(requireContext()).apply {
                text = "  ${index + 1}. $item"
                textSize = 14f
                setPadding(0, 12, 0, 12)
                setTextColor(ContextCompat.getColor(requireContext(), R.color.text_primary))
                setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_dot_teal, 0, 0, 0)
                compoundDrawablePadding = 16
            }
            binding.llSyllabus.addView(tv)
            if (index < course.syllabus.size - 1) {
                val divider = View(requireContext()).apply {
                    layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
                    setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.divider))
                }
                binding.llSyllabus.addView(divider)
            }
        }

        // Buttons
        binding.btnApplyNow.setOnClickListener {
            findNavController().navigate(R.id.action_detail_to_apply)
        }
        binding.btnInterestPing.setOnClickListener {
            findNavController().navigate(R.id.action_detail_to_ping)
        }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
