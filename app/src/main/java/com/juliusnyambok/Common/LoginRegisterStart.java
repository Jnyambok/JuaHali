package com.juliusnyambok.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.juliusnyambok.juahaliyako.R;

public class LoginRegisterStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register_start);
    }
//my name is julius

    public void login_function(View view) {
        startActivity(new Intent(LoginRegisterStart.this,LoginPage.class));
    }

    public void sign_in_function(View view) {
        startActivity(new Intent(LoginRegisterStart.this,SignupPage.class));
    }
}