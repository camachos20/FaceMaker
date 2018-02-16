package com.example.camachos20.facemaker;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author Stephanie Camacho
 * Created by Stephanie on 2/11/18.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Face myFace = new Face(this);



        //set up text views, seek bars, and radio group
        TextView tvRed = (TextView)findViewById(R.id.tvRed);
        TextView tvGreen = (TextView)findViewById(R.id.tvGreen);
        TextView tvBlue = (TextView)findViewById(R.id.tvBlue);

        SeekBar redSeekBar = (SeekBar)findViewById(R.id.seekBarRed);
        SeekBar greenSeekBar = (SeekBar)findViewById(R.id.seekBarGreen);
        SeekBar blueSeekBar = (SeekBar)findViewById(R.id.seekBarBlue);


        RadioGroup myRadioGroup = (RadioGroup)findViewById(R.id.rGroupFeatures);
        myRadioGroup.check(myFace.getRadButt());
        if(myFace.getRadButt()==R.id.radButtEyes)
        {
            redSeekBar.setProgress(myFace.getEyeRedVal());
            greenSeekBar.setProgress(myFace.getEyeGreenVal());
            blueSeekBar.setProgress(myFace.getEyeBlueVal());
            
            tvRed.setText("Red: "+myFace.getEyeRedVal());
            tvGreen.setText("Green: "+myFace.getEyeGreenVal());
            tvBlue.setText("Blue: "+myFace.getEyeBlueVal());
        }
        else if(myFace.getRadButt()==R.id.radButtHair)
        {
            redSeekBar.setProgress(myFace.getHairRedVal());
            greenSeekBar.setProgress(myFace.getHairGreenVal());
            blueSeekBar.setProgress(myFace.getHairBlueVal());

            tvRed.setText("Red: "+myFace.getHairRedVal());
            tvGreen.setText("Green: "+myFace.getHairGreenVal());
            tvBlue.setText("Blue: "+myFace.getHairBlueVal());
            
        }
        else if(myFace.getRadButt()==R.id.radButtSkin)
        {
            redSeekBar.setProgress(myFace.getSkinRedVal());
            greenSeekBar.setProgress(myFace.getSkinGreenVal());
            blueSeekBar.setProgress(myFace.getSkinBlueVal());

            tvRed.setText("Red: "+myFace.getSkinRedVal());
            tvGreen.setText("Green: "+myFace.getSkinGreenVal());
            tvBlue.setText("Blue: "+myFace.getSkinBlueVal());
            
        }

        //set up spinner
        Spinner hairSpinner = (Spinner) findViewById(R.id.spinnerHairstyle);
        hairSpinner.setSelection(myFace.getHairStyle());

        //set up button
        Button randomButt = (Button)findViewById(R.id.buttRandom);

        //register an instance of listener class with the view
        ListenerClass faceListener = new ListenerClass(myFace);
        faceListener.addSB(redSeekBar);
        faceListener.addSB(greenSeekBar);
        faceListener.addSB(blueSeekBar);
        faceListener.addTV(tvRed);
        faceListener.addTV(tvGreen);
        faceListener.addTV(tvBlue);

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
