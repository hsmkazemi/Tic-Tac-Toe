package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Boolean activePlayer = true;
    int [][] playTable = {{0,0,0},{0,0,0},{0,0,0}};
    int player = 0;
    int [] cellstate = {10,10,10,10,10,10,10,10,10};
    int [][] winnigPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    Boolean newGame = true;
    TextView textViewPlayerO;
    TextView textViewPlayerX;
    int xTime = 0;
    int oTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewPlayerO = findViewById(R.id.txtOplayer);
        textViewPlayerX = findViewById(R.id.txtXplayer);
    }


 /*   public void clickOnImage(View view){
        ImageView clickedImageView = (ImageView) view;
        String imageTag = clickedImageView.getTag().toString();
        String[] status = imageTag.split("");
        int first = Integer.parseInt(status[0]);
        int second = Integer.parseInt(status[1]);

        if (activePlayer) {
            if (playTable[first][second] < 1) {
                clickedImageView.setImageResource(R.drawable.oo);
                playTable[first][second] = 1;
                activePlayer = false;
            }

        }else{
            if (playTable[first][second] < 1) {
                clickedImageView.setImageResource(R.drawable.xx);
                playTable[first][second] = 2;
                activePlayer = true;
            }
        }
        clickedImageView.animate().alpha(1).setDuration(500);

        for (int[] ints : playTable) {
            if( ints[0] == ints[1] && ints[1] == ints[2] && ints[0] + ints[1] + ints[2] == 3 ){
                Toast.makeText(this, "O wins", 300).show();
            }else if( ints[0] == ints[1] && ints[1] == ints[2] && ints[0] + ints[1] + ints[2] == 6 ){
                Toast.makeText(this, "X wins", 300).show();
            }
        }

        if(playTable[0][0] == 1 && playTable[1][0] == 1 && playTable[2][0] == 1 ||
                playTable[0][1] == 1 && playTable[1][1] == 1 && playTable[2][1] == 1 ||
                playTable[0][2] == 1 && playTable[1][2] == 1 && playTable[2][2] == 1 ||
                playTable[0][0] == 1 && playTable[1][1] == 1 && playTable[2][2] == 1 ||
                playTable[0][2] == 1 && playTable[1][1] == 1 && playTable[2][0] == 1 ) {
            Toast.makeText(this, "O wins", 300).show();
        }else if(playTable[0][0] == 2 && playTable[1][0] == 2 && playTable[2][0] == 2 ||
                playTable[0][1] == 2 && playTable[1][1] == 2 && playTable[2][1] == 2 ||
                playTable[0][2] == 2 && playTable[1][2] == 2 && playTable[2][2] == 2 ||
                playTable[0][0] == 2 && playTable[1][1] == 2 && playTable[2][2] == 2 ||
                playTable[0][2] == 2 && playTable[1][1] == 2 && playTable[2][0] == 2 ) {
            Toast.makeText(this, "X wins", 300).show();
        }
    } */



    public void clickOn(View view){
        if(newGame) {
            ImageView clickOnImageView = (ImageView) view;
            int tag = Integer.parseInt(clickOnImageView.getTag().toString());

            if (cellstate[tag] == 10) {
                if (player == 0) {
                    clickOnImageView.setImageResource(R.drawable.oo);
                    cellstate[tag] = player;
                    player = 1;
                } else {
                    clickOnImageView.setImageResource(R.drawable.xx);
                    cellstate[tag] = player;
                    player = 0;
                }
            }
            clickOnImageView.animate().alpha(1).setDuration(500);

            for (int[] winnerCheck : winnigPosition) {
                if (cellstate[winnerCheck[0]] == cellstate[winnerCheck[1]]
                        && cellstate[winnerCheck[1]] == cellstate[winnerCheck[2]]
                        && cellstate[winnerCheck[0]] != 10) {
                    if (cellstate[winnerCheck[0]] + cellstate[winnerCheck[1]] + cellstate[winnerCheck[2]] == 0) {
                        Toast.makeText(this, "O wins", 300).show();
                        oTime = Integer.parseInt(textViewPlayerO.getText().toString());
                        oTime++;
                        textViewPlayerO.setText(oTime+"");
                        newGame = false;
                    } else {
                        Toast.makeText(this, "X wins", 300).show();
                        xTime = Integer.parseInt(textViewPlayerX.getText().toString());
                        xTime++;
                        textViewPlayerX.setText(xTime+"");
                        newGame = false;
                    }

                }

            }

        }else{
            Toast.makeText(this, "The game is over" , 300).show();
        }
    }

    public void newGame(View view){
        ConstraintLayout constraintLayout = findViewById(R.id.container);
        for (int con = 0; con < constraintLayout.getChildCount(); con++) {
            if (constraintLayout.getChildAt(con) instanceof ImageView){
                ImageView imageView = (ImageView) constraintLayout.getChildAt(con);
                if(imageView.getTag() != null){
                    imageView.setImageDrawable(null);
                }
            }
        }
        newGame = true;
        player = 0;
        for (int i = 0; i < 9; i++) {
            cellstate[i] = 10;
        }

    }

    public void resetGame(View view){
        ConstraintLayout constraintLayout = findViewById(R.id.container);
        for (int con = 0; con < constraintLayout.getChildCount(); con++) {
            if (constraintLayout.getChildAt(con) instanceof ImageView){
                ImageView imageView = (ImageView) constraintLayout.getChildAt(con);
                if(imageView.getTag() != null){
                    imageView.setImageDrawable(null);
                }
            }
        }
        newGame = true;
        player = 0;
        for (int i = 0; i < 9; i++) {
            cellstate[i] = 10;
        }
        xTime = 0;
        oTime = 0;
        textViewPlayerX.setText(xTime+"");
        textViewPlayerO.setText(oTime+"");
    }

}