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

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dabaewo1.R;
import com.google.android.material.textfield.TextInputLayout;

public class survey_2 extends AppCompatActivity {

    private int value;
    private String name;
    private String nickname;
    private String email;
    private String gender;
    private String phoneNumber;
    private String address;
    private int job;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey2);



        intent = getIntent();
        name = intent.getStringExtra("name");
        nickname = intent.getStringExtra("nickname");
        email = intent.getStringExtra("email");
        gender = intent.getStringExtra("gender");
        phoneNumber = intent.getStringExtra("phoneNumber");
        address = intent.getStringExtra("address");
        job = intent.getIntExtra("job", 0);
        findViewById(R.id.book_button).setOnClickListener(onClickListener);
        findViewById(R.id.readingbook_button).setOnClickListener(onClickListener);
        findViewById(R.id.smart_learn_button).setOnClickListener(onClickListener);
        findViewById(R.id.sports_button).setOnClickListener(onClickListener);
        findViewById(R.id.painting_button).setOnClickListener(onClickListener);
        findViewById(R.id.music_button).setOnClickListener(onClickListener);
        findViewById(R.id.job_button).setOnClickListener(onClickListener);
        findViewById(R.id.cooking_button).setOnClickListener(onClickListener);
        findViewById(R.id.chess_button).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if(id == R.id.book_button){
                value = 0;
            }
            else if(id == R.id.readingbook_button){
                value = 1;
            }
            else if(id == R.id.smart_learn_button){
                value = 2;
            }
            else if(id == R.id.sports_button){
                value = 3;
            }
            else if(id == R.id.painting_button){
                value = 4;
            }
            else if(id == R.id.music_button){
                value = 5;
            }
            else if(id == R.id.job_button){
                value = 6;
            }
            else if(id == R.id.cooking_button){
                value = 7;
            }
            else if(id == R.id.chess_button){
                value = 8;
            }
            Intent intent2 = new Intent(survey_2.this, survey_3.class);
            if(name != null){
                intent2.putExtra("name", name);
                intent2.putExtra("nickname", nickname);
                intent2.putExtra("email", email);
                intent2.putExtra("gender", gender);
                intent2.putExtra("phoneNumber", phoneNumber);
                intent2.putExtra("address", address);
                intent2.putExtra("job", job);
                intent2.putExtra("interest", value);
            }
            startActivity(intent2);
        }
    };
    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
