package dev.zarah.databinding

import android.os.Bundle
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dev.zarah.databinding.databinding.ActivityBannersBinding

class BannersActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityBannersBinding>(this, R.layout.activity_banners)
    }

    enum class Banner(val label: String,
                      @ColorRes val highlight: Int,
                      @ColorRes val background: Int) {
        INFO("Information", R.color.banner_info_highlight, R.color.banner_info_background),
        WARNING("Warning", R.color.banner_warning_highlight, R.color.banner_warning_background),
        ERROR("Error", R.color.banner_error_highlight, R.color.banner_error_background)
    }
}