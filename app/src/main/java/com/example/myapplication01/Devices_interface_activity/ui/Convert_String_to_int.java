package com.example.myapplication01.Devices_interface_activity.ui;

public class Convert_String_to_int {
    public static int CPU_type(String CPU_text) {
        int CPU_type = 0;
        switch (CPU_text) {
            case "CPU_R04CPU":
                CPU_type = 4097;
                break;
            case "CPU_R08CPU":
                CPU_type = 4098;
                break;
            case "CPU_R16CPU":
                CPU_type = 4099;
                break;
            case "CPU_R32CPU":
                CPU_type = 4100;
                break;
            case "CPU_R120CPU":
                CPU_type = 4101;
                break;
            case "CPU_R04ENCPU":
                CPU_type = 4104;
                break;
            case  "CPU_R08ENCPU":
                CPU_type = 4105;
                break;
            case "CPU_R16ENCPU":
                CPU_type = 4106;
                break;
            case "CPU_R32ENCPU":
                CPU_type = 4107;
                break;
            case "CPU_R120ENCPU":
                CPU_type = 4108;
                break;
            case "CPU_R16MTCPU":
                CPU_type = 4113;
                break;
            case "CPU_R32MTCPU":
                CPU_type = 4114;
                break;
            case "CPU_R12CCPU_V":
                CPU_type = 4129;
                break;
            case "CPU_FX5UCPU":
            case "CPU_FX5UCCPU":
                CPU_type = 528;
                break;
            case "CPU_Q00JCPU":
                CPU_type = 48;
                break;
            case "CPU_Q00UJCPU":
                CPU_type = 128;
                break;
            case "CPU_Q00CPU":
                CPU_type = 49;
                break;
            case "CPU_Q00UCPU":
                CPU_type = 129;
                break;
            case "CPU_Q01CPU":
                CPU_type = 50;
                break;
            case "CPU_Q01UCPU":
                CPU_type = 130;
                break;
            case "CPU_Q02CPU":
                CPU_type = 34;
                break;
            case "CPU_Q06CPU":
                CPU_type = 35;
                break;
            case "CPU_Q12CPU":
                CPU_type = 36;
                break;
            case "CPU_Q25CPU":
                CPU_type = 37;
                break;
            case "CPU_Q02PHCPU":
                CPU_type = 69;
                break;
            case "CPU_Q06PHCPU":
                CPU_type = 70;
                break;
            case "CPU_Q12PHCPU":
                CPU_type = 65;
                break;
            case "CPU_Q25PHCPU":
                CPU_type = 66;
                break;
            case "CPU_Q12PRHCPU":
                CPU_type = 67;
                break;
            case "CPU_Q25PRHCPU":
                CPU_type = 68;
                break;
            case "CPU_Q02UCPU":
                CPU_type = 131;
                break;
            case "CPU_Q03UDCPU":
                CPU_type = 112;
                break;
            case "CPU_Q04UDHCPU":
                CPU_type = 113;
                break;
            case "CPU_Q06UDHCPU":
                CPU_type = 114;
                break;
            case "CPU_Q10UDHCPU":
                CPU_type = 117;
                break;
            case "CPU_Q13UDHCPU":
                CPU_type = 115;
                break;
            case "CPU_Q20UDHCPU":
                CPU_type = 118;
                break;
            case "CPU_Q26UDHCPU":
                CPU_type = 116;
                break;
            case "CPU_Q03UDECPU":
                CPU_type = 144;
                break;
            case "CPU_Q04UDEHCPU":
                CPU_type = 145;
                break;
            case "CPU_Q06UDEHCPU":
                CPU_type = 146;
                break;
            case "CPU_Q10UDEHCPU":
                CPU_type = 149;
                break;
            case "CPU_Q13UDEHCPU":
                CPU_type = 147;
                break;
            case "CPU_Q20UDEHCPU":
                CPU_type = 150;
                break;
            case "CPU_Q26UDEHCPU":
                CPU_type = 148;
                break;
            case "CPU_Q50UDEHCPU":
                CPU_type = 152;
                break;
            case "CPU_Q100UDEHCPU":
                CPU_type = 154;
                break;
            case "CPU_Q03UDVCPU":
                CPU_type = 209;
                break;
            case "CPU_Q04UDVCPU":
                CPU_type = 210;
                break;
            case "CPU_Q06UDVCPU":
                CPU_type = 211;
                break;
            case "CPU_Q13UDVCPU":
                CPU_type = 212;
                break;
            case "CPU_Q26UDVCPU":
                CPU_type = 213;
                break;
            case "CPU_Q04UDPVCPU":
                CPU_type = 71;
                break;
            case "CPU_Q06UDPVCPU":
                CPU_type = 72;
                break;
            case "CPU_Q13UDPVCPU":
                CPU_type = 73;
                break;
            case "CPU_Q26UDPVCPU":
                CPU_type = 74;
                break;
            case "CPU_Q12DC_V":
                CPU_type = 88;
                break;
            case "CPU_Q24DHC_V":
                CPU_type = 89;
                break;
            case "CPU_Q24DHC_LS":
                CPU_type = 91;
                break;
            case "CPU_Q172DCPU":
                CPU_type = 1573;
                break;
            case "CPU_Q173DCPU":
                CPU_type = 1574;
                break;
            case "CPU_Q172DSCPU":
                CPU_type = 1575;
                break;
            case "CPU_Q173DSCPU":
                CPU_type = 1576;
                break;
            case "CPU_L02SCPU":
                CPU_type = 163;
                break;
            case "CPU_L02CPU":
                CPU_type = 161;
                break;
            case "CPU_L06CPU":
                CPU_type = 165;
                break;
            case "CPU_L26CPU":
                CPU_type = 164;
                break;
            case "CPU_L26CPUBT":
                CPU_type = 162;
                break;
        }
        return CPU_type;
    }

    public static int Io_number(String IOnumber_text){
        int Io_number = 0;
        switch (IOnumber_text){
            case "Host CPU":
                Io_number = 0x03FF;
                break;
            case "CPU No.1":
                Io_number = 0x03E0;
                break;
            case "CPU No.2":
                Io_number = 0x03E1;
                break;
            case "CPU No.3":
                Io_number = 0x03E2;
                break;
            case "CPU No.4":
                Io_number = 0x03E3;
                break;
        }
        return Io_number;
    }

    public static int Unit_type(String CPU_text) {
        int Unit_type = 0;
        switch (CPU_text) {
            case "UNIT_RETHER":
                Unit_type = 4098;
                break;
            case "UNIT_FETHER":
                Unit_type = 8193;
                break;
            case "UNIT_QNETHER":
                Unit_type = 44;
                break;
            case "UNIT_LNETHER":
                Unit_type = 82;
                break;
            case "UNIT_RJ71EN71":
                Unit_type = 4097;
                break;
            case "UNIT_QJ71E71":
                Unit_type = 26;
                break;
            case  "UNIT_LJ71E71":
                Unit_type = 92;
                break;
            case "UNIT_QCCPUETHER":
                Unit_type = 2048;
                break;
            case "UNIT_RCCPUETHER":
                Unit_type = 2080;
                break;
        }
        return Unit_type;
    }
}

