package com.nimtego.tcal.model.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.nimtego.tcal.model.Project;

import static com.nimtego.tcal.constant.DBConstant.DB_NAME_TRENCH;

public class DBHelperTrench extends SQLiteOpenHelper {

    private final String LOG = DBHelperTrench.class.getName();
    private static final String DATA_BASE_NAME = "trench.db";
    private static final String DATA_BASE_VERSION = "1";
    private static final String DATABASE_TABLE = "project_trench";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PROJECT_NAME = "project_name";
    private static final String COLUMN_DATE_CREATE = "create_date";
    private static final String COLUMN_DATE_CHANGE = "change_date";

    private static final String DATABASE_CREATE = "create table " + DATABASE_TABLE
            + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_PROJECT_NAME + " text not null, "
            + COLUMN_DATE_CREATE + " text not null, "
            + COLUMN_DATE_CHANGE + " text not null" + ");";

    public DBHelperTrench(Context context) {
        super(context, DB_NAME_TRENCH,
                null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(LOG, "Create new data base");
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.w(LOG, "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS todos");
        onCreate(sqLiteDatabase);
    }
    public long createNewData(Project project) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = content(project);
        return sqLiteDatabase.insert(DATABASE_TABLE, null, contentValues);
    }

    public boolean updateProject(long rowId, Project project) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.update(DATABASE_TABLE, content(project),
                COLUMN_ID + "=" + rowId,
                null) > 0;
    }

    private ContentValues content(Project project) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PROJECT_NAME, project.getNameProject());
        contentValues.put(COLUMN_DATE_CREATE, project.getCreateDate().toString());
        contentValues.put(COLUMN_DATE_CHANGE, project.getChangeDate().toString());
        return contentValues;
    }

    public void deleteTodo(long rowId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE, COLUMN_ID + "=" + rowId, null);
        db.close();
    }

    public Cursor getAllTodos() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query(DATABASE_TABLE, new String[] { COLUMN_ID,
                        COLUMN_PROJECT_NAME, COLUMN_DATE_CREATE, COLUMN_DATE_CHANGE }, null,
                null, null, null, null);
    }
    public Cursor getTodo(long rowId) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCursor = db.query(true, DATABASE_TABLE,
                new String[] { COLUMN_ID, COLUMN_PROJECT_NAME, COLUMN_DATE_CREATE,
                        COLUMN_DATE_CHANGE }, COLUMN_ID + "=" + rowId, null,
                null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}
