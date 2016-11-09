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
public class Step2AddNewTripFragment extends Fragment {
    private Button step2;
    private IncludeExcludeFragment includeExcludeFragment;

    public Step2AddNewTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_step2_add_new_trip, container, false);
        step2=(Button)view.findViewById(R.id.step2);
        includeExcludeFragment=new IncludeExcludeFragment();
        ((IndexActivity)getActivity()).backShow();
        ((IndexActivity)getActivity()).backStep1();
        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoIncludeExclude();
            }
        });
        return view;
    }

    public void gotoIncludeExclude(){
        getActivity().getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, includeExcludeFragment)
                .addToBackStack(null)
                .commit();
    }

}
