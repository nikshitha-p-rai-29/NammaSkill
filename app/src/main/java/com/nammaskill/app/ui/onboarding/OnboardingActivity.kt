package com.nammaskill.app.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.nammaskill.app.R
import com.nammaskill.app.ui.MainActivity
import com.nammaskill.app.utils.PrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

data class OnboardPage(
    val emoji: String,
    val title: String,
    val subtitle: String,
    val bgColor: Int
)

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {

    @Inject lateinit var prefManager: PrefManager

    private val pages = listOf(
        OnboardPage("🎓", "Find Your Skill", "Discover government vocational courses near your village — electrician, welding, coding & more!", 0xFF0D2137.toInt()),
        OnboardPage("📋", "Apply in One Tap", "Fill your basic profile once. Apply to any course with a single tap and get a reference ID instantly.", 0xFF1A3A5C.toInt()),
        OnboardPage("📞", "Get a Callback", "Tap 'Interest Ping' and the trainer will call you back. No complicated forms — it's that simple.", 0xFF00695C.toInt()),
        OnboardPage("⭐", "Real Success Stories", "See how youth from your district got jobs earning ₹15,000–₹25,000/month after a short course.", 0xFF4A148C.toInt())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<com.google.android.material.tabs.TabLayout>(R.id.tabLayout)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnSkip = findViewById<TextView>(R.id.btnSkip)

        viewPager.adapter = OnboardAdapter(pages)

        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == pages.size - 1) {
                    btnNext.text = "Get Started"
                    btnSkip.visibility = View.INVISIBLE
                } else {
                    btnNext.text = "Next"
                    btnSkip.visibility = View.VISIBLE
                }
            }
        })

        btnNext.setOnClickListener {
            if (viewPager.currentItem < pages.size - 1) {
                viewPager.currentItem++
            } else {
                finishOnboarding()
            }
        }

        btnSkip.setOnClickListener { finishOnboarding() }
    }

    private fun finishOnboarding() {
        prefManager.setOnboardingDone()
        startActivity(Intent(this, UserProfileSetupActivity::class.java))
        finish()
    }
}

class OnboardAdapter(private val pages: List<OnboardPage>) :
    RecyclerView.Adapter<OnboardAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val emoji: TextView = view.findViewById(R.id.tvEmoji)
        val title: TextView = view.findViewById(R.id.tvTitle)
        val subtitle: TextView = view.findViewById(R.id.tvSubtitle)
        val root: View = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.item_onboard_page, parent, false))

    override fun getItemCount() = pages.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val page = pages[position]
        holder.emoji.text = page.emoji
        holder.title.text = page.title
        holder.subtitle.text = page.subtitle
        holder.root.setBackgroundColor(page.bgColor)
    }
}
