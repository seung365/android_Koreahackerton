package com.example.dabaewo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class login2 extends AppCompatActivity {
    private static final int REQUEST_SEARCH_ADDRESS = 1;
    private TextInputEditText loginAddField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        loginAddField = findViewById(R.id.add);

        loginAddField.setOnClickListener(new View.OnClickListener() {
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
            // 주소 검색 결과 처리
            if (loginAddField != null && address != null && !address.isEmpty()) {
                loginAddField.setText(address);
            }
        }
    }
}
