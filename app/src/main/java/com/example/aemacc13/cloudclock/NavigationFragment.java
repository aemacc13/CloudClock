package com.example.aemacc13.cloudclock;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NavigationFragment extends Fragment {

    //Menu Bar
    Button check_hours= null;
    Button clock_hours= null;
    Button sign_out= null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_navigation, container, false);

        this.check_hours= (Button)rootView.findViewById(R.id.checkHours);
        this.clock_hours= (Button)rootView.findViewById(R.id.clockHours);
        this.sign_out= (Button)rootView.findViewById(R.id.signOut);

        check_hours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), HoursActivity.class);
                getActivity().startActivity(intent);
            }
        });

        clock_hours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), ClockActivity.class);
                getActivity().startActivity(intent);
            }
        });

        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
}
