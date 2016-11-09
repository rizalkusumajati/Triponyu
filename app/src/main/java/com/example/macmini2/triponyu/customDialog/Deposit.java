package com.example.macmini2.triponyu.customDialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.macmini2.triponyu.R;

/**
 * Created by macmini2 on 9/22/16.
 */

public class Deposit extends DialogFragment implements
        android.view.View.OnClickListener {
    int keyDel;
    public Activity c;
    String a;
    public Dialog d;
    public Button yes, no;

    public Deposit() {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        View view = LayoutInflater.from(this.getActivity()).inflate(R.layout.dialog_deposit, null, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
        builder.setView(view);
        setCancelable(false);
        yes = (Button) view.findViewById(R.id.buttonNext);
        no = (Button) view.findViewById(R.id.buttonClose);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        final EditText text = (EditText) view.findViewById(R.id.et_pin);

        text.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                boolean flag = true;
                String eachBlock[] = text.getText().toString().split("-");
                for (int i = 0; i < eachBlock.length; i++) {
                    if (eachBlock[i].length() > 4) {
                        flag = false;
                    }
                }
                if (flag) {

                    text.setOnKeyListener(new View.OnKeyListener() {

                        @Override
                        public boolean onKey(View view, int i, KeyEvent keyEvent) {
                            if (i == KeyEvent.KEYCODE_DEL)
                                keyDel = 1;
                            return false;
                        }


                    });

                    if (keyDel == 0) {

                        if (((text.getText().length() + 1) % 5) == 0) {

                            if (text.getText().toString().split("-").length <= 4) {
                                text.setText(text.getText() + "-");
                                text.setSelection(text.getText().length());
                            }
                        }
                        a = text.getText().toString();
                    } else {
                        a = text.getText().toString();
                        keyDel = 0;
                    }

                } else {
                    text.setText(a);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }


        });
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

