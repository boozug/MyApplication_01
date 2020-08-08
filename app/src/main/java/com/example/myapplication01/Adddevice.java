package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication01.TryActivityMainActivity;

import com.google.android.material.snackbar.Snackbar;

import static com.example.myapplication01.TryActivityMainActivity.device_list;

public class Adddevice extends AppCompatActivity {
//    private SQLiteDatabase mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddevice);
        
        DBUserAdapter dbUser = new DBUserAdapter(Adddevice.this);
//        region Binding layout object to java class
        TextView txthostadd1 = findViewById(R.id.Txtipfield1);
        TextView txthostadd2 = findViewById(R.id.Txtipfield2);
        TextView txthostadd3 = findViewById(R.id.Txtipfield3);
        TextView txthostadd4 = findViewById(R.id.Txtipfield4);
        TextView txtportnumber = findViewById(R.id.TxtPortnumber);
        TextView txtdesportnumber = findViewById(R.id.TxtDesPortnumber);
        TextView txtTimeout = findViewById(R.id.Txttimeout);
        TextView txtdesTimeout = findViewById(R.id.Txtcpu_timeout);
        ImageButton addbtn = findViewById(R.id.addButton);
        ImageButton backbtn = findViewById(R.id.next_Button);
        addbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String address = txthostadd1.getText().toString()+
                        "."+txthostadd2.getText().toString()+
                        "."+txthostadd3.getText().toString()+
                        "."+txthostadd4.getText().toString();
                String portnumber = txtportnumber.getText().toString();
                String desportnumber = txtdesportnumber.getText().toString();
                String timeout = txtTimeout.getText().toString();
                String destinationtimeout = txtdesTimeout.getText().toString();
                if(resultcheck(address,portnumber,desportnumber,timeout,destinationtimeout) ==true)
                {
                    Add_device_part2(address,portnumber,desportnumber,timeout,destinationtimeout);
                    dbUser.open();
                    try {
                        dbUser.AddDevice(device_list);
                        Toast.makeText(Adddevice.this, "Add device successful", Toast.LENGTH_SHORT).show();
                        dbUser.close();
                        Intent intent = new Intent(Adddevice.this,try_Country_activity_main.class);
                        startActivity(intent);

                    } catch (SQLiteException e) {
                        Snackbar.make(view, "error" + e.toString(), Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
                else
                {
                    Snackbar.make(view,"pls check your field",Snackbar.LENGTH_LONG).setAction("Action",null).show();
                }
            }
            private void Add_device_part2(String address, String portnumber, String desportnumber, String timeout, String destinationtimeout) {
                device_list.add(address);
                device_list.add(portnumber);
                device_list.add(desportnumber);
                device_list.add(timeout);
                device_list.add(destinationtimeout);
            }

            private boolean resultcheck (String address,String portnumber,String desportnumber,String timeout,String destinationtimeout) {
                if (address.equals("...") | portnumber.equals("") | desportnumber.equals("") | timeout.equals("") | destinationtimeout.equals("")) {
                    return false;
                }
                return true;
            }
            });
        }
    }