package com.example.aemacc13.cloudclock;

import android.provider.BaseColumns;

/**
 * Created by aemacc13 on 5/13/2017.
 */

public class JobsContract {

    private JobsContract() {}

    public static class JobsEntry implements BaseColumns {
        public static final String TABLE_NAME     = "jobs";
        public static final String COLUMN_NAME_ID = "job_id";
    }
}
