package com.example.aemacc13.cloudclock;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainFragment extends Fragment {

    //Text Fields
    EditText employee_id= null;
    EditText employee_password= null;

    //Button
    Button login_button= null;

    //Toasts
    Toast missing_id= null;
    Toast invalid_id= null;
    Toast missing_password= null;
    Toast invalid_password= null;

    //DB Stuff
    DBHelper dbHelper= null;
    SQLiteDatabase db= null;
    Handler handler= null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler = new Handler();
        dbHelper = new DBHelper(getContext());
        new CreateDB().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_main, container, false);

        //Text Fields
        this.employee_id= (EditText)rootView.findViewById(R.id.employeeID);
        this.employee_password= (EditText)rootView.findViewById(R.id.employeePassword);

        //Button
        this.login_button= (Button)rootView.findViewById(R.id.login);

        //Toasts
        this.missing_id= Toast.makeText(getContext(), "Please enter user id", Toast.LENGTH_LONG);
        this.invalid_id= Toast.makeText(getContext(), "User id is invalid", Toast.LENGTH_LONG);
        this.missing_password= Toast.makeText(getContext(), "Please enter password", Toast.LENGTH_LONG);
        this.invalid_password= Toast.makeText(getContext(), "Password is invalid", Toast.LENGTH_LONG);

        //Click Listener
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Validate Inputs
                if (employee_id.getText().length() == 0){
                    employee_id.requestFocus();
                    missing_id.show();
                } else if (employee_password.getText().length() == 0) {
                    employee_password.requestFocus();
                    missing_password.show();
                }else if (employee_id.getText().toString() != getEmployee(employee_id.getText().toString())) {
                    employee_id.requestFocus();
                    invalid_id.show();
                }else if (employee_password.getText().toString() == getPassword(employee_id.getText().toString())) {
                    changeActivity();
                } else {
                    employee_password.requestFocus();
                    invalid_password.show();
                }

            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    private class CreateDB extends AsyncTask<Void, Void, SQLiteDatabase> {

        @Override
        protected SQLiteDatabase doInBackground(Void... voids) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            String [] names = {"Alec", "Dennis", "Patty", "Sean", "Ed"};
            String [] passwords = {"password1", "password2", "password3", "password4"};
            String [] jobs= {"JOB1", "JOB2", "JOB3", "JOB4", "JOB5", "JOB6", "JOB7"};

            //fill employees table
            for (int i = 0; i < names.length; i++) {
                values.put(EmployeeContract.EmployeeEntry.COLUMN_NAME_ID, names[i] + "007");
                values.put(EmployeeContract.EmployeeEntry.COLUMN_NAME_PASSWORD, passwords[i]);
                values.put(EmployeeContract.EmployeeEntry.COLUMN_NAME_NAME, names[i]);

                System.out.println(names[i]);


                // the second arg means don't insert a row when there
                // are no values
                long rowId = db.insert(EmployeeContract.EmployeeEntry.TABLE_NAME,
                        null, values);
            }

            //fill jobs table
            for (int i= 0; i < jobs.length; i++){
                values.put(JobsContract.JobsEntry.COLUMN_NAME_ID, jobs[i]);

                long rowId = db.insert(JobsContract.JobsEntry.TABLE_NAME,
                        null, values);
            }

            return db;
        }

        @Override
        protected void onPostExecute(SQLiteDatabase db) {
            super.onPostExecute(db);
            MainFragment.this.db = db;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    
                }
            });
        }
    }

    public void changeActivity() {
        Intent intent= new Intent(getActivity(), ClockActivity.class);
        getActivity().startActivity(intent);
    }

    public String getEmployee(String employee_id){
        return DBQueries.getEmployee(db, employee_id);
    }

    public String getPassword(String employee_id){
        return DBQueries.getPassword(db, employee_id);
    }
}
