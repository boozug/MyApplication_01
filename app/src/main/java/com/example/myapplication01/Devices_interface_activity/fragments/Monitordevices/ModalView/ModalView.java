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
    public static int[] read_array_960_D_devices() {
        // Check connection
        int[] read_array_960_D_devices = new int[960];
        int pos = Devicelist_Activity_main.Count_save;
        int connect_res = connect_result("", pos);
        // Read array 960 D devices
        if (connect_res == 0x00) {
            String read_device_res_tmp = read_devices_res("D0", 960, read_array_960_D_devices);
            if (read_device_res_tmp == "OK") {
                return read_array_960_D_devices;
            } else {
                Log.d(TAG, "Error of reading device" + read_device_res_tmp);
            }
        }
        return read_array_960_D_devices;
    }

    public static ArrayList<Read_device_type> get_read_device_list() {
        ArrayList<Read_device_type> read_device_array_list = new ArrayList<Read_device_type>();
        ArrayList<String> tmp = new ArrayList<String>();
        // Add values followed by the number of value read
        int[] read_array_960_D_devices_tmp;
        read_array_960_D_devices_tmp =  read_array_960_D_devices();
//        for (int i = 0; i<= 3; i++){
//            for (int j = 0; j < 3; j++) {
        Read_device_type read_device_list = new Read_device_type();
        read_device_list.setId(0);
        read_device_list.setDevice_name("D");
        read_device_list.setAddress("D0");
        read_device_list.setValue(read_array_960_D_devices_tmp[0]);
        read_device_array_list.add(read_device_list);
        Read_device_type read_device_list1 = new Read_device_type();
        read_device_list1.setId(1);
        read_device_list1.setDevice_name("D");
        read_device_list1.setAddress("D1");
        read_device_list1.setValue(read_array_960_D_devices_tmp[1]);
        read_device_array_list.add(read_device_list1);



//            }
            //Test1
        for (int j=0; j<=3 ;j++){
            Log.d(TAG,"----------------------"+ read_device_array_list.get(j).getID_int());
            Log.d(TAG,read_device_array_list.get(j).getDevice_name()+" "+read_device_array_list.get(j).getAddress()+" "+read_device_array_list.get(j).getValue());
        }

//            read_device_array_list.add(read_device_list);
//        }
        return read_device_array_list;
    }
}
