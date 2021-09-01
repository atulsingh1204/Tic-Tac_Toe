package com.singhsahab.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, restart;
    TextView headerText;
    int playerO=0;
    int playerX=1;
    int active_player = playerO;
    int[] filledPos = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    boolean isGameActive=true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);

        restart = findViewById(R.id.restart);

        headerText = findViewById(R.id.tictactoe);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  private void restart(){

                    active_player=playerO;
                    headerText.setText("Next Turn= O");

                    filledPos= new int [] {-1,-1,-1,-1,-1,-1,-1,-1,-1};

                    btn0.setText("");
                    btn1.setText("");
                    btn2.setText("");
                    btn3.setText("");
                    btn4.setText("");
                    btn5.setText("");
                    btn6.setText("");
                    btn7.setText("");
                    btn8.setText("");

                    btn0.setBackground(getDrawable(android.R.color.darker_gray));
                    btn1.setBackground(getDrawable(android.R.color.darker_gray));
                    btn2.setBackground(getDrawable(android.R.color.darker_gray));
                    btn3.setBackground(getDrawable(android.R.color.darker_gray));
                    btn4.setBackground(getDrawable(android.R.color.darker_gray));
                    btn5.setBackground(getDrawable(android.R.color.darker_gray));
                    btn6.setBackground(getDrawable(android.R.color.darker_gray));
                    btn7.setBackground(getDrawable(android.R.color.darker_gray));
                    btn8.setBackground(getDrawable(android.R.color.darker_gray));


                    isGameActive=true;


                }
        });



        }

    //}

    @Override
    public void onClick(View view) {

        Button clickedbtn = findViewById(view.getId());
        int clickedTag = Integer.parseInt(view.getTag().toString());

            if(!isGameActive)
                return;
        if(filledPos[clickedTag] != -1){
            return;
        }
        filledPos[clickedTag] = active_player;

        if(active_player== playerO)
        {
            clickedbtn.setText("O");
           clickedbtn.setBackground(getDrawable(android.R.color.holo_blue_bright));
            headerText.setText("Next Turn= X");
            active_player=playerX;
        }
        else
        {
            clickedbtn.setText("X");
            clickedbtn.setBackground(getDrawable(android.R.color.holo_green_light));
            headerText.setText("Next Turn= O");
            active_player=playerO;
        }

        checkForWin();
    }

    private void checkForWin(){

        int[][] winPos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{2,4,6},{0,4,8}};
        for(int i=0; i<8; i++){

            int val0 = winPos[i][0];
            int val1 = winPos[i][1];
            int val2 = winPos[i][2];

            if(filledPos[val0]==filledPos[val1] && filledPos[val1]== filledPos[val2]){
                if(filledPos[val0] != -1){
                    isGameActive=false;

                    //winner Declared
                    if(filledPos[val0]==playerO)
                       showDialog("O is Winner!");
                    else
                        showDialog("X is Winner!");

                }
            }

        }
    }


        private void showDialog(String WinnerText){
        new AlertDialog.Builder(this)
                .setTitle(WinnerText)
                .setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        restartGame();
                    }
                })
                .show();
        }


        private void restartGame(){

        active_player=playerO;
        headerText.setText("Next Turn= O");
        filledPos= new int [] {-1,-1,-1,-1,-1,-1,-1,-1,-1};

            btn0.setText("");
            btn1.setText("");
            btn2.setText("");
            btn3.setText("");
            btn4.setText("");
            btn5.setText("");
            btn6.setText("");
            btn7.setText("");
            btn8.setText("");

            btn0.setBackground(getDrawable(android.R.color.darker_gray));
            btn1.setBackground(getDrawable(android.R.color.darker_gray));
            btn2.setBackground(getDrawable(android.R.color.darker_gray));
            btn3.setBackground(getDrawable(android.R.color.darker_gray));
            btn4.setBackground(getDrawable(android.R.color.darker_gray));
            btn5.setBackground(getDrawable(android.R.color.darker_gray));
            btn6.setBackground(getDrawable(android.R.color.darker_gray));
            btn7.setBackground(getDrawable(android.R.color.darker_gray));
            btn8.setBackground(getDrawable(android.R.color.darker_gray));

            isGameActive=true;


        }



}