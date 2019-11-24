package com.example.jiaqian.assignment4question2;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import java.util.Random;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Context;

public class AppInterface extends RelativeLayout {

    //ten textview
    TextView[] textViews= new TextView[10];
    //swaptextview for warning
    TextView SwapTextView;

    final int DP = (int)(getResources().getDisplayMetrics().density);

    //game object
    Game game = MainActivity.game;


    public AppInterface(Context context){
        super(context);

        //grid
        GridLayout grid = new GridLayout(context);
        grid.setId(GridLayout.generateViewId());
        grid.setRowCount(10);
        grid.setColumnCount(1);

        //location information of this grid
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0,0);
        params.width=120*DP;
        params.height=620*DP;
        params.leftMargin=200*DP;
        params.topMargin=30*DP;
        grid.setLayoutParams(params);

        //fill all textview into the grid
        for(int i =0;i<10;i++){
            textViews[i]=new TextView(context);
            if(i==game.randomWin||i==game.randomWin+1)
            {
                textViews[i].setBackgroundColor(Color.parseColor("#FF0000"));
            }
            else {
            textViews[i].setBackgroundColor(Color.parseColor("#999999"));
            }

            textViews[i].setTextColor(Color.BLACK);
            textViews[i].setTextSize((int)(60*0.4));
            textViews[i].setGravity(Gravity.CENTER);
            GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
            params1.width=120*DP;
            params1.height=60*DP;
            params1.rowSpec= GridLayout.spec(i,1);
            params1.columnSpec= GridLayout.spec(0,1);
            params1.topMargin = params1.bottomMargin= 1;
            params1.leftMargin=params1.rightMargin=1;
            textViews[i].setLayoutParams(params1);
            grid.addView(textViews[i]);
        }

        addView(grid);

        //set SwapTextView
        SwapTextView = new TextView(context);
        SwapTextView.setId(TextView.generateViewId());
        SwapTextView.setBackgroundColor(Color.parseColor("#999999"));
        SwapTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        SwapTextView.setTextColor(Color.parseColor("#000000"));
        SwapTextView.setPadding(10*DP,10*DP,10*DP,10*DP);
        SwapTextView.setGravity(Gravity.CENTER);
        params = new RelativeLayout.LayoutParams(0,0);
        //set location parameters
        params.width= 300*DP;
        params.height=RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.topMargin=20*DP;
        params.leftMargin=115*DP;
        params.addRule(RelativeLayout.BELOW,grid.getId());
        SwapTextView.setLayoutParams(params);
        addView(SwapTextView);
    }


    //draw board
    public void drawBoard(int[]num){

        for(int i =0;i<10;i++){
            textViews[i].setText(num[i]+"");
            if(i==game.randomWin||i==game.randomWin+1)
            {
                textViews[i].setBackgroundColor(Color.parseColor("#FF0000"));
            }
            else {
                textViews[i].setBackgroundColor(Color.parseColor("#999999"));
            }

        }
    }



}
