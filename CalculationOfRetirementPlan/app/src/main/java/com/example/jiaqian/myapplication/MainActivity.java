package com.example.jiaqian.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


       //handle submit button
        public void submit(View v){

        //get the view of each editBox and then get value from them
            EditText currentPrincipalEditText = (EditText)findViewById(R.id.inputCurrentPrincipal);
            EditText annualAdditionEditText = (EditText)findViewById(R.id.inputAnnualAddition);
            EditText numberOfYearsEditText = (EditText)findViewById(R.id.inputNumberOfYears);
            EditText rateOfReturnEditText = (EditText)findViewById(R.id.inputRateOfReturn);

            String currentPrincipalString = currentPrincipalEditText.getText().toString();
            String annualAdditionString = annualAdditionEditText.getText().toString();
            String numberOfYearsString = numberOfYearsEditText.getText().toString();
            String rateOfReturnString = rateOfReturnEditText.getText().toString();

            double currentPrincipal = Double.parseDouble(currentPrincipalString);
            double annualAddition = Double.parseDouble(annualAdditionString);
            double numberOfYears = Double.parseDouble(numberOfYearsString);
            double rateOfReturn = Double.parseDouble(rateOfReturnString);

            //using putExtra to pass values to the second activity
            Intent secondActivity = new Intent(this, SecondActivity.class);
            secondActivity.putExtra("currentPrincipal",currentPrincipal);
            secondActivity.putExtra("annualAddition",annualAddition);
            secondActivity.putExtra("numberOfYears",numberOfYears);
            secondActivity.putExtra("rateOfReturn",rateOfReturn);


            MainActivity.this.startActivity(secondActivity);


        }

}
