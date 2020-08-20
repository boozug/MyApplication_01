package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class Try_MainActivity extends AppCompatActivity {

    //ui
    private TextView text;

    //vars
    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try__main);
        text = findViewById(R.id.text);

//        created Observable from a list of task try_Task
//        Specify when the work will be done
//        where the work to be observer from
//        subscribe of Observer do on the background thread
//        Schedulers.io : Background thread

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}