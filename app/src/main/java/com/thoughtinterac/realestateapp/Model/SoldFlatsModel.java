package com.thoughtinterac.realestateapp.Model;

/**
 * Created by AshwiniBadgujar on 07-10-2016.
 */
public class SoldFlatsModel {

    private  String NameoftheAuthor;
    private  String FlatNo;
    private  String FlatType;
    private  String DateofPurchase;
    private  String OutOfResale;
    private  String Number;


    public String getNumber() {
        return Number;
    }
    public void setNumber(String number) {
        Number=number;
    }

    public String getNameoftheAuthor() {
        return NameoftheAuthor;
    }

    public void setNameoftheAuthor(String nameoftheAuthor) {
        NameoftheAuthor = nameoftheAuthor;
    }

    public String getFlatNo() {
        return FlatNo;
    }

    public void setFlatNo(String flatNo) {
        FlatNo = flatNo;
    }

    public String getFlatType() {
        return FlatType;
    }

    public void setFlatType(String flatType) {
        FlatType = flatType;
    }

    public String getDateofPurchase() {
        return DateofPurchase;
    }

    public void setDateofPurchase(String dateofPurchase) {
        DateofPurchase = dateofPurchase;
    }

    public String getOutOfResale() {
        return OutOfResale;
    }

    public void setOutOfResale(String outOfResale) {
        OutOfResale = outOfResale;
    }


}

