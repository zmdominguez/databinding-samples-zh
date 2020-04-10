package dev.zarah.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.Coil
import coil.api.load
import coil.transform.CircleCropTransformation

object ProfileAvatarBindingAdapter {
    @BindingAdapter("avatar")
    @JvmStatic
    fun bindAvatar(imageView: ImageView, oldProfile: Profile?, newProfile: Profile?) {
        if (oldProfile != newProfile) {
            Coil.load(imageView.context, newProfile?.avatarUrl) {
                placeholder(R.drawable.avatar_placeholder_round)
                error(R.drawable.avatar_placeholder_round)
                crossfade(true)
                transformations(CircleCropTransformation())
                target(imageView)
            }
        }
    }
}
