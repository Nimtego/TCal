package com.nimtego.tcal.presenter;

import android.util.Log;
import android.view.View;

import com.nimtego.tcal.R;
import com.nimtego.tcal.model.InputData;
import com.nimtego.tcal.model.Project;
import com.nimtego.tcal.model.ProjectProvider;
import com.nimtego.tcal.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class TrenchPresenter extends AbstractBasePresenter {
    private final String TAG = "TrenchPresenter";
    private List<Project> mProjectList;
    private static long idCr = 0L;

    @Override
    public void viewIsReady() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_button:
                Log.v(TAG, "  add_button in onClick() method");
                getDataFromActivity();
                break;
            case R.id.clear_button:
                clear();
                break;
        }
    }

    private void clear() {
        ((MainView)commonView).setData(InputData.dataBuilder().build());
    }

    private void getDataFromActivity() {
        InputData inputData = ((MainView)commonView).getData();
        if (inputData.getProjectName().isEmpty() ) { // TODO: 18.04.2018 hint check?
            commonView.toast("Name is empty");
        }
        else if (ProjectProvider.getProjectProvider().nameIsBusy(inputData.getProjectName())) { // TODO: 18.04.2018 hint check?
            commonView.toast("Name is busy");
        }
        else {
            Project project = new Project(inputData.getProjectName());
            project.setId(++idCr);
            addProject(project);
        }

    }

    private void addProject(Project project) {
        Log.v(TAG, " add project");
        ProjectProvider.getProjectProvider().add(project);
        commonView.toast(project.getNameProject());
    }


    private boolean nameIsBusy(String projectName) {
        for (Project pj : mProjectList) {
            if (pj.getNameProject().equals(projectName))
                return true;
        }
        return false;
    }

}
