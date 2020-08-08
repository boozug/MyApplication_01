package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication01.DBUserAdapter;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class try_Country_activity_main extends AppCompatActivity {
    DBUserAdapter dbUser = new DBUserAdapter(try_Country_activity_main.this);
    RecyclerView recyclerView;
    try_DeviceAdapter deviceAdapter;
    ArrayList<try_Device> try_deviceArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try__country_main);
        try_deviceArrayList = DBUserAdapter.get_all_devices();
        deviceAdapter = new try_DeviceAdapter(try_deviceArrayList);
        recyclerView = findViewById(R.id.recycler_view);recyclerView.addItemDecoration(new DividerItemDecoration(this,  LinearLayoutManager.VERTICAL));
        LinearLayoutManager layoutManager = new   LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(deviceAdapter);
    }
}