package com.example.macmini2.triponyu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.macmini2.triponyu.IndexActivity;
import com.example.macmini2.triponyu.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by macmini2 on 9/22/16.
 */

public class DepositAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<HashMap<String, String>> mDataset;
    final public String KEY_KOTA = "kota";
    final public String KEY_TANGGAL = "tangggal";
    final public String KEY_JUMLAH = "jumlah";
    final public String KEY_CONFIRM = "confirm";
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder1 extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtKota,txtDeposit;
        public TextView txtTanggal,txtJumlah;
        public Button btnManag;

        public ViewHolder1(View v) {
            super(v);
            txtDeposit=(TextView)v.findViewById(R.id.textDeposit);
            txtKota = (TextView) v.findViewById(R.id.kotaManag);
            txtTanggal = (TextView) v.findViewById(R.id.tanggalManag);
            txtJumlah = (TextView) v.findViewById(R.id.jumlahManag);
            btnManag = (Button) v.findViewById(R.id.buttonManag);

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
    public DepositAdapter(ArrayList<HashMap<String, String>> myDataset, Context mContext) {
        mDataset = myDataset;
        context=mContext;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {

        if (viewType==mDataset.size()-1){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.total_deposit, parent, false);
            // set the view's size, margins, paddings and layout parameters
            DepositAdapter.ViewHolder2 vh = new DepositAdapter.ViewHolder2(v);
            return vh;

        }
        else {

            // create a new view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_deposit, parent, false);
            // set the view's size, margins, paddings and layout parameters
            DepositAdapter.ViewHolder1 vh = new DepositAdapter.ViewHolder1(v);
            return vh;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (position==mDataset.size()-1){}
        else {
            HashMap<String, String> data = new HashMap<String, String>();
            data = mDataset.get(position);
            DepositAdapter.ViewHolder1 headerViewHolder = (DepositAdapter.ViewHolder1) holder;

            headerViewHolder.txtKota.setText(data.get(KEY_KOTA));
            headerViewHolder.txtTanggal.setText(data.get(KEY_TANGGAL));
            headerViewHolder.txtJumlah.setText(data.get(KEY_JUMLAH));
            String buttonStyle = data.get(KEY_CONFIRM);
            switch (buttonStyle) {
                case "need":
                    headerViewHolder.txtDeposit.setText("Trip On Progress");
                    headerViewHolder.btnManag.setVisibility(View.GONE);
                    break;
                case "confirm":

                    break;
                default:
                    break;
            }
        headerViewHolder.btnManag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((IndexActivity)context).showDepositDialog();
            }
        });

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