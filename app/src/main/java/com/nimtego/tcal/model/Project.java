package com.nimtego.tcal.model;


import java.util.Date;

public class Project {
    private long mId;
    private String nameProject;
    private Date createDate;
    private Date changeDate;

    public Project(String nameProject) {
        this.nameProject = nameProject;
        createDate = new Date();
        changeDate = new Date();
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
}
