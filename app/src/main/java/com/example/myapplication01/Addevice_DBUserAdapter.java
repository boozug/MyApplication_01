package com.example.myapplication01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
    private static SQLiteDatabase db;
    private static SQLiteOpenHelper DBHelper;
    private Context context = null;


    public Addevice_DBUserAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
//        DBHelper.onCreate(db);
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
//        ContentValues initiaValues = new ContentValues();
        String profile_countpl = String.valueOf (profile_counts + 1);
        String exec_str = "INSERT INTO device_table VALUES('" + profile_countpl + "',";
        for (int i = 0; i < Device_array.size(); i++) {
//            db.execSQL("INSERT INTO device_table VALUES "+s);
            if (i < Device_array.size() - 1) {
                exec_str = exec_str + "'" + Device_array.get(i) + "',";
            } else {
                exec_str = exec_str + "'" + Device_array.get(i) + "');";
                db.execSQL(exec_str);
            }
        }
    }

    public static void delete_rowsdatabase(int position) {

        String str_value = String.valueOf(position + 1);
        String exec_str = "DELETE FROM device_table WHERE _id = " + str_value + ";";
        db.execSQL(exec_str);
    }

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

}
