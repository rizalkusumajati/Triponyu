package com.example.macmini2.triponyu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.macmini2.triponyu.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by macmini2 on 9/21/16.
 */

public class HistoriBookingAdapter extends RecyclerView.Adapter<HistoriBookingAdapter.MyViewHolder> {

    private ArrayList<HashMap<String, String>> mDataset;
    final public String KEY_KOTA = "kota";
    final public String KEY_TANGGAL = "tangggal";



    // Provide a suitable constructor (depends on the kind of dataset)
    public HistoriBookingAdapter(ArrayList<HashMap<String, String>> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_history_booking, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HashMap<String, String> data = new HashMap<String, String>();
        data = mDataset.get(position);
        holder.txtKota.setText(data.get(KEY_KOTA));
        holder.txtTanggal.setText(data.get(KEY_TANGGAL));


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView txtKota;
        public TextView txtTanggal;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtKota = (TextView) itemView.findViewById(R.id.kotaManag);
            txtTanggal = (TextView) itemView.findViewById(R.id.tanggalManag);


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
