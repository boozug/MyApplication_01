package com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.Model;

import android.content.Context;

import java.util.List;

import com.example.myapplication01.Adddevice_activity.Addevice_DBUserAdapter;
import jp.co.melco.mxcomponent.MELMxCommunication;
import jp.co.melco.mxcomponent.MELMxOpenSettings;
import com.example.myapplication01.Devices_interface_activity.fragments.Apis.Convert_String_to_int;

public class Read_information_fromDB extends Addevice_DBUserAdapter{
    private static final int CPU = 1;
    private static final int IO_NUMBER = 2;
    private static final int UNIT_TYPE = 3;
    private static final int
    public Read_information_fromDB(Context ctx) {
        super(ctx);
    }

    public MELMxOpenSettings mx_open(int pos){
        MELMxOpenSettings mx_open = new MELMxOpenSettings();
        List<String> read_data_cursor_to_list = read_data_cursor_to_list(pos);
        int CPU_type = Convert_String_to_int.CPU_type(read_data_cursor_to_list.get(CPU));
        int IO_number = Convert_String_to_int.Io_number(read_data_cursor_to_list.get(IO_NUMBER));
        int UNIT_type = Convert_String_to_int.Unit_type(read_data_cursor_to_list.get(UNIT_TYPE));

        return mx_open;
    }
}
