package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tic_tac_toe.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickOnImage(View view){
        ImageView clickedImageView = (ImageView) view;
        clickedImageView.setImageResource(R.drawable.oo);
        clickedImageView.animate().alpha(0).setDuration(1000);

    }
}