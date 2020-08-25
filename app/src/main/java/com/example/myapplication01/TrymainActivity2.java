package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import jp.co.melco.mxcomponent.MELMxCommunication;
import jp.co.melco.mxcomponent.MELMxOpenSettings;

public class TrymainActivity2 extends AppCompatActivity {
    MELMxCommunication mxcomm = new MELMxCommunication();
    MELMxOpenSettings mxopen = new MELMxOpenSettings();
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trymain2);
        mxopen.hostAddress="192.168.3.40";
        //[Set MELSEC Port]
        mxopen.destinationPortNumber=5012;
        //[Set MELSEC UnitTypeNumber (see User's Manual)]
        mxopen.unitType=0x002C;
        //[Set MELSEC CPUTypeNumber (see User's Manual)]
        mxopen.cpuType=0x0091;
        //[Set MELSEC RemotePassword (if needed)]
        password="";
        //[Set MELSEC I/ONumber (see User's Manual)]
        mxopen.ioNumber=0x03FF;
        int res =  mxcomm.open(mxopen, password);
        Toast.makeText(TrymainActivity2.this,String.valueOf(res),Toast.LENGTH_LONG).show();
    }
}