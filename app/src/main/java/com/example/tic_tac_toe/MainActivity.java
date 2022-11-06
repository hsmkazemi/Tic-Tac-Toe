package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Boolean activePlayer = true;
    int [][] playTable = {{0,0,0},{0,0,0},{0,0,0}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void ClickOnImage(View view){
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



    }

}