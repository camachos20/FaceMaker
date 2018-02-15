package com.example.camachos20.facemaker;

import android.support.annotation.IdRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;

/**
 * Created by camachos20 on 2/15/2018.
 */

public class ListenerClass implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {


    //button listener
    @Override
    public void onClick(View v) {
        //reference the clicked button
        Button wasClicked = ((Button)v);

    }


    //radio group listener
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

    }

    //seekbar listener
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

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

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //required method, do nothing
    }
}
