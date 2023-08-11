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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_menu_gpt, container, false);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        webView = rootView.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        // 웹 페이지 로드
        webView.loadUrl("https://hackerton-f6788.web.app/chatGPT");

        // 웹 뷰와 네이티브 앱 간 데이터 통신을 위한 인터페이스 설정
        webView.addJavascriptInterface(new AppInterface(), "dabae");

        // Javascript 명령 실행
        String dataToSend = user.getUid(); // user uid 가져오기
        String javascriptCommand = "javascript:recommandLecture('" + dataToSend + "')";
        webView.loadUrl(javascriptCommand);
        displayTextView = rootView.findViewById(R.id.text_output);
        return rootView;
    }

    public class AppInterface {
        @JavascriptInterface
        public void dataToApp(String data) {
            displayTextView.setText(data);
           /* runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl("javascript:handleResultFromApp('" + data + "')");
                }
            });
            */
        }
    }
}
