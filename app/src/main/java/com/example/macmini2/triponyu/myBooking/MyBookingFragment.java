package com.example.macmini2.triponyu.myBooking;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.macmini2.triponyu.IndexActivity;
import com.example.macmini2.triponyu.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyBookingFragment extends Fragment {


    public MyBookingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_my_booking, container, false);
        ((IndexActivity)getActivity()).fragmentIndex=1;
        ((IndexActivity)getActivity()).setToolbarTitle("Rate Trip");
        ((IndexActivity)getActivity()).setFabInvisible();

        ((IndexActivity) getActivity()).backShow();
        ((IndexActivity) getActivity()).backMyBooking();

        return view;
    }

}
