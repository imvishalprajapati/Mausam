package com.app.mausamapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signIn extends AppCompatActivity {

    Button register,login;
    EditText username,password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        register = (Button) findViewById(R.id.BtnRegNow);
        login= (Button) findViewById(R.id.idBtnSignLogin);
        username =(EditText)findViewById(R.id.idusername);
        password=(EditText)findViewById(R.id.idpassword);
        DB=new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterScreen();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=username.getText().toString();
                String pass=password.getText().toString();

                if (user.equals("")||pass.equals(""))
                    Toast.makeText(signIn.this, "Enter All details", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                    if (checkuserpass==true){
                        Toast.makeText(signIn.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),user_profile.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(signIn.this, "Invalid Details", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void RegisterScreen(){
        Intent intent=new Intent(this,login_mausam.class);
        startActivity(intent);
    }
}