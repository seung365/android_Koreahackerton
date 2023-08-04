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




public class search2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);

        TextView loginButton = findViewById(R.id.textView7);

        ImageButton login = (ImageButton)findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 화면 이동 코드를 여기에 작성
                Intent intent = new Intent(getApplicationContext(), home_1.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 화면 이동 코드를 여기에 작성
                Intent intent = new Intent(getApplicationContext(), login2.class);
                startActivity(intent);
            }
        });
    }
}

