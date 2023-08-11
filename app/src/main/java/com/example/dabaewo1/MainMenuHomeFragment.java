package com.example.dabaewo1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import androidx.fragment.app.Fragment;

public class MainMenuHomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main_menu_home, container, false);

        // OneActivity를 자동으로 호출하는 코드
        Intent intent = new Intent(getActivity(), gpt_1.class);
        startActivity(intent);

        return rootView;
    }




}