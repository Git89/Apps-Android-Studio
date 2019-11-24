package com.example.jiaqian.sudokupuzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Point;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //constant size
    private final int SIZE = 9;
    //create an object of Question8Model
    private Question8Model model = new Question8Model();
    //declare an object of AppInterface
    private AppInterface appInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get the size of the screen
        Point screenSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(screenSize);
        //get width for 9 cells in one row
        int width =screenSize.x/SIZE;

        //initialize appInterface
        appInterface = new AppInterface(this,width-3);
        //call drawBoard method
        appInterface.drawBoard(model.getBoard());

        setContentView(appInterface);

        //set different TextChangedListener to each editBox by call setTextChangedListener method in AppInterface
        //each listener includes a specific location of editBox
        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                //create an object ofTextChangeHandler
                TextChangeHandler temp = new TextChangeHandler(i,j);
                appInterface.setTextChangedListener(temp,i,j);
            }
        }
    }


    public class TextChangeHandler implements TextWatcher{

        //variables about the location of each listener
        int x;
        int y;

        //constructor
        public TextChangeHandler(int x, int y){
            this.x = x;
            this.y = y;
        }
        //
        public void afterTextChanged(Editable e){
           String inputValue = appInterface.getInput(x,y);
           //after user delete the content of the editBox
           if(inputValue.equals("")){
               //set 0 in model
               model.setBoard(0,x,y);
               //after user types something
           }else{
               int value = Integer.parseInt(inputValue);
           // if value is out of range from 1 to 9 inclusively
               if(value>=10||value<=0){
                   //set 0 in model and clear interface
                   model.setBoard(0,x,y);
                   appInterface.clear(x,y);
               }
               //if if value is not repeated, set value in model and decide whether user won
               //if user won, then display win message
               if(model.checkRepeated(value,x,y)){
                   model.setBoard(value,x,y);
                   if(model.win()){
                       displayWinMessage();
                   }
                   //if value is repeated,set 0 in model and clear interface
               }else{
                   appInterface.clear(x,y);
                   model.setBoard(0,x,y);
               }
           }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before, int after){

        }
    }

    //displayWinMessage method
    private void displayWinMessage(){
        String message = "You win";
        int induration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(this,message,induration);

        toast.show();
    }
}
