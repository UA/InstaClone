package com.starlabs.instaclone.profile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nostra13.universalimageloader.core.ImageLoader
import com.starlabs.instaclone.R
import com.starlabs.instaclone.utils.UniversalImageLoader
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_profile_edit.*
import kotlinx.android.synthetic.main.fragment_profile_edit.view.*

class ProfileEditFragment : Fragment() {

    lateinit var circleProfileImageFragment : CircleImageView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile_edit,container,false)
        circleProfileImageFragment = view.findViewById(R.id.circleProfileImage)
        initImageLoader()

        setupProfilePicture()
        view.imgClose.setOnClickListener {
            activity?.onBackPressed()
        }
        return view
    }

    private fun initImageLoader(){
        var universalImageLoader = UniversalImageLoader(activity!!)
        ImageLoader.getInstance().init(universalImageLoader.config)
    }

    private fun setupProfilePicture() {
        var imageUrl = "static.makeuseof.com/wp-content/uploads/2015/11/perfect-profile-picture-all-about-face.jpg"
        UniversalImageLoader.setImage(imageUrl,circleProfileImageFragment,null,"https://")
    }
}