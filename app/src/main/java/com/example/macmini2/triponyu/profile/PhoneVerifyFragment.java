package com.example.macmini2.triponyu.profile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.macmini2.triponyu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneVerifyFragment extends Fragment {


    public PhoneVerifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phone_verify, container, false);
    }

}
