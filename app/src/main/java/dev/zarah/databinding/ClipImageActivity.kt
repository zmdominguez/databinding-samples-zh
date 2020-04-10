package dev.zarah.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dev.zarah.databinding.databinding.ActivityClipImageBinding

class ClipImageActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityClipImageBinding>(this, R.layout.activity_clip_image)
    }
}