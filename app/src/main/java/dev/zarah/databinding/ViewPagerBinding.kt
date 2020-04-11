/*
 * Copyright (c) 2020 Woolworths. All rights reserved.
 */

package dev.zarah.databinding

import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.ListenerUtil
import androidx.viewpager.widget.ViewPager

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
    viewPager: ViewPager,
    onPageScrollStateChangedListener: OnPageScrollStateChangedListener?,
    onPageScrolledListener: OnPageScrolledListener?,
    onPageSelectedListener: OnPageSelectedListener?
) {
    val onPageChangeListener: ViewPager.OnPageChangeListener?
    if (onPageScrolledListener == null &&
            onPageSelectedListener == null &&
            onPageScrollStateChangedListener == null) {
        onPageChangeListener = null
    } else {
        onPageChangeListener = object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
                onPageScrollStateChangedListener?.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                onPageScrolledListener?.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                onPageSelectedListener?.onPageSelected(position)
            }
        }
    }

    val oldListener = ListenerUtil.trackListener<ViewPager.OnPageChangeListener>(
            viewPager,
            onPageChangeListener,
            R.id.pageChangedListener)

    oldListener?.let { viewPager.removeOnPageChangeListener(oldListener) }
    onPageChangeListener?.let { viewPager.addOnPageChangeListener(it) }
}

interface OnPageScrolledListener {
    fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int)
}

interface OnPageSelectedListener {
    fun onPageSelected(position: Int)
}

interface OnPageScrollStateChangedListener {
    fun onPageScrollStateChanged(state: Int)
}
