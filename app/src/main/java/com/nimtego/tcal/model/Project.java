package com.nimtego.tcal.model;


public class Project {
    private long mId;

    private InputData mInputData;
    private CalculateData mCalculateData;

    public Project(InputData inputData) {
        mInputData = inputData;
        mId = 0L;
    }

    public InputData getInputDate() {
        return mInputData;
    }

    public void setId(long id) {
        mId = id;
    }
    public long getId() {
        return mId;
    }

    public String getName() {
        return mInputData.getProjectName();
    }
}
