package com.nammaskill.app.ui.apply

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nammaskill.app.data.model.Application
import com.nammaskill.app.databinding.ItemApplicationBinding

class ApplicationAdapter : ListAdapter<Application, ApplicationAdapter.VH>(DiffCB()) {

    inner class VH(private val b: ItemApplicationBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(app: Application) {
            b.tvAppCourse.text = app.courseTitle
            b.tvAppCenter.text = app.centerName
            b.tvAppDate.text = "Applied: ${app.appliedDate}"
            b.tvAppRefId.text = "Ref: ${app.referenceId}"
            b.tvAppStatus.text = app.status
            val color = when (app.status) {
                "Shortlisted" -> 0xFF2E7D32.toInt()
                "Confirmed" -> 0xFF1565C0.toInt()
                "Rejected" -> 0xFFC62828.toInt()
                else -> 0xFFFF6B00.toInt()
            }
            b.tvAppStatus.setTextColor(color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemApplicationBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(getItem(position))

    class DiffCB : DiffUtil.ItemCallback<Application>() {
        override fun areItemsTheSame(a: Application, b: Application) = a.id == b.id
        override fun areContentsTheSame(a: Application, b: Application) = a == b
    }
}
