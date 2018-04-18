package com.nimtego.tcal.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
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
        CalculateData calculateData = CalculateData.dataBuilder().
                projectName(String.valueOf(findViewById(R.id.project_name_editText))).
                lineLong(String.valueOf(findViewById(R.id.line_long_editText))).
                power(String.valueOf(findViewById(R.id.power_editText))).
                voltage(String.valueOf(findViewById(R.id.voltage_editText))).
                intersection(String.valueOf(findViewById(R.id.intersections_editText))).
                plate(findViewById(R.id.plate_CheckBox).callOnClick()).build();
        return calculateData;
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
