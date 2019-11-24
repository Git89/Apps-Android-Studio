package com.example.jiaqian.sudokupuzzle;

import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.EditText;
import android.content.Context;
import android.graphics.Color;
import android.text.InputType;

public class AppInterface extends GridLayout {

    //81 editBox
    EditText [][] editBox;

    //App interface constructor
    public AppInterface(Context context, int width){

      super(context);

      final int DP = (int)(getResources().getDisplayMetrics().density);

      //set 9rows and 9columns for the game board
      setRowCount(9);
      setColumnCount(9);

      //initialize editBox
      editBox= new EditText[9][9];

      //dynamically set parameters for each editBox
      for(int i=0;i<9;i++){
          for(int j=0;j<9;j++){
              editBox[i][j] =new EditText(context);
              editBox[i][j].setTextSize((int)(width*0.1));
              editBox[i][j].setTextColor(Color.BLACK);
              editBox[i][j].setInputType(InputType.TYPE_CLASS_NUMBER);
              editBox[i][j].setBackgroundColor(Color.parseColor("#009900"));
              editBox[i][j].setGravity(Gravity.CENTER);
              //use gridlayout because editBox is inside gridlayout
              GridLayout.LayoutParams params = new GridLayout.LayoutParams();
              params.width = width;
              params.height = width;
              params.rowSpec = GridLayout.spec(i,1);
              params.columnSpec = GridLayout.spec(j,1);
              params.topMargin = params.bottomMargin=2;
              params.leftMargin = params.rightMargin = 2;
              editBox[i][j].setLayoutParams(params);
              addView(editBox[i][j]);
          }
      }
    }

    //set value and background color for 81 editBox
    public void drawBoard(int[][]board)
    {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    //if board[i][j]==0,set empty string and background color is grey
                    editBox[i][j].setText("");
                    editBox[i][j].setBackgroundColor(Color.parseColor("#999999"));

                    //if not, set the value of board[i][j],default background color is green
                    //also disable this editBox,means that this can not be typed
                }else{
                    editBox[i][j].setText(board[i][j]+"");
                    editBox[i][j].setEnabled(false);
                }
            }
        }
    }

    //get String value from this editBox after the content of this editBox is changed
    public String getInput(int x, int y){
        String value = editBox[x][y].getText().toString();

        return value;
    }

    //clear specific editBox
    public void clear(int x, int y){
        editBox[x][y].setText("");
    }

    //set TextChangedListener for each editBox
    public void setTextChangedListener(TextWatcher tw,int x, int y){
        editBox[x][y].addTextChangedListener(tw);
    }

}
