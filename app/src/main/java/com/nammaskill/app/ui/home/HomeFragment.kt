package com.nammaskill.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nammaskill.app.R
import com.nammaskill.app.data.model.Course
import com.nammaskill.app.databinding.FragmentHomeBinding
import com.nammaskill.app.ui.MainViewModel
import com.nammaskill.app.ui.courses.CourseAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var courseAdapter: CourseAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        courseAdapter = CourseAdapter(
            onCourseClick = { course -> navigateToDetail(course) },
            onApplyClick = { course -> navigateToApply(course) }
        )
        binding.rvUpcomingCourses.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = courseAdapter
            isNestedScrollingEnabled = false
        }
    }

    private fun setupObservers() {
        viewModel.userProfile.observe(viewLifecycleOwner) { profile ->
            if (profile != null && profile.fullName.isNotEmpty()) {
                binding.tvGreeting.text = "Hello, ${profile.fullName.split(" ").first()}! 👋"
                binding.tvDistrict.text = "📍 ${profile.district}"
            }
        }

        viewModel.allCourses.observe(viewLifecycleOwner) { courses ->
            val upcoming = courses.take(4)
            courseAdapter.submitList(upcoming)
            binding.tvActiveCourses.text = courses.size.toString()
        }

        viewModel.allApplications.observe(viewLifecycleOwner) { apps ->
            binding.tvMyApplications.text = apps.size.toString()
        }
    }

    private fun setupClickListeners() {
        binding.btnExploreAll.setOnClickListener {
            findNavController().navigate(R.id.navigation_courses)
        }
        binding.btnViewStories.setOnClickListener {
            findNavController().navigate(R.id.navigation_stories)
        }
        binding.cardStats.setOnClickListener {
            findNavController().navigate(R.id.navigation_courses)
        }
        binding.btnNotifications.setOnClickListener {
            findNavController().navigate(R.id.navigation_profile)
        }
        binding.searchBar.setOnClickListener {
            findNavController().navigate(R.id.navigation_courses)
        }
        // Trade filter chips
        binding.chipAll.setOnClickListener { navigateToCourseWithFilter("All") }
        binding.chipElectrical.setOnClickListener { navigateToCourseWithFilter("Electrical") }
        binding.chipWelding.setOnClickListener { navigateToCourseWithFilter("Welding") }
        binding.chipSewing.setOnClickListener { navigateToCourseWithFilter("Sewing") }
        binding.chipCoding.setOnClickListener { navigateToCourseWithFilter("Coding") }
        binding.chipMobile.setOnClickListener { navigateToCourseWithFilter("Mobile") }
    }

    private fun navigateToCourseWithFilter(trade: String) {
        viewModel.setTradeFilter(trade)
        findNavController().navigate(R.id.navigation_courses)
    }

    private fun navigateToDetail(course: Course) {
        viewModel.setCurrentCourse(course)
        findNavController().navigate(R.id.action_home_to_detail)
    }

    private fun navigateToApply(course: Course) {
        viewModel.setCurrentCourse(course)
        findNavController().navigate(R.id.action_home_to_apply)
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
