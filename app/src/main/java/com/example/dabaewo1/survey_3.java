package com.example.dabaewo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class survey_3 extends AppCompatActivity {

    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey3);

        ImageButton purpose1_button = findViewById(R.id.purpose1);
        ImageButton purpose2_button = findViewById(R.id.purpose2);
        ImageButton purpose3_button = findViewById(R.id.purpose3);
        ImageButton purpose4_button = findViewById(R.id.purpose4);
        ImageButton purpose5_button = findViewById(R.id.purpose5);
        ImageButton purpose6_button = findViewById(R.id.purpose6);
        purpose1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 1; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
            }
        });

        purpose2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 2; // 원하는 값(예: 2)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
            }
        });

        purpose3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 3; // 원하는 값(예: 3)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
            }
        });

        purpose4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 4; // 원하는 값(예: 4)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
            }
        });

        purpose5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 5; // 원하는 값(예: 5)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
            }
        });

        purpose6_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 6; // 원하는 값(예: 6)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
            }
        });
    }
}