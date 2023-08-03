package com.example.dabaewo1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.dabaewo1.searchActivity;
import com.google.android.material.textfield.TextInputLayout;

public class searchAddress extends AppCompatActivity {

    private EditText mEdtAddress;
    private ImageButton edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        TextInputLayout loginAddField = findViewById(R.id.login_add_field);
        mEdtAddress = loginAddField.getEditText(); // Get the EditText from TextInputLayout
        edt = findViewById(R.id.myButton);
        edt.setFocusable(false);
        edt.setOnClickListener(view -> {
            //주소 검색 웹뷰 화면으로 이동
            Intent intent = new Intent(searchAddress.this, searchActivity.class);
            getSearchResult.launch(intent);
        });

    }

    private final ActivityResultLauncher<Intent> getSearchResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                //Search Activity 로부터의 결과 값이 이곳으로 전달 된다.
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null) {
                        String data = result.getData().getStringExtra("data");
                        if (data != null && !data.isEmpty()) {
                            mEdtAddress.setText(data); // Set the text to the EditText
                        }
                    }
                }
            }

    );
}
