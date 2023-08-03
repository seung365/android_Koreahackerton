package com.example.dabaewo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class login2 extends AppCompatActivity {
    private static final int REQUEST_SEARCH_ADDRESS = 1;
    private TextInputEditText loginAddField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        EditText btnSearchAddress = findViewById(R.id.add);
        btnSearchAddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean gainFocus) {
                //포커스가 주어졌을 때 동작
                if (gainFocus) {
                    // 주소 검색 웹뷰 화면으로 이동
                    Intent intent = new Intent(login2.this, searchAddress.class);
                    startActivityForResult(intent, REQUEST_SEARCH_ADDRESS);
                }
            }
        });

        ImageButton okbutton = (ImageButton) findViewById(R.id.signup_button);
        okbutton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SEARCH_ADDRESS && resultCode == RESULT_OK && data != null) {
            String address = data.getStringExtra("data");
            // 주소 검색 결과 처리
            if (loginAddField != null && address != null && !address.isEmpty()) {
                loginAddField.setText(address);
            }
        }
    }


}
