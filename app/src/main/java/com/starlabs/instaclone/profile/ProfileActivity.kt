package com.starlabs.instaclone.profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.starlabs.instaclone.R
import com.starlabs.instaclone.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.activity_home.*

class ProfileActivity : AppCompatActivity() {
    private val ACTIVITY_NUMBER = 4
    private val TAG = "ProfileActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        //setupNavigationView()
    }
    fun setupNavigationView(){
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomNavigationViewHelper.setupNavigation(this,bottomNavigationView)
        var menu = bottomNavigationView.menu
        var menuItem = menu.getItem(ACTIVITY_NUMBER)
        menuItem.setChecked(true)
    }
}
