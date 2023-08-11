package com.example.dabaewo1;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SendUID extends AppCompatActivity {

    private WebView webView;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        //webView = findViewById(R.id.textView);
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
    }

    // 웹 뷰와 네이티브 앱 간 데이터 통신을 위한 인터페이스 클래스
    public class AppInterface {
        @JavascriptInterface
        public void dataToApp(String data) {
            // 결과 데이터를 웹 페이지의 JavaScript 함수로 전달
            /*
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl("javascript:handleResultFromApp('" + data + "')");
                }
            });
            */
        }
    }
}