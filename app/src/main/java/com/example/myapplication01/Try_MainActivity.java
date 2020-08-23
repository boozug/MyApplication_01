//package com.example.myapplication01;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.TextView;
//
//import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
//import io.reactivex.rxjava3.annotations.NonNull;
//import io.reactivex.rxjava3.core.Observable;
//import io.reactivex.rxjava3.core.Observer;
//import io.reactivex.rxjava3.disposables.Disposable;
//import io.reactivex.rxjava3.functions.Predicate;
//import io.reactivex.rxjava3.schedulers.Schedulers;
//
//
//public class Try_MainActivity extends AppCompatActivity {
//
//    //ui
//    private TextView text;
//
//    //vars
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_try__main);
//        text = findViewById(R.id.text);
//
////        created Observable from a list of task try_Task
////        Specify when the work will be done
////        where the work to be observer from
////        subscribe of Observer do on the background thread
//        Observable<Try_Task> taskObservable = Observable
//                .fromIterable(Try_DataSource.createTaskList())
//                .subscribeOn(Schedulers.io())
//                .filter(new Predicate<Try_Task>() {
//                    @Override
//                    public boolean test(Try_Task try_task) throws Throwable {
//                        Log.d("this fragment", "test"+ Thread.currentThread().getName());
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        return try_task.getIsComplete();
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread());
//
//        taskObservable.subscribe(new Observer<Try_Task>() {
//            private static final String TAG = "this fragment";
//
//            // onSubcribe will be call as soon as Observable Subscriber subscribe to
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                Log.d(TAG,"onSubscribe: called");
//            }
//
//            // onNext method will be call when Observer interact with Observable
//            @Override
//            public void onNext(@NonNull Try_Task try_task) {
//                // u can see the name of the task that the method call
//                Log.d(TAG, "onNext: " + Thread.currentThread().getName());
//                // interact with all the task from the datasource (Try_datasource)
//                Log.d(TAG, "onNext: " + try_task.getDescription());
//
//            }
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.e(TAG,"onError: ", e);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG,"onComplete: called");
//            }
//        });
//    }
//}