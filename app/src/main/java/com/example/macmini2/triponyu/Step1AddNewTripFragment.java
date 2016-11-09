package com.example.macmini2.triponyu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Step1AddNewTripFragment extends Fragment {
    private Button step1;
    private Step2AddNewTripFragment step2AddNewTripFragment;

    public Step1AddNewTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_step1_add_new_trip, container, false);
        ((IndexActivity)getActivity()).fragmentIndex=1;
        ((IndexActivity)getActivity()).setToolbarTitle("Add New Trip");
        ((IndexActivity)getActivity()).setFabInvisible();


        step2AddNewTripFragment=new Step2AddNewTripFragment();
        step1=(Button)view.findViewById(R.id.step1);
        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoStep2();
            }
        });
        return view;
    }

    public void gotoStep2(){
        getActivity().getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, step2AddNewTripFragment)
                .addToBackStack(null)
                .commit();
    }

}
