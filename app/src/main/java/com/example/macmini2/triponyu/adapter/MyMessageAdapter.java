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
 * Created by macmini2 on 9/23/16.
 */

public class MyMessageAdapter  extends RecyclerView.Adapter<MyMessageAdapter.MyViewHolder> {

    private ArrayList<HashMap<String, String>> mDataset;




    // Provide a suitable constructor (depends on the kind of dataset)
    public MyMessageAdapter(ArrayList<HashMap<String, String>> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MyMessageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_my_message, parent, false);
        return new MyMessageAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyMessageAdapter.MyViewHolder holder, int position) {
        HashMap<String, String> data = new HashMap<String, String>();
        data = mDataset.get(position);



    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        public MyViewHolder(View itemView) {
            super(itemView);



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

}