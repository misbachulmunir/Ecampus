package com.munirkubangkangkung.ecampus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
WebView web;

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Tunggu sebentar...");
        progressDialog.show();
        //inisialisasi
        web=findViewById(R.id.webviewpb);
        web.getSettings().setLoadsImagesAutomatically(true);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://ecampus.pelitabangsa.ac.id/pb/ecampus.jsp");

        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressDialog.dismiss();
                //mengambil judull di web
                getSupportActionBar().setTitle(web.getTitle());
            }
        });
    }

    




}