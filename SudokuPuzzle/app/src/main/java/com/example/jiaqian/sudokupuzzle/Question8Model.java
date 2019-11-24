package com.example.jiaqian.sudokupuzzle;

public class Question8Model {

    //game board
    int [][] board;

    //constructor
    public Question8Model(){
        //call file teacher gave and initialize the board
        SudokuFile sf = new SudokuFile();
        board = sf.generate();

    }

    //get the value of the board
    public int [][] getBoard(){
        return board;
    }

    //check the newly added value is shown twice on its row,column and cells around it,respectively
   public boolean checkRepeated(int value, int x, int y){
        //check row
       for(int i=0;i<9;i++){
           if(board[i][y]==value){
               return false;
           }
       }
       //check column
       for(int j=0;j<9;j++){
           if(board[x][j]==value){
               return false;
           }
       }
       //check cells around it
       //if the newly added value is located at the out layer of the board
       if(x==0||y==0||x==8||y==8){

           //if this value is shown twice, then return false
           //the code below has same meaning as above
           if(x==0 && y==0){
               if(board[x][y+1]==value||board[x+1][y]==value||board[x+1][y+1]==value){
                   return false;
               }
           }else if(x<8 && y==0){
               if(board[x-1][y]==value||board[x-1][y+1]==value||board[x][y+1]==value||board[x+1][y+1]==value||board[x+1][y]==value){
                   return false;
               }
           }else if(x==8 && y==0){
               if(board[x-1][y]==value||board[x-1][y+1]==value||board[x][y+1]==value){
                   return false;
               }
           }else if(x==0 && y<8){
               if(board[x][y-1]==value||board[x+1][y-1]==value||board[x+1][y]==value||board[x][y+1]==value||board[x+1][y+1]==value){
                   return false;
               }
           }else if(x==0 && y==8){
               if(board[x][y-1]==value||board[x+1][y-1]==value||board[x+1][y]==value){
                   return false;
               }
           }else if(x<8 && y==8){
               if(board[x-1][y-1]==value||board[x-1][y]==value||board[x][y-1]==value||board[x+1][y-1]==value||board[x+1][y]==value){
                   return false;
               }
           }else if(x==8 && y==8){
               if(board[x-1][y-1]==value||board[x][y-1]==value||board[x-1][y]==value){
                   return false;
               }
           }else {
               if(board[x-1][y-1]==value||board[x-1][y]==value||board[x-1][y+1]==value||board[x][y+1]==value||board[x][y-1]==value){
                   return false;
               }
           }
           //if the newly added value is located at editBox wrapped by the out layer of the board
       }else {
           if(board[x-1][y-1]==value){
               return false;
           }
           if(board[x-1][y+1]==value){
               return false;
           }
           if(board[x+1][y-1]==value){
               return false;
           }
           if(board[x+1][y+1]==value){
               return false;
           }
       }
       //if no repeated value, then return true;
       return true;
   }
   //set value in specific editBox
   public void setBoard(int value,int x, int y){
        board[x][y]=value;
   }

   //decide if user won
   public boolean win(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    return false;
                }
            }
        }
        return true;
   }
}
