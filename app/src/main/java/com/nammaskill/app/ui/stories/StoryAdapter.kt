package com.nammaskill.app.ui.stories

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nammaskill.app.data.model.SuccessStory
import com.nammaskill.app.databinding.ItemStoryCardBinding

class StoryAdapter : ListAdapter<SuccessStory, StoryAdapter.VH>(DiffCB()) {

    inner class VH(private val b: ItemStoryCardBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(story: SuccessStory) {
            b.tvStoryEmoji.text = story.iconEmoji
            b.tvStoryName.text = "${story.personName}, ${story.age}"
            b.tvStoryLocation.text = "📍 ${story.location}"
            b.tvStoryQuote.text = "\"${story.quote}\""
            b.tvStoryTrade.text = story.trade
            b.tvStorySalary.text = story.monthlySalary
            b.tvStoryCurrentJob.text = story.currentJob
            try { b.bannerBg.setBackgroundColor(Color.parseColor(story.bannerColor)) } catch (e: Exception) {}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemStoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(getItem(position))

    class DiffCB : DiffUtil.ItemCallback<SuccessStory>() {
        override fun areItemsTheSame(a: SuccessStory, b: SuccessStory) = a.id == b.id
        override fun areContentsTheSame(a: SuccessStory, b: SuccessStory) = a == b
    }
}
