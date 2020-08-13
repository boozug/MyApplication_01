package com.example.myapplication01;

public class Replace_device_temp_UDT_activity_devices {
    private String id, ionumber, cputype, unittype, ipaddress, portnumber, destinationportnumber, timeout, destinationtimeout;
    public Replace_device_temp_UDT_activity_devices(String id,String ionumber, String cputype, String unittype, String ipaddress, String portnumber, String destinationportnumber, String timeout, String destinationtimeout){
        this.id = id;
        this.ionumber = ionumber;
        this.cputype = cputype;
        this.unittype = unittype;
        this.ipaddress = ipaddress;
        this.portnumber = portnumber;
        this.destinationportnumber = destinationportnumber;
        this.timeout = timeout;
        this.destinationtimeout = destinationtimeout;
    }
    public Replace_device_temp_UDT_activity_devices(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIonumber(){
        return ionumber;
    }

    public void setIonumber(String ionumber){
        this.ionumber = ionumber;
    }

    public String getCputype(){
        return cputype;
    }

    public void setCputype(String cputype){
        this.cputype = cputype;
    }

    public String getUnittype(){
        return unittype;
    }

    public void setUnittype(String unittype){
        this.unittype = unittype;
    }

    public String getIpaddress(){
        return ipaddress;
    }

    public void setIpaddress(String ipaddress){
        this.ipaddress = ipaddress;
    }

    public String getPortnumber(){
        return portnumber;
    }

    public void setPortnumber(String portnumber){
        this.portnumber = portnumber;
    }

    public String getDestinationportnumber(){
        return destinationportnumber;
    }

    public void setDestinationportnumber(String destinationportnumber){
        this.destinationportnumber= destinationportnumber;
    }

    public String getTimeout(){
        return timeout;
    }

    public void setTimeout(String timeout){
        this.timeout = timeout;
    }

    public String getDestinationtimeout(){
        return destinationtimeout;
    }

    public void setDestinationtimeout(String destinationtimeout){
        this.destinationtimeout = destinationtimeout;
    }
}
