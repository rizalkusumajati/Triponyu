package com.example.macmini2.triponyu.customDialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.macmini2.triponyu.R;

/**
 * Created by macmini2 on 9/19/16.
 */
public class IdCard extends DialogFragment implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;


    public IdCard() {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        View view = LayoutInflater.from(this.getActivity()).inflate(R.layout.dialog_id_card, null, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
        builder.setView(view);
        setCancelable(false);
        yes = (Button) view.findViewById(R.id.buttonNext);
        no = (Button) view.findViewById(R.id.buttonClose);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        return builder.create();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonNext:
                dismiss();
                break;
            case R.id.buttonClose:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}