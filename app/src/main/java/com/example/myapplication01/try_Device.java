package com.example.myapplication01;

public class try_Device {
    private String id, io_number, cpu_type, ip_address;
    public try_Device(String id, String io_number, String cpu_type, String ip_address) {
        this.id = id;
        this.io_number = io_number;
        this.cpu_type = cpu_type;
        this.ip_address = ip_address;
    }

    public try_Device() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIo_number() {
        return io_number;
    }

    public void setIo_number(String io_number) {
        this.io_number = io_number;
    }

    public String getCpu_type(){return cpu_type;}

    public void setCpu_type(String cpu_type){
        this.cpu_type = cpu_type;}

    public String getIp_address(){return ip_address;}

    public void setIp_address(String ip_address){
        this.ip_address = ip_address;}
}
