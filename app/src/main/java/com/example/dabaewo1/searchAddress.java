package com.example.dabaewo1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.QuickContactBadge;

public class searchAddress extends AppCompatActivity {

    private EditText mEdtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_address);

        mEdtAddress = findViewById(R.id.et_address);
        //block touch
        mEdtAddress.setFocusable(false);
        mEdtAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //주소 검색 웹뷰 화면으로 이동

                Intent intent = new Intent(searchAddress.this, searchActivity.class);
                getSearchResult.launch(intent);
            }
        });


    }

    private final ActivityResultLauncher<Intent> getSearchResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                //Search Activity 로부터의 결과 값이 이곳으로 전달 된다.
                if(result.getResultCode() == RESULT_OK){
                    if(result.getData() != null){
                        String data = result.getData().getStringExtra("data");
                        mEdtAddress.setText(data);
                    }
                }
            }

    );
}