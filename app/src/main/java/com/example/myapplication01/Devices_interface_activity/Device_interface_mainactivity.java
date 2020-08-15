package com.example.myapplication01.Devices_interface_activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication01.R;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.tabs.TabLayout;
public class Device_interface_mainactivity extends AppCompatActivity {
    @Override
    // Ghi đè
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);


    }

}