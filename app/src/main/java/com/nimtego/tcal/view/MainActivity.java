package com.nimtego.tcal.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nimtego.tcal.model.CalculateData;
import com.nimtego.tcal.R;

public class MainActivity extends AppCompatActivity implements MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public CalculateData getData() {
/*        CalculateData calculateData = CalculateData.dataBuilder().
                bill(String.valueOf(findViewById(R.id.billEditText))).tip()*/ // TODO: 12.04.2018  
        return null;
    }

    @Override
    public void toast(String message) {

    }

    @Override
    public void alarm(String message) {

    }

    @Override
    public void onClick(View view) {

    }
}
