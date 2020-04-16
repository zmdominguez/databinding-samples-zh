package dev.zarah.databinding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dev.zarah.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.handlers = this
    }

    fun launchBanners() {
        startActivity(Intent(this, BannersActivity::class.java))
    }

    fun launchCustomSetter() {
        startActivity(Intent(this, ClipImageActivity::class.java))
    }

    fun launchLiveDataExample() {
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    fun launchStringFormatting() {
        startActivity(Intent(this, StringFormattingActivity::class.java))
    }

    fun launchViewPager2Example() {
        startActivity(Intent(this, ViewPager2DemoActivity::class.java))
    }

    fun launchViewPagerExample() {
        startActivity(Intent(this, ViewPagerDemoActivity::class.java))
    }
}