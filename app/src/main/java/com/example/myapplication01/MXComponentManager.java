package com.example.myapplication01;

import java.util.Random;

import io.reactivex.rxjava3.core.Observable;
import jp.co.melco.mxcomponent.MELMxCommunication;
import jp.co.melco.mxcomponent.MELMxLabel;
import jp.co.melco.mxcomponent.MELMxOpenSettings;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Process;

import androidx.loader.content.AsyncTaskLoader;

public class MXComponentManager {

    private MELMxCommunication mxcomm;
    private MELMxOpenSettings mxopen;

    /**
     *
     * Name        : Open
     * Description : Initialize MELMxOpenSetting Class Members
     *
     */

    private int execOpen(String txtHostaddress, int IntPort, int Intunittype, int Intcputype, String txtPassword, int IntStartIOnumber){
//        Thread thread = new Thread()
        //[Set MELSEC HostAddress (Hostname or IPv4String)]
        mxopen.hostAddress=txtHostaddress;
        //[Set MELSEC Port]
        mxopen.destinationPortNumber=IntPort;
        //[Set MELSEC UnitTypeNumber (see User's Manual)]
        mxopen.unitType=Intunittype; //[ex. Unit QJ71E71]
        //[Set MELSEC CPUTypeNumber (see User's Manual)]
        mxopen.cpuType=Intcputype;  //[ex. Q20UDEHCPU]
        //[Set MELSEC RemotePassword (if needed)]
        //[Set MELSEC I/ONumber (see User's Manual)]
        mxopen.ioNumber=IntStartIOnumber;
        return mxcomm.open(mxopen, txtPassword);
    }

    /**
     *
     * Name        : Close
     * Description : Initialize MELMxOpenSetting Class Members
     *
     */
    private int execClose(){
        return mxcomm.close();
    }

    /**
     *
     * Name        : Read Device Block to MELSEC
     * Description : Execute MX Component "Write Device Block" Function
     *
     */
    private Integer readDeviceBlock(String deviceaddress) {
        //[call "Read Device Block" API]
        int readdata[]=new int[1];
        int result = mxcomm.readDeviceBlock(deviceaddress,1,readdata);
        //[if API Success Set DetailResultString Readed data("fault" set blank)]
        return result;
    }

    /**
     *
     * Name        : Write Device Block to MELSEC
     * Description : Execute MX Component "Write Device Block" Function
     *
     */
}



