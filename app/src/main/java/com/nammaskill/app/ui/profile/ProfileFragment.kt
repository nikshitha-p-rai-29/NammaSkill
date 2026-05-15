package com.nammaskill.app.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.nammaskill.app.R
import com.nammaskill.app.databinding.FragmentProfileBinding
import com.nammaskill.app.ui.MainViewModel
import com.nammaskill.app.ui.apply.ApplicationAdapter
import com.nammaskill.app.ui.onboarding.LoginActivity
import com.nammaskill.app.utils.PrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    @Inject lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefs = PrefManager(requireContext())

        // Profile data
        viewModel.userProfile.observe(viewLifecycleOwner) { profile ->
            profile?.let {
                binding.tvProfileName.text = it.fullName
                binding.tvProfilePhone.text = it.phone
                binding.tvProfileLocation.text = "${it.village}, ${it.district}"
                binding.tvProfileEducation.text = it.education
                binding.tvProfileGender.text = it.gender
                binding.tvProfileAge.text = "${it.age} years"
                val trades = it.preferredTrades.split(",").filter { t -> t.isNotEmpty() }
                binding.tvPreferredTrades.text = if (trades.isEmpty()) "Not set" else trades.joinToString("  •  ")
            }
        }

        // Applications
        val appAdapter = ApplicationAdapter()
        binding.rvMyApplications.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMyApplications.adapter = appAdapter
        binding.rvMyApplications.isNestedScrollingEnabled = false

        viewModel.allApplications.observe(viewLifecycleOwner) { apps ->
            appAdapter.submitList(apps)
            binding.tvAppCount.text = "${apps.size} Application(s)"
            binding.tvNoApps.visibility = if (apps.isEmpty()) View.VISIBLE else View.GONE
        }

        // Notification toggles
        binding.switchBatchAlerts.isChecked = prefs.getNotifBatches()
        binding.switchStatusAlerts.isChecked = prefs.getNotifStatus()
        binding.switchJobAlerts.isChecked = prefs.getNotifJobs()

        binding.switchBatchAlerts.setOnCheckedChangeListener { _, isChecked -> prefs.setNotifBatches(isChecked) }
        binding.switchStatusAlerts.setOnCheckedChangeListener { _, isChecked -> prefs.setNotifStatus(isChecked) }
        binding.switchJobAlerts.setOnCheckedChangeListener { _, isChecked -> prefs.setNotifJobs(isChecked) }

        // Edit profile
        binding.btnEditProfile.setOnClickListener {
            val bundle = Bundle().apply { putBoolean("is_edit", true) }
            findNavController().navigate(R.id.action_profile_to_editProfile, bundle)
        }

        // Logout
        binding.btnLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
