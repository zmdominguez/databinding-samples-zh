package dev.zarah.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.ImageLoader
import coil.api.load
import coil.transform.CircleCropTransformation

/**
 * Example of a binding adapter without a static implementation.
 */
interface ProfileAvatarBindingAdapter {
    @BindingAdapter("avatar")
    fun bindAvatar(imageView: ImageView, oldProfile: Profile?, newProfile: Profile?)
}

/**
 * A implementation of ProfileBindingAdapter that circle crops the profile image
 */
class CircleProfileAvatarBindingAdapter(private val imageLoader: ImageLoader) :
    ProfileAvatarBindingAdapter {
    override fun bindAvatar(imageView: ImageView, oldProfile: Profile?, newProfile: Profile?) {
        if (oldProfile != newProfile) {
            imageLoader.load(imageView.context, newProfile?.avatarUrl) {
                placeholder(R.drawable.avatar_placeholder_round)
                error(R.drawable.avatar_placeholder_round)
                crossfade(true)
                transformations(CircleCropTransformation())
                target(imageView)
            }
        }
    }
}

class SquareProfileAvatarBindingAdapter(private val imageLoader: ImageLoader) :
    ProfileAvatarBindingAdapter {
    override fun bindAvatar(imageView: ImageView, oldProfile: Profile?, newProfile: Profile?) {
        if (oldProfile != newProfile) {
            imageLoader.load(imageView.context, newProfile?.avatarUrl) {
                placeholder(R.drawable.avatar_placeholder_square)
                error(R.drawable.avatar_placeholder_square)
                target(imageView)
            }
        }
    }
}
