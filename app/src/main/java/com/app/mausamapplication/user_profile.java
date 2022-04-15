package com.app.mausamapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class user_profile extends AppCompatActivity {
    TextView cityName,userName,Email;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        cityName=findViewById(R.id.idTVCityDisplay);
        userName=findViewById(R.id.idTVuserNameDisplay);
        Email=findViewById(R.id.idTVEmailDisplay);
        toolbar= (Toolbar) findViewById(R.id.idToolbaar);
        setSupportActionBar(toolbar);


    }
    public void MainActivity(){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu,menu);
        return true;
    }
}