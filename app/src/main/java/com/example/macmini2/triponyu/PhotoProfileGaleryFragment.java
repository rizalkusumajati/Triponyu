package com.example.macmini2.triponyu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.macmini2.triponyu.adapter.PagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoProfileGaleryFragment extends Fragment {
    private LinearLayout tabPhotoProfile,tabPhotoGalery;
    private ViewPager viewPager;
    private View underlinePhotoProfile,underlinePhotoGalery;
    private Button step4;
    private CalendarAvailabilityFragment calendarAvailabilityFragment;

    public PhotoProfileGaleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_photo_profile_galery, container, false);
        ((IndexActivity)getActivity()).fragmentIndex=1;
        ((IndexActivity)getActivity()).setToolbarTitle("Add New Trip");
        ((IndexActivity)getActivity()).backShow();
        ((IndexActivity)getActivity()).backIncludeExclude();
        tabPhotoProfile=(LinearLayout)view.findViewById(R.id.tabPhotoProfile);
        tabPhotoGalery=(LinearLayout)view.findViewById(R.id.tabPhotoGalery);
        underlinePhotoProfile=view.findViewById(R.id.underlinePhotoProfile);
        underlinePhotoGalery=view.findViewById(R.id.underlinePhotoGalery);

        calendarAvailabilityFragment=new CalendarAvailabilityFragment();
        step4=(Button)view.findViewById(R.id.step4);
        step4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoCalendar();
            }
        });
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
                        underlinePhotoProfile.setVisibility(View.VISIBLE);
                        underlinePhotoGalery.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        underlinePhotoGalery.setVisibility(View.VISIBLE);
                        underlinePhotoProfile.setVisibility(View.INVISIBLE);
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
        return view;
    }

    private void setupTab() {
        tabPhotoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0,true);
                underlinePhotoProfile.setVisibility(View.VISIBLE);
                underlinePhotoGalery.setVisibility(View.INVISIBLE);
            }
        });
        tabPhotoGalery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1,true);
                underlinePhotoProfile.setVisibility(View.INVISIBLE);
                underlinePhotoGalery.setVisibility(View.VISIBLE);
            }
        });

        underlinePhotoProfile.setVisibility(View.VISIBLE);

    }

    public void setViewPager(){
        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager(),getActivity());

        adapter.addFrag(new PhotoGaleryFragment());
        adapter.addFrag(new PhotoProfileFragment());
        //adapter.addFrag(new HistoriFragment());

        viewPager.setAdapter(adapter);
    }

    public void gotoCalendar(){
        getActivity().getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, calendarAvailabilityFragment)
                .addToBackStack(null)
                .commit();
    }
}
