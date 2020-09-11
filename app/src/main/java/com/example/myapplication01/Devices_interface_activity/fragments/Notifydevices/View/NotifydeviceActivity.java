package com.example.myapplication01.Devices_interface_activity.fragments.Notifydevices.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.Model.Read_device_type;
import com.example.myapplication01.SQL_interface.Addevice_DBUserAdapter;
import android.content.Context;
import android.content.Intent;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication01.Devices_interface_activity.fragments.Notifydevices.Model.Notify_devices;
import com.example.myapplication01.Devices_interface_activity.ui.Interface_mainpage;
import com.example.myapplication01.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotifydeviceActivity extends AppCompatActivity {

    private static final String TAG = "Notify Activity";
    TextView device_name,device_id,device_address;
    EditText Min_value_txt,Notify_min_txt,Max_value_txt,Notify_max_txt;
    CheckBox Min_value_chx,Max_value_chx,Run_as_service;
    Button Save_btn;
    boolean update_or_add;

    public static ArrayList<List<String>> information_from_notify_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifydevice);
        Bundle mBundle = getIntent().getExtras();
        device_name = findViewById(R.id.device_type);
        device_id = findViewById(R.id.device_id);
        Save_btn = findViewById(R.id.save_notify_information);
        device_address = findViewById(R.id.device_address);
        Min_value_txt = findViewById(R.id.Notify_min_value);
        Notify_min_txt = findViewById(R.id.editTextTextMultiLine_minvalue);
        Min_value_chx = findViewById(R.id.Checkbox_minvalue);
        Max_value_txt = findViewById(R.id.Notify_max_value);
        Notify_max_txt = findViewById(R.id.editTextTextMultiLine_maxvalue);
        Max_value_chx = findViewById(R.id.Checkbox_maxvalue);
        Run_as_service = findViewById(R.id.Checkbox_run_as_service);
        if (mBundle != null) {
            device_id.setText(mBundle.getString("id"));
            device_name.setText(String.valueOf(Objects.requireNonNull(mBundle.getString("device name")).charAt(13)));
            device_address.setText(mBundle.getString("address"));
        }
        try {
        Notify_devices information_from_notify_activity_tmp = Addevice_DBUserAdapter.get_Notification_device(Integer.parseInt(device_id.toString()));
        Min_value_txt.setText(information_from_notify_activity_tmp.getMin_value_limit());
        Notify_min_txt.setText(information_from_notify_activity_tmp.getNoti_min_limit());
        Max_value_txt.setText(information_from_notify_activity_tmp.getMax_value_limit());
        Notify_max_txt.setText(information_from_notify_activity_tmp.getNoti_max_limit());
        Min_value_chx.setChecked(information_from_notify_activity_tmp.isMin_value_checked());
        Max_value_chx.setChecked(information_from_notify_activity_tmp.isMax_value_checked());
        Run_as_service.setChecked(information_from_notify_activity_tmp.isRun_as_service());
        update_or_add = true;
        }
        catch (Exception ignored){
            Log.d(TAG,"no need 2 create");
            update_or_add = false;
        }

        Save_btn.setOnClickListener(view -> { Intent_change_activity(this,device_id);
        });
    }
;
    private void Intent_change_activity(Context context, TextView device_id) {
        //Step 1: Convert cac thuoc tinh thu duoc tu activity dua vao fragment => dua cac gia tri vao mot array list static public
        String str_id,str_min_value,str_notify_min,str_max_value,str_notify_max;
        str_id = this.device_id.getText().toString();
        str_min_value = Min_value_txt.getText().toString();
        str_notify_min = Notify_min_txt.getText().toString();
        str_max_value = Max_value_txt.getText().toString();
        str_notify_max = Notify_max_txt.getText().toString();
        Notify_devices notify_devices_access = new Notify_devices();


        Integer pos = Integer.valueOf(device_id.getText().toString().substring(12));
        // Take from database.
        if (update_or_add)
        {
            // Co trong database
            Notify_devices notify_devices = Addevice_DBUserAdapter.get_Notification_device(pos+1);
            if (str_min_value.equals("")||str_notify_min.equals("")||str_max_value.equals("")||str_notify_max.equals(""))
            {
                Toast.makeText(context,"Pls check ur field",Toast.LENGTH_LONG).show();
            }
            else {
                Addevice_DBUserAdapter.update_device_setting(notify_devices, context);
            }
            Intent intent = new Intent(context, Interface_mainpage.class);
            context.startActivity(intent);
        }
        else
        {
            // Chua co trong database
            Notify_devices notify_devices = Addevice_DBUserAdapter.get_Notification_device(pos+1);
            Addevice_DBUserAdapter.add_device_setting(notify_devices, context);
            Intent intent = new Intent(context, Interface_mainpage.class);
            context.startActivity(intent);
        }
    }
}