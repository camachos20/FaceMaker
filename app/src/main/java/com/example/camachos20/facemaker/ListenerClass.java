package com.example.camachos20.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author Stephanie Camacho
 * Created by Stephanie on 2/11/18.
 */

public class ListenerClass implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    //These are all the Views that this listener maintains
    private ArrayList<TextView> allTVs = new ArrayList<>();
    private ArrayList<SeekBar> allSBs = new ArrayList<>();



    //face object
    private Face myFace = null;

    public ListenerClass(Face initFace){
        myFace = initFace;
    }


    //Adders
    public void addTV(TextView anotherTV)
    {
        allTVs.add(anotherTV);
    }
    public void addSB(SeekBar anSB)
    {
        allSBs.add(anSB);
    }

    //button listener
    @Override
    public void onClick(View v) {
        //reference the clicked button
        Button wasClicked = ((Button)v);
        myFace.randomize();

    }


    /**radio group listener updates seekbars and textviews for the corresponding
     * selected facial feature
     * */

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if (checkedId == R.id.radButtEyes)
        {
            myFace.setRadButt(0);
            for(SeekBar sb : allSBs)
            {
                if (sb.getId() == R.id.seekBarRed)
                {
                    sb.setProgress(myFace.getEyeRedVal());
                }
                else if (sb.getId() == R.id.seekBarGreen)
                {
                    sb.setProgress(myFace.getEyeGreenVal());
                }
                else if (sb.getId() == R.id.seekBarBlue)
                {
                    sb.setProgress(myFace.getEyeBlueVal());
                }
            }
            for (TextView tv : allTVs) {
                if (tv.getId() == R.id.tvRed) {
                    tv.setText("Red: " + myFace.getEyeRedVal());
                }
                else if (tv.getId() == R.id.tvGreen) {
                    tv.setText("Green:"+ myFace.getEyeGreenVal());
                }
                else if (tv.getId() == R.id.tvBlue) {
                    tv.setText("Blue: " + myFace.getEyeBlueVal() );
                }
            }
            
        }
        else if (checkedId==R.id.radButtHair)
        {
            myFace.setRadButt(1);
            for(SeekBar sb : allSBs)
            {
                if (sb.getId() == R.id.seekBarRed)
                {
                    sb.setProgress(myFace.getHairRedVal());
                }
                else if (sb.getId() == R.id.seekBarGreen)
                {
                    sb.setProgress(myFace.getHairGreenVal());
                }
                else if (sb.getId() == R.id.seekBarBlue)
                {
                    sb.setProgress(myFace.getHairBlueVal());
                }
            }
            for (TextView tv : allTVs) {
                if (tv.getId() == R.id.tvRed) {
                    tv.setText("Red: " + myFace.getHairRedVal());
                }
                else if (tv.getId() == R.id.tvGreen) {
                    tv.setText("Green:"+ myFace.getHairGreenVal());
                }
                else if (tv.getId() == R.id.tvBlue) {
                    tv.setText("Blue: " + myFace.getHairBlueVal() );
                }
            }

        }
        else if (checkedId==R.id.radButtSkin)
        {
            myFace.setRadButt(2);
            for(SeekBar sb : allSBs)
            {
                if (sb.getId() == R.id.seekBarRed)
                {
                    sb.setProgress(myFace.getSkinRedVal());
                }
                else if (sb.getId() == R.id.seekBarGreen)
                {
                    sb.setProgress(myFace.getSkinGreenVal());
                }
                else if (sb.getId() == R.id.seekBarBlue)
                {
                    sb.setProgress(myFace.getSkinBlueVal());
                }
            }
            for (TextView tv : allTVs) {
                if (tv.getId() == R.id.tvRed) {
                    tv.setText("Red: " + myFace.getSkinRedVal());
                }
                else if (tv.getId() == R.id.tvGreen) {
                    tv.setText("Green:"+ myFace.getSkinGreenVal());
                }
                else if (tv.getId() == R.id.tvBlue) {
                    tv.setText("Blue: " + myFace.getSkinBlueVal() );
                }
            }

        }
        



    }

    //seekbar listener
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        /**if red sb is changed, update corresponding txt view, check which radio button is pressed,
         * and update corresponding color
        */
        if(seekBar.getId()==R.id.seekBarRed) {

            for (TextView tv : allTVs) {
                if (tv.getId() == R.id.tvRed) {
                    tv.setText("Red: " + progress);
                }
            }

            if (myFace.getRadButt()==0)
            {
                myFace.setEyeColor(progress,myFace.getEyeGreenVal(),myFace.getEyeBlueVal());
            }
            else if (myFace.getRadButt()==1)
            {
                myFace.setHairColor(progress,myFace.getHairGreenVal(),myFace.getHairBlueVal());
            }
            else if (myFace.getRadButt()==2)
            {
                myFace.setSkinColor(progress,myFace.getSkinGreenVal(),myFace.getSkinBlueVal());
            }

        }
        /**if green sb is changed, update corresponding txt view, check which radio button is pressed,
         * and update corresponding color
         */        else if(seekBar.getId()==R.id.seekBarGreen) {
            for (TextView tv : allTVs) {
                if (tv.getId() == R.id.tvGreen) {
                    tv.setText("Green: " + progress);
                }

            }

            if (myFace.getRadButt()==0)
            {
                myFace.setEyeColor(myFace.getEyeRedVal(),progress,myFace.getEyeBlueVal());
            }
            else if (myFace.getRadButt()==1)
            {
                myFace.setHairColor(myFace.getHairRedVal(),progress,myFace.getHairBlueVal());
            }
            else if (myFace.getRadButt()==2)
            {
                myFace.setSkinColor(myFace.getSkinRedVal(),progress,myFace.getSkinBlueVal());
            }
        }
        /**if blue sb is changed, update corresponding txt view, check which radio button is pressed,
         * and update corresponding color
         */
        else if(seekBar.getId()==R.id.seekBarBlue) {
            for (TextView tv : allTVs) {
                if (tv.getId() == R.id.tvBlue) {
                    tv.setText("Blue: " + progress);
                }

            }
            if (myFace.getRadButt()==0)
            {
                myFace.setEyeColor(myFace.getEyeRedVal(),myFace.getEyeGreenVal(),progress);
            }
            else if (myFace.getRadButt()==1)
            {
                myFace.setHairColor(myFace.getHairRedVal(),myFace.getHairGreenVal(),progress);
            }
            else if (myFace.getRadButt()==2)
            {
                myFace.setSkinColor(myFace.getSkinRedVal(),myFace.getSkinGreenVal(),progress);
            }
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //required methods, do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //required methods, do nothing
    }


    //spinner listener
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //check which hairstyle is selected and set the face's hairstyle int
        if (parent.getItemAtPosition(position).toString().equalsIgnoreCase("Bun"))
        {
            myFace.setHairStyle(0);
        }
        else if (parent.getItemAtPosition(position).toString().equalsIgnoreCase("Bad Toupee"))
        {
            myFace.setHairStyle(1);
        }
        else if (parent.getItemAtPosition(position).toString().equalsIgnoreCase("Mohawk"))
        {
            myFace.setHairStyle(2);
        }

    }

    //initialize spinner selection
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        if(myFace.getHairStyle()==0)
        {
            parent.setSelection(0);
        }
        else if (myFace.getHairStyle()==1)
        {
            parent.setSelection(1);
        }
        else if (myFace.getHairStyle()==2)
        {
            parent.setSelection(2);
        }
    }






}
