package com.starlabs.instaclone.profile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.starlabs.instaclone.R
import com.starlabs.instaclone.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    private val ACTIVITY_NUMBER = 4
    private val TAG = "ProfileActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupNavigationView()
        setupToolbar()
    }

    private fun setupToolbar() {
        imgProfileSettings.setOnClickListener{
            var intent = Intent(this,ProfileSettingsActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
        tvProfileEdit.setOnClickListener {
            profileRoot.visibility = View.GONE
            var transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.profileContainer,ProfileEditFragment())
            transaction.addToBackStack("ProfileEdit added")
            transaction.commit()
        }
    }

    fun setupNavigationView(){
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomNavigationViewHelper.setupNavigation(this,bottomNavigationView)
        var menu = bottomNavigationView.menu
        var menuItem = menu.getItem(ACTIVITY_NUMBER)
        menuItem.setChecked(true)
    }

    override fun onBackPressed() {
        profileRoot.visibility = View.VISIBLE
        super.onBackPressed()
    }
}
