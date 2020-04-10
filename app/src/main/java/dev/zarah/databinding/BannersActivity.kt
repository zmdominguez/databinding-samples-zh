package dev.zarah.databinding

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import dev.zarah.databinding.databinding.ActivityBannersBinding

class BannersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityBannersBinding>(this, R.layout.activity_banners)
        binding.headline =
            "All the UI elements below are not custom views but <include>d layouts. This illustrates how we can " +
                "bind pre-defined values to various components of a reusable widget."
    }

    enum class Banner(
        val label: String,
        @ColorRes val highlight: Int,
        @ColorRes val background: Int
    ) {
        INFO(
            "Information",
            R.color.banner_info_highlight,
            R.color.banner_info_background
        ),
        WARNING(
            "Warning",
            R.color.banner_warning_highlight,
            R.color.banner_warning_background
        ),
        ERROR(
            "Error",
            R.color.banner_error_highlight,
            R.color.banner_error_background
        )
    }
}

@BindingAdapter("bannerHighlight")
fun setBannerHighlight(view: View, banner: BannersActivity.Banner) {
    view.setBackgroundColor(ContextCompat.getColor(view.context, banner.highlight))
}