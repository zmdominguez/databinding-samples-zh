package dev.zarah.databinding

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import dev.zarah.databinding.databinding.ActivityBannersBinding

class StringFormattingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityBannersBinding>(this, R.layout.activity_string_formatting)
        binding.headline = getString(R.string.string_formatting_description)
    }

    data class User()
}