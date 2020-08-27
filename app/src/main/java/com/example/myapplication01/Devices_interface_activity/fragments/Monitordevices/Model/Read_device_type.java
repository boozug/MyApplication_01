package com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.Model;

public class Read_device_type {
    private static Integer id;
    private static String device_name;
    private static String input_type;
    private static String address;
    private static Integer value;

    public Read_device_type(Integer id, String device_name, String input_type, String address, Integer value){
        this.id = id;
        this.device_name = device_name;
        this.input_type = input_type;
        this.address = address;
        this.value = value;
    }

    public static Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public static String getDevice_name() {return device_name;}

    public void setDevice_name(String device_name) {this.device_name = device_name;}

    public static String getInput_type() {return input_type;}

    public void setInput_type(String input_type) {this.input_type = input_type;}

    public static String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public static Integer getValue() {return value;}

    public void setValue(Integer value) {this.value = value;}

}
