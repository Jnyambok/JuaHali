package com.juliusnyambok.juahaliyako;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=2000;
//animation variables
    Animation topAnim,BottomAnim;
    ImageView logoimage;
    TextView logotext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        BottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks
        logoimage=findViewById(R.id.imageView);
        logotext=findViewById(R.id.apptitle);
        logoimage.setAnimation(topAnim);
        logotext.setAnimation(BottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,OnBoarding.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);






    }
}