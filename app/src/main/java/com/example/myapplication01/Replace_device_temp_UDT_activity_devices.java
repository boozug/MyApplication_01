package com.example.myapplication01;

public class Replace_device_temp_UDT_activity_devices {
    private String ionumber, cputype, unittype, ipaddress, portnumber, destinationportnumber, timeout, destinationtimeout;
    public Replace_device_temp_UDT_activity_devices(String ionumber, String cputype, String unittype, String ipaddress, String portnumber, String destinationportnumber, String timeout, String destinationtimeout){
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

    public String getIonumber(){
        return ionumber;
    }

    public void setIonumber(){
        this.ionumber = ionumber;
    }

    public String getCputype(){
        return cputype;
    }

    public void setCputype(){
        this.cputype = cputype;
    }

    public String getUnittype(){
        return unittype;
    }

    public void setUnittype(){
        this.unittype = unittype;
    }

    public String getIpaddress(){
        return ipaddress;
    }

    public void setIpaddress(){
        this.ipaddress = ipaddress;
    }

    public String getPortnumber(){
        return portnumber;
    }

    public void setPortnumber(){
        this.portnumber = portnumber;
    }

    public String getDestinationportnumber(){
        return destinationportnumber;
    }

    public void setDestinationportnumber(){
        this.destinationportnumber= destinationportnumber;
    }

    public String getTimeout(){
        return timeout;
    }

    public void setTimeout(){
        this.timeout = timeout;
    }

    public String getDestinationtimeout(){
        return destinationtimeout;
    }

    public void setDestinationtimeout(){
        this.destinationtimeout = destinationtimeout;
    }
}
