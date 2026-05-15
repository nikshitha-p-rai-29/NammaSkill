package com.nammaskill.app.ui.courses

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nammaskill.app.R
import com.nammaskill.app.data.model.Course
import com.nammaskill.app.databinding.ItemCourseCardBinding

class CourseAdapter(
    private val onCourseClick: (Course) -> Unit,
    private val onApplyClick: (Course) -> Unit
) : ListAdapter<Course, CourseAdapter.VH>(DiffCallback()) {

    inner class VH(private val binding: ItemCourseCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(course: Course) {
            binding.tvCourseTitle.text = course.title
            binding.tvCenterName.text = "🏛️ ${course.centerName}"
            binding.tvEmoji.text = course.iconEmoji
            binding.tvDuration.text = "⏱ ${course.duration}"
            binding.tvJobTag.text = "✅ ${course.jobGuarantee}"
            binding.tvSeatsTag.text = "🪑 ${course.seatsLeft} seats left"
            binding.tvLanguage.text = "🗣 ${course.language}"
            binding.tvStartDate.text = "Starts: ${course.startDate}"
            binding.tvFee.text = "Fee: ${course.fee}"

            try {
                binding.cardEmojiBackground.setCardBackgroundColor(Color.parseColor(course.bannerColor))
            } catch (e: Exception) {
                binding.cardEmojiBackground.setCardBackgroundColor(Color.parseColor("#FFF0E5"))
            }

            // Seats urgency indicator
            val seatsPercent = (course.seatsLeft.toFloat() / course.totalSeats) * 100
            binding.progressSeats.progress = seatsPercent.toInt()
            when {
                seatsPercent < 30 -> binding.tvSeatsTag.setTextColor(Color.parseColor("#C62828"))
                seatsPercent < 60 -> binding.tvSeatsTag.setTextColor(Color.parseColor("#FF6B00"))
                else -> binding.tvSeatsTag.setTextColor(Color.parseColor("#2E7D32"))
            }

            binding.root.setOnClickListener { onCourseClick(course) }
            binding.btnApply.setOnClickListener { onApplyClick(course) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemCourseCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(getItem(position))

    class DiffCallback : DiffUtil.ItemCallback<Course>() {
        override fun areItemsTheSame(old: Course, new: Course) = old.id == new.id
        override fun areContentsTheSame(old: Course, new: Course) = old == new
    }
}
