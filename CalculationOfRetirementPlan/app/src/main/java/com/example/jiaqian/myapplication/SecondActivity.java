package com.example.jiaqian.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        updateView();
    }

    //updateView
    private void updateView(){

        //get value from main activity through extra
        Intent intent = getIntent();

        double currentPrincipal = intent.getDoubleExtra("currentPrincipal",0);
        double annualAddition = intent.getDoubleExtra("annualAddition",0);
        double numberOfYears =intent.getDoubleExtra("numberOfYears",0);
        double rateOfReturn = intent.getDoubleExtra("rateOfReturn",0);

        //set output
        TextView resultTextView = (TextView)findViewById(R.id.output);
        String output="";

        for(int i = 1;i<=numberOfYears;i++){
            DecimalFormat f = new DecimalFormat("##.00");
            //calculate the amount
            double total =((currentPrincipal+(annualAddition/(rateOfReturn/100)))*
                    Math.pow(1+(rateOfReturn/100),i))-(annualAddition/(rateOfReturn/100));

            //this is for adjust the physical distance between the year and amount
            //if year is less than 100
            if(i<10){
                output=output+i+"                              "+f.format(total)+"\n";
            }//if year is great than 10
            else if(i<100){
                output=output+i+"                            "+f.format(total)+"\n";
            }

        }
        //set output
        resultTextView.setText(output);

    }


    //handle back button
    public void back(View v){
        finish();
    }
}
