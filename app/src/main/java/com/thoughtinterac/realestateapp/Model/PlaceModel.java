package com.thoughtinterac.realestateapp.Model;

/**
 * Created by AzaharSheikh on 30-09-2016.
 */
public class PlaceModel {

    private String place_title;
    private String place_id;
    private String  place_address;
    private String  place_distance;
    private String  place_type;
    private String  lat;
    private String  lng;
    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }


    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }


    public String getPlace_title() {
        return place_title;
    }

    public void setPlace_title(String place_title) {
        this.place_title = place_title;
    }

    public String getPlace_address() {
        return place_address;
    }

    public void setPlace_address(String place_address) {
        this.place_address = place_address;
    }

    public String getPlace_distance() {
        return place_distance;
    }

    public void setPlace_distance(String place_distance) {
        this.place_distance = place_distance;
    }

    public String getPlace_type() {
        return place_type;
    }

    public void setPlace_type(String place_type) {
        this.place_type = place_type;
    }


}
