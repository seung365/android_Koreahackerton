package com.example.dabaewo1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dabaewo1.R;
import com.google.android.material.textfield.TextInputLayout;

public class survey_2 extends AppCompatActivity {

    private int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey2);




        ImageButton bookButton = findViewById(R.id.book_button);
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 0; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_3.class);
                startActivity(intent);
            }
        });

        ImageButton readingbookbutton = findViewById(R.id.readingbook_button);
        readingbookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 1; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_3.class);
                startActivity(intent);
            }
        });

        ImageButton smart_learnbutton = findViewById(R.id.smart_learn_button);
        smart_learnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 2; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_3.class);
                startActivity(intent);
            }
        });

        ImageButton sportsbutton = findViewById(R.id.sports_button);
        sportsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 3; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_3.class);
                startActivity(intent);
            }
        });

        ImageButton paintingbutton = findViewById(R.id.painting_button);
        paintingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 4; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_3.class);
                startActivity(intent);
            }
        });

        ImageButton musicbutton = findViewById(R.id.music_button);
        musicbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 5; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_3.class);
                startActivity(intent);
            }
        });

        ImageButton jobbutton = findViewById(R.id.job_button);
        jobbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 6; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_3.class);
                startActivity(intent);
            }
        });



        ImageButton cookingbutton = findViewById(R.id.cooking_button);
        cookingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               value = 7; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_3.class);
                startActivity(intent);
            }
        });

        ImageButton chessbutton = findViewById(R.id.chess_button);
        chessbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 8; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_3.class);
                startActivity(intent);
            }
        });








    }
}
