package com.thoughtinterac.realestateapp.Model;

/**
 * Created by AzaharSheikh on 03-10-2016.
 */
public class MyProjectListModel
{

    public String getProjectDate() {
        return ProjectDate;
    }

    public void setProjectDate(String projectDate) {
        ProjectDate = projectDate;
    }

    public String getProjectLocation() {
        return ProjectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        ProjectLocation = projectLocation;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getProjectType() {
        return ProjectType;
    }

    public void setProjectType(String projectType) {
        ProjectType = projectType;
    }

    String ProjectName,ProjectLocation,ProjectDate,ProjectType;

}
