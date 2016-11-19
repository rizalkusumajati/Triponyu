package com.example.macmini2.triponyu.bookingManagement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.macmini2.triponyu.IndexActivity;
import com.example.macmini2.triponyu.R;
import com.example.macmini2.triponyu.adapter.PagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookingManagementMenuFragment extends Fragment {
    private LinearLayout tabYourTrip,tabBookingConfirm;
    private ViewPager viewPager;
    private View underlineYourTrip,underlineBookingConfirm;

    public BookingManagementMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_booking_management_menu, container, false);

        ((IndexActivity)getActivity()).fragmentIndex=1;
        ((IndexActivity)getActivity()).setToolbarTitle("Booking Management");
        ((IndexActivity)getActivity()).setFabInvisible();
        tabYourTrip=(LinearLayout)view.findViewById(R.id.tabYourTrip);
        tabBookingConfirm=(LinearLayout)view.findViewById(R.id.tabBookConfirm);
        underlineYourTrip=view.findViewById(R.id.underlineYourTrip);
        underlineBookingConfirm=view.findViewById(R.id.underlineBookConfirm);
        viewPager=(ViewPager)view.findViewById(R.id.viewPager);
        setViewPager();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        underlineYourTrip.setVisibility(View.VISIBLE);
                        underlineBookingConfirm.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        underlineBookingConfirm.setVisibility(View.VISIBLE);
                        underlineYourTrip.setVisibility(View.INVISIBLE);
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
        tabYourTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0,true);
                underlineYourTrip.setVisibility(View.VISIBLE);
                underlineBookingConfirm.setVisibility(View.INVISIBLE);
            }
        });
        tabBookingConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1,true);
                underlineYourTrip.setVisibility(View.INVISIBLE);
                underlineBookingConfirm.setVisibility(View.VISIBLE);
            }
        });

        underlineYourTrip.setVisibility(View.VISIBLE);

    }

    public void setViewPager(){
        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager(),getActivity());

        adapter.addFrag(new YourTripFragment());
        adapter.addFrag(new BookingManagementFragment());
        //adapter.addFrag(new HistoriFragment());

        viewPager.setAdapter(adapter);
    }

}
