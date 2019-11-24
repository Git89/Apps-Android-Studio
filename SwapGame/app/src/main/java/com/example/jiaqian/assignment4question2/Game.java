package com.example.jiaqian.assignment4question2;
import java.util.Random;

public class Game {

    //ten number for board
    int [] num = new int[10];
    //randomly choose start point for sliding window
    int randomWin;
    //total number of swap left
    int swapLeft=45;


    public Game(){

        Random rand = new Random();
        //create ten numbers randomly ranging from 1 to 100
        for(int i = 0;i<10;i++){
            num[i]=rand.nextInt(100)+1;
        }
        //choose start window
        randomWin = rand.nextInt(9);
    }



    //get num[]
    public int[] getNum(){
        return num;
    }

    //get swapLeft
    public int getSwapLeft(){
        return swapLeft;
    }

    //swap number inside num
    public void swap(){
        int temp = num[randomWin];
        num[randomWin]=num[randomWin+1];
        num[randomWin+1]=temp;
        swapLeft--;
    }

    //change window after one single tap
    public void changeWindow(){
        if(randomWin<=7){
            randomWin++;
        }else{
            randomWin=0;
        }

    }

    //check if user wins
    public boolean win(){
        for(int i=0;i<9;i++){
            if(num[i]>num[i+1]){
                return false;
            }
        }
        return true;
    }

}
