package com.nammaskill.app.ui.apply

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nammaskill.app.databinding.FragmentPingBinding
import com.nammaskill.app.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PingFragment : Fragment() {
    private var _binding: FragmentPingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentCourse.observe(viewLifecycleOwner) { course ->
            course?.let {
                binding.tvPingCourse.text = it.title
                binding.tvPingTrainer.text = it.trainerName
                binding.tvPingTrainerPhone.text = it.trainerPhone
                binding.tvPingCenter.text = it.centerName
            }
        }

        viewModel.userProfile.observe(viewLifecycleOwner) { profile ->
            profile?.let {
                binding.tvPingName.text = it.fullName
                binding.tvPingPhone.text = it.phone
            }
        }

        binding.btnBack.setOnClickListener { findNavController().popBackStack() }

        binding.btnSendPing.setOnClickListener {
            binding.btnSendPing.isEnabled = false
            binding.btnSendPing.text = "Sending..."
            viewModel.sendPing()
        }

        viewModel.pingResult.observe(viewLifecycleOwner) { sent ->
            if (sent) {
                binding.layoutPingForm.visibility = View.GONE
                binding.layoutPingSuccess.visibility = View.VISIBLE
                viewModel.clearPingResult()
            }
        }

        binding.btnPingDone.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
