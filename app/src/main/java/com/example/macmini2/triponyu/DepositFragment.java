package com.example.macmini2.triponyu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.macmini2.triponyu.adapter.BookingManagementAdapter;
import com.example.macmini2.triponyu.adapter.DepositAdapter;
import com.example.macmini2.triponyu.customDialog.Deposit;
import com.example.macmini2.triponyu.customDialog.Pin;
import com.example.macmini2.triponyu.recyclerComponent.DividerItemDecoration;
import com.example.macmini2.triponyu.recyclerComponent.RecyclerTouchListenerDeposit;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class DepositFragment extends Fragment {
    final public String KEY_KOTA = "kota";
    final public String KEY_TANGGAL = "tangggal";
    final public String KEY_JUMLAH = "jumlah";
    final public String KEY_CONFIRM = "confirm";
    private ArrayList<HashMap<String, String>> dataset;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] kota=new String[]{"Solo, Central Java","Solo, Central Java","Solo, Central Java","Solo, Central Java","Solo, Central Java"};
    private String[] tanggal=new String[]{"16 Sept 2016","16 Sept 2016","16 Sept 2016","16 Sept 2016","16 Sept 2016"};
    private String[] jumlah=new String[]{"Rp 1.000.000","Rp 1.000.000","Rp 1.000.000","Rp 1.000.000","Rp 1.000.000"};
    private String[] konfirm=new String[]{"confirm","need","confirm","need","confirm"};

    public DepositFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_deposit, container, false);
        ((IndexActivity)getActivity()).fragmentIndex=1;
        ((IndexActivity)getActivity()).setToolbarTitle("Deposit");
        ((IndexActivity)getActivity()).setFabInvisible();

        dataset = new ArrayList<HashMap<String, String>>();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);


        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        setupData();

        mAdapter=new DepositAdapter(dataset,getContext());
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
            map.put(KEY_JUMLAH, jumlah[i]);
            map.put(KEY_CONFIRM,konfirm[i] );
            i++;

            dataset.add(map);
        }


    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

}
