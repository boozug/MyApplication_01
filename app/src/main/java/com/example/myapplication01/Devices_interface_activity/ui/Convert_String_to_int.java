package com.example.myapplication01.Devices_interface_activity.ui;

public class Convert_String_to_int {
    public static int CPU_type(String CPU_text) {
        int CPU_type = 0;
        switch (CPU_text) {
            case "CPU_R04CPU":
                CPU_type = 4097;
            case "CPU_R08CPU":
                CPU_type = 4098;
            case "CPU_R16CPU":
                CPU_type = 4099;
            case "CPU_R32CPU":
                CPU_type = 4100;
            case "CPU_R120CPU":
                CPU_type = 4101;
            case "CPU_R04ENCPU":
                CPU_type = 4104;
            case  "CPU_R08ENCPU":
                CPU_type = 4105;;
            case "CPU_R16ENCPU":
                CPU_type = 4106;
            case "CPU_R32ENCPU":
                CPU_type = 4107;
            case "CPU_R120ENCPU":
                CPU_type = 4108;
            case "CPU_R16MTCPU":
                CPU_type = 4113;
            case "CPU_R32MTCPU":
                CPU_type = 4114;
            case "CPU_R12CCPU_V":
                CPU_type = 4129;
            case "CPU_FX5UCPU":
                CPU_type = 528;
            case "CPU_FX5UCCPU":
                CPU_type = 528;
            case "CPU_Q00JCPU":
                CPU_type = 48;
            case "CPU_Q00UJCPU":
                CPU_type = 128;
            case "CPU_Q00CPU":
                CPU_type = 49;
            case "CPU_Q00UCPU":
                CPU_type = 129;
            case "CPU_Q01CPU":
                CPU_type = 50;
            case "CPU_Q01UCPU":
                CPU_type = 130;
            case "CPU_Q02CPU":
                CPU_type = 34;
            case "CPU_Q06CPU":
                CPU_type = 35;
            case "CPU_Q12CPU":
                CPU_type = 36;
            case "CPU_Q25CPU":
                CPU_type = 37;
            case "CPU_Q02PHCPU":
                CPU_type = 69;
            case "CPU_Q06PHCPU":
                CPU_type = 70;
            case "CPU_Q12PHCPU":
                CPU_type = 65;
            case "CPU_Q25PHCPU":
                CPU_type = 66;
            case "CPU_Q12PRHCPU":
                CPU_type = 67;
            case "CPU_Q25PRHCPU":
                CPU_type = 68;
            case "CPU_Q02UCPU":
                CPU_type = 131;
            case "CPU_Q03UDCPU":
                CPU_type = 112;
            case "CPU_Q04UDHCPU":
                CPU_type = 113;
            case "CPU_Q06UDHCPU":
                CPU_type = 114;
            case "CPU_Q10UDHCPU":
                CPU_type = 117;
            case "CPU_Q13UDHCPU":
                CPU_type = 115;
            case "CPU_Q20UDHCPU":
                CPU_type = 118;
            case "CPU_Q26UDHCPU":
                CPU_type = 116;
            case "CPU_Q03UDECPU":
                CPU_type = 144;
            case "CPU_Q04UDEHCPU":
                CPU_type = 145;
            case "CPU_Q06UDEHCPU":
                CPU_type = 146;
            case "CPU_Q10UDEHCPU":
                CPU_type = 149;
            case "CPU_Q13UDEHCPU":
                CPU_type = 147;
            case "CPU_Q20UDEHCPU":
                CPU_type = 150;
            case "CPU_Q26UDEHCPU":
                CPU_type = 148;
            case "CPU_Q50UDEHCPU":
                CPU_type = 152;
            case "CPU_Q100UDEHCPU":
                CPU_type = 154;
            case "CPU_Q03UDVCPU":
                CPU_type = 209;
            case "CPU_Q04UDVCPU":
                CPU_type = 210;
            case "CPU_Q06UDVCPU":
                CPU_type = 211;
            case "CPU_Q13UDVCPU":
                CPU_type = 212;
            case "CPU_Q26UDVCPU":
                CPU_type = 213;
            case "CPU_Q04UDPVCPU":
                CPU_type = 71;
            case "CPU_Q06UDPVCPU":
                CPU_type = 72;
            case "CPU_Q13UDPVCPU":
                CPU_type = 73;
            case "CPU_Q26UDPVCPU":
                CPU_type = 74;
            case "CPU_Q12DC_V":
                CPU_type = 88;
            case "CPU_Q24DHC_V":
                CPU_type = 89;
            case "CPU_Q24DHC_LS":
                CPU_type = 91;
            case "CPU_Q172DCPU":
                CPU_type = 1573;
            case "CPU_Q173DCPU":
                CPU_type = 1574;
            case "CPU_Q172DSCPU":
                CPU_type = 1575;
            case "CPU_Q173DSCPU":
                CPU_type = 1576;
            case "CPU_L02SCPU":
                CPU_type = 163;
            case "CPU_L02CPU":
                CPU_type = 161;
            case "CPU_L06CPU":
                CPU_type = 165;
            case "CPU_L26CPU":
                CPU_type = 164;
            case "CPU_L26CPUBT":
                CPU_type = 162;
        }
        return CPU_type;
    }

    public static int Io_number(String IOnumber_text){
        int Io_number = 0;
        switch (IOnumber_text){
            case "Host CPU":
                Io_number = 0x03FF;
            case "CPU No.1":
                Io_number = 0x03E0;
            case "CPU No.2":
                Io_number = 0x03E1;
            case "CPU No.3":
                Io_number = 0x03E2;
            case "CPU No.4":
                Io_number = 0x03E3;
        }
        return Io_number;
    }

    public static int Unit_type(String CPU_text) {
        int Unit_type = 0;
        switch (CPU_text) {
            case "UNIT_RETHER":
                Unit_type = 4098;
            case "UNIT_FETHER":
                Unit_type = 8193;
            case "UNIT_QNETHER ":
                Unit_type = 44;
            case "UNIT_LNETHER":
                Unit_type = 82;
            case "UNIT_RJ71EN71":
                Unit_type = 4097;
            case "UNIT_QJ71E71":
                Unit_type = 26;
            case  "UNIT_LJ71E71":
                Unit_type = 92;
            case "UNIT_QCCPUETHER":
                Unit_type = 2048;
            case "UNIT_RCCPUETHER":
                Unit_type = 2080;
        }
        return Unit_type;
    }
}

