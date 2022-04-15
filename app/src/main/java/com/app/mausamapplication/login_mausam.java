package com.app.mausamapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_mausam extends AppCompatActivity {
    EditText username,password,mail,uname;
    Button register,loginb;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mausam);
        username= (EditText) findViewById(R.id.idusername);
        password= (EditText) findViewById(R.id.idpassword);
        mail= (EditText) findViewById(R.id.idEdtEmail);
        uname= (EditText) findViewById(R.id.idEdtName);
        register= (Button) findViewById(R.id.idbtnReg);
        loginb= (Button) findViewById((R.id.idBtnRlogin));
        DB= new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String email=mail.getText().toString();
                String nameu=uname.getText().toString();

                if (user.equals("")||pass.equals("")||email.equals(""))
                    Toast.makeText(login_mausam.this, "Pls Fill All details", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuser=DB.checkusername(user);
                        if (checkuser==false){
                            Boolean insert=DB.insertData(user,pass,email,nameu);
                            if (insert==true){
                                Toast.makeText(login_mausam.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),signIn.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(login_mausam.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(login_mausam.this, "User Exist | pls Login", Toast.LENGTH_SHORT).show();
                        }
                }
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