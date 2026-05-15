package com.nammaskill.app.ui.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nammaskill.app.R
import com.nammaskill.app.databinding.FragmentCoursesBinding
import com.nammaskill.app.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoursesFragment : Fragment() {
    private var _binding: FragmentCoursesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: CourseAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCoursesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupFilterChips()
        setupDurationFilters()
        setupObservers()
        setupAddCourse()
    }

    private fun setupRecyclerView() {
        adapter = CourseAdapter(
            onCourseClick = { course ->
                viewModel.setCurrentCourse(course)
                findNavController().navigate(R.id.action_courses_to_detail)
            },
            onApplyClick = { course ->
                viewModel.setCurrentCourse(course)
                findNavController().navigate(R.id.action_courses_to_apply)
            }
        )
        binding.rvCourses.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCourses.adapter = adapter
    }

    private fun setupFilterChips() {
        val trades = mapOf(
            binding.chipFilterAll to "All",
            binding.chipFilterElectrical to "Electrical",
            binding.chipFilterWelding to "Welding",
            binding.chipFilterSewing to "Sewing",
            binding.chipFilterCoding to "Coding",
            binding.chipFilterMobile to "Mobile Repair",
            binding.chipFilterPlumbing to "Plumbing",
            binding.chipFilterMechanic to "Mechanic",
            binding.chipFilterBeauty to "Beauty"
        )
        trades.forEach { (chip, trade) ->
            chip.setOnClickListener {
                viewModel.setTradeFilter(trade)
                trades.keys.forEach { it.isChecked = false }
                chip.isChecked = true
            }
        }

        // Sync from ViewModel
        viewModel.selectedTrade.observe(viewLifecycleOwner) { trade ->
            trades.forEach { (chip, t) -> chip.isChecked = t == trade }
        }
    }

    private fun setupDurationFilters() {
        binding.btnDurAll.setOnClickListener { setDuration("all") }
        binding.btnDurShort.setOnClickListener { setDuration("short") }
        binding.btnDurLong.setOnClickListener { setDuration("long") }

        viewModel.selectedDuration.observe(viewLifecycleOwner) { dur ->
            binding.btnDurAll.isSelected = dur == "all"
            binding.btnDurShort.isSelected = dur == "short"
            binding.btnDurLong.isSelected = dur == "long"

            // Update button appearances
            listOf(binding.btnDurAll, binding.btnDurShort, binding.btnDurLong).forEach {
                it.setBackgroundResource(if (it.isSelected) R.drawable.bg_filter_selected else R.drawable.bg_filter_default)
            }
        }
    }

    private fun setDuration(dur: String) {
        viewModel.setDurationFilter(dur)
    }

    private fun setupObservers() {
        viewModel.allCourses.observe(viewLifecycleOwner) { courses ->
            val filtered = viewModel.getFilteredCourses(courses)
            adapter.submitList(filtered)
            binding.tvResultCount.text = "${filtered.size} courses found"
        }
        viewModel.selectedTrade.observe(viewLifecycleOwner) { _ ->
            viewModel.allCourses.value?.let { courses ->
                val filtered = viewModel.getFilteredCourses(courses)
                adapter.submitList(filtered)
                binding.tvResultCount.text = "${filtered.size} courses found"
            }
        }
        viewModel.selectedDuration.observe(viewLifecycleOwner) { _ ->
            viewModel.allCourses.value?.let { courses ->
                val filtered = viewModel.getFilteredCourses(courses)
                adapter.submitList(filtered)
                binding.tvResultCount.text = "${filtered.size} courses found"
            }
        }
    }

    private fun setupAddCourse() {
        binding.fabAddCourse.setOnClickListener {
            findNavController().navigate(R.id.action_courses_to_addCourse)
        }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
