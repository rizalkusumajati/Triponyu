package com.example.macmini2.triponyu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.macmini2.triponyu.createAccount.CreateAccountActivity;
import com.example.macmini2.triponyu.IndexActivity;
import com.example.macmini2.triponyu.R;

public class LoginActivity extends AppCompatActivity {
private Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button)findViewById(R.id.buttonLogIn);
        register=(Button)findViewById(R.id.btn_register);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,IndexActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class));
            }
        });
    }
}
