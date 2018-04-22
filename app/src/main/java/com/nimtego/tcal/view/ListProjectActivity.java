package com.nimtego.tcal.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nimtego.tcal.R;

public class ListProjectActivity extends AppCompatActivity implements CommonView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_project);
    }

    @Override
    public void toast(String message) {

    }

    @Override
    public void alarm(String message) {

    }
}
