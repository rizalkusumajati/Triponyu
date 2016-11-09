package com.example.macmini2.triponyu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by macmini2 on 9/15/16.
 */
public class OpeningActivity extends AppCompatActivity {
    private Button createAccount,login;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        createAccount=(Button)findViewById(R.id.buttonCreateAccount);
        login=(Button)findViewById(R.id.buttonLogIn);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(OpeningActivity.this,CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OpeningActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
