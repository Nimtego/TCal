package com.nimtego.tcal.presenter;

import android.view.View;

import com.nimtego.tcal.R;
import com.nimtego.tcal.model.InputData;
import com.nimtego.tcal.model.Project;
import com.nimtego.tcal.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class TrenchPresenter extends AbstractBasePresenter {
    private List<Project> mProjectList;

    @Override
    public void viewIsReady() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_button:
                getDataFromActivity();
                break;
            case R.id.clear_button:
                clear();
        }
    }

    private void clear() {
        ((MainView)commonView).setData(InputData.dataBuilder().build());
    }

    private void getDataFromActivity() {
        InputData inputData = ((MainView)commonView).getData();
        if (mProjectList == null)
            mProjectList = new ArrayList<>();
        if (nameIsBusy(inputData.getProjectName()))
            commonView.toast("Name is busy");
        
    }

    private boolean nameIsBusy(String projectName) {
        for (Project pj : mProjectList) {
            if (pj.getInputDate().getProjectName().equals(projectName))
                return true;
        }
        return false;
    }
}
