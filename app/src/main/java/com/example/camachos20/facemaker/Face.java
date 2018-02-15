package com.example.camachos20.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;



/**
 * Created by Stephanie on 2/11/18.
 */
public class Face extends SurfaceView {

    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;
    String currFeature;

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

    }




    public void randomize(){
        this.hairStyle = (int) (Math.random() *3);
        this.skinColor = Color.rgb((int) (Math.random()*256),(int) (Math.random()*256), (int)(Math.random()*256));
        this.eyeColor = Color.rgb((int) (Math.random()*256),(int) (Math.random()*256), (int)(Math.random()*256));
        this.hairColor = Color.rgb((int) (Math.random()*256),(int) (Math.random()*256), (int)(Math.random()*256));
        invalidate();



    }

    @Override
    public void onDraw(Canvas canvas) {

        //draw head
        Paint skinPaint = new Paint ();
        skinPaint.setColor(this.skinColor);
        canvas.drawOval(100.0f, 150.0f, 850.0f, 1000.0f, skinPaint);

        //draw eyes
        Paint whitePaint = new Paint();
        whitePaint.setColor(Color.WHITE);
        canvas.drawOval(250.0f, 350.0f,350.0f,500.0f,whitePaint);
        canvas.drawOval(600.0f, 350.0f,700.0f,500.0f,whitePaint);

        Paint eyePaint = new Paint();
        eyePaint.setColor(this.eyeColor);
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
        drawHair(canvas);




    }


    public void drawHair(Canvas canvas)
    {
        Paint hairPaint = new Paint();
        hairPaint.setColor(this.hairColor);

        if (this.hairStyle == 0)
        {
            //draw bun
            canvas.drawArc(170.0f,150.0f,780.0f, 530.0f,180.0f,180.0f,true, hairPaint);
            canvas.drawCircle(450.0f, 150.0f, 200.0f, hairPaint);


        }
        else if (this.hairStyle == 1)
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
        else if (this.hairStyle == 2)
        {
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

