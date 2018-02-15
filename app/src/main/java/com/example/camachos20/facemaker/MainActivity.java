package com.example.camachos20.facemaker;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Retrive references to relevant views
        TextView tvRed = (TextView)findViewById(R.id.tvRed);
        TextView tvGreen = (TextView)findViewById(R.id.tvGreen);
        TextView tvBlue = (TextView)findViewById(R.id.tvBlue);

        SeekBar redSeekBar = (SeekBar)findViewById(R.id.seekBarRed);
        SeekBar greenSeekBar = (SeekBar)findViewById(R.id.seekBarGreen);
        SeekBar blueSeekBar = (SeekBar)findViewById(R.id.seekBarBlue);

        RadioGroup myRadioGroup = (RadioGroup)findViewById(R.id.rGroupFeatures);
        Spinner hairSpinner = (Spinner) findViewById(R.id.spinnerHairstyle);
        Button randomButt = (Button)findViewById(R.id.buttRandom);

        //register an instance of listener class with the view
        ListenerClass faceListener = new ListenerClass();

        //Register listener with the button
        randomButt.setOnClickListener(faceListener);

        //Register listener with the seekbars
        redSeekBar.setOnSeekBarChangeListener(faceListener);
        greenSeekBar.setOnSeekBarChangeListener(faceListener);
        blueSeekBar.setOnSeekBarChangeListener(faceListener);

        //Register the listener with the RadioGroup
        myRadioGroup.setOnCheckedChangeListener(faceListener);

        //Register the listener with the spinner
        hairSpinner.setOnItemSelectedListener(faceListener);



    }
}
