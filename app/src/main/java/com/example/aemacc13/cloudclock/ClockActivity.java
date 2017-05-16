package com.example.aemacc13.cloudclock;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClockActivity extends AppCompatActivity {

    Button clock_in= null;
    Button clock_out= null;

    //DB Stuff
    DBHelper dbHelper= null;
    SQLiteDatabase db= null;
    Handler handler= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        this.clock_in= (Button)findViewById(R.id.clockIn);
        this.clock_out= (Button)findViewById(R.id.clockOut);

        clock_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clockIn();
            }
        });

        clock_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clockOut();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        handler = new Handler();
        dbHelper = new DBHelper(this);
        db= dbHelper.getWritableDatabase();
    }

    void clockIn(){
        DBQueries.clockIn(db);
    }

    void clockOut(){
        DBQueries.clockOut(db);
    }
}
