package com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.ModalView;

import android.util.Log;

import com.example.myapplication01.Devices_interface_activity.fragments.Apis.MX_Component_API;
import com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.Model.Read_device_type;
import com.example.myapplication01.Plclist_activity.Devicelist_Activity_main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import jp.co.melco.mxcomponent.MELMxOpenSettings;
import static com.example.myapplication01.Devices_interface_activity.fragments.Apis.MX_Component_API.connect_result;
import static com.example.myapplication01.Devices_interface_activity.fragments.Apis.MX_Component_API.read_devices_res;
import static com.example.myapplication01.Devices_interface_activity.fragments.Notifydevices.View.NotifydeviceActivity.information_from_notify_activity;

public class ModalView {
    private static final String TAG = "Modal View Fragment";
    public static ArrayList<Read_device_type> read_device_types_array_list_final;
    public static int[] read_array_960_D_devices = new int[960];
    public static long start;
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
            Arrays.fill(read_array_960_D_devices,0);
        }
        return Final_res;
    }

    public static ArrayList<Read_device_type> get_read_device_list(int[] read_array_960_D_devices) {
        ArrayList<Read_device_type> read_device_array_list = new ArrayList<>();
        // Add values followed by the number of value read
        for (int j = 0; j < 960; j++) {
            int MIN_LIMIT = 1;
            int NOTIFY_MIN_LIMIT = 2;
            int MAX_LIMIT = 3;
            int NOTIFY_MAX_LIMIT = 4;
            int MIN_CHECKED = 5;
            int MAX_CHECKED = 6;
            int RUN_AS_SERVICE = 7;
            // take data from activity notification
//            min_value_limit int
//            noti_min_limit String
//            max_value_limit int
//            noti_max_limit String
//            min_value_checked boolean
//            max_value_checked boolean
//            run_as_service_checked boolean
//            noti_count int.
            List<String> list_information_from_notify_activity = information_from_notify_activity.get(j);
            Read_device_type read_device_list = new Read_device_type();
            read_device_list.setId(j);
            read_device_list.setDevice_name("D");
            read_device_list.setAddress("D"+j);
            read_device_list.setValue(read_array_960_D_devices[j]);
            boolean res = (read_device_list.isMin_value_checked()||read_device_list.isMax_value_checked());
            if (res){
                read_device_list.setMin_value_limit(Integer.decode(list_information_from_notify_activity.get(MIN_LIMIT)));
                read_device_list.setNoti_min_limit(list_information_from_notify_activity.get(NOTIFY_MIN_LIMIT));
                read_device_list.setMax_value_limit(Integer.decode(list_information_from_notify_activity.get(MAX_LIMIT)));
                read_device_list.setNoti_max_limit(list_information_from_notify_activity.get(NOTIFY_MAX_LIMIT));
                read_device_list.setMin_value_checked(Boolean.getBoolean(list_information_from_notify_activity.get(MIN_CHECKED)));
                read_device_list.setMax_value_checked(Boolean.getBoolean(list_information_from_notify_activity.get(MAX_CHECKED)));
                read_device_list.setRun_as_service(Boolean.getBoolean(list_information_from_notify_activity.get(RUN_AS_SERVICE)));
                if(read_device_list.isMin_value_checked()&(read_array_960_D_devices[j]<=read_device_list.getMin_value_limit())){
                read_device_list.setNotify_count(read_device_list.getNotify_count()+1);}
                else if (read_device_list.isMax_value_checked()&(read_array_960_D_devices[j]>=read_device_list.getMax_value_limit())){
                    read_device_list.setNotify_count(read_device_list.getNotify_count()+1);}
            }
            else {
                read_device_list.setMin_value_limit(0);
                read_device_list.setNoti_min_limit("");
                read_device_list.setMax_value_limit(0);
                read_device_list.setNoti_max_limit("");
                read_device_list.setMin_value_checked(false);
                read_device_list.setMax_value_checked(false);
                read_device_list.setRun_as_service(false);
                read_device_list.setNotify_count(0);
            }
            read_device_array_list.add(read_device_list);
        }
        return read_device_array_list;
    }

    //-----------------------------------------------------
    public static Integer Read_deivce_adapter_to_Observable(){
        start = System.currentTimeMillis();
        int final_res;
        final_res = Connect_res();
        read_device_types_array_list_final = get_read_device_list(read_array_960_D_devices);
        return final_res;
    }
}
