package com.mystory.gituserlist.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mystory.gituserlist.presentation.fragment.ApiFragment
import com.mystory.gituserlist.presentation.fragment.LocalFragment

/**
 * MainPagerAdapter
 * @author wsseo
 * @since 2019. 3. 24
 **/
class MainPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    var apiFragment: ApiFragment =
        ApiFragment()
    var localFragment: LocalFragment =
        LocalFragment()
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> apiFragment
            else -> localFragment
        }
    }
    override fun getCount(): Int {
       return 2
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "API"
            else -> "Local"
        }
    }
}