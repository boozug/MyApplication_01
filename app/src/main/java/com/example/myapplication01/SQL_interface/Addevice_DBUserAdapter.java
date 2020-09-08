package com.example.myapplication01.SQL_interface;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.myapplication01.Adddevice_activity.Addevice_UDT_activity;
import com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.Model.Read_device_type;
import com.example.myapplication01.Devices_interface_activity.fragments.Notifydevices.Model.Notify_devices;
import com.example.myapplication01.Plclist_activity.Replace_device_temp_UDT_activity_devices;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Addevice_DBUserAdapter
{
    public static final String KEY_ROWID = "_id";
    public static final String KEY_USERNAME= "username";
    public static final String KEY_PASSWORD = "password";
    private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME = "usersdb";
    private static final String DATABASE_TABLE = "users";
    private static final int DATABASE_VERSION = 1;

//    private static final String INSERT_TABLE = ""

    private static final String DATABASE_CREATE_USERS =
            "create table users (_id integer primary key autoincrement, "
                    + "username text not null unique, "
                    + "password text not null);";

    private static final String DATABASE_CREATE_DEVICE_LIST =
            "create table device_table (_id integer primary key autoincrement, "
                    + "ionumber text not null,"
                    + "cputype text not null,"
                    + "unittype text not null,"
                    + "ipaddress text not null unique, "
                    +"port_number text not null,"
                    +"destinnation_portnumber text not null,"
                    +"time_out text not null,"
                    +"destination_timeout not null);";

    private static final String DATABASE_CREATE_DEVICE_ATTRIBUTE =
            "create table device_notify_setting (_id integer primary key,"
                    + "device_address text not null,"
                    + "min_value_limit text not null,"
                    + "max_value_limit text not null,"
                    + "notify_count text not null,"
                    + "notify_min_limit text not null,"
                    + "notify_max_limit text not null,"
                    + "min_value_checked text not null,"
                    + "max_value_checked text not null,"
                    + "run_as_service text not null);";
    private static SQLiteDatabase db;
    private static SQLiteOpenHelper DBHelper;
    private Context context = null;


    public Addevice_DBUserAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(DATABASE_CREATE_USERS);
            db.execSQL(DATABASE_CREATE_DEVICE_LIST);
            db.execSQL(DATABASE_CREATE_DEVICE_ATTRIBUTE);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS users");
            onCreate(db);
        }
    }

    public static void open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
    }


    public static void close()
    {
        DBHelper.close();
    }

    public long AddUser(String username, String password)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_USERNAME, username);
        initialValues.put(KEY_PASSWORD, password);
        return db.insert(DATABASE_TABLE, null, initialValues);

    }

    public void AddDevice(int profile_counts, List<String> Device_array) {
        String profile_countpl = String.valueOf (profile_counts + 1);
        String exec_str = "INSERT INTO device_table VALUES('" + profile_countpl + "',";
        for (int i = 0; i < Device_array.size(); i++) {
            if (i < Device_array.size() - 1) {
                exec_str = exec_str + "'" + Device_array.get(i) + "',";
            } else {
                exec_str = exec_str + "'" + Device_array.get(i) + "');";
                db.execSQL(exec_str);
            }
        }
    }

    //    region ------------------------update into SQLite database after swipe right
    public static void delete_selected_rows(int position,Context context){
        String delete_query = "DELETE FROM device_table WHERE _id >= "+ String.valueOf(position+1) +";";
        SQLiteDatabase db = DBHelper.getWritableDatabase();
        try{
            db.execSQL(delete_query);
            Toast.makeText(context,"delete finished", Toast.LENGTH_LONG).show();
        }
        catch (SQLiteException e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        DBHelper.close();
    }
    //    endregion

    //    region update_database_moveup
    public static void update_database_moveup(ArrayList<Replace_device_temp_UDT_activity_devices>  arrayList, Context context){
        for (Replace_device_temp_UDT_activity_devices a: arrayList){
            String id, ionumber, cputype, unittype, ipaddress, portnumber, destinationportnumber, timeout, destinationtimeout;
            id = a.getId();
            int i=Integer.parseInt(id);
            String idsub = String.valueOf(i-1);
            ionumber = a.getIonumber();
            cputype = a.getCputype();

            unittype = a.getUnittype();
            ipaddress = a.getIpaddress();

            portnumber = a.getPortnumber();
            destinationportnumber = a.getDestinationportnumber();

            timeout = a.getTimeout();
            destinationtimeout = a.getDestinationtimeout();
            String insert_query = "INSERT INTO device_table VALUES ('"
                   +idsub + "','" +ionumber+ "','" +cputype+ "','" +unittype+ "','" + ipaddress+ "','" +portnumber+ "','" +destinationportnumber+ "','"+timeout+"','" +destinationtimeout+ "');" ;
            SQLiteDatabase db = DBHelper.getWritableDatabase();
            try{
                db.execSQL(insert_query);
                Toast.makeText(context,"update finished", Toast.LENGTH_LONG).show();
            }
            catch (SQLiteException e)
            {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
            }
            DBHelper.close();
        }
    }
    //    endregion

    //region remove device list
    public static ArrayList<Replace_device_temp_UDT_activity_devices>remove_device_left(int position){
        ArrayList<Replace_device_temp_UDT_activity_devices>  arrayList = new ArrayList<>();
        // select all query left
        String select_query = "SELECT * FROM device_table WHERE _id > "+ (position+1) +" ;";
        SQLiteDatabase db = DBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query,null);
        Replace_device_temp_UDT_activity_devices device_replaced = new Replace_device_temp_UDT_activity_devices();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()){
            do{
                device_replaced.setId(cursor.getString(0));
                device_replaced.setIonumber(cursor.getString(1));
                device_replaced.setCputype(cursor.getString(2));
                device_replaced.setUnittype(cursor.getString(3));
                device_replaced.setIpaddress(cursor.getString(4));
                device_replaced.setPortnumber(cursor.getString(5));
                device_replaced.setDestinationportnumber(cursor.getString(6));
                device_replaced.setTimeout(cursor.getString(7));
                device_replaced.setDestinationtimeout(cursor.getString(8));
                arrayList.add(device_replaced);
            }while (cursor.moveToNext());
        }
        DBHelper.close();
        return arrayList;
    }
    //endregion

    //    region-------------------------get all devices
        public static ArrayList<Addevice_UDT_activity> get_all_devices(){
        ArrayList<Addevice_UDT_activity> arrayList = new ArrayList<>();

        // select all query
         String select_query = "SELECT *FROM device_table";
         SQLiteDatabase db = DBHelper.getWritableDatabase();
         Cursor cursor = db.rawQuery(select_query,null);
         //looping through all rows and adding to list
         if(cursor.moveToFirst()){
             do {
                 Addevice_UDT_activity Devices = new Addevice_UDT_activity();
                 Devices.setId(cursor.getString(0));
                 Devices.setIo_number(cursor.getString(1));
                 Devices.setCpu_type(cursor.getString(2));
                 Devices.setIp_address(cursor.getString(4));
                 arrayList.add(Devices);
             }while (cursor.moveToNext());
         }
         DBHelper.close();
         return arrayList;
     }
//     endregion

    //Query information from selected position: table: device_table
    public static List<String> read_information_from_position_in_database(int pos){
        List<String> read_device_type = new ArrayList<>();
        int pos_plus = pos + 1;
        String select_query = "SELECT *FROM device_table WHERE _id = "+ pos_plus +" ;";
        SQLiteDatabase db = DBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query,null);
        cursor.moveToFirst();
        for (int i = 0; i<=8; i++)
        {read_device_type.add(cursor.getString(i));}
        return read_device_type;
    }

    //     region ---------------------read data cursor
    @NonNull
    public static List<String> read_data_cursor_to_list(FragmentActivity activity, int position){
        List<String> Pac_attribute = new ArrayList<>();
        String select_query = "SELECT * FROM device_table WHERE _id = "+ (position+1) +" ;";
        try{
        SQLiteDatabase db = DBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query,null);
        cursor.moveToFirst();
//        String str1 = cursor.getString(0);
            for (int i=0; i<=8; i++){
                Pac_attribute.add(cursor.getString(i));
            }
        return Pac_attribute;
        }
        catch (SQLiteException e){
//            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
            Log.e("TAG",e.getMessage());
        }
        DBHelper.close();
        return Pac_attribute;
    }
    //     endregion
    //region--------------------login form
    public boolean Login(String username, String password) throws SQLException
    {
        Cursor mCursor = db.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE username=? AND password=?", new String[]{username,password});
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }

    public int getProfilesCount(){
        SQLiteDatabase readableDatabase = db;
        return (int) DatabaseUtils.queryNumEntries(readableDatabase, "device_table");
    }
    //    endregion

    //region device notify declaration
    public void write_device_setting(Read_device_type read_device_type){
        String s1,s2,s3,s4,s5,s6,s7,s8,s9;
        s1 = read_device_type.getAddress();
        s2 = String.valueOf(read_device_type.getMin_value_limit());
        s3 = String.valueOf(read_device_type.getMax_value_limit());
        s4 = String.valueOf(read_device_type.getNotify_count());
        s5 = read_device_type.getNoti_min_limit();
        s6 = read_device_type.getNoti_max_limit();
        s7 = String.valueOf(read_device_type.isMin_value_checked());
        s8 = String.valueOf(read_device_type.isMax_value_checked());
        s9 = String.valueOf(read_device_type.isRun_as_service());
        String insert_query = "INSERT INTO device_notify_setting VALUES ('"
                +s1 + "','" +s2+ "','" +s3+ "','" +s4+ "','" +s5+ "','" +s6+ "','" +s7+ "','"+s8+"','" +s9+ "');" ;
        SQLiteDatabase db = DBHelper.getWritableDatabase();
        try{
            db.execSQL(insert_query);
            Toast.makeText(context,"update finished", Toast.LENGTH_LONG).show();
        }
        catch (SQLiteException e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        DBHelper.close();
    }

    public static void update_device_setting(Notify_devices notify_devices,Context context{
        String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
        s1 = String.valueOf(notify_devices.getId());
        s2 = notify_devices.getAddress();
        s3 = String.valueOf(notify_devices.getMin_value_limit());
        s4 = String.valueOf(notify_devices.getMax_value_limit());
        s5 = String.valueOf(notify_devices.getNotify_count());
        s6 = notify_devices.getNoti_min_limit();
        s7 = notify_devices.getNoti_max_limit();
        s8 = String.valueOf(notify_devices.isMin_value_checked());
        s9 = String.valueOf(notify_devices.isMax_value_checked());
        s10 = String.valueOf(notify_devices.isRun_as_service());
        String update_query = "UPDATE device_notify_setting" +
                "SET device_address ="+s2+","+
                "min_value_limit ="+s3+","+
                "max_value_limit ="+s4+","+
                "notify_count ="+s5+","+
                "notify_min_limit"+s6+","+
                "notify_max_limit"+s7+","+
                "min_value_checked"+s8+","+
                "max_value_checked"+s9+","+
                "run_as_service"+s10+","+
                "  + WHERE employeeid ="+s1+";";
        SQLiteDatabase db = DBHelper.getWritableDatabase();
        try{
            db.execSQL(update_query);
            Toast.makeText(context,"update finished", Toast.LENGTH_LONG).show();
        }
        catch (SQLiteException e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        DBHelper.close();
    }

    public static Notify_devices get_Notification_device(int pos){
        List<String> notify_device_query_from_database = new ArrayList<>();
        String select_query = "SELECT *FROM device_table WHERE (_id ="+pos+");";
        SQLiteDatabase db = DBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query,null);
        //looping through all rows and adding to list
        cursor.moveToFirst();
        Notify_devices notify_devices = new Notify_devices();
        notify_devices.setAddress(cursor.getString(1));
        notify_devices.setMin_value_limit(Integer.valueOf(cursor.getString(2)));
        notify_devices.setMax_value_limit(Integer.valueOf(cursor.getString(3)));
        notify_devices.setNoti_min_limit(cursor.getString(5));
        notify_devices.setNoti_max_limit(cursor.getString(6));
        notify_devices.setMin_value_checked(get_boolean(cursor.getString(7)));
        notify_devices.setMax_value_checked(get_boolean(cursor.getString(8)));
        notify_devices.setRun_as_service(get_boolean(cursor.getString(9)));
        DBHelper.close();
        return notify_devices;
    }

    private boolean get_boolean(@NotNull String i) {
        boolean b;
        b = false;
        switch (i){
            case "true" :
                b = true;
                break;
            case "false" :
                b = false;
        }
        return b;
    }
    //endregion

}
