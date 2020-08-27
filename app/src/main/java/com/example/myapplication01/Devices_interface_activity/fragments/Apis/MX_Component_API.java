package com.example.myapplication01.Devices_interface_activity.fragments.Apis;
import jp.co.melco.mxcomponent.MELMxCommunication;
import jp.co.melco.mxcomponent.MELMxOpenSettings;
public class MX_Component_API {
//    --------------------------Diagnostic
    private static MELMxCommunication mx_comm = new MELMxCommunication();
    private static MELMxOpenSettings mx_open = new MELMxOpenSettings();

    public static int connect_result (String host_address, Integer destination_port_number, Integer unit_type, Integer cpu_type, Integer io_number, Integer protocol_type, String password){
        mx_open.hostAddress = host_address;
        mx_open.destinationPortNumber = destination_port_number;
        mx_open.unitType = unit_type;
        mx_open.cpuType =cpu_type;
        mx_open.ioNumber = io_number;
        mx_open.protocolType = protocol_type;
        return mx_comm.open(mx_open,password);
    }
    public static String read_devices_res(String Offset,int number_of_devices,int[] write_data){
        int read_device = mx_comm.readDeviceBlock(Offset,number_of_devices,write_data);
        if (read_device == 0){
            return "OK";
        }
        else
        {
            return String.valueOf(read_device);
        }
    }

    public static String write_devices_res(String Offset, int number_of_devices,int[] read_data){
        int write_deivice = mx_comm.writeDeviceBlock(Offset,number_of_devices,read_data);
        if (write_deivice == 0){
            return "OK";
        }
        else
        {
            return String.valueOf(write_deivice);
        }
    }
    public static int result(MELMxOpenSettings mx_open, MELMxCommunication mx_comm, String password) {return mx_comm.open(mx_open,password);}
    public static String result_string(int result_int) throws Exception {
        String result_string = "";
        switch (result_int){
            case 0x00000000:
                result_string = "Normal completion";
                break;
            case 0x01800001:
                result_string = "No command error the specified CPU module or module does not support the corresponding function";
                break;
            case 0x01800003:
                result_string ="Memory securing error";
                break;
            case 0x01800004:
                result_string = "Load error";
                break;
            case 0x01801002:
                result_string = "Multi-line open error";
                break;
            case 0x01801003:
            case 0x01808404:
                result_string = "Open not yet executed";
                break;
            case 0x01801006:
                result_string = " Specified module error";
                break;
            case 0x01801007:
                result_string = "Specified CPU error";
                break;
            case 0x01801009:
                result_string = "Setting file open failed";
                break;
            case 0x0180100B:
                result_string = "Protocol type error The specified protocol is incorrect";
                break;
            case 0x01802001:
                result_string = "Device error The device character string specified in the method is an incorrect device character string.";
                break;
            case 0x01802002:
                result_string = "Device number error The device character string number specified in the method is an incorrect device number.";
                break;
            case 0x01802005:
                result_string = "Size error The number of points specified in the method is incorrect.";
                break;
            case 0x01802007:
                result_string = "Receive data error\n" +
                        "The received data is abnormal.";
                break;
            case 0x01802079:
                result_string = "'null' specification error\n" +
                        "'null' is specified to the argument";
                break;
            case 0x01808001:
                result_string = "Multiple open error\n" +
                        "The open method was executed again after it\n" +
                        "was executed.";
                break;
            case 0x01808007:
                result_string = "Socket object generation error\n" +
                        "The generation of the Socket object failed.";
                break;
            case 0x01808008:
                result_string = "Port connection error\n" +
                        "Establishment of connection failed. The\n" +
                        "connection target does not respond";
                break;
            case 0x01808101:
                result_string = "unripe close error";
                break;
            case 0x01808201:
                result_string = "Send error\n" +
                        "Data send failed.";
                break;
            case 0x01808301:
                result_string = "Receive error\n" +
                        "Data receive failed.";
                break;
            case 0x0180840B:
                result_string = "Time-out error\n" +
                        "Data could not be received before the\n" +
                        "timeout period had elapsed.";
                break;
            case 0x01902001:
                result_string = "Extended device mixed error Both a device and extended device are specified.";
                break;
            case 0x01902801:
                result_string = "Label data incorrect error\n" +
                        "The specified label data to the argument is\n" +
                        "incorrect.";
                break;
            case 0x01902802:
            case 0xFE003001:
                result_string = "Label name length error\n" +
                        "Label name length or total number of label\n" +
                        "name length exceeds the applicable length.";
                break;
            case 0x01902803:
            case 0xFE003002:
                result_string = "Label data size error\n" +
                        "The data size of the label exceeds the\n" +
                        "applicable size.";
                break;
            case 0x01902804:
            case 0xFE003003:
                result_string = "Label name length and label data size error\n" +
                        "The total size of label name length and label\n" +
                        "data exceeds the applicable size.";
                break;
            case 0x01902805:
                result_string = "Label data incorrect error\n" +
                        "The type of the specified label is unknown.";
                break;
            case 0x01903801:
                result_string = "Data type mismatch error\n" +
                        "The data type of the specified label\n" +
                        "mismatches the one set to the CPU module.";
                break;
            case 0x01904001:
                result_string = "Remote password length error\n" +
                        "The remote password length is not 4 bytes or\n" +
                        "exceeds 32 bytes";
                break;
            case 0x01904002:
                result_string ="Port number error\n" +
                        "The port number is wrong.";
                break;
            case 0x01905001:
                result_string ="The send error of the remote password lock\n" +
                        "has occurred in the close processing when\n" +
                        "setting the remote password.";
                break;
            case 0x0190FFFF:
                result_string ="Exception occurrence error in the operating\n" +
                        "environment\n" +
                        "An exception error has occurred in the\n" +
                        "running device.";
                break;
            case 0xF0000001:
                result_string = " No-license error";
                break;
            case 0xF0000003:
                result_string = "Already open error\n" +
                        "The open method was executed again after it\n" +
                        "was executed.";
                break;
            case 0xF0000004:
                result_string = " Not yet open error\n" +
                        "The open method has not been executed.";
                break;
            case 0xF1000002:
                result_string = "Start I/O No. error\n" +
                        "The value of specified start I/O number is\n" +
                        "incorrect. No matching start I/O number\n" +
                        "exist.";
                break;
            case 0xF1000005:
                result_string = "Size error\n" +
                        "The size specified to the read/write method is\n" +
                        "abnormal. The 'first read/write number + size'\n" +
                        "exceeds the device or buffer area.";
                break;
            case 0xFE003004:
                result_string = "Label data type error\n" +
                        "The data type of the label is unsupported";
                break;
            case 0xFE004001:
                result_string = "'null' is specified.\n" +
                        "'null' is specified to the argument.";
        }
        return result_string;
    }
}
