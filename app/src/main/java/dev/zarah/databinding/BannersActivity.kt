package dev.zarah.databinding

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
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
        @DrawableRes val background: Int
    ) {
        INFO(
            "Information",
            R.drawable.banner_info_background
        ),
        WARNING(
            "Warning",
            R.drawable.banner_warning_background
        ),
        ERROR(
            "Error",
            R.drawable.banner_error_background
        )
    }
}
