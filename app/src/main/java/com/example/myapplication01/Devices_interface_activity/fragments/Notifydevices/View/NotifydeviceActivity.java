package com.example.myapplication01.Devices_interface_activity.fragments.Notifydevices.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication01.R;

import java.util.Objects;

public class NotifydeviceActivity extends AppCompatActivity {

    TextView device_name;
    TextView device_id;
    TextView device_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifydevice);
        Bundle mBundle = getIntent().getExtras();
        device_name = findViewById(R.id.device_type);
        device_id = findViewById(R.id.device_id);
        device_address = findViewById(R.id.device_address);
        if (mBundle != null) {
            device_id.setText(mBundle.getString("id"));
            device_name.setText(String.valueOf(Objects.requireNonNull(mBundle.getString("device name")).charAt(13)));
            device_address.setText(mBundle.getString("address"));
        }
    }
}