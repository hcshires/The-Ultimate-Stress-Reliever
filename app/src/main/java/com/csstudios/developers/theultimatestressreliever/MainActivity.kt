package com.csstudios.developers.theultimatestressreliever

import android.content.Intent
import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
0

        val stressSound = MediaPlayer.create(this, R.raw.laugh)

        stressButton.setOnClickListener {
            stressSound.start()
        }

        activityButton.setOnClickListener {
            val adviceScreen = Intent(activityButton.context, AdviceActivity::class.java)
            activityButton.context.startActivity(adviceScreen)
        }
    }
}
