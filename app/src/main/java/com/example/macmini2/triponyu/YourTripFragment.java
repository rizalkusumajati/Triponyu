package com.example.macmini2.triponyu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.macmini2.triponyu.adapter.BookingManagementAdapter;
import com.example.macmini2.triponyu.adapter.YourTripAdapter;
import com.example.macmini2.triponyu.recyclerComponent.DividerItemDecoration;
import com.example.macmini2.triponyu.recyclerComponent.RecyclerTouchListenerYourTrip;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class YourTripFragment extends Fragment {
    final public String KEY_KOTA = "kota";
    final public String KEY_TANGGAL = "tangggal";
    final public String KEY_JUMLAH = "jumlah";
    final public String KEY_CONFIRM = "confirm";
    private ArrayList<HashMap<String, String>> dataset;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] kota=new String[]{"Cave Trip","Dinner Mie Djawa","Cave Trip","Dinner Mie Djawa","Cave Trip"};
    private String[] tanggal=new String[]{"Maks 2 person","Maks 2 person","Maks 2 person","Maks 2 person","Maks 2 person"};
    private String[] jumlah=new String[]{"Solo","Solo","Solo","Solo","Solo"};
    private CommentTripFragment commentTripFragment;


    public YourTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_your_trip, container, false);

        dataset = new ArrayList<HashMap<String, String>>();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        commentTripFragment=new CommentTripFragment();
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        setupData();

        mAdapter=new YourTripAdapter(dataset);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListenerYourTrip(getContext(), mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                gotoCommentTrip();

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
            map.put(KEY_JUMLAH, jumlah[i]);

            i++;

            dataset.add(map);
        }


    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public void gotoCommentTrip(){
        getActivity().getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, commentTripFragment)
                .addToBackStack(null)
                .commit();
    }

}
