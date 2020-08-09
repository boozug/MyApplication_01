package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Adddevice_activity_1 extends AppCompatActivity {

    static List<String> device_list = new ArrayList<>();
    static String io_number = new String();
    static String cpu_type = new String();
    static String unit_type = new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ExpandableListView expandableListView;
        ExpandableListAdapter expandableListAdapter;
        List<String> expandableListTitle;
        HashMap<String, List<String>> expandableListDetail;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.try_activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        ImageButton imnextpage = findViewById(R.id.next_Button);
        expandableListDetail = Devicelist_datapump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new Devicelist_listadapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        expandableListTitle.get(groupPosition) + " List Expanded.",
//                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        expandableListTitle.get(groupPosition) + " List Collapsed.",
//                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                try {
                    Add_device(groupPosition, childPosition);
                    Checkpoint(groupPosition,childPosition);

                return true;}
                catch (Exception e)
                {
                    Toast.makeText(Adddevice_activity_1.this,e.getMessage(), Toast.LENGTH_LONG).show();
                }
                return false;
            }


            private void Checkpoint(int groupPosition, int childPosition) {
                if (io_number.equals("") | cpu_type.equals("") | unit_type.equals("")){

                    Toast.makeText(
                            getApplicationContext(),
                            expandableListTitle.get(groupPosition) + " -> "
                                    + expandableListDetail.get(expandableListTitle.get(groupPosition)).get(
                                    childPosition), Toast.LENGTH_SHORT
                    ).show();
                }
                else {
                    device_list = Make_device(io_number, cpu_type, unit_type);
                    Toast.makeText(getApplicationContext(),"Finished configuration 1st step. Pls put to the next setp",Toast.LENGTH_SHORT).show();
                }
            }

            private List<String> Make_device(String io_number, String cpu_type, String unit_type) {
                List<String> device_output = new ArrayList<>();
                device_output.add(io_number);
                device_output.add(cpu_type);
                device_output.add(unit_type);
                return device_output;
            }

            private void Add_device(int groupPosition, int childPosition_tmp) {
                switch (groupPosition) {
                    case 0:
                        io_number = expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition_tmp);
                        break;
                    case 1:
                        cpu_type = expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition_tmp);
                        break;
                    case 2:
                        unit_type = expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition_tmp);
                }
            }
        });

        imnextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (io_number.equals("") | cpu_type.equals("") | unit_type.equals("")){
                    Toast.makeText(getApplicationContext(),"Pls fill all the form before",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent((Adddevice_activity_1.this), Adddevice_activity_2.class);
                    startActivity(intent);
                }
                }
        });
    }
}
