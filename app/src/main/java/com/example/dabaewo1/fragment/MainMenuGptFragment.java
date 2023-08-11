package com.example.dabaewo1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.dabaewo1.R;

public class MainMenuGptFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_menu_gpt, container, false);

        final TextView displayTextView = rootView.findViewById(R.id.text_output);
        displayTextView.setText("이것은 임의의 문자열입니다.");

        return rootView;
    }
}
