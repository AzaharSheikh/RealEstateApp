package com.thoughtinterac.realestateapp.Model;

/**
 * Created by AzaharSheikh on 03-10-2016.
 */
public class MyProjectListModel
{

    String project_list;
    String projDetails;

    public String getDoc_deatils() {
        return projDetails;
    }

    public void setDoc_deatils(String doc_deatils) {
        this.projDetails = doc_deatils;
    }



    public String getDoc_status() {
        return project_list;
    }

    public void setDoc_status(String doc_status) {
        this.project_list = doc_status;
    }


}
