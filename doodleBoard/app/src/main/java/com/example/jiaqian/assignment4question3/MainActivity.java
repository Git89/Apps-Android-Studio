package com.example.jiaqian.assignment4question3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    Game game;
    GameView gameView;
    private GestureDetector gestureDetector;

    float sceneWidth;
    float sceneHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        this.sceneWidth= screenWidth();
        this.sceneHeight = screenHeight();

        game = new Game();

        //initialize gameView
        gameView = new GameView(this,game,sceneWidth,sceneHeight);

        setContentView(gameView);

        //attach gesture listener
        GestureListener temp = new GestureListener();
        gestureDetector = new GestureDetector(this,temp);

    }

    //get screen width
    public int screenWidth(){
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        return size.x;
    }

    //get screen height
    public int screenHeight(){
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        return size.y;
    }

    //
    private class GestureListener implements GestureDetector.OnGestureListener{

        //this will be called if click is inside the platte
        public boolean onDown(MotionEvent e){
            //update current color in Game
            game.currentColor();
            // call onDraw, change the background color of the square in interface
            gameView. postInvalidate();


            return true;
        }

        public boolean onFling(MotionEvent E1,MotionEvent e2,float velocityX,float velocityY){
            return true;
        }
        public boolean onScroll(MotionEvent E1,MotionEvent e2,float velocityX,float velocityY){
            return true;
        }
        public void onLongPress(MotionEvent e){

        }
        public void onShowPress(MotionEvent e){

        }
        public boolean onSingleTapUp(MotionEvent e){
            return true;
        }
    }


    public boolean onTouchEvent(MotionEvent event){

        int DP = (int)(getResources().getDisplayMetrics().density);

        //get action
        int action = event.getAction();
        //get x and y coordinate for the click
        float x = event.getX();
        float y = event.getY()-(80*DP);



        if(action == MotionEvent.ACTION_DOWN){
            //within the square
            if(400*DP<=x && x<=((400*DP)+(100*DP))){
                if(730 * DP <= y && y <= 830 * DP){
                    //call on down method
                    gestureDetector.onTouchEvent(event);
                    return true;
                }
            }
            //outside of the square,then doodle,add points into list
            else {
               game.addPoints(x,y);
               gameView. postInvalidate();
            }
            //if move
        }else if(action == MotionEvent.ACTION_MOVE){
            //add points into list
            game.addPoints(x,y);
            //call onDraw
            gameView.postInvalidate();

            //if up
        }else if(action == MotionEvent.ACTION_UP){

            ;
        }
        return true;
    }

}
