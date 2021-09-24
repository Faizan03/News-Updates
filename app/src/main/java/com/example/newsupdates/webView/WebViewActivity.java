package com.example.newsupdates.webView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.newsupdates.CustomAdapter.CustomAdapterChild;
import com.example.newsupdates.CustomAdapter.CustomAdapterParent;
import com.example.newsupdates.R;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    String Url;
    ProgressBar progressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view);
        webView=findViewById(R.id.webView);
        progressBar2=findViewById(R.id.progressBar3);
        progressBar2.setVisibility(View.VISIBLE);
        Intent intent=getIntent();
        Url=intent.getStringExtra(CustomAdapterChild.WEB_URL);


        webView.setWebViewClient(new WebViewController());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(Url);
    }
    class WebViewController extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }



        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar2.setVisibility(View.GONE);
        }
    }
}
