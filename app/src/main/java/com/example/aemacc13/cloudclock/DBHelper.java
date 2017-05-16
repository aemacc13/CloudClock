package com.example.aemacc13.cloudclock;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aemacc13 on 5/13/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "GelbergSigns.db";
    public static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_EMPLOYEES_TABLE =
            "CREATE TABLE " +
                    EmployeeContract.EmployeeEntry.TABLE_NAME + " (" +
                    EmployeeContract.EmployeeEntry.COLUMN_NAME_ID + " varchar not null, " +
                    EmployeeContract.EmployeeEntry.COLUMN_NAME_PASSWORD + " varchar not null, " +
                    EmployeeContract.EmployeeEntry.COLUMN_NAME_NAME + " varchar not null, " +
                    "PRIMARY KEY (" + EmployeeContract.EmployeeEntry.COLUMN_NAME_ID + "))";

    private static final String SQL_CREATE_JOBS_TABLE =
            "CREATE TABLE " +
                    JobsContract.JobsEntry.TABLE_NAME + " (" +
                    JobsContract.JobsEntry.COLUMN_NAME_ID + " varchar not null, " +
                    "PRIMARY KEY (" + JobsContract.JobsEntry.COLUMN_NAME_ID + "))";

    private static final String SQL_CREATE_HOURS_TABLE =
            "CREATE TABLE " +
                    HoursContract.HoursEntry.TABLE_NAME + " (" +
                    HoursContract.HoursEntry.COLUMN_NAME_ENTRY + " int not null, " +
                    HoursContract.HoursEntry.COLUMN_NAME_ID + " varchar not null, " +
                    HoursContract.HoursEntry.COLUMN_NAME_IN + " long not null, " +
                    HoursContract.HoursEntry.COLUMN_NAME_OUT + " long not null, " +
                    "PRIMARY KEY (" + HoursContract.HoursEntry.COLUMN_NAME_ENTRY + "))";


    private static final String SQL_DROP_EMPLOYEES_TABLE =
            "DROP TABLE IF EXISTS " + EmployeeContract.EmployeeEntry.TABLE_NAME;
    private static final String SQL_DROP_JOBS_TABLE =
            "DROP TABLE IF EXISTS " + JobsContract.JobsEntry.TABLE_NAME;
    private static final String SQL_DROP_HOURS_TABLE =
            "DROP TABLE IF EXISTS " + HoursContract.HoursEntry.TABLE_NAME;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_EMPLOYEES_TABLE);
        db.execSQL(SQL_CREATE_JOBS_TABLE);
        db.execSQL(SQL_CREATE_HOURS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_HOURS_TABLE);
        db.execSQL(SQL_DROP_JOBS_TABLE);
        db.execSQL(SQL_DROP_EMPLOYEES_TABLE);
        onCreate(db);
    }
}
