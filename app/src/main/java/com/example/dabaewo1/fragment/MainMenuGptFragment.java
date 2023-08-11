package com.example.dabaewo1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.dabaewo1.R;

public class MainMenuGptFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_menu_gpt, container, false);

        final EditText input = rootView.findViewById(R.id.text_input);
        Button print_button = rootView.findViewById(R.id.button_text01);
        final TextView output = rootView.findViewById(R.id.text_output);

        print_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText(input.getText());
            }
        });

        return rootView;
    }
}
