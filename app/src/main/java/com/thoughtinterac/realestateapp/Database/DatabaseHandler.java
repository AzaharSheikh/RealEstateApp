package com.thoughtinterac.realestateapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.thoughtinterac.realestateapp.Activities.LoginActivity;
import com.thoughtinterac.realestateapp.Fragments.MyBankDetailsFragment;

/**
 * Created by AzaharSheikh on 01-10-2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 11;

    // Database Name
    public static final String DATABASE_NAME = "real_estate_db";
    public static final String TABLE_REGISTER = "register_tb";

    // user reg  Table Columns names
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_NAME = "user_name";
    public static final String KEY_USER_ADDRESS = "user_address";
    public static final String KEY_USER_JOB_DESC = "user_job_desc";
    public static final String KEY_USER_MOBILE = "user_mobile";
    public static final String KEY_USER_EMAIL = "user_email";
    public static final String KEY_USER_PASSWORD = "user_password";
    public static final String KEY_PAN_NUMBER="pan_number";
    public static final String KEY_BANK_DETAILS="bank_details";
    public static final String KEY_PROJECT_NAME="project_name";
    public static final String KEY_REALATOR_NAME="realator_name";
    // user installment info table
    public static final String TABLE_USER_INSTALLMENT = "user_installment_tb";
    public static final String KEY_USER_INST_STAGE_NAME = "user_inst_stage_name";
    public static final String KEY_USER_INST_PERCENTAGE = "user_inst_percentage";
    public static final String KEY_USER_INST_RUPEES = "user_inst_rupees";
    public static final String KEY_USER_INST_STAGE_STATUS = "user_inst_stage_status";
    // project list table
    public static final String TABLE_REALTOR_PROJECT_LIST = "realtor_project_list_tb";
    public static final String TABLE_REALTOR_PROJECT_LIST_VERTUAL = "realtor_project_list_tb_vertual";
    public static final String KEY_Project_id = "Project_id";
    public static final String KEY_Project_Name = "Project_Name";
    public static final String KEY_Project_Location = "Project_Location";
    public static final String KEY_ProjectDescription = "ProjectDescription";
    public static final String KEY_bhk1_FloorAreaSqFt = "bhk1_FloorAreaSqFt";
    public static final String KEY_bhk1_NoofFloor = "bhk1_NoofFloor";
    public static final String KEY_bhk1_price = "bhk1_price";
    public static final String KEY_bhk2_FloorAreaSqFt = "bhk2_FloorAreaSqFt";
    public static final String KEY_bhk2_NoofFloor = "bhk2_NoofFloor";
    public static final String KEY_bhk2_price = "bhk2_price";
    public static final String KEY_bhk3_FloorAreaSqFt = "bhk3_FloorAreaSqFt";
    public static final String KEY_bhk3_NoofFloor = "bhk3_NoofFloor";
    public static final String KEY_bhk3_price = "bhk3_price";
    public static final String KEY_SEARCH_COL = "search_col";

    //user edit option flag

    public static final String TABLE_USER_EDIT_FLAG = "user_edit_flag";
    public static final String KEY_id = "_id";
    public static final String KEY_flag = "_flag";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_REGISTER_TABLE = "CREATE TABLE " + TABLE_REGISTER + "("
                + KEY_USER_ID + " INTEGER PRIMARY KEY ," + KEY_USER_NAME + " TEXT,"
                + KEY_USER_ADDRESS + " TEXT," + KEY_USER_JOB_DESC+" TEXT, "+KEY_USER_MOBILE+" TEXT, " +KEY_USER_EMAIL+" TEXT NOT NULL UNIQUE , " +KEY_USER_PASSWORD+" TEXT ," +KEY_PAN_NUMBER+" TEXT, "+KEY_BANK_DETAILS+" TEXT "+")";

        String CREATE_INSTALLMENT_TABLE = "CREATE TABLE " + TABLE_USER_INSTALLMENT + "("
                + KEY_USER_EMAIL + " TEXT NOT NULL," + KEY_USER_INST_STAGE_NAME + " TEXT,"
                + KEY_USER_INST_PERCENTAGE + " TEXT, " + KEY_USER_INST_RUPEES+" TEXT, "+KEY_USER_INST_STAGE_STATUS +" TEXT "+")";

        String CREATE_REALTOR_PROJECT_LIST_TABLE = "CREATE TABLE " + TABLE_REALTOR_PROJECT_LIST + "("
                +   KEY_Project_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +   KEY_Project_Name + " TEXT,"
                +   KEY_Project_Location + " TEXT,"
                +   KEY_ProjectDescription+" TEXT, "
                +   KEY_bhk1_FloorAreaSqFt+" TEXT, "
                +   KEY_bhk1_NoofFloor+" TEXT  , "
                +   KEY_bhk1_price+" TEXT ,"
                +   KEY_bhk2_FloorAreaSqFt+" TEXT, "
                +   KEY_bhk2_NoofFloor+" TEXT  , "
                +   KEY_bhk2_price+" TEXT ,"
                +   KEY_bhk3_FloorAreaSqFt+" TEXT, "
                +   KEY_bhk3_NoofFloor+" TEXT  , "
                +   KEY_bhk3_price+" TEXT ,"
                +   KEY_SEARCH_COL+" TEXT "
                +")";


        String CREATE_REALTOR_PROJECT_LIST_VERTUAL_TABLE= "CREATE VIRTUAL TABLE  " + TABLE_REALTOR_PROJECT_LIST_VERTUAL + " USING FTS4 ("
                +KEY_Project_id+" , "
        +KEY_SEARCH_COL
                +")";


String CREATE_USER_EDIT_FALG_TABLE = "CREATE TABLE " + TABLE_USER_EDIT_FLAG + "("
        + KEY_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_flag + " TEXT DEFAULT 'false'" +")";

        db.execSQL(CREATE_REGISTER_TABLE);
        db.execSQL(CREATE_INSTALLMENT_TABLE);
        db.execSQL(CREATE_REALTOR_PROJECT_LIST_TABLE);
        db.execSQL(CREATE_USER_EDIT_FALG_TABLE);
        db.execSQL(CREATE_REALTOR_PROJECT_LIST_VERTUAL_TABLE);
        Log.d("database","Created successfully");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_INSTALLMENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REALTOR_PROJECT_LIST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REALTOR_PROJECT_LIST_VERTUAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_EDIT_FLAG);
        Log.d("database","drop successfully");
        // Create tables again
        onCreate(db);
    }
}