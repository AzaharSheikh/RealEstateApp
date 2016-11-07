package com.thoughtinterac.realestateapp.Activities;

import android.content.ContentValues;
import android.content.Context;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzaharSheikh on 20-10-2016.
 */
public class Single_User_Details extends AppCompatActivity {

    List<View> allView;
    ArrayList <String> user_email ;
    ArrayList <String> user_instl_stage_name    ;
    ArrayList <String> user_instl_stage_status  ;
    ArrayList <String> user_instl_percentage    ;
    ArrayList <String> user_instl_amount        ;

    TextView txt_total_instl_percentage, txt_instl_total_amount,txt_username;
    Button btn_update_installment;
    private RadioGroup rg_myproject;
    LinearLayout li_project_details,li_installation_main,li_project_status,li_installation;
    String str_user_name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_user_details);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        allView = new ArrayList<View>();

        li_installation_main=(LinearLayout)findViewById(R.id.li_installation_main);
        li_project_details=(LinearLayout)findViewById(R.id.li_project_details);
        li_project_status=(LinearLayout)findViewById(R.id.li_project_status);
        li_installation=(LinearLayout)findViewById(R.id.li_installation);


        txt_total_instl_percentage=(TextView)findViewById(R.id.txt_total_instl_percentage);
        txt_instl_total_amount =(TextView)findViewById(R.id.txt_total_amount);
        txt_username=(TextView)findViewById(R.id.txt_username);
        btn_update_installment=(Button)findViewById(R.id.btn_update_installment);
        user_email = new ArrayList<>();
        user_instl_stage_name = new ArrayList<>();
        user_instl_stage_status= new ArrayList<>();
        user_instl_percentage = new ArrayList<>();
        user_instl_amount = new ArrayList<>();
        rg_myproject = (RadioGroup)findViewById(R.id.rg_myproject);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            str_user_name = bundle.getString(DatabaseHandler.KEY_USER_NAME);
            txt_username.setText(str_user_name);
        }
        rg_myproject.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbt_project_details:
                        //Toast.makeText(getActivity(), "project details checked", Toast.LENGTH_SHORT).show();
                        li_installation_main.setVisibility(View.GONE);
                        li_project_details.setVisibility(View.VISIBLE);
                        li_project_status.setVisibility(View.GONE);

                        break;
                    case R.id.rbt_project_status:
                        //Toast.makeText(getActivity(), "Photos details checked", Toast.LENGTH_SHORT).show();
                        li_installation_main.setVisibility(View.GONE);
                        li_project_details.setVisibility(View.GONE);
                        li_project_status.setVisibility(View.VISIBLE);

                        break;
                    case R.id.rbt_project_installment:
                        //Toast.makeText(getActivity(), "Map details checked", Toast.LENGTH_SHORT).show();
                        li_installation_main.setVisibility(View.VISIBLE);
                        li_project_details.setVisibility(View.GONE);
                        li_project_status.setVisibility(View.GONE);



                        break;
                }
            }
        });
        DatabaseHandler  handler  = new DatabaseHandler(Single_User_Details.this);
        SQLiteDatabase db = handler.getWritableDatabase();
        String[] restoreInstallationColumn = new String[]{DatabaseHandler.KEY_USER_EMAIL,DatabaseHandler.KEY_USER_INST_STAGE_NAME,DatabaseHandler.KEY_USER_INST_PERCENTAGE,DatabaseHandler.KEY_USER_INST_RUPEES,DatabaseHandler.KEY_USER_INST_STAGE_STATUS};
        Cursor cursor = db.query(DatabaseHandler.TABLE_USER_INSTALLMENT, restoreInstallationColumn, DatabaseHandler.KEY_USER_EMAIL + "='" + "Azr" + "'", null, null, null, null);
        if (cursor != null && cursor.getCount() > 0)
        {
            while (cursor.moveToNext())
            {
                user_email.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_EMAIL)));
                user_instl_stage_name.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_INST_STAGE_NAME)));
                user_instl_stage_status.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_INST_STAGE_STATUS)));
                user_instl_percentage.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_INST_PERCENTAGE)));
                user_instl_amount.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_INST_RUPEES)));
            }
        }else
        {
            user_email.add("Azr");
            user_instl_stage_name.add("Agreement");
            user_instl_stage_status.add("true");
            user_instl_percentage.add("15");
            user_instl_amount.add("15000");

            user_email.add("Azr");
            user_instl_stage_name.add("2 slab");
            user_instl_stage_status.add("true");
            user_instl_percentage.add("25");
            user_instl_amount.add("25000");

            user_email.add("Azr");
            user_instl_stage_name.add("Pulm");
            user_instl_stage_status.add("true");
            user_instl_percentage.add("10");
            user_instl_amount.add("5000");

            user_email.add("Azr");
            user_instl_stage_name.add("Pulm");
            user_instl_stage_status.add("true");
            user_instl_percentage.add("10");
            user_instl_amount.add("5000");

            user_email.add("Azr");
            user_instl_stage_name.add("Pulm");
            user_instl_stage_status.add("true");
            user_instl_percentage.add("10");
            user_instl_amount.add("5000");

            user_email.add("Azr");
            user_instl_stage_name.add("Pulm");
            user_instl_stage_status.add("true");
            user_instl_percentage.add("10");
            user_instl_amount.add("5000");
        }

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for(int i = 0; i<user_email.size();i++)
        {
            final View v  = inflater.inflate(R.layout.user_instl_single_row, null);
            final TextView txt_instl_name = (TextView)v.findViewById(R.id.txt_instl_name);
            txt_instl_name.setText(user_instl_stage_name.get(i));
            final EditText edt_instl_percentage = (EditText)v.findViewById(R.id.edt_instl_percentage);
            //edt_instl_percentage.setId(100 +i);
            edt_instl_percentage.setText(user_instl_percentage.get(i));
            final EditText edt_amount = (EditText)v.findViewById(R.id.edt_amount);
            //edt_amount.setId(200+i);
            edt_amount.setText(user_instl_amount.get(i));
            allView.add(v);
            li_installation.addView(v);

        }
        setTotalPercentage();
        setTotalAmount();
        btn_update_installment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //user_email.clear();
                //user_instl_stage_name.clear();
                //user_instl_stage_status.clear();
                user_instl_percentage.clear();
                user_instl_amount.clear();
                for(int i=0; i < allView.size(); i++)
                {
                    final TextView txt_instl_name = (TextView)allView.get(i).findViewById(R.id.txt_instl_name);
                    final EditText edt_instl_percentage = (EditText)allView.get(i).findViewById(R.id.edt_instl_percentage);
                    final EditText edt_amount = (EditText)allView.get(i).findViewById(R.id.edt_amount);
                    user_instl_percentage.add(edt_instl_percentage.getText().toString());
                    String amount = edt_amount.getText().toString();
                    user_instl_amount.add(amount);
                }
                DatabaseHandler  helper = new DatabaseHandler(Single_User_Details.this);
                SQLiteDatabase db = helper.getWritableDatabase();
                boolean status = db.delete(DatabaseHandler.TABLE_USER_INSTALLMENT, DatabaseHandler.KEY_USER_EMAIL + " = '" + user_email.get(0) + "'", null) > 0;
                if(status){}
               for(int i = 0 ; i<user_instl_percentage.size();i++)
               {
                   String email = user_email.get(i);
                   String stage_name = user_instl_stage_name.get(i);
                   String stage_status = user_instl_stage_status.get(i);
                   String percentage =  user_instl_percentage.get(i);
                   String amount = user_instl_amount.get(i);
                  // boolean status = db.delete(DatabaseHandler.TABLE_USER_INSTALLMENT, DatabaseHandler.KEY_USER_EMAIL + " = '" + user_email.get(i) + "'", null) > 0;
                   ContentValues contentValues = new ContentValues();
                   contentValues.put(DatabaseHandler.KEY_USER_EMAIL, email);
                   contentValues.put(DatabaseHandler.KEY_USER_INST_STAGE_NAME, stage_name);
                   contentValues.put(DatabaseHandler.KEY_USER_INST_PERCENTAGE, percentage);
                   contentValues.put(DatabaseHandler.KEY_USER_INST_RUPEES, amount);
                   contentValues.put(DatabaseHandler.KEY_USER_INST_STAGE_STATUS, stage_status);
                   boolean insert_status = db.insert(DatabaseHandler.TABLE_USER_INSTALLMENT, null, contentValues) > 0;
                   Log.d("insert_status",insert_status+"");
               }
                setTotalAmount();
                setTotalPercentage();
            }
        });

    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
    private void setTotalAmount() {
        float totalAmount=0;
        for(int i = 0 ; i < user_instl_amount.size();i++)
        {
            float totl = Float.parseFloat(user_instl_amount.get(i));
            totalAmount+=totl;
        }
        txt_instl_total_amount.setText(totalAmount+"");
    }

    private void setTotalPercentage() {
        float totalPercentage=0;
        for(int i = 0 ; i < user_instl_amount.size();i++)
        {
            float totl = Float.parseFloat(user_instl_percentage.get(i));
            totalPercentage+=totl;
        }
        txt_total_instl_percentage.setText(totalPercentage+"");
    }
}
