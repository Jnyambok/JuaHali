package com.juliusnyambok.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.juliusnyambok.juahaliyako.R;

public class SignupPage extends AppCompatActivity {
//The sign up page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
    }




//Goes to the sign up page
    public void login_function(View view) {
        startActivity(new Intent(SignupPage.this,SignupPage.class));
    }
}