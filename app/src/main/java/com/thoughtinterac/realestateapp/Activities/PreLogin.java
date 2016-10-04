package com.thoughtinterac.realestateapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.thoughtinterac.realestateapp.R;

/**
 * Created by AshwiniBadgujar on 04-10-2016.
 */
public class PreLogin extends AppCompatActivity
{
    ImageView img_user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_login);
        img_user=(ImageView)findViewById(R.id.img_user);
        img_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PreLogin.this,LoginActivity.class);
                startActivity(i);

            }
        });
    }
}
