package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Devicelist_Activity_main extends AppCompatActivity {
    Addevice_DBUserAdapter dbUser = new Addevice_DBUserAdapter(Devicelist_Activity_main.this);
    RecyclerView recyclerView;
    Devicelist_deviceAdapter deviceAdapter;
    ArrayList<Addevice_UDT_activity> addeviceUDTactivityArrayList = new ArrayList<>();
    FloatingActionButton actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try__country_main);
        addeviceUDTactivityArrayList = Addevice_DBUserAdapter.get_all_devices();
        deviceAdapter = new Devicelist_deviceAdapter(addeviceUDTactivityArrayList);
        actionButton = (FloatingActionButton)findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view);recyclerView.addItemDecoration(new DividerItemDecoration(this,  LinearLayoutManager.VERTICAL));
        LinearLayoutManager layoutManager = new   LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(deviceAdapter);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_insertactivity();
            }

            private void show_insertactivity() {
                Intent intent = new Intent(Devicelist_Activity_main.this, Adddevice_activity_1.class);
                startActivity(intent);
            }
        });
    }
}