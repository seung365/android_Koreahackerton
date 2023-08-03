package com.example.dabaewo1;// login2.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dabaewo1.searchAddress;
import com.google.android.material.textfield.TextInputLayout;

public class login2 extends AppCompatActivity {
    private static final int REQUEST_SEARCH_ADDRESS = 1;
    private TextInputLayout loginAddField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        loginAddField = findViewById(R.id.login_add_field);

        ImageButton btnSearchAddress = findViewById(R.id.myButton);
        btnSearchAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 주소 검색 웹뷰 화면으로 이동
                Intent intent = new Intent(login2.this, searchAddress.class);
                startActivityForResult(intent, REQUEST_SEARCH_ADDRESS);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SEARCH_ADDRESS && resultCode == RESULT_OK && data != null) {
            String address = data.getStringExtra("data");
            // 여기서 주소 검색 결과 처리
            EditText editText = loginAddField.getEditText();
            if (editText != null) {
                editText.setText(address);
            }
        }
    }
}
