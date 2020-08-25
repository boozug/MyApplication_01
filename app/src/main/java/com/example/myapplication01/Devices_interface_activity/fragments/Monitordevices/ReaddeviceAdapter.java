package com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication01.R;

import java.util.ArrayList;
import java.util.List;

public class ReaddeviceAdapter extends RecyclerView.Adapter<ReaddeviceAdapter.ViewHolder>{
    List<Read_device_type> read_device_typeList;
    // return adapter to recyclerview
    public ReaddeviceAdapter(List<Read_device_type> readDeviceTypeList){
        this.read_device_typeList = readDeviceTypeList;
    }

//    public static ArrayList<Read_device_type> get_all_devices() {
//
//    }

    // Create viewholder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_read_devices_flateditems,parent,false);
        return new ViewHolder(view);
    }
    // Bind viewholder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Read_device_type readdevice = read_device_typeList.get(position);
        holder.id.setText(Read_device_type.getId());
        holder.devicename.setText(Read_device_type.getDevice_name());
        holder.inputtype.setText(Read_device_type.getInput_type());
        holder.address.setText(Read_device_type.getAddress());
        holder.value.setText(Read_device_type.getValue());
    }


    @Override
    public int getItemCount() {
        return read_device_typeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id,devicename,inputtype,address,value;

        public ViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.id_textView);
            devicename = view.findViewById(R.id.devicename_textView);
            inputtype = view.findViewById(R.id.inputtype_textView);
            address = view.findViewById(R.id.address_textView);
            value = view.findViewById(R.id.value_textView);
        }
    }
}