package com.example.macmini2.triponyu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.macmini2.triponyu.adapter.MyAdapter;
import com.example.macmini2.triponyu.adapter.PagerAdapter;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> myDataset=new ArrayList<>();
    private LinearLayout slide;
    private ViewPager viewPager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_recycler_view, container, false);
        Log.i("Oncreate","Oncreate");
        ((IndexActivity)getActivity()).fragmentIndex=0;
        ((IndexActivity)getActivity()).setToolbarTitle("Home");
        ((IndexActivity)getActivity()).setFabVisible();
        slide=(LinearLayout)view.findViewById(R.id.slide);
        viewPager=(ViewPager)slide.findViewById(R.id.pager);
        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager(),getActivity());

        adapter.addFrag(new Home1Fragment());
        adapter.addFrag(new Home2Fragment());
        //adapter.addFrag(new HistoriFragment());

        viewPager.setAdapter(adapter);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("OnResume","OnResume");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            PagerAdapter adapter = new PagerAdapter(getChildFragmentManager(),getActivity());

            adapter.addFrag(new Home1Fragment());
            adapter.addFrag(new Home2Fragment());
            //adapter.addFrag(new HistoriFragment());

            viewPager.setAdapter(adapter);

        }
    }
}
