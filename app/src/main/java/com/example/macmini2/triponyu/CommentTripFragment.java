package com.example.macmini2.triponyu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.macmini2.triponyu.adapter.ActiveBookingAdapter;
import com.example.macmini2.triponyu.adapter.CommentTripAdapter;
import com.example.macmini2.triponyu.recyclerComponent.DividerItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommentTripFragment extends Fragment {
    final public String KEY_KOTA = "kota";
    final public String KEY_TANGGAL = "tangggal";
    private ArrayList<HashMap<String, String>> dataset;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private LihatBookingFragment lihatBookingFragment;
    private String[] kota=new String[]{"Solo, Central Java","Solo, Central Java","Solo, Central Java","Solo, Central Java","Solo, Central Java"};
    private String[] tanggal=new String[]{"16 Sept 2016","16 Sept 2016","16 Sept 2016","16 Sept 2016","16 Sept 2016"};

    public CommentTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment_trip, container, false);
        dataset = new ArrayList<HashMap<String, String>>();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        lihatBookingFragment=new LihatBookingFragment();
        ((IndexActivity)getActivity()).fragmentIndex=1;
        ((IndexActivity)getActivity()).setToolbarTitle("Comment Trip");
        ((IndexActivity)getActivity()).setFabInvisible();
        ((IndexActivity) getActivity()).backShow();
        ((IndexActivity) getActivity()).backBookingManag();
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        setupData();

        mAdapter=new CommentTripAdapter(dataset);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);

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

}
