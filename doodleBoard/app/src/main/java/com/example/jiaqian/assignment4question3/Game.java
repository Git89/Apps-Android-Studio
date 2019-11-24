package com.example.jiaqian.assignment4question3;

import java.util.LinkedList;

public class Game {

    //store 8 colors
    String color[]=new String[8];

    //linked list used to store all the points on the screen
    LinkedList<Point> list = new LinkedList<>();

    //used to change the color of the small right bottom square
    int singleTapNum;
    //
    String currentColor="#000000";

    //initialize color[]
    public Game(){

        color[0]="#000000";
        color[1]="#FFFFFF";
        color[2]="#999999";
        color[3]="#FF0000";
        color[4]="#00FF00";
        color[5]="#0000FF";
        color[6]="#FFFF00";
        color[7]="#994C00";
    }

    //update and return currentColor
    public String currentColor(){
        if(singleTapNum<=6){
            //increment singleTapNum
            singleTapNum++;
            //set currentColor
            currentColor=color[singleTapNum];
            return color[singleTapNum];
        }else{
            //update singleTapNum
            singleTapNum=0;
            //set currentColor
            currentColor=color[singleTapNum];
            return color[singleTapNum];
        }
    }

    //add points to list
    public void addPoints(float x,float y){
        //create a new object of Point
        Point point = new Point(x,y,currentColor);
        //add this new point into list
        list.add(point);
    }

}

