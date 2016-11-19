package com.example.macmini2.triponyu.createAccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.macmini2.triponyu.R;
import com.example.macmini2.triponyu.login.LoginActivity;

public class CreateAccountActivity extends AppCompatActivity {
    private Button btnLogin,btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        btnLogin=(Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateAccountActivity.this, LoginActivity.class));
            }
        });
    }
}
