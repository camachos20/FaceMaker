package com.example.camachos20.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.RadioGroup;


/**
 * Created by Stephanie on 2/11/18.
 */
public class Face extends SurfaceView {

    private int skinRedVal;
    private int skinGreenVal;
    private int skinBlueVal;
    private int eyeRedVal;
    private int eyeGreenVal;
    private int eyeBlueVal;
    private int hairRedVal;
    private int hairGreenVal;
    private int hairBlueVal;
    private int hairColor;
    private int eyeColor;
    private int skinColor;

    private int hairStyle;
    private int radButt;





    public Face(Context context){
        super(context);
        setWillNotDraw(false);
        randomize();
    }

    public Face(Context context, AttributeSet attrs) {
        super(context,attrs);
        setWillNotDraw(false);
        randomize();
    }

    public Face(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        setWillNotDraw(false);
        randomize();

    }

    public Face(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);
        setWillNotDraw(false);
        randomize();

    }

    //getters and setters

    public int getRadButt()
    {
        if(radButt==0)
        {
            return R.id.radButtEyes;
        }
        else if (radButt==1)
        {
            return R.id.radButtHair;
        }
        else if (radButt==2)
        {
            return R.id.radButtSkin;
        }
        else
        {
            return -1;
        }
    }
    public int getSkinRedVal()
    {
        return skinRedVal;
    }
    public int getSkinGreenVal()
    {
        return skinGreenVal;
    }
    public int getSkinBlueVal()
    {
        return skinBlueVal;
    }
    public int getEyeRedVal()
    {
        return eyeRedVal;    
    }
    public int getEyeGreenVal()
    {
        return eyeGreenVal;
    }
    public int getEyeBlueVal()
    {
        return eyeBlueVal;
    }
    public int getHairRedVal()
    {
        return hairRedVal;
    }
    public int getHairGreenVal()
    {
        return hairGreenVal;
    }
    public int getHairBlueVal()
    {
        return hairBlueVal;
    }

    public int getHairStyle()
    {
        return hairStyle;
    }
    public void setRadButt(int value)
    {
        radButt = value;
    }

    public void setSkinRedVal(int value)
    {
        skinRedVal = value;
        setSkinColor(value, getSkinGreenVal(),getSkinBlueVal());

    }
    public void setSkinGreenVal(int value)
    {
        skinGreenVal= value;
        setSkinColor(getSkinRedVal(),value,getSkinBlueVal());

    }
    public void setSkinBlueVal(int value)
    {
        skinBlueVal= value;
        setSkinColor(getSkinRedVal(),getSkinGreenVal(),value);

    }
    public void setEyeRedVal(int value)
    {
        eyeRedVal= value;
        setEyeColor(value,getEyeGreenVal(),getEyeBlueVal());

    }
    public void setEyeGreenVal(int value)
    {
        eyeGreenVal= value;
        setEyeColor(getEyeRedVal(),value,getEyeBlueVal());

    }
    public void setEyeBlueVal(int value)
    {
        eyeBlueVal= value;
        setEyeColor(getEyeRedVal(),getEyeGreenVal(),value);

    }
    public void setHairRedVal(int value)
    {
        hairRedVal= value;
        setHairColor(value,getHairGreenVal(),getHairBlueVal());

    }
    public void setHairGreenVal(int value)
    {
        hairGreenVal= value;
        setHairColor(getHairRedVal(),value,getHairBlueVal());

    }
    public void setHairBlueVal(int value)
    {
        hairBlueVal= value;
        setHairColor(getHairRedVal(),getHairGreenVal(),value);

    }
    public void setHairColor(int r, int g, int b)
    {
        hairColor=Color.rgb(r,g,b);
        invalidate();
    }
    public void setEyeColor(int r, int g, int b)
    {
        eyeColor=Color.rgb(r,g,b);
        invalidate();
    }
    public void setSkinColor(int r, int g, int b)
    {
        skinColor=Color.rgb(r,g,b);
        invalidate();
    }
    public void setHairStyle(int hairInt)
    {
        hairStyle=hairInt;
        invalidate();
    }
    
    
    



    public void randomize(){

        skinRedVal = (int) (Math.random()*256);
        skinGreenVal= (int) (Math.random()*256);
        skinBlueVal= (int) (Math.random()*256);
        eyeRedVal= (int) (Math.random()*256);
        eyeGreenVal= (int) (Math.random()*256);
        eyeBlueVal= (int) (Math.random()*256);
        hairRedVal= (int) (Math.random()*256);
        hairGreenVal= (int) (Math.random()*256);
        hairBlueVal= (int) (Math.random()*256);
        hairStyle = (int) (Math.random() *3);
        skinColor = Color.rgb(skinRedVal,skinGreenVal,skinBlueVal);
        eyeColor = Color.rgb(eyeRedVal,eyeGreenVal,eyeBlueVal);
        hairColor = Color.rgb(hairRedVal,hairGreenVal,hairBlueVal);
        hairStyle = (int) ((Math.random()*3));
        radButt = (int) ((Math.random()*3));
        invalidate();

        /**
         External Citation
         Date: 13 February 2018
         Problem: did not know how to get the canvas to redraw
         Resource: https://developer.android.com/reference/android/view/View.html
         Solution: I learned that I need to call invalidate()
         */

    }

    //getters and setters



    @Override
    public void onDraw(Canvas canvas) {

        //draw head
        Paint skinPaint = new Paint ();
        skinPaint.setColor(skinColor);
        canvas.drawOval(100.0f, 150.0f, 850.0f, 1000.0f, skinPaint);

        //draw eyes
        Paint whitePaint = new Paint();
        whitePaint.setColor(Color.WHITE);
        canvas.drawOval(250.0f, 350.0f,350.0f,500.0f,whitePaint);
        canvas.drawOval(600.0f, 350.0f,700.0f,500.0f,whitePaint);

        Paint eyePaint = new Paint();
        eyePaint.setColor(eyeColor);
        canvas.drawOval(270.0f, 370.0f, 330.0f, 480.0f, eyePaint);
        canvas.drawOval( 620.0f, 370.0f, 680.0f, 480.0f, eyePaint);

        Paint blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        canvas.drawOval(290.0f, 420.0f, 310.0f, 440.0f, blackPaint);
        canvas.drawOval( 640.0f, 420.0f, 660.0f, 440.0f, blackPaint);

        //draw nose
        blackPaint.setStyle(Paint.Style.STROKE);
        blackPaint.setStrokeWidth(5.0f);
        canvas.drawArc(445.0f, 500.0f, 505.0f, 610.0f, 0.0f, 180.0f,false, blackPaint );
        canvas.drawArc(445.0f, 500.0f, 505.0f, 610.0f, 270.0f, 180.0f,false, blackPaint );


        //draw mouth
        Paint redPaint = new Paint();
        redPaint.setColor(Color.rgb(255,102,102));
        canvas.drawArc(250.0f, 600.0f, 700.0f, 850.0f, 0.0f, 180.0f, true, redPaint);


        //draw hair
        drawHair(canvas, hairStyle);




    }


    public void drawHair(Canvas canvas, int hairStyleInt)
    {
        Paint hairPaint = new Paint();
        hairPaint.setColor(hairColor);

        if (hairStyleInt == 0)
        {
            //draw bun
            canvas.drawArc(170.0f,150.0f,780.0f, 530.0f,180.0f,180.0f,true, hairPaint);
            canvas.drawCircle(450.0f, 150.0f, 200.0f, hairPaint);


        }
        else if (hairStyleInt == 1)
        {
            //draw a really bad toupee
            hairPaint.setStyle(Paint.Style.STROKE);
            hairPaint.setStrokeWidth(3.0f);

            for (float i = 0.0f; i<150.0f; i+=5.0f)
            {
                canvas.drawArc(240.0f, 150.0f, (700.0f+i), 610.0f, 270.0f,
                        100.0f, false, hairPaint);

                canvas.drawArc((125.0f+i), 150.0f, 825.0f, 610.0f, 180.0f,
                        100.0f, false, hairPaint);
            }

        }
        else if (hairStyleInt == 2)
        {
            //draw a mohawk
            hairPaint.setStrokeWidth(20.0f);
            float[] arr = {350, 200, 330, 50,
                    371, 205, 351, 45,
                    392, 210, 372, 40,
                    413, 215, 393, 35,
                    434, 220, 414, 30,
                    455, 225, 435, 25,
                    465, 228, 455, 23,
                    476, 230, 476, 20,
                    485, 228, 495, 23,
                    497, 225, 517, 25,
                    518, 220, 538, 30,
                    539, 215, 559, 35,
                    560, 210, 580, 40,
                    581, 205, 601, 45,
                    600, 200 ,620,50};

            canvas.drawLines(arr,hairPaint);


        }
    }


}

