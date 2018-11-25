package com.starlabs.instaclone.utils

import android.content.Context
import android.content.Intent
import android.provider.ContactsContract
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import com.starlabs.instaclone.R
import com.starlabs.instaclone.home.HomeActivity
import com.starlabs.instaclone.news.NewsActivity
import com.starlabs.instaclone.profile.ProfileActivity
import com.starlabs.instaclone.search.SearchActivity
import com.starlabs.instaclone.share.ShareActivity


class BottomNavigationViewHelper {
    companion object {
        fun setupBottomNavigationView(bottomNavigationViewEx: BottomNavigationViewEx){
            bottomNavigationViewEx.enableAnimation(false)
            bottomNavigationViewEx.setTextVisibility(false)
            bottomNavigationViewEx.enableItemShiftingMode(false)
            bottomNavigationViewEx.enableShiftingMode(false)
        }

        fun setupNavigation(context:Context, bottomNavigationViewEx: BottomNavigationViewEx){
            bottomNavigationViewEx.onNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener{
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when(item.itemId){
                        R.id.nav_menu_home -> {
                            val intent = Intent(context,HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }
                        R.id.nav_menu_search -> {
                            val intent = Intent(context,SearchActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }
                        R.id.nav_menu_share -> {
                            val intent = Intent(context,ShareActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                        }
                        R.id.nav_menu_news -> {
                            val intent = Intent(context,NewsActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }
                        R.id.nav_menu_profile -> {
                            val intent = Intent(context, ProfileActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }
                    }
                    return false
                }

            }
        }
    }
}