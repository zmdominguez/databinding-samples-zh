package dev.zarah.databinding

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import dev.zarah.databinding.databinding.ActivityViewpager2DemoBinding
import dev.zarah.databinding.databinding.ActivityViewpagerDemoBinding
import dev.zarah.databinding.databinding.ItemSimplePageBinding

class ViewPagerDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityViewpagerDemoBinding>(this, R.layout.activity_viewpager_demo)
        binding.viewModel = ViewPagerDemoViewModel()
        binding.lifecycleOwner = this

        setupViewPager(binding.viewpager)
    }

    private fun setupViewPager(viewpager: ViewPager) {
        viewpager.adapter = SimplePagerAdapter()

        /*
        With the BindingAdapter, we do not need to write all the "Do nothing"s.
        -------
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                // Do nothing
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // Do nothing
            }

            override fun onPageSelected(position: Int) {
                viewModel.onPageSelected(position)
            }
        })
        */
    }

    class SimplePagerAdapter : PagerAdapter() {
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val pageLayout = ItemSimplePageBinding.inflate(LayoutInflater.from(container.context))
            pageLayout.profile = PROFILES[position]

            val view = pageLayout.root
            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
            container.removeView(view as View)
        }

        override fun isViewFromObject(view: View, obj: Any) = view == obj

        override fun getCount() = PROFILES.size

    }

    class ViewPagerDemoViewModel {
        fun onPageSelected(page: Int) {
            Log.d("ViewPager Demo", "Page selected is $page")
        }
    }
}