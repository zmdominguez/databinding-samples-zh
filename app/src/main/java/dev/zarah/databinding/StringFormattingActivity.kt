package dev.zarah.databinding

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import dev.zarah.databinding.databinding.ActivityBannersBinding
import dev.zarah.databinding.databinding.ActivityStringFormattingBinding

class StringFormattingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityStringFormattingBinding>(this, R.layout.activity_string_formatting)
        binding.viewModel = ProfileViewModel()
        binding.lifecycleOwner = this
    }

}