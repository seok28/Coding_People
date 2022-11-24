package com.example.mobile_programming.Fragment.ListFragment

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import com.example.mobile_programming.R


class VideoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val videoView = findViewById<VideoView>(R.id.videoView)

        videoView.setMediaController(MediaController(this))

//        videoView.setVideoURI(Uri.parse("android.res://"+ packageName + "/"+ R.drawable.li))

    }

}