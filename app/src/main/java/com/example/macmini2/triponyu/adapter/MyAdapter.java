package com.example.macmini2.triponyu.adapter;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.macmini2.triponyu.R;

import java.util.ArrayList;

/**
 * Created by macmini2 on 9/16/16.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
     public class ViewHolder1 extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ViewPager pager;
        //public TextView txtFooter;

        public ViewHolder1(View v) {
            super(v);
            pager=(ViewPager)v.findViewById(R.id.pager);
        }
    }
    public class ViewHolder2 extends RecyclerView.ViewHolder {
        // each data item is just a string in this case


        public ViewHolder2(View v) {
            super(v);

        }
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {
        // each data item is just a string in this case


        public ViewHolder3(View v) {
            super(v);

        }
    }
    public void add(String item) {
        mDataset.add(item);
        notifyDataSetChanged();
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        if (viewType==0){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_header, parent, false);
            ViewHolder2 vh = new ViewHolder2(v);
            return vh;
        }
        else if (viewType==1){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_favorite, parent, false);
            // set the view's size, margins, paddings and layout parameters
            ViewHolder1 vh = new ViewHolder1(v);
            return vh;
        }
        else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_footer, parent, false);
            // set the view's size, margins, paddings and layout parameters
            ViewHolder3 vh = new ViewHolder3(v);
            return vh;
        }
        // create a new view

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            final String name = mDataset.get(position);

        }
        else {

        }
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
