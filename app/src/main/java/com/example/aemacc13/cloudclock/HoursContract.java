package com.example.aemacc13.cloudclock;

import android.provider.BaseColumns;

/**
 * Created by aemacc13 on 5/13/2017.
 */

public class HoursContract {

    private HoursContract() {}

    public static class HoursEntry implements BaseColumns {
        public static final String TABLE_NAME      = "hours";
        public static final String COLUMN_NAME_ENTRY  = "entry";
        public static final String COLUMN_NAME_ID  = "employee_id";
        public static final String COLUMN_NAME_IN  = "in_time";
        public static final String COLUMN_NAME_OUT = "out_time";
    }
}
