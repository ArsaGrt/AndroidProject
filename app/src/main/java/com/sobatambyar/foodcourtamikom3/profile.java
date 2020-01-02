package com.sobatambyar.foodcourtamikom3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.HashMap;

public class profile extends AppCompatActivity {

    SessionManager sessionManager;
    String getId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        HashMap<String, String> user = sessionManager.getUserDetail();
        String strName = user.get(sessionManager.NAME);
        String strEmail = user.get(sessionManager.EMAIL);
    }
}
