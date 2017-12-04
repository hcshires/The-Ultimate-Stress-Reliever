package com.csstudios.developers.theultimatestressreliever;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer stressSound = MediaPlayer.create(this, R.raw.laugh);

        Button stressButton = (Button) findViewById(R.id.stressButton);
            stressButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stressSound.start();
                }
            });

        ImageButton btnSwitch = (ImageButton) findViewById(R.id.btnSwitch);
            btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchScreen = new Intent(v.getContext(), AdviceActivity.class);
                    startActivity(switchScreen);
            }
        });

    }
}//End of class