package com.example.dabaewo1.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dabaewo1.R;
import com.example.dabaewo1.lecture;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainMenuSearchFragment extends Fragment {

    private FirebaseFirestore db;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Firestore 인스턴스 초기화
        db = FirebaseFirestore.getInstance();

        // Firestore 데이터 가져오기 메서드 호출
        fetchDataFromFirestore();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_menu_search, container, false);

        // 이곳에서 rootView 내의 뷰 요소들을 초기화하거나 처리할 수 있습니다.

        return rootView;
    }

    private void fetchDataFromFirestore() {
        db.collection("daegu")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<lecture> lectures = new ArrayList<>();
                            for (DocumentSnapshot document : task.getResult()) {
                                lecture lecture1 = document.toObject(lecture.class);
                                lectures.add(lecture1);
                            }
                            for (lecture lecture : lectures) {
                                Log.d("Lecture", "Lecture: " + lecture.getLectureName());
                            }

                            // 가져온 데이터를 활용하여 원하는 처리를 수행할 수 있습니다.
                        } else {
                            // Firestore 데이터 가져오기 실패
                        }
                    }
                });
    }
}
