package com.example.myapplication01.Devices_interface_activity.fragments.Notifydevices.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication01.Devices_interface_activity.ui.Interface_mainpage;
import com.example.myapplication01.R;

import java.util.Objects;

public class NotifydeviceActivity extends AppCompatActivity {

    TextView device_name,device_id,device_address;
    EditText Min_value_txt,Notify_min_txt,Max_value_txt,Notify_max_txt;
    CheckBox Min_value_chx,Max_value_chx,Run_as_service;
    Button Save_btn;
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
        Save_btn.setOnClickListener(view -> { Intent_change_activitise(this);
        });
    }

    private void Intent_change_activitise(Context context) {
        Intent intent = new Intent(context, Interface_mainpage.class);
        intent.putExtra("min value", Min_value_txt.getText().toString());
        intent.putExtra("notify min",Notify_min_txt.getText().toString());
        intent.putExtra("max value",Max_value_txt.getText().toString());
        intent.putExtra("notify max",Notify_max_txt.getText().toString());
        intent.putExtra("Min value choice",Min_value_chx.isChecked());
        intent.putExtra("Max value choice",Max_value_chx.isChecked());
        intent.putExtra("Run as service",Run_as_service.isChecked());
        context.startActivity(intent);
    }
}