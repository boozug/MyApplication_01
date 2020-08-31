package com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.VIew;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.Model.Read_device_type;
import com.example.myapplication01.R;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class Read_devicesFragment extends Fragment {

    private static final String TAG = "Read_device_Fragment";
    public PublishSubject<ArrayList<Read_device_type>> read_device_typeArrayList;
    public Button Read_value_btn;
    public Button Monitoring_enable_switch;

    ReaddeviceAdapter readdeviceAdapter;
    ArrayList<Read_device_type> read_device_ArrayList;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        RecyclerView recyclerView;
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_read_device, container, false);

//        region----------------------------------code start here
        recyclerView = v.findViewById(R.id.recycler_view_read_device);
        Read_value_btn =v.findViewById(R.id.read_value_button);
        Monitoring_enable_switch = v.findViewById(R.id.read_continous_value);
        // use linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        configure_read_value_button(v);
        configure_monitoring_button(v);
        createObservable(v,recyclerView);
//        endregion
        return v;
    }

    private void configure_monitoring_button(View v) {
//        Read_value_btn.setVisibility(v.GONE);
        Log.d(TAG,"Hello");
    }

    private void configure_read_value_button(View v){
        Read_value_btn.setOnClickListener(view -> read_device_array_list());
    }
    private void read_device_array_list(){
        read_device_ArrayList = ReaddeviceAdapter.get_all_devices();
        read_device_typeArrayList.onNext(read_device_ArrayList);
    }

    private void set_adapter(View v,RecyclerView recyclerView, ArrayList<Read_device_type> read_device_ArrayList){
        readdeviceAdapter = new ReaddeviceAdapter(read_device_ArrayList);
        recyclerView.setAdapter(readdeviceAdapter);
    }


    private void createObservable(View v, RecyclerView recyclerView) {
        read_device_typeArrayList = PublishSubject.create();
        read_device_typeArrayList.subscribe(new Observer<ArrayList<Read_device_type>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<Read_device_type> read_device_types) {
                set_adapter(v,recyclerView,read_device_types);
            }


            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Toast.makeText(getActivity(),"finish",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

