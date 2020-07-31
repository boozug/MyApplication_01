package com.example.myapplication01;

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

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final EditText txtUserName = (EditText) findViewById(R.id.Txtname);
        final EditText txtPassword = (EditText) findViewById(R.id.Txtpassword);
        final EditText txtPasswordrpt = (EditText) findViewById(R.id.Rptpassword);
        RelativeLayout btnRegister = (RelativeLayout) findViewById(R.id.relative_layout_btn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            //             @Override
            public void onClick(View view) {
                String username = txtUserName.getText().toString();
                String password = txtPassword.getText().toString();
                String rptpassword = txtPasswordrpt.getText().toString();
                try {
                    if (username.length() >= 8) {
                        if (password.equals(rptpassword) ) {
                            DBUserAdapter dbUser = new DBUserAdapter(SignupActivity.this);
                            dbUser.open();
                            try {
                                dbUser.AddUser(username,password);
                                Toast.makeText(SignupActivity.this,"Finished. Pls check your account in the login form", Toast.LENGTH_LONG).show();
                                dbUser.close();
                            }
                            catch (SQLiteException e){
                                Toast.makeText(SignupActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(SignupActivity.this,"Pls correct password", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(SignupActivity.this,"Pls add an correct User", Toast.LENGTH_LONG).show();
                    }

                }
                catch(Exception e){
                    Toast.makeText(SignupActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();

                }
            }
        });
        //endregion

        //region change to login page
        TextView login = (TextView) findViewById(R.id.textView_login);
        login.setMovementMethod(LinkMovementMethod.getInstance());
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        // endregion
    }
}
