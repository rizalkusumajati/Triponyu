package com.example.macmini2.triponyu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class LihatBookingFragment extends Fragment {


    public LihatBookingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_lihat_booking, container, false);
        ((IndexActivity)getActivity()).fragmentIndex=1;
        ((IndexActivity)getActivity()).setToolbarTitle("Lihat Booking");
        ((IndexActivity)getActivity()).setFabInvisible();
        ((IndexActivity) getActivity()).backShow();

        ((IndexActivity) getActivity()).backMyBooking();

        return view;
    }

}
