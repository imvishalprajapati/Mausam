package com.app.mausamapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login_mausam extends AppCompatActivity {
    EditText username,password,email,uname;
    Button register,loginb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mausam);
        username= (EditText) findViewById(R.id.idusername);
        password= (EditText) findViewById(R.id.idpassword);
        email= (EditText) findViewById(R.id.idEdtEmail);
        uname= (EditText) findViewById(R.id.idEdtName);
        register= (Button) findViewById(R.id.idbtnReg);
        loginb= (Button) findViewById((R.id.idBtnRlogin));

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        loginb.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginScreen();
            }
        }));
    }
    public void LoginScreen(){
        Intent intent= new Intent(this,signIn.class);
        startActivity(intent);
    }
}