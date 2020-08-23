package com.juliusnyambok.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.juliusnyambok.juahaliyako.R;
import com.juliusnyambok.juahaliyako.RecyclerViewMain;

public class LoginPage extends AppCompatActivity {

//Login Page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);//corresponding activity xml

    }


//Goes straight to the main recycler view page  (for now)
    public void go_to_home(View view){
        startActivity(new Intent(LoginPage.this, RecyclerViewMain.class));
    }






//Goes to the sign up page
    public void sign_in_function(View view) {
        startActivity(new Intent(LoginPage.this,SignupPage.class));
    }
}