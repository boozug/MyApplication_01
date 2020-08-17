package com.example.myapplication01.Devices_interface_activity.fragments.Logging;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.myapplication01.Adddevice_activity.Addevice_DBUserAdapter;
import com.example.myapplication01.Devices_interface_activity.ui.Convert_String_to_int;
import com.example.myapplication01.Login_activity.Login_Mainactivity;
import com.example.myapplication01.Plclist_activity.Devicelist_Activity_main;
import com.example.myapplication01.Plclist_activity.Replace_device_temp_UDT_activity_devices;
import com.example.myapplication01.R;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import static androidx.core.content.ContextCompat.getSystemService;
import static com.example.myapplication01.Adddevice_activity.Addevice_DBUserAdapter.read_data_cursor_to_list;
import static com.example.myapplication01.Plclist_activity.Devicelist_Activity_main.Count_save;


public class LoggingFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View v = inflater.inflate(R.layout.fragment_tickets, container, false);
        Button bt = v.findViewById(R.id.button_convert);
        Button bt2 = v.findViewById(R.id.button_notification1);
        Button bt3 = v.findViewById(R.id.button_notification2);
//      region-------------------------------------------------create Notification Channel
        NotificationCompat.Builder noti001 = new NotificationCompat.Builder(getActivity(), "channel1")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setChannelId("channel1")
                .setContentTitle("Table alarm 001")
                .setContentText("Alarm number 001")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManagerCompat1 = NotificationManagerCompat.from(getActivity());

        NotificationCompat.Builder noti002 = new NotificationCompat.Builder(getActivity(), "channel1")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setChannelId("channel1")
                .setContentTitle("Table alarm 001")
                .setContentText("Alarm number 002")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManagerCompat2 = NotificationManagerCompat.from(getActivity());
//      endregion

        TextView text = v.findViewById(R.id.textView2);
        int pos = Count_save;
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Detect_type_of_value(pos);
            }

            private void Detect_type_of_value(int pos) {
                List<String> read_data_cursor_to_list = read_data_cursor_to_list(getActivity(), pos);
                String str0, str1, str2, str3, str4, str5, str6, str7, str8;
                str1 = String.valueOf(Convert_String_to_int.CPU_type())
                text.setText(str1);
            }
        });
        bt2.setOnClickListener(view -> notificationManagerCompat1.notify(100, noti001.build()));
        bt3.setOnClickListener(view -> notificationManagerCompat2.notify(100,noti002.build()));
        return v;
    }


//    private void createNotificationChannel() {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                CharSequence name = "studentChannel";
//                String description = "Channel for student notification";
//                int importance = NotificationManager.IMPORTANCE_DEFAULT;
//                NotificationChannel channel1 = new NotificationChannel("ChannelA", name, importance);
//                channel1.setDescription(description);
//                // Register the channel with the system; you can't change the importance
//                // or other notification behaviors after this
//                NotificationManager notificationManager = getSystemService(getActivity(), NotificationManager.class);
//                notificationManager.createNotificationChannel(channel1);
//            }
//        }
}
