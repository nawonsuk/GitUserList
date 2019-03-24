package com.mystory.gituserlist.presentation.adapter

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mystory.gituserlist.presentation.activity.MainActivity
import com.squareup.picasso.Picasso
/**
 * MainBindingAdapter
 * @author wsseo
 * @since 2019. 3. 24
 **/
object MainBindingAdapter {
    @BindingAdapter("setViewPagerAdapter")
    @Synchronized @JvmStatic fun setViewPagerAdapter(pager: ViewPager, activity: MainActivity?) {
        activity?.let{
            pager.adapter = MainPagerAdapter(it.supportFragmentManager)
        }
    }
//
//    @BindingAdapter("setTabViewPager")
//    @Synchronized @JvmStatic fun setTabViewPager(tabLayout: TabLayout, pagerView: ViewPager) {
//        tabLayout.setupWithViewPager(pagerView, true)
//    }

    @BindingAdapter("loadImage")
    @Synchronized @JvmStatic fun loadImage(iv:ImageView, url:String?) {
        try {
            url?.let {
                if(it.isNotEmpty()){
                   Picasso.with(iv.context).load(it).into(iv)
                }
            }
        }catch (e:Exception){
            Log.e("loadImage","loadImage Exception")
        }
    }
}