package com.nimtego.tcal.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nimtego.tcal.model.sql.*;

public class ProjectProvider implements TrenchDataProvider {
    private final String TAG = "ProjectProvider";
    private DBHelperTrench mDBHelperTrench;
    private ContentValues mContentValues;
    private static ProjectProvider mProjectProvider;

    private ProjectProvider() {
        mProjectProvider = this;
        mContentValues = new ContentValues();
    }


    public static ProjectProvider getProjectProvider() {
        if (mProjectProvider == null) {
            mProjectProvider = new ProjectProvider();

        }
        return mProjectProvider;
    }
    @Override
    public List<Project> getList() {
        Log.d(TAG, "--- Rows in mytable: ---");
        List<Project> projectList = new ArrayList<>();
        SQLiteDatabase db = mDBHelperTrench.getWritableDatabase();
        // делаем запрос всех данных из таблицы mytable, получаем Cursor
        Cursor c = db.query("trench",
                            null,
                            null,
                           null,
                           null,
                            null,
                           null);

        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("projectName");
            int createDataColIndex = c.getColumnIndex("createData");
            int changeDataColIndex = c.getColumnIndex("changeData");

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d(TAG,
                        "ID = " + c.getInt(idColIndex) +
                                ", name = " + c.getString(nameColIndex) +
                                ", email = " + c.getString(createDataColIndex));
                SimpleDateFormat formatter = new SimpleDateFormat();
                Project project = new Project(c.getString(nameColIndex));
                try {
                    project.setCreateDate(formatter.parse(c.getString(createDataColIndex)));
                    project.setChangeDate(formatter.parse(c.getString(changeDataColIndex)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                projectList.add(project);
            } while (c.moveToNext());
        } else
            Log.d(TAG, "0 rows");
        c.close();
        db.close();
        return projectList;
    }

    @Override
    public boolean addProject(Project project) {
        Log.d(TAG, "--- addProject ---");
        // подготовим данные для вставки в виде пар: наименование столбца - значение
        SQLiteDatabase db = mDBHelperTrench.getWritableDatabase();
        mContentValues.put("projectName", project.getNameProject());
        mContentValues.put("createDate", project.getCreateDate().toString());
        mContentValues.put("changeDate", project.getChangeDate().toString());
        // вставляем запись и получаем ее ID
        long rowID = db.insert("trench", null, mContentValues);
        Log.d(TAG, "row inserted, ID = " + rowID);
        db.close();
        return true;
    }

    @Override
    public boolean removeById(int id) {
        return false;
    }

    @Override
    public void setContentDB(Context context) {
        mDBHelperTrench = new DBHelperTrench(context);
    }

    @Override
    public boolean removeByName(String name) {
        return false;
    }

    public boolean nameIsBusy(String name) {
        List<Project> projectList = getList();
        for (Project pj : projectList) {
            if (pj.getNameProject().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean dbHelperIsNull() {
        return mDBHelperTrench == null;
    }

    public String[] arrayNames() {
        List<Project> projectList = getList();
        String[] names = new String[projectList.size()];
        for (int i = 0; i < names.length; i++) {
            names[i] = projectList.get(i).getNameProject();
        }
        return names;
    }
}
