package com.example.jiaqian.assignment4question3;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GameView extends View{

    private Game game;

    float sceneWidth;
    float sceneHeight;

    //constructor
    public GameView(Context context,Game game, float sceneWidth,float sceneHeight){

        super(context);
        this.game = game;
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

        public void onDraw (Canvas canvas){

        Paint paint = new Paint();
        int DP = (int)(getResources().getDisplayMetrics().density);

        //draw background
        paint.setColor(Color.parseColor("#FFFFFF"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0,0,sceneWidth,sceneHeight,paint);


        //draw points
        for(int i = 0;i<game.list.size();i++){
            Point point = game.list.get(i);
            paint.setColor(Color.parseColor(point.color));
            paint.setStrokeWidth(20);
            canvas.drawPoint(point.x,point.y,paint);
        }

        //draw square
        paint.setColor(Color.parseColor(game.currentColor));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(400*DP,650*DP,500*DP,750*DP,paint);


    }

}

