package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

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
        TextView txtportnumber = findViewById(R.id.TxtPortnumber);
        TextView txtdesportnumber = findViewById(R.id.TxtDesPortnumber);
        ImageButton addbtn = findViewById(R.id.addButton);
        ImageButton backbtn = findViewById(R.id.cancelButton);
        String host_address = txthostadd1+"."+txthostadd2+"."+txthostadd3;
        String[] device_array = {host_address,txtportnumber.toString(),txtdesportnumber.toString()};
        //        endregion
        addbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dbUser.open();
                try {
                    dbUser.AddDevice(device_array);
                }
                catch (SQLiteException e)
                {
                                    Snackbar.make(view, "error"+e.toString(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                }
            }
        });
    }
}