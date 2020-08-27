package com.example.myapplication01.Devices_interface_activity.fragments.Apis;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.List;

import com.example.myapplication01.Adddevice_activity.Addevice_DBUserAdapter;
import jp.co.melco.mxcomponent.MELMxCommunication;
import jp.co.melco.mxcomponent.MELMxOpenSettings;
import com.example.myapplication01.Devices_interface_activity.fragments.Apis.Convert_String_to_int;

public class Read_information_fromDB extends Addevice_DBUserAdapter{
    private static final int CPU = 1;
    private static final int IO_NUMBER = 2;
    private static final int UNIT_TYPE = 3;
    private static final int IP_ADDRESS = 4;
    private static final int DESTINATION_PORT_NUMBER = 6;
    private static final int DESTINATION_TIMEOUT = 8;

    public Read_information_fromDB(Context ctx) {
        super(ctx);
    }

    /**
     * Create mx_open depend on the position of the Database
     * @param pos position of Database
     * @return
     */
    public static MELMxOpenSettings mx_open(int pos){
        @NonNull
        MELMxOpenSettings mx_open = new MELMxOpenSettings();
        List<String> read_data_cursor_to_list = read_data_cursor_to_list(pos);
        int CPU_type = Convert_String_to_int.CPU_type(read_data_cursor_to_list.get(CPU));
        int IO_number = Convert_String_to_int.Io_number(read_data_cursor_to_list.get(IO_NUMBER));
        int UNIT_type = Convert_String_to_int.Unit_type(read_data_cursor_to_list.get(UNIT_TYPE));
        String IP_address = read_data_cursor_to_list.get(IP_ADDRESS);
        int DESTINATION_port_number = Integer.getInteger(read_data_cursor_to_list.get(DESTINATION_PORT_NUMBER));
        int DESTINATION_timeout = Integer.getInteger(read_data_cursor_to_list.get(DESTINATION_TIMEOUT));
        mx_open.cpuType = CPU_type;
        mx_open.ioNumber = IO_number;
        mx_open.unitType = UNIT_type;
        mx_open.hostAddress = IP_address;
        mx_open.destinationPortNumber = DESTINATION_port_number;
        mx_open.timeOut = DESTINATION_timeout;
        return mx_open;
    }
}
