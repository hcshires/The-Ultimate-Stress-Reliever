package com.csstudios.developers.theultimatestressreliever

import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_advice.*

class AdviceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advice)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        // Media players for advice (One for each recording)
        val adviceSound = MediaPlayer.create(this, R.raw.advice1)
        val adviceSound2 = MediaPlayer.create(this, R.raw.advice2)
        val adviceSound3 = MediaPlayer.create(this, R.raw.advice3)
        val adviceSound4 = MediaPlayer.create(this, R.raw.advice4)
        val adviceSound5 = MediaPlayer.create(this, R.raw.advice5)
        val adviceSound6 = MediaPlayer.create(this, R.raw.advice6)

        // Spinner content (Array from strings.xml)
        val adviceArray = resources.getStringArray(R.array.adviceArray)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, adviceArray)
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        adviceSpinner.adapter = adapter

        // Execute spinner options to sounds
        adviceSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedAdvice = parent?.selectedItem.toString()
                adviceButton.setOnClickListener {
                    when (selectedAdvice) {
                        "Fun Fact" -> adviceSound.start()
                        "Random Advice" -> adviceSound2.start()
                        "Life-changing Advice" -> adviceSound3.start()
                        "Another Fun Fact" -> adviceSound4.start()
                        "Did You Know?" -> adviceSound5.start()
                        "Just One More Thing..." -> adviceSound6.start()
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Set TextView to "select an option" (strings.xml)"
                nothingSelected.text = resources.getString(R.string.nothingSelected)
            }
        }

        // Switch Activities
        activityButton2.setOnClickListener {
            val mainScreen = Intent(activityButton2.context, MainActivity::class.java)
            activityButton2.context.startActivity(mainScreen)
        }
    }
}