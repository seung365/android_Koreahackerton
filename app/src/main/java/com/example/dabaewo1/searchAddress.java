package com.example.dabaewo1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.dabaewo1.searchActivity;
import com.google.android.material.textfield.TextInputLayout;

public class searchAddress extends AppCompatActivity {

    private EditText mEdtAddress;
    private TextInputLayout loginAddField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        loginAddField = findViewById(R.id.login_add_field);
        mEdtAddress = loginAddField.getEditText(); // TextInputLayout에서 EditText를 가져옵니다.

        Intent intent = new Intent(searchAddress.this, searchActivity.class);
        getSearchResult.launch(intent);


    }

    private final ActivityResultLauncher<Intent> getSearchResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                // SearchActivity로부터의 결과 값이 이곳으로 전달됩니다.
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null) {
                        String data = result.getData().getStringExtra("data");
                        if (data != null && !data.isEmpty()) {
                            mEdtAddress.setText(data); // EditText에 주소를 설정합니다.
                        }
                    }
                }
            }
    );
}
