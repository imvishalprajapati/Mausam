package com.app.mausamapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class user_profile extends AppCompatActivity {
    TextView cityName,userName,Email;
    ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        cityName=findViewById(R.id.idTVCityDisplay);
        userName=findViewById(R.id.idTVuserNameDisplay);
        Email=findViewById(R.id.idTVEmailDisplay);
        backButton= (ImageButton) findViewById(R.id.idBtnback);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity();
            }
        });

    }
    public void MainActivity(){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}