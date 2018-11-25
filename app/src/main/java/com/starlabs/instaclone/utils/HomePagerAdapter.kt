package com.starlabs.instaclone.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class HomePagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    private var mFragmentList: ArrayList<Fragment> = ArrayList()
    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment){
        mFragmentList.add(fragment)

    }
}