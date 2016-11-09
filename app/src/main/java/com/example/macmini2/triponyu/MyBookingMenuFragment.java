package com.example.macmini2.triponyu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.macmini2.triponyu.adapter.PagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyBookingMenuFragment extends Fragment {
    private ViewPager viewPager;
    private LinearLayout tabActive,tabHistory;
    private View underlineActive,underlineHistory;

    public MyBookingMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_my_booking_menu, container, false);
        ((IndexActivity)getActivity()).fragmentIndex=1;
        ((IndexActivity)getActivity()).setToolbarTitle("My Booking");
        ((IndexActivity)getActivity()).setFabInvisible();


        tabActive=(LinearLayout)view.findViewById(R.id.tabActive);
        tabHistory=(LinearLayout)view.findViewById(R.id.tabHistory);
        viewPager=(ViewPager)view.findViewById(R.id.viewPager);
        underlineActive=view.findViewById(R.id.underlineActive);
        underlineHistory=view.findViewById(R.id.underlineHistory);
        setViewPager();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        underlineActive.setVisibility(View.VISIBLE);
                        underlineHistory.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        underlineActive.setVisibility(View.INVISIBLE);
                        underlineHistory.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupTab();

        // Inflate the layout for this fragment
        return view;

    }

    private void setupTab() {
        tabActive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0,true);
                underlineActive.setVisibility(View.VISIBLE);
                underlineHistory.setVisibility(View.INVISIBLE);
            }
        });
        tabHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1,true);
                underlineActive.setVisibility(View.INVISIBLE);
                underlineHistory.setVisibility(View.VISIBLE);
            }
        });

        underlineActive.setVisibility(View.VISIBLE);

    }

    public void setViewPager(){
        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager(),getActivity());

        adapter.addFrag(new ActiveBookingFragment());
        adapter.addFrag(new HistoryBookingFragment());
        //adapter.addFrag(new HistoriFragment());

        viewPager.setAdapter(adapter);
    }


}
