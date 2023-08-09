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

public class survey_1 extends AppCompatActivity {

    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey1);



        ImageButton farmerButton = findViewById(R.id.farmer_button);
        farmerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               value = 0; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_2.class);
                startActivity(intent);
            }
        });

        ImageButton policebutton = findViewById(R.id.police_button);
        policebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 value = 1; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_2.class);
                startActivity(intent);
            }
        });

        ImageButton sellerButton = findViewById(R.id.seller_button);
        sellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 2; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_2.class);
                startActivity(intent);
            }
        });

        ImageButton programerbutton = findViewById(R.id.programer_button);
        programerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 value = 3; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_2.class);
                startActivity(intent);
            }
        });

        ImageButton scientistbutton = findViewById(R.id.scientist_button);
        scientistbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               value = 4; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_2.class);
                startActivity(intent);
            }
        });

        ImageButton mechanicbutton = findViewById(R.id.mechanic_button);
        mechanicbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 5; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_2.class);
                startActivity(intent);
            }
        });

        ImageButton workerbutton = findViewById(R.id.worker_button);
        workerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 6; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_2.class);
                startActivity(intent);
            }
        });

        ImageButton soldierbutton = findViewById(R.id.soldier_button);
        soldierbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              value = 7; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_2.class);
                startActivity(intent);
            }
        });

        ImageButton nothingbutton = findViewById(R.id.nothing_button);
        nothingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = 8; // 원하는 값(예: 1)을 부여
                Log.d("ImageButtonClick", "ImageButton Clicked, Value: " + value);
                Intent intent = new Intent(getApplicationContext(), survey_2.class);
                startActivity(intent);
            }
        });







    }
}
