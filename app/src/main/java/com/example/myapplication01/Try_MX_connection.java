package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import jp.co.melco.mxcomponent.MELMxCommunication;
import jp.co.melco.mxcomponent.MELMxLabel;
import jp.co.melco.mxcomponent.MELMxOpenSettings;

@SuppressWarnings("SpellCheckingInspection")
public class Try_MX_connection extends AppCompatActivity {
    //[MX Component Communication Class]
    private MELMxCommunication mxcomm;
    //[MX Component OpenSetting Class]
    private MELMxOpenSettings mxopen;
    //[MX Component "Open"API Password argumet]
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //[NOTE:Change below Value for User's Environment]
        //[Set MELSEC HostAddress (Hostname or IPv4String)]
        mxcomm = new MELMxCommunication();
        mxopen = new MELMxOpenSettings();
        mxopen.hostAddress = "192.168.3.39";
        //[Set MELSEC Port]
        mxopen.destinationPortNumber = 5024;
        //[Set MELSEC UnitTypeNumber (see User's Manual)]
//        mxopen.unitType = 0x001A; //[ex. Unit QJ71E71]
        mxopen.unitType = 0x002C; //[ex. Unit QCpu built-in]
        //[Set MELSEC CPUTypeNumber (see User's Manual)]
//        mxopen.cpuType = 0x0096;  //[ex. Q20UDEHCPU]
        mxopen.cpuType = 0x0091; //[Q04UDEHCPU]
        //[Set MELSEC RemotePassword (if needed)]
        password = "";
        //[Set MELSEC I/ONumber (see User's Manual)]
//        mxopen.ioNumber = 0x03E0; // Multiple CPU No1
        mxopen.ioNumber = 0x03FF;
        setContentView(R.layout.activity_try__m_x_connection);
//        Check connection
        Button connect = findViewById(R.id.btn_connect);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Set parameters
//                setOpenSetting();
                mxcomm.open(mxopen, password);
                int result = execOpen();
//           Toast.makeText()
                Toast.makeText(Try_MX_connection.this, result, Toast.LENGTH_LONG).show();
//                Read data

            }
        });
    }

//    private void setOpenSetting() {
//        //[NOTE:Change below Value for User's Environment]
//        //[Set MELSEC HostAddress (Hostname or IPv4String)]
//        mxopen.hostAddress = "192.168.3.39";
//        //[Set MELSEC Port]
//        mxopen.destinationPortNumber = 5024;
//        //[Set MELSEC UnitTypeNumber (see User's Manual)]
////        mxopen.unitType = 0x001A; //[ex. Unit QJ71E71]
//        mxopen.unitType = 0x002C; //[ex. Unit QCpu built-in]
//        //[Set MELSEC CPUTypeNumber (see User's Manual)]
////        mxopen.cpuType = 0x0096;  //[ex. Q20UDEHCPU]
//        mxopen.cpuType = 0x0091; //[Q04UDEHCPU]
//        //[Set MELSEC RemotePassword (if needed)]
//        password = "";
//        //[Set MELSEC I/ONumber (see User's Manual)]
////        mxopen.ioNumber = 0x03E0; // Multiple CPU No1
//        mxopen.ioNumber = 0x03FF;
//    }

    public int execOpen() {
        //[call "Open" API]
        int value = mxcomm.open(mxopen, password);
        return value;
    }
}
