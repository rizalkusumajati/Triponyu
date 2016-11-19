package com.example.macmini2.triponyu.myBooking;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.macmini2.triponyu.R;
import com.example.macmini2.triponyu.myBooking.MyBookingFragment;
import com.example.macmini2.triponyu.recyclerComponent.DividerItemDecoration;
import com.example.macmini2.triponyu.adapter.HistoriBookingAdapter;
import com.example.macmini2.triponyu.recyclerComponent.RecyclerTouchListenerRate;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryBookingFragment extends Fragment {
    final public String KEY_KOTA = "kota";
    final public String KEY_TANGGAL = "tangggal";
    private ArrayList<HashMap<String, String>> dataset;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyBookingFragment rateFragment;
    private String[] kota=new String[]{"Solo, Central Java","Solo, Central Java","Solo, Central Java","Solo, Central Java","Solo, Central Java"};
    private String[] tanggal=new String[]{"16 Sept 2016","16 Sept 2016","16 Sept 2016","16 Sept 2016","16 Sept 2016"};

    public HistoryBookingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_history_booking, container, false);
        dataset = new ArrayList<HashMap<String, String>>();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        rateFragment=new MyBookingFragment();

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        setupData();

        mAdapter=new HistoriBookingAdapter(dataset);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListenerRate(getContext(), mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                gotoRateTrip();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        // Inflate the layout for this fragment
        return view;
    }

    public void setupData(){
        int i =0;
        for (String kota_sat:kota) {
            HashMap<String, String> map = new HashMap<String, String>();

            map.put(KEY_KOTA, kota_sat);
            map.put(KEY_TANGGAL, tanggal[i]);

            i++;

            dataset.add(map);
        }


    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    private void gotoRateTrip(){
        getActivity().getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, rateFragment)
                .addToBackStack(null)
                .commit();
    }

}
