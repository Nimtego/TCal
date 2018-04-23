package com.nimtego.tcal.model.sql;

import android.content.Context;

import com.nimtego.tcal.model.Project;

import java.util.List;

public interface TrenchDataProvider {
    List<Project> getList();
    boolean addProject(Project project);
    boolean removeById(int id);
    void setContentDB(Context context);
    boolean removeByName(String name);
    boolean nameIsBusy(String name);
    boolean dbHelperIsNull();
}
