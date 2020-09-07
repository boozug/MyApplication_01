package com.example.myapplication01.Devices_interface_activity.fragments.Notifydevices.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication01.Devices_interface_activity.ui.Interface_mainpage;
import com.example.myapplication01.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotifydeviceActivity extends AppCompatActivity {

    TextView device_name,device_id,device_address;
    EditText Min_value_txt,Notify_min_txt,Max_value_txt,Notify_max_txt;
    CheckBox Min_value_chx,Max_value_chx,Run_as_service;
    Button Save_btn;
    public static ArrayList<List<String>> information_from_notify_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifydevice);
        Bundle mBundle = getIntent().getExtras();
        device_name = findViewById(R.id.device_type);
        device_id = findViewById(R.id.device_id);
        Save_btn = findViewById(R.id.save_notify_information);
        device_address = findViewById(R.id.device_address);
        Min_value_txt = findViewById(R.id.Notify_min_value);
        Notify_min_txt = findViewById(R.id.editTextTextMultiLine_minvalue);
        Min_value_chx = findViewById(R.id.Checkbox_minvalue);
        Max_value_txt = findViewById(R.id.Notify_max_value);
        Notify_max_txt = findViewById(R.id.editTextTextMultiLine_maxvalue);
        Max_value_chx = findViewById(R.id.Checkbox_maxvalue);
        Run_as_service = findViewById(R.id.Checkbox_run_as_service);
        if (mBundle != null) {
            device_id.setText(mBundle.getString("id"));
            device_name.setText(String.valueOf(Objects.requireNonNull(mBundle.getString("device name")).charAt(13)));
            device_address.setText(mBundle.getString("address"));
        }
        Save_btn.setOnClickListener(view -> { Intent_change_activity(this);
        });
    }

    private void Intent_change_activity(Context context) {
        //Step 1: Convert cac thuoc tinh thu duoc tu activity dua vao fragment => dua cac gia tri vao mot array list static public
        List<String> information_from_notify_activity_tmp = null;
        String str1,str2,str3,str4,str5;
        str1 = device_id.getText().toString();
        str2 = Min_value_txt.getText().toString();
        str3 = Notify_min_txt.getText().toString();
        str4 = Max_value_txt.getText().toString();
        str5 = Notify_max_txt.getText().toString();
        if (str2.equals("")||str3.equals("")||str4.equals("")||str5.equals(""))
        {
            Toast.makeText(context,"Pls check ur field",Toast.LENGTH_LONG).show();
        }
        else {
        information_from_notify_activity_tmp.add(str1);
        information_from_notify_activity_tmp.add(str2);
        information_from_notify_activity_tmp.add(str3);
        information_from_notify_activity_tmp.add(str4);
        information_from_notify_activity_tmp.add(str5);
        information_from_notify_activity_tmp.add(String.valueOf(Min_value_chx.isChecked()));
        information_from_notify_activity_tmp.add(String.valueOf(Max_value_chx.isChecked()));
        information_from_notify_activity_tmp.add(String.valueOf(Run_as_service.isChecked()));}
        int index = Integer.parseInt(device_id.getText().toString());
        if (information_from_notify_activity.get(index) == null){
        information_from_notify_activity.add(information_from_notify_activity_tmp);}
        else {information_from_notify_activity.set(index,information_from_notify_activity_tmp);}
        Intent intent = new Intent(context, Interface_mainpage.class);
        context.startActivity(intent);
    }
}