package com.example.dabaewo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class survey_3 extends AppCompatActivity {

    private int value;
    private String name;
    private String nickname;
    private String email;
    private String gender;
    private String phoneNumber;
    private String address;
    private int age;
    private int job;
    private int interest;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey3);

        intent = getIntent();
        name = intent.getStringExtra("name");
        nickname = intent.getStringExtra("nickname");
        email = intent.getStringExtra("email");
        gender = intent.getStringExtra("gender");
        phoneNumber = intent.getStringExtra("phoneNumber");
        address = intent.getStringExtra("address");
        age = intent.getIntExtra("age");
        job = intent.getIntExtra("job", 0);
        interest = intent.getIntExtra("interest", 0);

        findViewById(R.id.purpose1).setOnClickListener(onClickListener);
        findViewById(R.id.purpose2).setOnClickListener(onClickListener);
        findViewById(R.id.purpose3).setOnClickListener(onClickListener);
        findViewById(R.id.purpose4).setOnClickListener(onClickListener);
        findViewById(R.id.purpose5).setOnClickListener(onClickListener);
        findViewById(R.id.purpose6).setOnClickListener(onClickListener);
    }

    private void startLoginActivity(){
        Intent intent = new Intent(this, com.example.dabaewo1.search2.class);
        startActivity(intent);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.purpose1) {
                value = 0;
            } else if (id == R.id.purpose2) {
                value = 1;
            } else if (id == R.id.purpose3) {
                value = 2;
            } else if (id == R.id.purpose4) {
                value = 3;
            } else if (id == R.id.purpose5) {
                value = 4;
            } else if (id == R.id.purpose6) {
                value = 5;
            }
            updateUser(name, nickname, email, gender, phoneNumber, address, job, interest, value);
        }
    };

    public void updateUser(String name, String nickname, String email, String gender, String phoneNumber, String address, int job, int interest, int purpose)
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseFirestore db = FirebaseFirestore.getInstance(); //fireStore 초기화
        UserInfo userinfo = new UserInfo(name, nickname, email, gender, phoneNumber, address, job, interest, purpose, age);
        if (user != null) {
            db.collection("users").document(user.getUid()).set(userinfo)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            startToast("회원정보 등록을 성공하였습니다.");
                            startLoginActivity();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            startToast("회원정보 등록에 실패했습니다.");
                        }
                    });
        }
        else{
            startToast("user is null");
        }
    }
    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}