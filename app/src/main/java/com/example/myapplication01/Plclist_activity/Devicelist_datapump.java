package com.example.myapplication01.Plclist_activity;

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
        unit_type.add("UNIT_FETHER");
        unit_type.add("UNIT_QNETHER");
        unit_type.add("UNIT_LNETHER");
        unit_type.add("UNIT_RJ71EN71");
        unit_type.add("UNIT_QJ71E71");
        unit_type.add("UNIT_LJ71E71");
        unit_type.add("UNIT_QCCPUETHER");
        unit_type.add("UNIT_RCCPUETHER");

        List<String> io_number = new ArrayList<String>();
        io_number.add("Host CPU");
        io_number.add("CPU No.1");
        io_number.add("CPU No.2");
        io_number.add("CPU No.3");
        io_number.add("CPU No.4");

        List<String> cpu_type = new ArrayList<String>();
        cpu_type.add("CPU_R04CPU");
        cpu_type.add("CPU_R08CPU");
        cpu_type.add("CPU_R16CPU");
        cpu_type.add("CPU_R32CPU");
        cpu_type.add("CPU_R120CPU");
        cpu_type.add("CPU_R04ENCPU");
        cpu_type.add("CPU_R08ENCPU");
        cpu_type.add("CPU_R16ENCPU");
        cpu_type.add("CPU_R32ENCPU");
        cpu_type.add("CPU_R120ENCPU");
        cpu_type.add("CPU_R16MTCPU");
        cpu_type.add("CPU_R32MTCPU");
        cpu_type.add("CPU_R12CCPU_V");
        //FX Cpus
        cpu_type.add("CPU_FX5UCPU");
        cpu_type.add("CPU_FX5UCCPU");
        //Q Cpus
        cpu_type.add("CPU_Q00JCPU");
        cpu_type.add("CPU_Q00UJCPU");
        cpu_type.add("CPU_Q00CPU");
        cpu_type.add("CPU_Q00UCPU");
        cpu_type.add("CPU_Q01CPU");
        cpu_type.add("CPU_Q01UCPU");
        cpu_type.add("CPU_Q02CPU");
        cpu_type.add("CPU_Q06CPU");
        cpu_type.add("CPU_Q12CPU");
        cpu_type.add("CPU_Q25CPU");
        cpu_type.add("CPU_Q02PHCPU");
        cpu_type.add("CPU_Q06PHCPU");
        cpu_type.add("CPU_Q12PHCPU");
        cpu_type.add("CPU_Q25PHCPU");
        cpu_type.add("CPU_Q12PRHCPU");
        cpu_type.add("CPU_Q25PRHCPU");
        cpu_type.add("CPU_Q02UCPU");
        cpu_type.add("CPU_Q03UDCPU");
        cpu_type.add("CPU_Q04UDHCPU");
        cpu_type.add("CPU_Q06UDHCPU");
        cpu_type.add("CPU_Q10UDHCPU");
        cpu_type.add("CPU_Q13UDHCPU");
        cpu_type.add("CPU_Q20UDHCPU");
        cpu_type.add("CPU_Q26UDHCPU");
        cpu_type.add("CPU_Q03UDECPU");
        cpu_type.add("CPU_Q04UDEHCPU");
        cpu_type.add("CPU_Q06UDEHCPU");
        cpu_type.add("CPU_Q10UDEHCPU");
        cpu_type.add("CPU_Q13UDEHCPU");
        cpu_type.add("CPU_Q20UDEHCPU");
        cpu_type.add("CPU_Q26UDEHCPU");
        cpu_type.add("CPU_Q50UDEHCPU");
        cpu_type.add("CPU_Q100UDEHCPU");
        cpu_type.add("CPU_Q03UDVCPU");
        cpu_type.add("CPU_Q04UDVCPU");
        cpu_type.add("CPU_Q06UDVCPU");
        cpu_type.add("CPU_Q13UDVCPU");
        cpu_type.add("CPU_Q26UDVCPU");
        cpu_type.add("CPU_Q04UDPVCPU");
        cpu_type.add("CPU_Q06UDPVCPU");
        cpu_type.add("CPU_Q13UDPVCPU");
        cpu_type.add("CPU_Q26UDPVCPU");
        cpu_type.add("CPU_Q12DC_V");
        cpu_type.add("CPU_Q24DHC_LS");
//        Motion cpus
        cpu_type.add("CPU_Q172DCPU");
        cpu_type.add("CPU_Q173DCPU");
        cpu_type.add("CPU_Q172DSCPU");
        cpu_type.add("CPU_Q173DSCPU");
//        L cpus
        cpu_type.add("CPU_L02SCPU");
        cpu_type.add("CPU_L02CPU");
        cpu_type.add("CPU_L06CPU");
        cpu_type.add("L06CPU-P");
        cpu_type.add("CPU_L26CPU");
        cpu_type.add("CPU_L26CPUBT");

        expandableListDetail.put("UNIT TYPE", unit_type);
        expandableListDetail.put("IO NUMBER", io_number);
        expandableListDetail.put("CPU TYPE", cpu_type);
        return expandableListDetail;
    }
}
