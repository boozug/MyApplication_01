package com.example.myapplication01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Devicelist_Activity_main extends AppCompatActivity {
    Addevice_DBUserAdapter dbUser = new Addevice_DBUserAdapter(Devicelist_Activity_main.this);
    RecyclerView recyclerView;
    Devicelist_deviceAdapter deviceAdapter;
    ArrayList<Addevice_UDT_activity> addeviceUDTactivityArrayList = new ArrayList<>();
    FloatingActionButton actionButton;
    SwipeController swipeController = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try__country_main);
        addeviceUDTactivityArrayList = Addevice_DBUserAdapter.get_all_devices();
        deviceAdapter = new Devicelist_deviceAdapter(addeviceUDTactivityArrayList);
        actionButton = (FloatingActionButton)findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this,  LinearLayoutManager.VERTICAL));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
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

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        swipeController = new SwipeController(new Try_swipeControlleraction() {
            public void onRightClicked(int position) {
                deviceAdapter.list_device.remove(position);
                deviceAdapter.notifyItemRemoved(position);
                deviceAdapter.notifyItemRangeChanged(position, deviceAdapter.getItemCount());
            }
        });

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
    }
}