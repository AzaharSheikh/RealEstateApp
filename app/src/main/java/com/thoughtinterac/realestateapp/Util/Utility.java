package com.thoughtinterac.realestateapp.Util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by AzaharSheikh on 30-09-2016.
 */
public class Utility {

    public  static String bank_share_pref="s_pref_bank_details";
    public  static String remember_me_share_pref="s_pref_remember_me_details";
    public  static String remember_me_flag="remember_me_flag";
    public  static String remember_me_email ="remember_me_email";
    public  static String remember_me_password="remember_me_password";
    public static float distFrom(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);
        float distance =dist/1000;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        distance= Float.parseFloat(df.format(distance));

        return distance;
    }
}
