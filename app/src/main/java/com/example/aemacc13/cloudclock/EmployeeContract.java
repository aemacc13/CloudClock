package com.example.aemacc13.cloudclock;

import android.provider.BaseColumns;

/**
 * Created by aemacc13 on 5/13/2017.
 */

public class EmployeeContract {

    private EmployeeContract() {}

    public static class EmployeeEntry implements BaseColumns {
        public static final String TABLE_NAME           = "employees";
        public static final String COLUMN_NAME_ID       = "employee_id";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_NAME     = "name";
        public static final String COLUMN_NAME_HOURS    = "hours";
    }
}
