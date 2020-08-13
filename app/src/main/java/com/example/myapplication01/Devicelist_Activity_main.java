package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication01.Addevice_DBUserAdapter;
import java.util.ArrayList;

public class Devicelist_Activity_main extends AppCompatActivity {
    Addevice_DBUserAdapter dbUser = new Addevice_DBUserAdapter(Devicelist_Activity_main.this);
    RecyclerView recyclerView;
    Devicelist_deviceAdapter deviceAdapter;
    ArrayList<Addevice_UDT_activity> addeviceUDTactivityArrayList = new ArrayList<>();
    FloatingActionButton actionButton;
    ArrayList<Replace_device_temp_UDT_activity_devices> array_buffer_before_del = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try__country_main);
        actionButton = findViewById(R.id.fab);
        addeviceUDTactivityArrayList = Addevice_DBUserAdapter.get_all_devices();
        deviceAdapter = new Devicelist_deviceAdapter(addeviceUDTactivityArrayList);

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(deviceAdapter);
        //---------------------------------------region swipe action
        SwipeController swipeController = new SwipeController(new SwipeControllerActions(){
            @Override
            public void onRightClicked(int position) {
                if(position+1 == deviceAdapter.getItemCount()| position == 0){
                    Addevice_DBUserAdapter.delete_selected_rows(position,Devicelist_Activity_main.this);
                }
                else {
                    array_buffer_before_del = Addevice_DBUserAdapter.remove_device_left(position);
                    Addevice_DBUserAdapter.delete_selected_rows(position,Devicelist_Activity_main.this);
                    Addevice_DBUserAdapter.update_database_moveup(array_buffer_before_del,Devicelist_Activity_main.this);}
                deviceAdapter.list_device.remove(position);
                deviceAdapter.notifyItemRemoved(position);
                deviceAdapter.notifyItemRangeChanged(position,deviceAdapter.getItemCount());
            }



            @Override
            public void onLeftClicked(int position) {
                Toast.makeText(Devicelist_Activity_main.this, "left finshed", Toast.LENGTH_LONG).show();
            }
        });
        ItemTouchHelper itemTouchpapers1 = new ItemTouchHelper(swipeController);
        itemTouchpapers1.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
        //endregion

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