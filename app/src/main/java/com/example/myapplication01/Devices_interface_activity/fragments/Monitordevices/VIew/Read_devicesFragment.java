package com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.VIew;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.Model.Read_device_type;
import com.example.myapplication01.R;

import java.util.ArrayList;

public class Read_devicesFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        RecyclerView recyclerView;
        ReaddeviceAdapter readdeviceAdapter;
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_read_device, container, false);

//        region----------------------------------code start here
        recyclerView = v.findViewById(R.id.recycler_view_read_device);

        // use linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Read_device_type> read_device_ArrayList = ReaddeviceAdapter.get_all_devices();
        readdeviceAdapter = new ReaddeviceAdapter(read_device_ArrayList);
        recyclerView.setAdapter(readdeviceAdapter);
        //        endregion
        return v;
    }
}
