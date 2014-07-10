package com.example.momentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.actionbarsherlock.app.SherlockActivity;
import com.example.momentdemo.http.HttpGetMomentData;


public class MainActivity extends SherlockActivity {

    public static final String TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActionbar();


        new HttpGetMomentData().getHttpMomentData();

    }

    private void initActionbar() {
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        View customNav = LayoutInflater.from(this).inflate(
                R.layout.custom_actionbar, null);

        getSupportActionBar().setCustomView(customNav);

    }


}
