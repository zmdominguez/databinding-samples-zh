package dev.zarah.databinding

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import dev.zarah.databinding.databinding.ActivityViewpager2DemoBinding
import dev.zarah.databinding.databinding.ItemSimplePageBinding

class ViewPager2DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityViewpager2DemoBinding>(this, R.layout.activity_viewpager2_demo)
        binding.viewModel = ViewPager2DemoViewModel()
        binding.lifecycleOwner = this

        setupViewPager(binding.viewpager)
    }

    private fun setupViewPager(viewpager: ViewPager2) {
        viewpager.adapter = SimplePagerAdapter()

        /*
        With the BindingAdapter, registering and unregistering the callback is
        taken care of.
        -------
        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.onPageSelected(position)
            }
        })
        */
    }

    class SimplePagerAdapter : RecyclerView.Adapter<SimplePageViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimplePageViewHolder {
            val binding = ItemSimplePageBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false)
            return SimplePageViewHolder(binding)
        }

        override fun onBindViewHolder(holder: SimplePageViewHolder, position: Int) {
            holder.bind(position)
        }

        override fun getItemCount() = PROFILES.size
    }

    class SimplePageViewHolder(val binding: ItemSimplePageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.profile = PROFILES[position]
        }
    }

    class ViewPager2DemoViewModel {
        fun onPageSelected(page: Int) {
            Log.d("ViewPager2 Demo", "Page selected is $page")
        }
    }
}