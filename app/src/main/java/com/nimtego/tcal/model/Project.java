package com.nimtego.tcal.model;


public class Project {
    private long id;

    private InputData mInputData;
    private CalculateData mCalculateData;

    public Project(InputData inputData) {
        mInputData = inputData;
        id = 0L;
    }

    public InputData getInputDate() {
        return mInputData;
    }
}
