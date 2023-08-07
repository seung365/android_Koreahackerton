package com.example.dabaewo1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class login2 extends AppCompatActivity
{
    //Tag
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

        if(id.length() > 0 && password.length() > 0){ // 이메일 비번 안적었을 때
            mAuth.createUserWithEmailAndPassword(id, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                startToast("회원가입 성공");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUser(name, nickname, email, gender, phoneNumber, address);
                                startsurveyActicity();
                                // 성공시 updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "회원가입 실패", task.getException());
                                //실패시 updateUI(null);
                            }
                        }
                    });
        }
        else{
            startToast("id과 패스워드를 입력하세요.");
        }
    }

    private final ActivityResultLauncher<Intent> getSearchResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                // SearchActivity로부터의 결과 값이 이곳으로 전달됩니다.
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null) {
                        String data = result.getData().getStringExtra("address");
                        if (data != null && !data.isEmpty()) {
                            ((TextInputLayout) findViewById(R.id.login_add_field)).getEditText().setText(data); // EditText에 주소를 설정합니다.
                        }
                    }
                }
            }
    );
    public void updateUser(String name, String nickname, String email, String gender, String phoneNumber, String address)
    {
        if (name.length() > 0 && phoneNumber.length() > 9 && email.length() > 0 && address.length() > 0)
        {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance(); //fireStore 초기화
            UserInfo userinfo = new UserInfo(name, nickname, email, gender, phoneNumber, address);
            if (user != null)
            {
                db.collection("users").document(user.getUid()).set(userinfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>()
                        {
                            @Override
                            public void onSuccess(Void aVoid)
                            {
                                startToast("회원정보 등록을 성공하였습니다.");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener()
                        {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                                startToast("회원정보 등록에 실패했습니다.");
                            }
                        });
            }
        }
        else
        {
            startToast("회원정보를 입력해주세요.");
        }
    }
    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}