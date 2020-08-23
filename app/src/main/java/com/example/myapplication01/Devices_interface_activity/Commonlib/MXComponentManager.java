//package com.example.myapplication01.Devices_interface_activity.Commonlib;
//
//import android.gesture.OrientedBoundingBox;
//import android.os.Build;
//
//import androidx.annotation.RequiresApi;
//
//import com.google.android.material.slider.Slider;
//
//import java.util.concurrent.Callable;
//
//import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
//import io.reactivex.rxjava3.annotations.NonNull;
//import io.reactivex.rxjava3.core.Observable;
//import io.reactivex.rxjava3.core.ObservableEmitter;
//import io.reactivex.rxjava3.core.ObservableOnSubscribe;
//import io.reactivex.rxjava3.core.Observer;
//import io.reactivex.rxjava3.functions.Function;
//import io.reactivex.rxjava3.schedulers.Schedulers;
//import jp.co.melco.mxcomponent.MELMxCommunication;
//import jp.co.melco.mxcomponent.MELMxOpenSettings;
//
//public class MXComponentManager {
//    //Interface MXComponent result Callback
//    public static interface MXComponentManagerCallBack{
//        public void resultMXComponent(int seqno, int result, long time, String detail);
//    }
//
//    //Load library
//    static{
//        try{
//            System.loadLibrary("MXComponent");
//        } catch (UnsatisfiedLinkError e){
//            System.out.println("loadLibarary Error");
//        }
//    }
//
//    public static MELMxOpenSettings mxopen = new MELMxOpenSettings();
//    public static MELMxCommunication mxcomm = new MELMxCommunication();
//    //MX Component result Callback Delegate Pointer
//    private MXComponentManagerCallBack callBack = null;
//    //Command Execute Status Flag
//    public Boolean commandexecute = false;
//    String detailstring;
//    public void setCallBack(MXComponentManagerCallBack callBackclass){
//        callBack = callBackclass;
//    }
//    private Integer result = mxcomm.open(mxopen,password);
//
////    region---------------------------clarification
//    private static String password;
//    /**
//     *
//     * Name        : Class Constructor
//     * Description : Initialize Class Member variable and Status
//     *
//     * @return
//     */
//    public int result (MELMxCommunication mxcomm, MELMxOpenSettings mxopen, String password){return mxcomm.open(mxopen,password);}
//
//    /**
//     *
//     * Name        : Close MELSEC CONNECTION
//     * Description : Execute MX Component "Close" Function
//     *
//     */
//    public int result (MELMxCommunication mxcomm){return mxcomm.close();}
//
//
//    /**
//     *
//     * Name        : Read Device Block from MELSEC
//     * Description : Execute MX Component "Read Device Block" Function
//     * @param seqno: Execute sequence number (result callback with this number)
//     *
//     */
////    public
//
////endregion
//
////    region----------------------------------------------------DRAFT
//
////    public Integer result(MELMxCommunication mxcom,MELMxOpenSettings mxopen,String password) {
////        Integer result = mxcom.open(mxopen,password);
////        return result;
////        }
//
////    public int result (MELMxCommunication mxcomm, MELMxOpenSettings mxopen, String password){return mxcomm.open(mxopen,password);}
////    public static Integer result = mxcomm.open(mxopen,password);
////    private void connectObserver(){
////        Observable.just(result)
////                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
////        .subscribe({
////
////        });};
////endregion
//}
