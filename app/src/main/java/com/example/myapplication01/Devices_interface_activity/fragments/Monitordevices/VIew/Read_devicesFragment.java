package com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.VIew;


import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication01.Devices_interface_activity.fragments.Apis.MX_Component_API;
import com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.ModalView.ModalView;
import com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.Model.Read_device_type;
import com.example.myapplication01.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

import static com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.ModalView.ModalView.read_device_types_array_list_final;

public class Read_devicesFragment extends Fragment {

    private static final String TAG = "Read_device_Fragment";
    public Button Read_value_btn;
    public Switch Monitoring_enable_switch;
    ModalView modalView;


    ReaddeviceAdapter readdeviceAdapter;
    TextView Connection_setup_time;
    TextView Connection_status;
    TextView Reading_duration;
    SearchView searchView;
    boolean res;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        RecyclerView recyclerView;
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_read_device, container, false);
    //        region----------------------------------code start here
        recyclerView = v.findViewById(R.id.recycler_view_read_device);
        Read_value_btn = v.findViewById(R.id.read_value_button);
        Monitoring_enable_switch = v.findViewById(R.id.read_continous_value);
        Connection_setup_time = v.findViewById(R.id.read_connection_setup_time_textview);
        Connection_status = v.findViewById(R.id.read_connection_status_textview);
        Reading_duration = v.findViewById(R.id.reading_duration_textview);
        searchView = v.findViewById(R.id.read_device_search);
        // use linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        Read_value_btn.setOnClickListener(view -> create_Observable_Observer_read_value(recyclerView,searchView.getQuery().toString()));
        Monitoring_enable_switch.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                Read_value_btn.setVisibility(View.GONE);
                create_Observable_Observer_monitoring_value(recyclerView,searchView.getQuery().toString());
            }
            else
            {
                Read_value_btn.setVisibility(View.VISIBLE);
            }
        });
        return v;
    }



    private void create_Observable_Observer_monitoring_value(RecyclerView recyclerView, String s) {
        @NonNull
        Observable<Integer> Result_value_monitoring_observable = Observable.fromCallable(ModalView::Read_deivce_adapter_to_Observable);
        Result_value_monitoring_observable
                .repeatWhen(objectObservable -> Observable.timer(1,TimeUnit.SECONDS).repeat())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    Disposable disposable;
                    @Override
                    public void onSubscribe(Disposable d) {
                            disposable =d;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        if (!Monitoring_enable_switch.isChecked()){
                            disposable.dispose();
                        }
                        display_status(integer,ModalView.start);
                        Data_filter(s);
                        set_adapter(recyclerView,read_device_types_array_list_final);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private void Data_filter(String s) {
        if(s!= "")
        {
            ArrayList<Read_device_type> read_device_types_tmp = new ArrayList<>();
            for (Read_device_type r:read_device_types_array_list_final){
                if (String.valueOf(r.getId()).contains(s)||(r.getAddress().contains(s)||r.getDevice_name().contains(s)))
                {
                    read_device_types_tmp.add(r);
                }
                read_device_types_array_list_final = read_device_types_tmp;
            }
        }
    }


    private void create_Observable_Observer_read_value(RecyclerView recyclerView, String s) {
        long start = System.currentTimeMillis();
        @NonNull
        Observable<Integer> Result_value_observable = Observable.fromCallable(ModalView::Read_deivce_adapter_to_Observable);
        Result_value_observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Integer integer) {
                        display_status(integer,start);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Data_filter(s);
                        set_adapter(recyclerView,read_device_types_array_list_final);
                    }
                });
    }


    private void display_status(Integer integer, long start) {

        Connection_status.setText(MX_Component_API.result_string(integer));
        long interval = System.currentTimeMillis()-start;
        Reading_duration.setText("interval time: "+String.valueOf(interval)+" ms");
        Log.d(TAG,"Running");
    }

    private void set_adapter(@NotNull RecyclerView recyclerView, ArrayList<Read_device_type> read_device_ArrayList) {
        Parcelable recyclerViewState;
        readdeviceAdapter = new ReaddeviceAdapter(read_device_ArrayList);
        recyclerViewState = recyclerView.getLayoutManager().onSaveInstanceState();
        recyclerView.setAdapter(readdeviceAdapter);
        Objects.requireNonNull(recyclerView.getLayoutManager()).onRestoreInstanceState(recyclerViewState);
    }
}
