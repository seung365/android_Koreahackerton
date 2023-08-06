package com.example.dabaewo1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.UpdateRequest;
import java.io.FileInputStream;
import java.io.IOException;

public class login2 extends AppCompatActivity
{
    private static final String TAG = "login2Activity";
    private static final int REQUEST_SEARCH_ADDRESS = 1;
    private TextInputEditText loginAddField;
    private FirebaseAuth mAuth;
    private String name;
    private String nickname;
    private String email;
    private String password;
    private String gender;
    private String id;
    private String phoneNumber;
    private String address;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        mAuth = FirebaseAuth.getInstance();
        EditText btnSearchAddress = findViewById(R.id.add);
        btnSearchAddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean gainFocus) {
                //포커스가 주어졌을 때 동작
                if (gainFocus) {
                    // 주소 검색 웹뷰 화면으로 이동
                    Intent intent = new Intent(login2.this, searchAddress.class);
                    getSearchResult.launch(intent);
                }
            }
        });

        findViewById(R.id.signup_button).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                if (view.getId() == R.id.signup_button) {
                    startToast("클릭");
                    signUp();
                }
            }
        });
    }


    private void startsurveyActicity(){
        Intent intent = new Intent(this, survey_1.class);
        startActivity(intent);
    }
    // 회원가입 기능.
    public void updateUser(String name, String nickname, String gender, String id, String phoneNumber, String address, String tmpUID)
    {
            try {
                // Firebase Admin SDK 초기화
                FileInputStream serviceAccount = new FileInputStream("path/to/your/serviceAccountKey.json");
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setDatabaseUrl("https://your-project-id.firebaseio.com")
                        .build();
                FirebaseApp.initializeApp(options);

                // 사용자 정보 업데이트 예시
                String uid = tmpUID; // 사용자의 고유한 식별자 (UID)
                String newName = name; // 사용자 이름
                String newGender = gender; // 성별
                String newAddress = address; // 주소
                String newNickname = nickname; // 별명
                String newId = id; // ID
                String newPhone = phoneNumber;

                // 사용자 정보 업데이트 요청 생성
                UpdateRequest request = new UpdateRequest(uid)
                        .setDisplayName(newName)
                        .setCustomClaim("gender", newGender) // 사용자 정의(Claim) 프로퍼티 추가
                        .setCustomClaim("address", newAddress) // 사용자 정의(Claim) 프로퍼티 추가
                        .setCustomClaim("nickname", newNickname) // 사용자 정의(Claim) 프로퍼티 추가
                        .setCustomClaim("id", newId) // 사용자 정의(Claim) 프로퍼티 추가
                        .setCustomClaim("phoneNumber", newPhone);

                // 사용자 정보 업데이트
                UserRecord userRecord = FirebaseAuth.getInstance().updateUser(request);

                System.out.println("사용자 정보가 성공적으로 업데이트되었습니다.");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    //회원가입 버튼 리스너
    private void signUp()
    {
        name = ((TextInputLayout) findViewById(R.id.namefield)).getEditText().getText().toString();
        nickname = ((TextInputLayout) findViewById(R.id.nicknamefield)).getEditText().getText().toString();
        email = ((TextInputLayout) findViewById(R.id.login_mail_Field)).getEditText().getText().toString();
        password = ((TextInputLayout) findViewById(R.id.login_pw_field)).getEditText().getText().toString();
        gender = ((TextInputLayout) findViewById(R.id.gender)).getEditText().getText().toString();
        id = ((TextInputLayout) findViewById(R.id.login_id_Field)).getEditText().getText().toString();
        phoneNumber = ((TextInputLayout) findViewById(R.id.login_telefield)).getEditText().getText().toString();
        address = ((TextInputLayout) findViewById(R.id.login_add_field)).getEditText().getText().toString();
}