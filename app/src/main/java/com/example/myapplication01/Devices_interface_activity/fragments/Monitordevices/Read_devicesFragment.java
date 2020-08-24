package com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication01.Adddevice_activity.Addevice_DBUserAdapter;
import com.example.myapplication01.R;

import java.util.ArrayList;

public class Read_devicesFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        RecyclerView recyclerView = null;
        ReaddeviceAdapter readdeviceAdapter;
        ArrayList<Read_device_type> read_device_ArrayList = new ArrayList<>();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_read_device, container, false);
//        region----------------------------------code start here
        read_device_ArrayList = ReaddeviceAdapter.get_all_devices();
        readdeviceAdapter = new ReaddeviceAdapter(read_device_ArrayList);
        recyclerView = recyclerView.findViewById(R.id.recycler_view_read_device);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(readdeviceAdapter);
        //        endregion
        return v;
    }
}
