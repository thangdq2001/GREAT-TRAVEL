package com.example.duan1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class wellcomeApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome_app);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
startActivity(new Intent(wellcomeApp.this,MainActivity.class));
finish();
            }
        },4000);
    }
}