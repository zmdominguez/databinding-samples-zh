package dev.zarah.databinding

import androidx.databinding.DataBindingComponent
import coil.ImageLoader

/**
 * Implementation of the generated [DataBindingComponent] that provides the [CircleProfileAvatarBindingAdapter]
 */
class ProfileDataBindingComponent(private val imageLoader: ImageLoader) : DataBindingComponent {
    override fun getProfileAvatarBindingAdapter(): ProfileAvatarBindingAdapter =
        CircleProfileAvatarBindingAdapter(imageLoader)
}