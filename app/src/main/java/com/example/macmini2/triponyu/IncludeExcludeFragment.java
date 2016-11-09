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
public class IncludeExcludeFragment extends Fragment {
    private LinearLayout tabInclude,tabExclude;
    private ViewPager viewPager;
    private View underlineInclude,underlineExclude;
    private Button step3;
    private PhotoProfileGaleryFragment photoProfileGaleryFragment;
    public IncludeExcludeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_include_exclude, container, false);
        ((IndexActivity)getActivity()).fragmentIndex=1;
        ((IndexActivity)getActivity()).setToolbarTitle("Add New Trip");
        ((IndexActivity)getActivity()).backShow();
        ((IndexActivity)getActivity()).backStep2();
        tabInclude=(LinearLayout)view.findViewById(R.id.tabInclude);
        tabExclude=(LinearLayout)view.findViewById(R.id.tabExclude);
        underlineInclude=view.findViewById(R.id.underlineInclude);
        underlineExclude=view.findViewById(R.id.underlineExclude);
        viewPager=(ViewPager)view.findViewById(R.id.viewPager);
        photoProfileGaleryFragment=new PhotoProfileGaleryFragment();
        step3=(Button)view.findViewById(R.id.step3);
        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoPhotoProfileGalery();
            }
        });
        setViewPager();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        underlineInclude.setVisibility(View.VISIBLE);
                        underlineExclude.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        underlineExclude.setVisibility(View.VISIBLE);
                        underlineInclude.setVisibility(View.INVISIBLE);
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
        tabInclude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0,true);
                underlineInclude.setVisibility(View.VISIBLE);
                underlineExclude.setVisibility(View.INVISIBLE);
            }
        });
        tabExclude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1,true);
                underlineInclude.setVisibility(View.INVISIBLE);
                underlineExclude.setVisibility(View.VISIBLE);
            }
        });

        underlineInclude.setVisibility(View.VISIBLE);

    }

    public void gotoPhotoProfileGalery(){
        getActivity().getSupportFragmentManager().beginTransaction()

                .replace(R.id.frame, photoProfileGaleryFragment)
                .addToBackStack(null)
                .commit();

    }

    public void setViewPager(){
        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager(),getActivity());

        adapter.addFrag(new IncludeFragment());
        adapter.addFrag(new ExcludeFragment());
        //adapter.addFrag(new HistoriFragment());

        viewPager.setAdapter(adapter);
    }

}
