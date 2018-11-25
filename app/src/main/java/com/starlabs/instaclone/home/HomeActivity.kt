package com.starlabs.instaclone.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.starlabs.instaclone.R
import com.starlabs.instaclone.utils.BottomNavigationViewHelper
import com.starlabs.instaclone.utils.HomePagerAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val ACTIVITY_NUMBER = 0
    private val TAG = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupNavigationView()
        setupHomeViewPager()
    }
    private fun setupNavigationView(){
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomNavigationViewHelper.setupNavigation(this,bottomNavigationView)
        var menu = bottomNavigationView.menu
        var menuItem = menu.getItem(ACTIVITY_NUMBER)
        menuItem.setChecked(true)
    }

    private fun setupHomeViewPager(){
        var homePagerAdapter = HomePagerAdapter(supportFragmentManager)
        homePagerAdapter.addFragment(CameraFragment())
        homePagerAdapter.addFragment(HomeFragment())
        homePagerAdapter.addFragment(MessagesFragment())
        homeViewPager.adapter = homePagerAdapter
        homeViewPager.setCurrentItem(1)
    }
}
