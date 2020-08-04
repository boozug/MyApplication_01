package com.example.myapplication01;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import jp.co.melco.mxcomponent.MELMxCommunication;
import jp.co.melco.mxcomponent.MELMxLabel;
import jp.co.melco.mxcomponent.MELMxOpenSettings;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class DevicelistActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devicelist);
        String[][] myDataset = new String[1][3];
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);
//        Fab create new device
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DevicelistActivity.this, Adddevice.class);
                startActivity(intent);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }
}