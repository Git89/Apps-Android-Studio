package com.example.jiaqian.assignment4question2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    public static Game game;

    AppInterface appInterface;

    boolean gameOver;

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game = new Game();
        //initialize appInterface
        appInterface = new AppInterface(this);

        //draw board
        appInterface.drawBoard(game.getNum());

        //set swapTextview
        appInterface.SwapTextView.setText(game.getSwapLeft()+" Swap Left");

        setContentView(appInterface);

        gameOver=false;

        //attach gesture listener
        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this,temp);


    }

    public boolean onTouchEvent(MotionEvent event){
        //if game is not over
        if(!gameOver)gestureDetector.onTouchEvent(event);
        return true;
    }

    //
    private class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {
        //one single tap
        public boolean onSingleTapConfirmed(MotionEvent event){
            //change window
            game.changeWindow();
            //draw board
            appInterface.drawBoard(game.getNum());
            return true;
        }

        //double tap
        public boolean onDoubleTap(MotionEvent event){
            //swap
            game.swap();

            //draw board
            appInterface.drawBoard(game.getNum());

            //if win
            if(game.win()){
                appInterface.SwapTextView.setText("win");
                gameOver=true;
                //if not win and swapLeft==0
            }else if(game.swapLeft==0){
                appInterface.SwapTextView.setText("lose");
                gameOver=true;
                //if not win and swapLeft!=0
            }else{
                appInterface.SwapTextView.setText(game.getSwapLeft()+" Swap Left");
            }
            return true;
        }
    }
}
