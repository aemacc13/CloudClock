package com.example.aemacc13.cloudclock;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by aemacc13 on 5/13/2017.
 */

public class DBQueries {

    private static String LOG_TAG = DBQueries.class.getName();

    public static String getEmployee(SQLiteDatabase db, String employee_id) {
        String [] projection = {
                EmployeeContract.EmployeeEntry._ID,
                EmployeeContract.EmployeeEntry.COLUMN_NAME_ID};

        String selection= EmployeeContract.EmployeeEntry.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs= {employee_id};

        Cursor cursor= db.query(
                EmployeeContract.EmployeeEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        return cursor.getString(cursor.getColumnIndexOrThrow(EmployeeContract.EmployeeEntry._ID));
    }

    public static String getPassword(SQLiteDatabase db, String employee_id) {
        String [] projection = {
                EmployeeContract.EmployeeEntry._ID,
                EmployeeContract.EmployeeEntry.COLUMN_NAME_PASSWORD};

        String selection= EmployeeContract.EmployeeEntry.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs= {employee_id};

        Cursor cursor= db.query(
                EmployeeContract.EmployeeEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        return cursor.getString(cursor.getColumnIndexOrThrow(EmployeeContract.EmployeeEntry._ID));
    }

    public static void clockIn(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(HoursContract.HoursEntry.COLUMN_NAME_IN, System.nanoTime());

    }

    public static void clockOut(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(HoursContract.HoursEntry.COLUMN_NAME_OUT, System.nanoTime());

    }
}
