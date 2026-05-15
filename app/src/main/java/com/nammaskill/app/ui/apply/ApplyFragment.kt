package com.nammaskill.app.ui.apply

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nammaskill.app.databinding.FragmentApplyBinding
import com.nammaskill.app.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ApplyFragment : Fragment() {
    private var _binding: FragmentApplyBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentApplyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var currentCourse = viewModel.currentCourse.value
        var currentProfile = viewModel.userProfile.value

        viewModel.currentCourse.observe(viewLifecycleOwner) { course ->
            currentCourse = course
            course?.let {
                binding.tvApplyCourseTitle.text = it.title
                binding.tvApplyCenterName.text = it.centerName
                binding.tvApplyStartDate.text = it.startDate
                binding.tvApplyFee.text = it.fee
            }
        }

        viewModel.userProfile.observe(viewLifecycleOwner) { profile ->
            currentProfile = profile
            profile?.let {
                binding.tvApplyName.text = it.fullName
                binding.tvApplyAge.text = "${it.age} years"
                binding.tvApplyPhone.text = it.phone
                binding.tvApplyLocation.text = "${it.village}, ${it.district}"
                binding.tvApplyEducation.text = it.education
                binding.tvApplyGender.text = it.gender
            }
        }

        binding.btnBack.setOnClickListener { findNavController().popBackStack() }

        binding.btnConfirmApply.setOnClickListener {
            val course = currentCourse
            val profile = currentProfile
            if (course != null && profile != null) {
                viewModel.submitApplication(course, profile)
            }
        }

        viewModel.applyResult.observe(viewLifecycleOwner) { refId ->
            if (refId != null) {
                binding.layoutForm.visibility = View.GONE
                binding.layoutSuccess.visibility = View.VISIBLE
                binding.tvRefId.text = "Reference ID: $refId"
                viewModel.clearApplyResult()
            }
        }

        binding.btnDone.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
