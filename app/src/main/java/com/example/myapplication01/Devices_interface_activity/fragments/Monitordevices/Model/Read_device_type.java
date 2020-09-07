package com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.Model;

public class Read_device_type {

    Integer id, value, min_value_limit, max_value_limit;
    String device_name, address, noti_min_limit, noti_max_limit;
    boolean min_value_checked, max_value_checked, run_as_service;
    static Integer notify_count;

    public Read_device_type() {
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {
        this.id = id;}

    public String getDevice_name() {return device_name;}

    public void setDevice_name(String device_name) {
        this.device_name = device_name;}

    public String getAddress() {return address;}

    public void setAddress(String address) {
        this.address = address;}

    public Integer getValue() {return value;}

    public void setValue(Integer value) {
        this.value = value;}

    public Integer getMin_value_limit() {return min_value_limit;}

    public void setMin_value_limit(Integer min_value_limit) {this.min_value_limit = min_value_limit;}

    public Integer getMax_value_limit() {return max_value_limit;}

    public void setMax_value_limit(Integer max_value_limit) {this.max_value_limit = max_value_limit;}

    public Integer getNotify_count() {return notify_count;}

    public void setNotify_count(Integer notify_count) {this.notify_count = notify_count;}

    public String getNoti_min_limit() {return noti_min_limit;}

    public void setNoti_min_limit(String noti_min_limit) {this.noti_min_limit = noti_min_limit;}

    public String getNoti_max_limit() {return noti_max_limit;}

    public void setNoti_max_limit(String noti_max_limit) {this.noti_max_limit = noti_max_limit;}

    public boolean isMin_value_checked() {return min_value_checked;}

    public void setMin_value_checked(boolean min_value_checked) {this.min_value_checked = min_value_checked;}

    public boolean isMax_value_checked() {return max_value_checked;}

    public void setMax_value_checked(boolean max_value_checked) {this.max_value_checked = max_value_checked;}

    public boolean isRun_as_service() {return  run_as_service;}

    public void setRun_as_service(boolean run_as_service){this.run_as_service = run_as_service;}
}
