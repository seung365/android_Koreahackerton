package com.example.dabaewo1.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dabaewo1.MyRecyclerAdapter;
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
    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mRecyclerAdapter;
    private ArrayList<lecture> mLectureList = new ArrayList<>();
    private FirebaseFirestore db; // Firestore 인스턴스

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_menu_search, container, false);

        mRecyclerView = rootView.findViewById(R.id.recyclerview);

        // LinearLayoutManager 설정
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        // 어댑터 초기화 및 RecyclerView에 설정
        mRecyclerAdapter = new MyRecyclerAdapter();
        mRecyclerView.setAdapter(mRecyclerAdapter);

        // Firebase Firestore 인스턴스 초기화
        db = FirebaseFirestore.getInstance();

        // Firebase 데이터 가져오기
        fetchFirebaseData();

        return rootView;
    }

    private void fetchFirebaseData() {
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

                            // 어댑터에 데이터 설정 및 갱신
                            mLectureList.addAll(lectures);
                            mRecyclerAdapter.setFriendList(mLectureList);
                            mRecyclerAdapter.notifyDataSetChanged(); // 어댑터에 데이터가 변경되었음을 알림
                        } else {
                            // Firestore 데이터 가져오기 실패
                            Log.d("MainMenuSearchFragment", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
}
