package dev.zarah.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import coil.Coil
import dev.zarah.databinding.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setDefaultComponent(ProfileDataBindingComponent(Coil.loader()))

        val binding =
            DataBindingUtil.setContentView<ActivityProfileBinding>(this, R.layout.activity_profile)
        binding.viewModel = ProfileViewModel()
        binding.lifecycleOwner = this
    }
}