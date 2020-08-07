package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

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
        ImageButton addbtn = findViewById(R.id.addButton);
        ImageButton backbtn = findViewById(R.id.next_Button);
        addbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Add_device_part2(txthostadd1,txthostadd2,txthostadd3,txthostadd4,txtportnumber,txtdesportnumber);
                dbUser.open();
                try {
                    dbUser.AddDevice(device_list);
                }
                catch (SQLiteException e)
                {
                    Snackbar.make(view, "error"+e.toString(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                }
            }

            private void Add_device_part2(TextView txthostadd1, TextView txthostadd2, TextView txthostadd3, TextView txthostadd4,  TextView txtportnumber, TextView txtdesportnumber) {
                String address = txthostadd1.getText().toString()+
                        "."+txthostadd2.getText().toString()+
                        "."+txthostadd3.getText().toString()+
                        "."+txthostadd4.getText().toString();
                String portnumber = txtportnumber.getText().toString();
                String desportnumber = txtdesportnumber.getText().toString();
                if(address.equals("")|portnumber.equals("")|desportnumber.equals("")){
                    Toast.makeText(getApplicationContext(),"Pls finish all the designated fields.",Toast.LENGTH_SHORT).show();
                }
                else {
                    device_list.add(address);
                    device_list.add(portnumber);
                    device_list.add(desportnumber);
                }
            }
        });
    }
}