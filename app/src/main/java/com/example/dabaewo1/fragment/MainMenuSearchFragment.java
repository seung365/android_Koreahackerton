package com.example.dabaewo1.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.view.inputmethod.EditorInfo;
import android.view.KeyEvent;

import androidx.fragment.app.Fragment;

import com.example.dabaewo1.R;
import com.example.dabaewo1.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainMenuSearchFragment extends Fragment {

    private List<String> list;
    private ListView listView;
    private EditText editSearch;
    private SearchAdapter adapter;
    private ArrayList<String> arraylist;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_menu_search, container, false);

        editSearch = rootView.findViewById(R.id.editSearch);
        listView = rootView.findViewById(R.id.listView);

        list = new ArrayList<String>();
        settingList();
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);
        adapter = new SearchAdapter(list, requireContext());
        listView.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editable.toString();
                if (!text.isEmpty() && text.charAt(text.length() - 1) == '\n') {
                    // Enter 키를 눌렀을 때 처리
                    editable.replace(text.length() - 1, text.length(), ""); // Enter 제거
                    addToListAndRefresh(text); // 리스트에 추가하고 아답터 갱신
                } else {
                    search(text); // 엔터 키 이외의 입력에 대한 검색 처리
                }
            }
        });

        return rootView;
    }

    private void addToListAndRefresh(String text) {
        list.add(text.trim()); // 입력된 텍스트를 리스트에 추가
        adapter.notifyDataSetChanged(); // 아답터 갱신
    }

    public void search(String charText) {
        list.clear();

        if (charText.length() == 0) {
            list.addAll(arraylist);
        } else {
            for (int i = 0; i < arraylist.size(); i++) {
                if (arraylist.get(i).toLowerCase().contains(charText)) {
                    list.add(arraylist.get(i));
                }
            }
        }

        adapter.notifyDataSetChanged(); // 데이터 변경 알림
    }

    private void settingList() {
        list.add("국어");
        list.add("영어");
        list.add("수학");
        list.add("과학");
        list.add("미술");
    }
}
