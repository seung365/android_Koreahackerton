package com.example.dabaewo1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.dabaewo1.R;
import com.example.dabaewo1.SendUID;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainMenuGptFragment extends Fragment {

    private WebView webView;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private TextView displayTextView;
    private String dataToSend;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_menu_gpt, container, false);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        dataToSend = user.getUid(); // user uid 가져오기

        displayTextView = rootView.findViewById(R.id.text_output); // TextView 초기화
        displayTextView.setText("기본값"); // 기본값 설정

        webView = rootView.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        // 웹 페이지 로드
        webView.loadUrl("https://hackerton-f6788.web.app/chatGPT");
        webView.setVisibility(webView.GONE);

        // 웹 뷰와 네이티브 앱 간 데이터 통신을 위한 인터페이스 설정
        webView.addJavascriptInterface(new AppInterface(), "dabae");
        displayTextView.setText("왜안돼");

        // Javascript 명령 실행

        return rootView;
    }

    public class AppInterface {
        @JavascriptInterface
        public String DataToWeb() {
            // 네이티브 앱에서 생성한 데이터
            return dataToSend;
        }
        @JavascriptInterface
        public void dataToApp(String data) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    displayTextView.setText(data);
                }
            });
        }
    }
}
