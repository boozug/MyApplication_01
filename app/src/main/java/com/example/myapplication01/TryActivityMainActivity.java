package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TryActivityMainActivity extends AppCompatActivity {

    static List<String> device_list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ExpandableListView expandableListView;
        ExpandableListAdapter expandableListAdapter;
        List<String> expandableListTitle;
        HashMap<String, List<String>> expandableListDetail;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.try_activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = TryexpandableListDatapump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new Trycustomexpandablelistadapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                try {
                Add_device(groupPosition, childPosition);
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return true;}
                catch (Exception e)
                {
                    Toast.makeText(TryActivityMainActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
                }
                return false;
            }

            private void Add_device(int groupPosition, int childPosition_tmp) {
                switch (groupPosition) {
                    case 0:
                        device_list.add(expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition_tmp));
                        break;
                    case 1:
                        if (device_list != null) {
                            device_list.add(2, expandableListDetail.get(
                                    expandableListTitle.get(groupPosition)).get(
                                    childPosition_tmp));
                        } else {
                            device_list.add(expandableListDetail.get(
                                    expandableListTitle.get(groupPosition)).get(
                                    childPosition_tmp));
                        }
                        break;
                    case 2:
                        if (device_list != null) {
                            device_list.add(3, expandableListDetail.get(
                                    expandableListTitle.get(groupPosition)).get(
                                    childPosition_tmp));
                        } else {
                            device_list.add(expandableListDetail.get(
                                    expandableListTitle.get(groupPosition)).get(
                                    childPosition_tmp));
                        }
                }
            }
        });
    }
}
