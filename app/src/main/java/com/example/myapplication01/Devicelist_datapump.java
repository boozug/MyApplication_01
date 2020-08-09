package com.example.myapplication01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("ALL")
public class Devicelist_datapump {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();
//Add data to adapter
        List<String> unit_type = new ArrayList<String>();
        unit_type.add("UNIT_RETHER");
        unit_type.add("UNIT_RJ71EN71");
        unit_type.add("UNIT_FETHER");
        unit_type.add("UNIT_QNETHER");
        unit_type.add("UNIT_QJ71E71");
        unit_type.add("UNIT_LNETHER");
        unit_type.add("UNIT_LJ71E71");

        List<String> io_number = new ArrayList<String>();
        io_number.add("Host CPU");
        io_number.add("CPU No.1");
        io_number.add("CPU No.2");
        io_number.add("CPU No.3");
        io_number.add("CPU No.4");

        List<String> cpu_type = new ArrayList<String>();
        cpu_type.add("R04CPU");
        cpu_type.add("R08CPU");
        cpu_type.add("R16CPU");
        cpu_type.add("R32CPU");
        cpu_type.add("R120CPU");
        cpu_type.add("R04ENCPU");
        cpu_type.add("R08ENCPU");
        cpu_type.add("R16ENCPU");
        cpu_type.add("R32ENCPU");
        cpu_type.add("R120ENCPU");
        cpu_type.add("R08PCPU");
        cpu_type.add("R08PCPU");
        cpu_type.add("R32PCPU");
        cpu_type.add("R120PCPU");
        cpu_type.add("R12CCPU-V");
        cpu_type.add("R16MTCPU");
        cpu_type.add("R32MTCPU");
        //FX Cpus
        cpu_type.add("FX5UCPU");
        cpu_type.add("FX5UCCPU");
        //Q Cpus
        cpu_type.add("Q00JCPU");
        cpu_type.add("Q00UJCPU");
        cpu_type.add("Q00CPU");
        cpu_type.add("Q00UCPU");
        cpu_type.add("Q01CPU");
        cpu_type.add("Q01UCPU");
        cpu_type.add("Q02(H)CPU");
        cpu_type.add("Q06HCPU");
        cpu_type.add("Q12HCPU");
        cpu_type.add("Q25HCPU");
        cpu_type.add("Q12PRHCPU");
        cpu_type.add("Q25PRHCPU");
        cpu_type.add("Q02UCPU");
        cpu_type.add("Q03UDCPU");
        cpu_type.add("Q04UDHCPU");
        cpu_type.add("Q06UDHCPU");
        cpu_type.add("Q10UDHCPU");
        cpu_type.add("Q13UDHCPU");
        cpu_type.add("Q20UDHCPU");
        cpu_type.add("Q26UDHCPU");
        cpu_type.add("Q03UDECPU");
        cpu_type.add("Q04UDEHCPU");
        cpu_type.add("Q06UDEHCPU");
        cpu_type.add("Q10UDEHCPU");
        cpu_type.add("Q13UDEHCPU");
        cpu_type.add("Q20UDEHCPU");
        cpu_type.add("Q26UDEHCPU");
        cpu_type.add("Q50UDEHCPU");
        cpu_type.add("Q100UDEHCPU");
        cpu_type.add("Q03UDVCPU");
        cpu_type.add("Q04UDVCPU");
        cpu_type.add("Q06UDVCPU");
        cpu_type.add("Q13UDVCPU");
        cpu_type.add("Q26UDVCPU");
        cpu_type.add("Q12DCCPU-V");
        cpu_type.add("Q24DHCCPU-V");
        cpu_type.add("Q24DHCCPU-LS");
//        Motion cpus
        cpu_type.add("Q172DCPU");
        cpu_type.add("Q173DCPU");
        cpu_type.add("Q172DSCPU");
        cpu_type.add("Q173DSCPU");
//        L cpus
        cpu_type.add("L02SCPU");
        cpu_type.add("L02SCPU-P");
        cpu_type.add("L02CPU");
        cpu_type.add("L02CPU-P");
        cpu_type.add("L06CPU");
        cpu_type.add("L06CPU-P");
        cpu_type.add("L26CPU");
        cpu_type.add("L26CPU-P");
        cpu_type.add("L26CPU-BT");
        cpu_type.add("L26CPU-PBT");




        expandableListDetail.put("UNIT TYPE", unit_type);
        expandableListDetail.put("IO NUMBER", io_number);
        expandableListDetail.put("CPU TYPE", cpu_type);
        return expandableListDetail;
    }
}
