package com.example.macmini2.triponyu.requestTrip;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.macmini2.triponyu.IndexActivity;
import com.example.macmini2.triponyu.R;

import org.w3c.dom.Text;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class RequestTripFragment extends Fragment {
    private LinearLayout setDate;
    private TextView tv_setDate;


    public RequestTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_request_trip, container, false);
        ((IndexActivity)getActivity()).setFabInvisible();
        setDate= (LinearLayout) view.findViewById(R.id.selectDate);
        tv_setDate=(TextView)view.findViewById(R.id.tv_setDate);

        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate();
            }
        });
        return view;
    }

    public void setDate(){
        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date = ""+String.valueOf(year) +"-"+String.valueOf(monthOfYear)
                        +"-"+String.valueOf(dayOfMonth);
                tv_setDate.setText(date);

            }
        }, yy, mm, dd);
        datePicker.show();
    }

}
