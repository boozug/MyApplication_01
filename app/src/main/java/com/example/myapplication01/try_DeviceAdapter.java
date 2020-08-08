package com.example.myapplication01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class try_DeviceAdapter extends RecyclerView.Adapter<try_DeviceAdapter.DeviceHolder> {

    List<try_Device> list_device;
    public try_DeviceAdapter(List<try_Device> list_device) {
        this.list_device = list_device;
    }

    @Override
    public DeviceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.try_country_row_layout, parent, false);
        return new DeviceHolder(view);
    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
//
//    }


    @Override
    public void onBindViewHolder(DeviceHolder holder, int position) {
        try_Device device = list_device.get(position);
        holder.id.setText(device.getId());
        holder.ionumber.setText(device.getIo_number());
        holder.cputype.setText(device.getCpu_type());
        holder.ipaddres.setText(device.getIp_address());
    }

    @Override
    public int getItemCount() {
        return list_device.size();
    }

    public class DeviceHolder extends RecyclerView.ViewHolder {
        TextView id, ionumber, cputype, ipaddres;

        public DeviceHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_textView);
            ionumber = itemView.findViewById(R.id.ionumber_textView);
            cputype = itemView.findViewById(R.id.cputype_textView);
            ipaddres = itemView.findViewById(R.id.ipaddress_textView);
        }
    }
}
