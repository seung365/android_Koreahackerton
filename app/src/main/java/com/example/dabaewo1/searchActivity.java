package com.example.dabaewo1;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class searchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new BridgeInterFace(), "Android");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // 웹뷰가 로딩 완료되면 주소 검색을 실행합니다.
                webView.loadUrl("javascript:sample2_execDaumPostcode();");
            }
        });

        webView.loadUrl("https://hackerton-f6788.firebaseapp.com");
    }

    private class BridgeInterFace {
        @JavascriptInterface
        public void processData(String data) {
            // 다음 주소 검색 API의 결과 값을 브릿지 통로를 통해 전달 받음
            // 여기서 주소를 클릭했을 때 처리를 수행하고 액티비티를 닫습니다.
            Intent intent = new Intent();
            intent.putExtra("data", data);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
