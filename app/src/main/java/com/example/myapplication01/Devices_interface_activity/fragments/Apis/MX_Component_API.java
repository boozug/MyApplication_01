package com.example.myapplication01.Devices_interface_activity.fragments.Apis;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import jp.co.melco.mxcomponent.MELMxCommunication;
import jp.co.melco.mxcomponent.MELMxOpenSettings;

import static com.example.myapplication01.SQL_interface.Addevice_DBUserAdapter.read_information_from_position_in_database;

public class MX_Component_API {
//    --------------------------Diagnostic
    private static MELMxCommunication mx_comm = new MELMxCommunication();
    private static MELMxOpenSettings mx_open = new MELMxOpenSettings();


    /**
     * Connect function
     * @param password passsword of the connect function
     * @param pos position of the Database which is opened
     * @return connect returned
     */
    public static int connect_result(String password, int pos){
        mx_open = mx_open_setting(read_information_from_position_in_database(pos));
        return mx_comm.open(mx_open,password);
    }


    /**
     *
     * @param nut_information create MELMxCommunication from nut_information
     * @return
     */
    public static MELMxOpenSettings mx_open_setting(List<String> nut_information) {
        final int CPU = 1;
        final int IO_NUMBER = 2;
        final int UNIT_TYPE = 3;
        final int IP_ADDRESS = 4;
        final int DESTINATION_PORT_NUMBER = 6;
        final int TIMEOUT = 7;
        final int DESTINATION_TIMEOUT = 8;
        MELMxOpenSettings mxOpenSettings = new MELMxOpenSettings();
        mxOpenSettings.ioNumber = Convert_String_to_int.Io_number(nut_information.get(IO_NUMBER));
        mxOpenSettings.cpuType = Convert_String_to_int.CPU_type(nut_information.get(CPU));
        mxOpenSettings.unitType= Convert_String_to_int.Unit_type(nut_information.get(UNIT_TYPE));
        mxOpenSettings.hostAddress= nut_information.get(IP_ADDRESS);
        mxOpenSettings.destinationPortNumber= Integer.valueOf(nut_information.get(DESTINATION_PORT_NUMBER));
        mxOpenSettings.timeOut = Integer.valueOf(nut_information.get(TIMEOUT));
        mxOpenSettings.cpuTimeOut= Integer.valueOf(nut_information.get(DESTINATION_TIMEOUT));
        return mxOpenSettings;
    }

    /**
     *
     * @param Offset Start address of read values
     * @param number_of_devices number of values
     * @param write_data data written to
     * @return String returned
     */
    @NotNull
    public static int read_devices_res(String Offset, int number_of_devices, int[] write_data){
        int read_device = mx_comm.readDeviceBlock(Offset,number_of_devices,write_data);
        return read_device;
    }

    /**
     *
     * @param Offset Start address of read values
     * @param number_of_devices number of values
     * @param read_data data read to
     * @return String returned
     */
    @NotNull
    public static String write_devices_res(String Offset, int number_of_devices, int[] read_data){
        int write_deivice = mx_comm.writeDeviceBlock(Offset,number_of_devices,read_data);
        if (write_deivice == 0){
            return "OK";
        }
        else
        {
            return String.valueOf(write_deivice);
        }
    }
    // region -------------------------------------------------------------------------------------------Diagnostic----------------------------------
    public static int result(MELMxOpenSettings mx_open, @NotNull MELMxCommunication mx_comm, String password) {return mx_comm.open(mx_open,password);}
    //-----------------------------------------------------Diagnostic string-------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    @NotNull
    @Contract(pure = true)
    /**
     * Program for diagnostic errors of program to string.
     */
    public static String result_string(int result_int) {
        String result_string = "";
            if (result_int == 0x00000000){ result_string = "Normal completion";}
            else if (result_int == 0x01800001) {result_string = "No command error the specified CPU module or module does not support the corresponding function";}
            else if (result_int == 0x01800003) {result_string ="Memory securing error";}
            else if (result_int == 0x01800004) {result_string = "Load error";}
            else if (result_int == 0x01801002) {result_string = "Multi-line open error";}
            else if (result_int == 0x01801003 || result_int == 0x01808404) {result_string = "Open not yet executed";}
            else if (result_int == 0x01801006) {result_string = " Specified module error";}
            else if (result_int == 0x01801007) {result_string = "Specified CPU error";}
            else if (result_int == 0x01801009) {result_string = "Setting fil" +
                    "e open failed";}
            else if (result_int == 0x0180100B) {result_string = "Protocol type error The specified protocol is incorrect";}
            else if (result_int == 0x01802001) {result_string = "Device error The device character string specified in the method is an incorrect device character string.";}
            else if (result_int == 0x01802002) {result_string = "Device number error The device character string number specified in the method is an incorrect device number.";}
            else if (result_int == 0x01802005) { result_string = "Size error The number of points specified in the method is incorrect.";}
            else if (result_int == 0x01802007) {result_string = "Receive data error\n" +
                        "The received data is abnormal.";}
            else if (result_int == 0x01802079) { result_string = "'null' specification error\n" +
                        "'null' is specified to the argument";}
            else if (result_int == 0x01808001) {result_string = "Multiple open error\n" +
                        "The open method was executed again after it\n" +
                        "was executed.";}

            else if (result_int == 0x01808007){
                result_string = "Socket object generation error\n" +
                        "The generation of the Socket object failed.";}
            else if (result_int == 0x01808008){
                result_string = "Port connection error\n" +
                        "Establishment of connection failed. The\n" +
                        "connection target does not respond";}
            else if (result_int == 0x01808101){
                result_string = "unripe close error";}
            else if (result_int == 0x01808201){
                result_string = "Send error\n" +
                        "Data send failed.";}
            else if (result_int == 0x01808301){
                result_string = "Receive error\n" +
                        "Data receive failed.";}
            else if (result_int == 0x0180840B){
                result_string = "Time-out error\n" +
                        "Data could not be received before the\n" +
                        "timeout period had elapsed.";}
            else if (result_int == 0x01902001){
                result_string = "Extended device mixed error Both a device and extended device are specified.";}
            else if (result_int == 0x01902801){
                result_string = "Label data incorrect error\n" +
                        "The specified label data to the argument is\n" +
                        "incorrect.";}
            else if (result_int == 0x01902802 || result_int == 0xFE003001){
                result_string = "Label name length error\n" +
                        "Label name length or total number of label\n" +
                        "name length exceeds the applicable length.";}
            else if (result_int == 0x01902803 || result_int == 0xFE003002){
                result_string = "Label data size error\n" +
                        "The data size of the label exceeds the\n" +
                        "applicable size.";}
            else if (result_int == 0x01902804 || result_int == 0xFE003003){
                result_string = "Label name length and label data size error\n" +
                        "The total size of label name length and label\n" +
                        "data exceeds the applicable size.";}
            else if (result_int == 0x01902805){
                result_string = "Label data incorrect error\n" +
                        "The type of the specified label is unknown.";}
            else if (result_int == 0x01903801){
                result_string = "Data type mismatch error\n" +
                        "The data type of the specified label\n" +
                        "mismatches the one set to the CPU module.";}
            else if (result_int == 0x01904001){
                result_string = "Remote password length error\n" +
                        "The remote password length is not 4 bytes or\n" +
                        "exceeds 32 bytes";}
            else if (result_int == 0x01904002){
                result_string ="Port number error\n" +
                        "The port number is wrong.";}
            else if (result_int == 0x01905001){
                result_string ="The send error of the remote password lock\n" +
                        "has occurred in the close processing when\n" +
                        "setting the remote password.";}
            else if (result_int == 0x0190FFFF){
                result_string ="Exception occurrence error in the operating\n" +
                        "environment\n" +
                        "An exception error has occurred in the\n" +
                        "running device.";}
            else if (result_int == 0xF0000001){
                result_string = " No-license error";}
            else if (result_int == 0xF0000003){
                result_string = "Already open error\n" +
                        "The open method was executed again after it\n" +
                        "was executed.";}
            else if ( result_int == 0xF0000004){
                result_string = " Not yet open error\n" +
                        "The open method has not been executed.";}
            else if (result_int == 0xF1000002){
                result_string = "Start I/O No. error\n" +
                        "The value of specified start I/O number is\n" +
                        "incorrect. No matching start I/O number\n" +
                        "exist.";}
            else if (result_int == 0xF1000005){
                result_string = "Size error\n" +
                        "The size specified to the read/write method is\n" +
                        "abnormal. The 'first read/write number + size'\n" +
                        "exceeds the device or buffer area.";}
            else if (result_int == 0xFE003004){
                result_string = "Label data type error\n" +
                        "The data type of the label is unsupported";}
            else if (result_int == 0xFE004001){
                result_string = "'null' is specified.\n" +
                        "'null' is specified to the argument.";}
            else{result_string = "error unknown" + result_int;}
        return result_string;
    }


    //endregion
}
