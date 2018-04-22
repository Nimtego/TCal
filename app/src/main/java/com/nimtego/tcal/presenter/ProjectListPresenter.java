package com.nimtego.tcal.presenter;

import android.util.Log;
import android.view.View;

import com.nimtego.tcal.R;
import com.nimtego.tcal.view.MainActivity;

public class ProjectListPresenter extends AbstractBasePresenter {
    private final String TAG = "ProjectListPresenter";

    @Override
    public void viewIsReady() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.project_add_fragment:
                Log.v(TAG, "  add_button in onClick() method");
                addProject();
                break;
        }
    }

    private void addProject() {
        commonView.intent(MainActivity.class);
    }
}
