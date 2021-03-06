package com.example.myapplication01.Signup_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication01.SQL_interface.Addevice_DBUserAdapter;
import com.example.myapplication01.Login_activity.Login_Mainactivity;
import com.example.myapplication01.R;

public class Signup_mainactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final EditText txtUserName = findViewById(R.id.Txtname);
        final EditText txtPassword = findViewById(R.id.Txtpassword);
        final EditText txtPasswordrpt = findViewById(R.id.Rptpassword);
        RelativeLayout btnRegister = findViewById(R.id.relative_layout_btn);
        //             @Override
        btnRegister.setOnClickListener(view -> {
            String username = txtUserName.getText().toString();
            String password = txtPassword.getText().toString();
            String rptpassword = txtPasswordrpt.getText().toString();
            try {
                if (username.length() >= 8) {
                    if (password.equals(rptpassword) ) {
                        Addevice_DBUserAdapter dbUser = new Addevice_DBUserAdapter(Signup_mainactivity.this);
                        dbUser.open();
                        try {
                            dbUser.AddUser(username,password);
                            Toast.makeText(Signup_mainactivity.this,"Finished. Pls check your account in the login form", Toast.LENGTH_LONG).show();
                            dbUser.close();
                        }
                        catch (SQLiteException e){
                            Toast.makeText(Signup_mainactivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(Signup_mainactivity.this,"Pls correct password", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(Signup_mainactivity.this,"Pls add an correct User", Toast.LENGTH_LONG).show();
                }

            }
            catch(Exception e){
                Toast.makeText(Signup_mainactivity.this,e.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
        //endregion

        //region change to login page
        TextView login = findViewById(R.id.textView_login);
        login.setMovementMethod(LinkMovementMethod.getInstance());
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup_mainactivity.this, Login_Mainactivity.class);
                startActivity(intent);

            }
        });
        // endregion


    }
}
