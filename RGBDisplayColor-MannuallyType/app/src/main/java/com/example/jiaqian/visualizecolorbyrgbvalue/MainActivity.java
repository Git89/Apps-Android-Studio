package com.example.jiaqian.visualizecolorbyrgbvalue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;
import android.text.Editable;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get view of red,blue,yellow box
        EditText inputRedValueEditText = (EditText)findViewById(R.id.labelRedValue);
        EditText inputBlueValueEditText = (EditText)findViewById(R.id.labelBlueValue);
        EditText inputYellowValueEditText = (EditText)findViewById(R.id.labelYellowValue);

        //create object of TextChangeHandle
        TextChangeHandle temp = new TextChangeHandle();

        //attach text listener to red,blue,yellow input box
        inputRedValueEditText.addTextChangedListener(temp);
        inputBlueValueEditText.addTextChangedListener(temp);
        inputYellowValueEditText.addTextChangedListener(temp);

    }
    public void display(View v){
        displayColor();
    }

    //implement interface TextWatcher
    public class TextChangeHandle implements TextWatcher
    {
        public void afterTextChanged(Editable e){
            displayColor(); //if text is changed, call displayColor()
        }
        public void beforeTextChanged(CharSequence s, int start, int count, int after){

        }
        public void onTextChanged(CharSequence s,int start, int before, int after){

        }
    }
    public void displayColor()
    {
        //get value of red input box
        EditText inputRedValueEditText = (EditText)findViewById(R.id.labelRedValue);
        String inputRedValueString = inputRedValueEditText.getText().toString();
        int redValue=catchException(inputRedValueString);

        //get value of blue input box
        EditText inputBlueValueEditText = (EditText)findViewById(R.id.labelBlueValue);
        String inputBlueValueString = inputBlueValueEditText.getText().toString();
        int blueValue=catchException(inputBlueValueString);

        //get value of yellow input box
        EditText inputYellowValueEditText = (EditText)findViewById(R.id.labelYellowValue);
        String inputYellowValueString = inputYellowValueEditText.getText().toString();
        int yellowValue=catchException(inputYellowValueString);

        //set color to labelDisplayColor according to rgb value
        TextView showColorView = (TextView)findViewById(R.id.labelDisplayColor);
        showColorView.setBackgroundColor(Color.rgb(redValue,blueValue,yellowValue));
    }

    //handle empty input or input greater than 255
    public int catchException(String str){
        int value=0;
        try{
            value=Integer.parseInt(str);
            if(value>255){//input greater than 255 is seen as 255
                value=255;
            }

        }catch(NumberFormatException e) {
            value = 0;//empty input is seen as 0
        }
        return value;
    }
}
