package com.starlabs.instaclone.profile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.starlabs.instaclone.R
import com.starlabs.instaclone.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.activity_profile_settings.*

class ProfileSettingsActivity : AppCompatActivity() {
    private val ACTIVITY_NUMBER = 4
    private val TAG = "ProfileSettingsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)
        setupNavigationView()
        setupToolbar()
        fragmentNavigations()
    }

    private fun fragmentNavigations() {
        tvProfileEditAccountSettings.setOnClickListener {
            profileSettingsRoot.visibility = View.GONE
            var transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.profileSettingsContainer,ProfileEditFragment())
            transaction.addToBackStack("ProfileEdit added")
            transaction.commit()
        }
        tvLogOut.setOnClickListener {
            profileSettingsRoot.visibility = View.GONE
            var transaction =  supportFragmentManager.beginTransaction()
            transaction.replace(R.id.profileSettingsContainer,SignOutFragment())
            transaction.addToBackStack("SignOut Added")
            transaction.commit()
        }
    }

    override fun onBackPressed() {
        profileSettingsRoot.visibility = View.VISIBLE
        super.onBackPressed()
    }

    private fun setupToolbar() {
        imgBack.setOnClickListener{
            onBackPressed()
        }
    }

    fun setupNavigationView(){
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomNavigationViewHelper.setupNavigation(this,bottomNavigationView)
        var menu = bottomNavigationView.menu
        var menuItem = menu.getItem(ACTIVITY_NUMBER)
        menuItem.setChecked(true)
    }
}
