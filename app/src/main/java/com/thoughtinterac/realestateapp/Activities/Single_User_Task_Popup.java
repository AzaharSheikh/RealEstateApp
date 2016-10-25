package com.thoughtinterac.realestateapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 10-10-2016.
 */
public class Single_User_Task_Popup extends AppCompatActivity {
    TextView txt_user_name;
    String str_user_name;
    Button btn_view_user_details,btn_realtor_view_user_document,btn_send_reminder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_user_task_popup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        txt_user_name=(TextView)findViewById(R.id.txt_user_name);
        btn_view_user_details=(Button)findViewById(R.id.btn_view_user_details) ;
        btn_realtor_view_user_document=(Button)findViewById(R.id.btn_realtor_view_user_document);
        btn_send_reminder=(Button)findViewById(R.id.btn_send_reminder);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            str_user_name = bundle.getString(DatabaseHandler.KEY_USER_NAME);
            txt_user_name.setText(str_user_name);
        }
        btn_view_user_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                bundle1.putString(DatabaseHandler.KEY_USER_NAME,str_user_name);
                Intent i = new Intent(Single_User_Task_Popup.this,Single_User_Details.class);
                i.putExtras(bundle1);
                startActivity(i);
            }
        });
        btn_realtor_view_user_document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Single_User_Task_Popup.this,RealtorViewUserDocumentDetails.class);
                startActivity(i);
            }
        });
        btn_send_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Single_User_Task_Popup.this,SendUserReminder.class);
                //startActivity(i);
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "shri@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Alert");
                email.putExtra(Intent.EXTRA_TEXT, "Please submit document");

//need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }
}
