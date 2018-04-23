package com.nimtego.tcal.model.sql;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.nimtego.tcal.constant.DBConstant.DB_NAME_TRENCH;

public class DBHelperTrench extends SQLiteOpenHelper {

    private final String LOG = "DBHelper/";

    public DBHelperTrench(Context context) {
        super(context, DB_NAME_TRENCH, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(LOG, "Create new data base");
        sqLiteDatabase.execSQL("create table trench ("
                + "id integer primary key autoincrement,"
                + "projectName text,"
                + "createDate text,"
                + "changeDate text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
