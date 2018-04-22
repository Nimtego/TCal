package com.nimtego.tcal.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectProvider {
    private List<Project> mProjectList;
    private static ProjectProvider mProjectProvider;

    private ProjectProvider() {
        mProjectList = new ArrayList<>();
        mProjectProvider = this;
    }

    public static ProjectProvider getProjectProvider() {
        if (mProjectProvider == null)
            mProjectProvider = new ProjectProvider();
        return mProjectProvider;
    }

    public boolean add(Project project) {
        return mProjectList.add(project);
    }

    public Project remove(int number) {
        return mProjectList.remove(number);
    }

    public boolean remove(String name) {
        for (Project pr : mProjectList) {
            if (pr.getNameProject().equals(name))
                return mProjectList.remove(pr);
        }
        return false;
    }

    public boolean nameIsBusy(String name) {
        for (Project pr : mProjectList){
            if (pr.getNameProject().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public String[] arrayNames() {
        String[] names = new String[mProjectList.size()];
        for (int i = 0; i < names.length; i++) {
            names[i] = mProjectList.get(i).getNameProject();
        }
        return names;
    }

}
