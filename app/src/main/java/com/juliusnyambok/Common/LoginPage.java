package com.juliusnyambok.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.juliusnyambok.juahaliyako.MainActivity;
import com.juliusnyambok.juahaliyako.R;
import com.juliusnyambok.juahaliyako.RecyclerViewMain;

import org.w3c.dom.Text;

import java.util.Objects;

public class LoginPage extends AppCompatActivity {


    private static final String KEY_NAME="name_key";//Keys to be saved in the extras bundles
    private static final String KEY_PASS="pass_key";


 //Values to be saved in the extras bundles

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

    }


    public void go_to_home(View view){
        startActivity(new Intent(LoginPage.this, RecyclerViewMain.class));
    }







    public void sign_in_function(View view) {
        startActivity(new Intent(LoginPage.this,SignupPage.class));
    }
}