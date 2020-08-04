package com.example.myapplication01;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

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
                    DBUserAdapter dbUser = new DBUserAdapter(LoginActivity.this);
                    dbUser.open();
                    if(dbUser.Login(username,password))
                    {
                        Toast.makeText(LoginActivity.this,"Logged In Successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, DevicelistActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"Invalid Username/Password", Toast.LENGTH_LONG).show();
                    }
                    dbUser.close();
                }
            } catch (Exception e) {
                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        TextView register = (TextView) findViewById(R.id.textView_register);
        register.setMovementMethod(LinkMovementMethod.getInstance());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}