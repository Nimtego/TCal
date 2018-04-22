package com.nimtego.tcal.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nimtego.tcal.R;
import com.nimtego.tcal.presenter.Presenter;
import com.nimtego.tcal.presenter.ProjectListPresenter;

public class ListProjectActivity extends AppCompatActivity implements CommonView {
    private Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_project);
        init();
    }

    private void init() {
        mPresenter = new ProjectListPresenter();
        findViewById(R.id.project_add_fragment).setOnClickListener(mPresenter);
        mPresenter.attachView(this);
    }

    @Override
    public void toast(String message) {

    }

    @Override
    public void alarm(String message) {

    }

    @Override
    public void intent(Class<MainActivity> commonView) {
        Intent intent = new Intent(this, commonView);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
