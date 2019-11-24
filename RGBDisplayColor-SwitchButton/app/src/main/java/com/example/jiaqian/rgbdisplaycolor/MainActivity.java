package com.example.jiaqian.rgbdisplaycolor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get view of each seekBar
        SeekBar seekBar1 = (SeekBar)findViewById(R.id.labelSeekBar1);
        SeekBar seekBar2 = (SeekBar)findViewById(R.id.labelSeekBar2);
        SeekBar seekBar3 = (SeekBar)findViewById(R.id.labelSeekBar3);

        //create an object of ChangerHandler
        ChangerHandler temp = new ChangerHandler();

        //attach ChangerHandler to each seekBar
        seekBar1.setOnSeekBarChangeListener(temp);
        seekBar2.setOnSeekBarChangeListener(temp);
        seekBar3.setOnSeekBarChangeListener(temp);
    }


    private class ChangerHandler implements SeekBar.OnSeekBarChangeListener{
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
            //create an object of Question3Model
            Question3Model obj = new Question3Model();
            //get id of seekBar changed
            int barId = seekBar.getId();

            //if it is seekBar red
            if(barId== R.id.labelSeekBar1){
                //set red value
                obj.setRedValue(progress);

                TextView redValueTextView = (TextView)findViewById(R.id.labelRedValue);
                //set text to red textView
                redValueTextView.setText(obj.redValue+"");

                //if it is seekBar yellow
            }else if(barId== R.id.labelSeekBar2){
                //set yellow value
                obj.setYellowValue(progress);
                TextView yellowValueTextView = (TextView)findViewById(R.id.labelYellowValue);
                //set text to yellow textView
                yellowValueTextView.setText(obj.yellowValue+"");
                //if it is seekBar blue
            }else{
                //set blue value
                obj.setBlueValue(progress);
                TextView blueValueTextView = (TextView)findViewById(R.id.labelBlueValue);
                //set text to blue textView
                blueValueTextView.setText(obj.blueValue+"");
            }

            TextView displayColorTextView = (TextView)findViewById(R.id.displayColor);
            //display color user wants
            displayColorTextView.setBackgroundColor(Color.rgb(obj.redValue,obj.blueValue,obj.yellowValue));
        }
        public void onStartTrackingTouch(SeekBar seekBar){

        }
        public void onStopTrackingTouch(SeekBar seekBar){

        }
    }
}
