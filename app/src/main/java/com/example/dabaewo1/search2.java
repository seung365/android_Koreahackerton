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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class search2 extends AppCompatActivity {

    private static final String TAG = "serach2Activity";
    private FirebaseAuth mAuth;
    TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextView;
    TextView textShowItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.loginButton).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            login();
        }
    };
    //    public void onTextView7Clicked(View view) {
//        // 다른 화면으로 이동하는 코드 작성
//        Intent intent = new Intent(this, com.example.dabaewo1.login2.class);
//        startActivity(intent);
//    }
    private void startLoginActicity(){
        Intent intent = new Intent(this, com.example.dabaewo1.login2.class);
        startActivity(intent);
    }

    private void login(){
        String email = ((TextInputLayout)findViewById(R.id.textField)).getEditText().getText().toString();
        String password = ((TextInputLayout)findViewById(R.id.textField2)).getEditText().getText().toString();

        if(email.length() > 0 && password.length() > 0){
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("로그인 성공");
                                startLoginActicity();
                            } else {
                                if (task.getException() != null) {
                                    // 실패한 예외를 로그로 출력합니다.
                                    Log.e("LoginActivity", "로그인 실패: " + task.getException().getMessage());
                                    startToast("이메일이나 패스워드가 틀렸습니다.ㅠ");
                                }
                            }
                        }
                    });
        }
        else{
            startToast("이메일과 패스워드를 입력하세요.");
        }
    }




}


