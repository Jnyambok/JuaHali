package com.juliusnyambok.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.juliusnyambok.juahaliyako.MainActivity;
import com.juliusnyambok.juahaliyako.R;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }






    public void sign_in_function(View view) {
        startActivity(new Intent(LoginPage.this,SignupPage.class));
    }
}