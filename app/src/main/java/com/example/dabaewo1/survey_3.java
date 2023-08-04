package com.example.dabaewo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class survey_3 extends AppCompatActivity {

    private int value;

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
                value = 0;
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), search2.class);
                startActivity(intent);
            }
        });

        purpose2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 1;
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), search2.class);
                startActivity(intent);
            }
        });

        purpose3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 2;
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), search2.class);
                startActivity(intent);
            }
        });

        purpose4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 3; //
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), search2.class);
                startActivity(intent);
            }
        });

        purpose5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 4;
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), search2.class);
                startActivity(intent);
            }
        });

        purpose6_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 5;
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), search2.class);
                startActivity(intent);
            }
        });
    }
}