package com.csstudios.developers.theultimatestressreliever;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import java.util.Arrays;
import java.lang.String;

public class AdviceActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);

        // Media players for advice (One for each recording)
        final MediaPlayer adviceSound = MediaPlayer.create(this, R.raw.advice1);
        final MediaPlayer adviceSound2 = MediaPlayer.create(this, R.raw.advice2);
        final MediaPlayer adviceSound3 = MediaPlayer.create(this, R.raw.advice3);
        final MediaPlayer adviceSound4 = MediaPlayer.create(this, R.raw.advice4);
        final MediaPlayer adviceSound5 = MediaPlayer.create(this, R.raw.advice5);
        final MediaPlayer adviceSound6 = MediaPlayer.create(this, R.raw.advice6);

        final Button adviceButton = (Button) findViewById(R.id.adviceButton);

        //Select advice with spinner
        Spinner spinnerAdvice = (Spinner) findViewById(R.id.spinnerAdvice);
        String[] adviceArray = getResources().getStringArray(R.array.advice);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, Arrays.asList(adviceArray));

        spinnerAdvice.setAdapter(adapter);
        spinnerAdvice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String selectedAdvice = parent.getSelectedItem().toString();
                adviceButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    // Detection of Spinner Selection
                    public void onClick(View v) {
                        // Advice selected, then plays sound and stops all other sounds
                        switch (selectedAdvice) {
                            case "Fun Fact": adviceSound.start();
                                break;
                            case "Random Advice": adviceSound2.start();
                                break;
                            case "Life-changing Advice": adviceSound3.start();
                                break;
                            case "Another Fun Fact": adviceSound4.start();
                                break;
                            case "Did You Know?": adviceSound5.start();
                                break;
                            case "Just One More Thing...": adviceSound6.start();
                                break;
                        }

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Switch Activities
        ImageButton buttonSwitch = (ImageButton) findViewById(R.id.btnSwitch);
        buttonSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainScreen = new Intent(v.getContext(), MainActivity.class);
                startActivity(mainScreen);
            }
        });
    }
}// End of class