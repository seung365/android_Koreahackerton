package com.example.dabaewo1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login2 extends AppCompatActivity
{
    private static final String TAG = "login2Activity";
    private static final int REQUEST_SEARCH_ADDRESS = 1;
    private TextInputEditText loginAddField;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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
                Intent intent = new Intent(getApplicationContext(), survey_1.class);
                startActivity(intent);
            }
        });
    }

    // 회원가입 기능.

    //회원가입 버튼 리스너
    View.OnClickListener onClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (v.getId() == R.id.signup_button) signUp();
        }
    };
    private void signUp()
    {
        String name = ((TextInputLayout)findViewById(R.id.namefield)).getEditText().getText().toString();
        String nickname = ((TextInputLayout)findViewById(R.id.nicknamefield)).getEditText().getText().toString();
        String email = ((TextInputLayout)findViewById(R.id.login_mail_Field)).getEditText().getText().toString();
        String password = ((TextInputLayout)findViewById(R.id.login_pw_field)).getEditText().getText().toString();
        String gender = ((TextInputLayout)findViewById(R.id.gender)).getEditText().getText().toString();
        String id = ((TextInputLayout)findViewById(R.id.login_id_Field)).getEditText().getText().toString();
        String phoneNumber = ((TextInputLayout)findViewById(R.id.login_telefield)).getEditText().getText().toString();
        String address = ((TextInputLayout)findViewById(R.id.login_add_field)).getEditText().getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "회원 가입에 성공했습니다.");
                            FirebaseUser user = mAuth.getCurrentUser();
                            // 성공시 updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "회원가입 실패", task.getException());
                            //실패시 updateUI(null);
                        }
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