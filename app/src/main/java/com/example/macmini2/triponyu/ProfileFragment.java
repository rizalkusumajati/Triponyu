package com.example.macmini2.triponyu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.macmini2.triponyu.customDialog.BankAccount;
import com.example.macmini2.triponyu.customDialog.IdCard;
import com.example.macmini2.triponyu.customDialog.Pin;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private LinearLayout phone,idCard,bankAccount;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ((IndexActivity)getActivity()).fragmentIndex=1;
        ((IndexActivity)getActivity()).setToolbarTitle("My Profile");
        ((IndexActivity)getActivity()).setFabInvisible();
        phone=(LinearLayout)view.findViewById(R.id.phoneNumber);
        idCard=(LinearLayout)view.findViewById(R.id.idCard);
        bankAccount=(LinearLayout)view.findViewById(R.id.bankAccount);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Pin().show(getActivity().getSupportFragmentManager(), null);
            }
        });

        idCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new IdCard().show(getActivity().getSupportFragmentManager(), null);
            }
        });

       bankAccount.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               new BankAccount().show(getActivity().getSupportFragmentManager(), null);
           }
       });

        return view;
    }

}
