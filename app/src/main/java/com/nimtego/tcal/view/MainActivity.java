package com.nimtego.tcal.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nimtego.tcal.model.InputData;
import com.nimtego.tcal.R;
import com.nimtego.tcal.presenter.Presenter;
import com.nimtego.tcal.presenter.TrenchPresenter;

public class MainActivity extends AppCompatActivity implements MainView {
    private Presenter mPresenter;
    private EditText projectName;
    private EditText lineLong;
    private EditText power;
    private EditText voltage;
    private EditText intersection;
    private AppCompatCheckBox plate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mPresenter = new TrenchPresenter();
        mPresenter.attachView(this); // TODO: 18.04.2018 inject Dagger2
        Button add = findViewById(R.id.add_button);
        Button clear = findViewById(R.id.clear_button);
        add.setOnClickListener(mPresenter);
        clear.setOnClickListener(mPresenter);
        projectName = findViewById(R.id.project_name_editText);
        lineLong = findViewById(R.id.line_long_editText);
        power = findViewById(R.id.power_editText);
        voltage = findViewById(R.id.voltage_editText);
        intersection = findViewById(R.id.intersections_editText);
        plate = findViewById(R.id.plate_CheckBox);

    }

    @Override
    public InputData getData() {
        return InputData.dataBuilder().
                projectName(String.valueOf(projectName.getText())).
                lineLong(String.valueOf(lineLong.getText())).
                power(String.valueOf(power.getText())).
                voltage(String.valueOf(voltage.getText())).
                intersection(String.valueOf(intersection.getText())).
                plate(plate.callOnClick()).build();
    }

    @Override
    public void setData(InputData inputData) {
        projectName.clearComposingText();
        projectName.setText(inputData.getProjectName());
        lineLong.setText(inputData.getLineLong());
        power.setText(inputData.getPower());
        voltage.setText(inputData.getVoltage());
        intersection.setText(inputData.getIntersection());
        plate.setChecked(inputData.isPlate());
    }

    @Override
    public void toast(String message) {
        Toast.makeText(MainActivity.this, message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void alarm(String message) {

    }

    @Override
    public void intent(Class<MainActivity> commonView) {

    }
}
