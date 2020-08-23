package com.juliusnyambok.Common;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.juliusnyambok.juahaliyako.R;


//This is the page where one decides whether to login,sign up or learn more about the application

public class LoginRegisterStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register_start);//Corresponding activity xml file
    }





    //goes to the LoginPage
    public void login_function(View view) {
        startActivity(new Intent(LoginRegisterStart.this,LoginPage.class));
    }



    //goes to the Sign up page
    public void sign_in_function(View view) {
        startActivity(new Intent(LoginRegisterStart.this,SignupPage.class));
    }
}