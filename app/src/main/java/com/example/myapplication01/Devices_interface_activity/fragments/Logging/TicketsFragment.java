package com.example.myapplication01.Devices_interface_activity.fragments.Logging;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.myapplication01.Adddevice_activity.Addevice_DBUserAdapter;
import com.example.myapplication01.Login_activity.Login_Mainactivity;
import com.example.myapplication01.Plclist_activity.Devicelist_Activity_main;
import com.example.myapplication01.Plclist_activity.Replace_device_temp_UDT_activity_devices;
import com.example.myapplication01.R;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import static com.example.myapplication01.Adddevice_activity.Addevice_DBUserAdapter.read_data_cursor_to_list;
import static com.example.myapplication01.Plclist_activity.Devicelist_Activity_main.Count_save;


public class TicketsFragment extends Fragment {


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View v = inflater.inflate(R.layout.fragment_tickets, container, false);
        Button bt = v.findViewById(R.id.button);
        TextView text = v.findViewById(R.id.textView2);
        int pos = Count_save;
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Detect_type_of_value(pos);
            }

            private void Detect_type_of_value(int pos) {
                List<String> read_data_cursor_to_list = read_data_cursor_to_list(getActivity(),pos);
                String str1 = read_data_cursor_to_list.get(0);
//                Toast.makeText(getActivity(),"hello"+String.valueOf(pos+1),Toast.LENGTH_SHORT).show();
            }
        });
//         Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_tickets, container, false);
        return v;
    }
}
