package com.thoughtinterac.realestateapp.Activities;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;

/**
 * Created by AzaharSheikh on 12-10-2016.
 */
public class SearchProjectActivity extends AppCompatActivity {

    ImageView img_back;
    EditText edt_search;
    Button btn_search_project;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.search_project);
       // getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.custom_theme_layout);
        //img_back = (ImageView) findViewById(R.id.img_back);
//        img_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//    });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        btn_search_project=(Button)findViewById(R.id.btn_search_project) ;
        edt_search=(EditText)findViewById(R.id.edt_search);

        DatabaseHandler handler= new DatabaseHandler(SearchProjectActivity.this);
        final  SQLiteDatabase db = handler.getWritableDatabase();
        btn_search_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] selectionArgs = { edt_search.getText().toString() };
                Cursor cursor = db.rawQuery("SELECT * FROM "+DatabaseHandler.TABLE_REALTOR_PROJECT_LIST_VERTUAL+" WHERE "+DatabaseHandler.KEY_SEARCH_COL+" MATCH ?", selectionArgs);
                ArrayList<String> projrct_id_list = new ArrayList<>();
                if(cursor != null)
                {
                    while (cursor.moveToNext())
                    {
                        String c = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_Project_id));
                        Log.d("SearchResult",c);
                        projrct_id_list.add(c);
                    }
                    showResult(projrct_id_list);
                }
            }
        });




}
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
    private void showResult(ArrayList<String> projrct_id_list) {

    }
}