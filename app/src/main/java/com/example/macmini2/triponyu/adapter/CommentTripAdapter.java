package com.example.macmini2.triponyu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.macmini2.triponyu.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by macmini2 on 9/22/16.
 */

public class CommentTripAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<HashMap<String, String>> mDataset;
    final public String KEY_KOTA = "kota";
    final public String KEY_TANGGAL = "tangggal";
    final public String KEY_JUMLAH = "jumlah";


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder1 extends RecyclerView.ViewHolder {
        // each data item is just a string in this case


        public ViewHolder1(View v) {
            super(v);



        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        // each data item is just a string in this case


        public ViewHolder2(View v) {
            super(v);



        }
    }


    public void add(HashMap<String, String> item) {
        mDataset.add(item);
        notifyDataSetChanged();
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CommentTripAdapter(ArrayList<HashMap<String, String>> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {

        if (viewType==mDataset.size()-1){
            // create a new view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.button_read_more, parent, false);
            // set the view's size, margins, paddings and layout parameters
            CommentTripAdapter.ViewHolder2 vh = new CommentTripAdapter.ViewHolder2(v);
            return vh;
        }
        else {
            // create a new view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_comment_trip, parent, false);
            // set the view's size, margins, paddings and layout parameters
            CommentTripAdapter.ViewHolder1 vh = new CommentTripAdapter.ViewHolder1(v);
            return vh;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position==mDataset.size()-1){

            CommentTripAdapter.ViewHolder2 headerViewHolder = (CommentTripAdapter.ViewHolder2) holder;
        }
        else {
            HashMap<String, String> data = new HashMap<String, String>();
            data = mDataset.get(position);
            CommentTripAdapter.ViewHolder1 headerViewHolder = (CommentTripAdapter.ViewHolder1) holder;
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
