package com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.VIew;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.ModalView.ModalView;
import com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.Model.Read_device_type;
import com.example.myapplication01.R;

import java.util.ArrayList;
import java.util.List;

public class ReaddeviceAdapter extends RecyclerView.Adapter<ReaddeviceAdapter.ViewHolder>{
    List<Read_device_type> read_device_typeList;
    // return adapter to recyclerview

    // Provide a reference to the views for each data item
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, device_name,address,value;
        Button notificator_btn;
        public ViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.id_textView);
            device_name = view.findViewById(R.id.devicename_textView);
            address = view.findViewById(R.id.address_textView);
            value = view.findViewById(R.id.value_textView);
            notificator_btn = view.findViewById(R.id.button_notification1);
            notificator_btn.setOnClickListener(new View.OnClickListener() {
                private static final String TAG = "Read_device_adapter";
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of data set)
    public ReaddeviceAdapter(List<Read_device_type> readDeviceTypeList){
        this.read_device_typeList = readDeviceTypeList;
    }


    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_read_devices_flateditems,parent,false);
        return new ViewHolder(view);
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Read_device_type read_device_type_tmp = read_device_typeList.get(position);
        holder.id.setText("Address ID: "+String.valueOf(read_device_type_tmp.getId()));
        holder.device_name.setText("Device type: "+read_device_type_tmp.getDevice_name());
        holder.address.setText("Address number: " + read_device_type_tmp.getAddress());
        holder.value.setText("Value is: "+ String.valueOf(read_device_type_tmp.getValue()));
    }
    // Return the size of your data set (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return read_device_typeList.size();
    }
}