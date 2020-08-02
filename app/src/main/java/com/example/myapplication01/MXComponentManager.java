package com.example.myapplication01;

import java.util.Random;

import jp.co.melco.mxcomponent.MELMxCommunication;
import jp.co.melco.mxcomponent.MELMxLabel;
import jp.co.melco.mxcomponent.MELMxOpenSettings;
import android.os.AsyncTask;
import android.os.Process;

import androidx.loader.content.AsyncTaskLoader;

public class MXComponentManager {

    private MELMxCommunication mxcom;
    private MELMxOpenSettings mxopen;
    private String password = "";
    public Boolean commandexecute=false;

    /**
     *
     * Name        : Open Setting Initalize
     * Description : Initialize MELMxOpenSetting Class Members
     *
     */
    private void setOpenSetting(String txtHostaddress, int IntPort, int Intunittype, int Intcputype, String txtPassword, int IntStartIOnumber){

        //[NOTE:Change below Value for User's Environment]

        //[Set MELSEC HostAddress (Hostname or IPv4String)]
        mxopen.hostAddress=txtHostaddress;
        //[Set MELSEC Port]
        mxopen.destinationPortNumber=IntPort;
        //[Set MELSEC UnitTypeNumber (see User's Manual)]
        mxopen.unitType=Intunittype; //[ex. Unit QJ71E71]
        //[Set MELSEC CPUTypeNumber (see User's Manual)]
        mxopen.cpuType=Intcputype;  //[ex. Q20UDEHCPU]
        //[Set MELSEC RemotePassword (if needed)]
        password=txtPassword;
        //[Set MELSEC I/ONumber (see User's Manual)]
        mxopen.ioNumber=IntStartIOnumber;
    }

    /**
     *
     * Name        : Open MELSEC CONNECTION
     * Description : Execute MX Component "Open" Function
     * @param seqno: Execute sequence number (result callback with this number)
     *
     */
    public void execOpen(int seqno){
//        //check command execute state
//        if(commandexecute) return;
//
//        //set command execute state
//        commandexecute = true;
//        final int seq=seqno;
        //Move the thread into background
        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
    }

}
