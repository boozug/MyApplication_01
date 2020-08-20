package com.example.myapplication01.Devices_interface_activity.Commonlib;

import android.os.Process;
import android.util.Log;

import jp.co.melco.mxcomponent.MELMxCommunication;
import jp.co.melco.mxcomponent.MELMxOpenSettings;

public class Connect_task implements Runnable {
    public static MELMxOpenSettings mxopen = new MELMxOpenSettings();
    public static MELMxCommunication mxcomm = new MELMxCommunication();
    public static String password= "";
    public static Integer result;
    @Override
    public void run() {
        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
        result = MXComponentManager.result(mxcomm,mxopen,password);
    }
}
