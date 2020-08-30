package com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.Model;

public class Read_device_type {

    static Integer id;
    static String device_name;
    static String address;
    static Integer value;


    public Read_device_type() {
        Read_device_type.id = 0;
        Read_device_type.device_name="";
        Read_device_type.address="";
        Read_device_type.value =0;
    }


    public static String getId() {return String.valueOf(id);}

    public Integer getID_int() {return id;}

    public void setId(Integer id) {
        Read_device_type.id = id;}

    public static String getDevice_name() {return device_name;}

    public void setDevice_name(String device_name) {
        Read_device_type.device_name = device_name;}

    public static String getAddress() {return address;}

    public void setAddress(String address) {
        Read_device_type.address = address;}

    public static String getValue() {return String.valueOf(value);}

    public void setValue(Integer value) {
        Read_device_type.value = value;}



}
