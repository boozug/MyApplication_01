package com.example.myapplication01.Login_activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication01.Adddevice_activity.Addevice_DBUserAdapter;
import com.example.myapplication01.Plclist_activity.Devicelist_Activity_main;
import com.example.myapplication01.R;
import com.example.myapplication01.Signup_activity.Signup_mainactivity;

public class Login_Mainactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        RelativeLayout btnLogin = findViewById(R.id.relative_layout_btn);
        final EditText txtUserName = findViewById(R.id.Txtname);
        final EditText txtPassword = findViewById(R.id.Txtpassword);
        //region signin activity
        btnLogin.setOnClickListener(view -> {
            String username = txtUserName.getText().toString();
            String password = txtPassword.getText().toString();
            try {
                if (username.length() > 0 && password.length() > 0) {
                    Addevice_DBUserAdapter dbUser = new Addevice_DBUserAdapter(Login_Mainactivity.this);
                    dbUser.open();
                    if(dbUser.Login(username,password))
                    {
                        Toast.makeText(Login_Mainactivity.this,"Logged In Successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Login_Mainactivity.this, Devicelist_Activity_main.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Login_Mainactivity.this,"Invalid Username/Password", Toast.LENGTH_LONG).show();
                    }
                    dbUser.close();
                }
            } catch (Exception e) {
                Toast.makeText(Login_Mainactivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        TextView register = (TextView) findViewById(R.id.textView_register);
        register.setMovementMethod(LinkMovementMethod.getInstance());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Mainactivity.this, Signup_mainactivity.class);
                startActivity(intent);
            }
        });

//        rxbtncom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Login_Mainactivity.this, TrymainActivity2.class);
//                startActivity(intent);
//            }
//        });
    }
}