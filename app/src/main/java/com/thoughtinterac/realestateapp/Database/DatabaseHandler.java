package com.thoughtinterac.realestateapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.thoughtinterac.realestateapp.Activities.LoginActivity;
import com.thoughtinterac.realestateapp.Fragments.MyBankDetailsFragment;

/**
 * Created by AzaharSheikh on 01-10-2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "real_estate_db";
    public static final String TABLE_REGISTER = "register_tb";

    // product Table Columns names
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_NAME = "user_name";
    public static final String KEY_USER_ADDRESS = "user_address";
    public static final String KEY_USER_JOB_DESC = "user_job_desc";
    public static final String KEY_USER_MOBILE = "user_mobile";
    public static final String KEY_USER_EMAIL = "user_email";
    public static final String KEY_USER_PASSWORD = "user_password";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_REGISTER_TABLE = "CREATE TABLE " + TABLE_REGISTER + "("
                + KEY_USER_ID + " INTEGER PRIMARY KEY ," + KEY_USER_NAME + " TEXT,"
                + KEY_USER_ADDRESS + " TEXT," + KEY_USER_JOB_DESC+" TEXT, "+KEY_USER_MOBILE+" TEXT, " +KEY_USER_EMAIL+" TEXT NOT NULL UNIQUE , " +KEY_USER_PASSWORD+" TEXT " +")";
        db.execSQL(CREATE_REGISTER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);

        // Create tables again
        onCreate(db);
    }
}
