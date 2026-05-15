package com.nammaskill.app.ui.map

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nammaskill.app.data.model.SkillCenter
import com.nammaskill.app.databinding.ItemCenterBinding

class CenterAdapter(
    private val onCallClick: (SkillCenter) -> Unit
) : ListAdapter<SkillCenter, CenterAdapter.VH>(DiffCB()) {

    inner class VH(private val b: ItemCenterBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(center: SkillCenter) {
            b.tvCenterEmoji.text = center.iconEmoji
            b.tvCenterName.text = center.name
            b.tvCenterAddress.text = center.address
            b.tvCenterDistance.text = "📍 ${center.distanceKm} km away"
            b.tvCenterCourses.text = "${center.activeCourses} active courses"
            b.tvCenterPhone.text = center.phone
            b.btnCallCenter.setOnClickListener { onCallClick(center) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemCenterBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(getItem(position))

    class DiffCB : DiffUtil.ItemCallback<SkillCenter>() {
        override fun areItemsTheSame(a: SkillCenter, b: SkillCenter) = a.id == b.id
        override fun areContentsTheSame(a: SkillCenter, b: SkillCenter) = a == b
    }
}
