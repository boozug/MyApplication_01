package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Adddevice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddevice);
//        region Binding layout object to java class
        TextView txthostadd1 = findViewById(R.id.Txtipfield1);
        TextView txthostadd2 = findViewById(R.id.Txtipfield2);
        TextView txthostadd3 = findViewById(R.id.Txtipfield3);
        TextView txtUnittype = findViewById(R.id.TxtUnittype);
        TextView txtionumber = findViewById(R.id.TxtIOnumber);
        TextView txtcputype = findViewById(R.id.TxtCPUType);
        TextView txtprotocoltype = findViewById(R.id.TxtProtocolype);
        TextView txtportnumber = findViewById(R.id.TxtPortnumber);
        TextView txtdesportnumber = findViewById(R.id.TxtDesPortnumber);
        ImageButton addbtn = findViewById(R.id.addButton);
        ImageButton backbtn = findViewById(R.id.cancelButton);
//        endregion
        addbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
    }
}