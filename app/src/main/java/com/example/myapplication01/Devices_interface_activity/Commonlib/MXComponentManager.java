package com.example.myapplication01.Devices_interface_activity.Commonlib;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import jp.co.melco.mxcomponent.MELMxCommunication;
import jp.co.melco.mxcomponent.MELMxLabel;
import jp.co.melco.mxcomponent.MELMxOpenSettings;
import android.os.AsyncTask;

import java.util.concurrent.BlockingDeque;

public class MXComponentManager {
    //Interface MXComponent result Callback
    public static interface MXComponentManagerCallBack{
        public void resultMXComponent(int seqno, int result, long time, String detail);
    }

    //Load library
    static{
        try{
            System.loadLibrary("MXComponent");
        } catch (UnsatisfiedLinkError e){
            System.out.println("loadLibarary Error");
        }
    }

    public static MELMxOpenSettings mxopen = new MELMxOpenSettings();
    public static MELMxCommunication mxcomm = new MELMxCommunication();
    private String password = "";
    //MX Component result Callback Delegate Pointer
    private MXComponentManagerCallBack callBack = null;
    //Command Execute Status Flag
    public Boolean commandexecute = false;
    String detailstring;
    public void setCallBack(MXComponentManagerCallBack callBackclass){
        callBack = callBackclass;
    }

    /**
     *
     * Name        : Class Constructor
     * Description : Initialize Class Member variable and Status
     *
     */
    public void execOpen(int seqno) {
        Observable.just(mxcomm)
                .map(new Function<>() {
                }
    }
}
