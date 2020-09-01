package com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.ModalView;

import android.util.Log;

import com.example.myapplication01.Devices_interface_activity.fragments.Apis.MX_Component_API;
import com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.Model.Read_device_type;
import com.example.myapplication01.Plclist_activity.Devicelist_Activity_main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jp.co.melco.mxcomponent.MELMxOpenSettings;
import static com.example.myapplication01.Devices_interface_activity.fragments.Apis.MX_Component_API.connect_result;
import static com.example.myapplication01.Devices_interface_activity.fragments.Apis.MX_Component_API.read_devices_res;

public class ModalView {
    private static final String TAG = "Modal View Fragment";
    public static ArrayList<Read_device_type> read_device_types_array_list_final;
    public static int[] read_array_960_D_devices = new int[960];

    private static int Connect_res(){
        // Check connection
        int Final_res = 0;
        int pos = Devicelist_Activity_main.Count_save;
        int connect_res = connect_result("", pos);
        // Read array 960 D devices
        if (connect_res == 0x00|| connect_res == 0xF0000003){
            int read_device_res_tmp = read_devices_res("D0", 960, read_array_960_D_devices);
            Final_res = read_device_res_tmp;
        }
        else{
            Final_res = connect_res;
        }
        return Final_res;
    }

    public static ArrayList<Read_device_type> get_read_device_list(int[] read_array_960_D_devices) {
        ArrayList<Read_device_type> read_device_array_list = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<String>();
        int[] read_array_960_D_devices_tmp;
        // Add values followed by the number of value read
        for (int j = 0; j < 960; j++) {
            Read_device_type read_device_list = new Read_device_type();
            read_device_list.setId(j);
            read_device_list.setDevice_name("D");
            read_device_list.setAddress("D"+j);
            read_device_list.setValue(read_array_960_D_devices[j]);
            read_device_array_list.add(read_device_list);
        }
        return read_device_array_list;
    }

    //-----------------------------------------------------
    public static Integer Read_deivce_adapter_to_Observable(){
        int final_res;
        final_res = Connect_res();
        if (final_res == 0x00|| final_res == 0xF0000003){
            read_device_types_array_list_final = get_read_device_list(read_array_960_D_devices);
        }
        return final_res;
    }
}
