package com.thoughtinterac.realestateapp.Model;

/**
 * Created by AshwiniBadgujar on 07-10-2016.
 */
public class ProjectModel {



    private  String ProjectName="";
    private  String projectlocation="";
    private  String ProjectDate="";


    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getUserAddr() {
        return projectlocation;
    }

    public void setUserAddr(String userAddr) {
        projectlocation = userAddr;
    }

    public String getDate() {
        return ProjectDate;
    }

    public void setDate(String date) {
        ProjectDate = date;
    }


}

