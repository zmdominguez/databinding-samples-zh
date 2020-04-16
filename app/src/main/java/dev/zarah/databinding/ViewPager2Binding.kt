package dev.zarah.databinding

import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.ListenerUtil
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

/**
 * Original code from https://gist.github.com/zmdominguez/c809ee4ee8d8b45ea5faa3fee7cb9141
 */
@BindingAdapter(
        value = [
            "onPageScrollStateChanged",
            "onPageScrolled",
            "onPageSelected"],
        requireAll = false)
fun setPageChangeListener(
        viewPager2: ViewPager2,
        onPageScrollStateChangedListener: OnPageScrollStateChangedListener?,
        onPageScrolledListener: OnPageScrolledListener?,
        onPageSelectedListener: OnPageSelectedListener?
) {
    val onPageChangeCallback: ViewPager2.OnPageChangeCallback?

    if (onPageScrolledListener == null &&
            onPageSelectedListener == null &&
            onPageScrollStateChangedListener == null) {
        onPageChangeCallback = null
    } else {
        onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                onPageScrolledListener?.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageScrollStateChanged(state: Int) {
                onPageScrollStateChangedListener?.onPageScrollStateChanged(state)
            }

            override fun onPageSelected(position: Int) {
                onPageSelectedListener?.onPageSelected(position)
            }
        }
    }

    val oldListener = ListenerUtil.trackListener<ViewPager2.OnPageChangeCallback>(
            viewPager2,
            onPageChangeCallback,
            R.id.pageChangeCallback)

    oldListener?.let { viewPager2.unregisterOnPageChangeCallback(oldListener) }
    onPageChangeCallback?.let { viewPager2.registerOnPageChangeCallback(it) }
}
