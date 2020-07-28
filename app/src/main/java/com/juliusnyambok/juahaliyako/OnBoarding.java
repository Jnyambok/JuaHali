package com.juliusnyambok.juahaliyako;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBoarding extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private Button mNextButton;
    private Button mBackButton;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        mSlideViewPager=(ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout=(LinearLayout) findViewById(R.id.dotsLayout);

        sliderAdapter=new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        mBackButton=(Button) findViewById(R.id.back_button);
        mNextButton=(Button) findViewById(R.id.next_button);

        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

       //The onclick listeners
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        });


    }

    public void addDotsIndicator(int position){
        mDots=new TextView[3];
        mDotLayout.removeAllViews();
        for (int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }
        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }


    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
        addDotsIndicator(i);
        mCurrentPage=i;
        if(i==0){
            mNextButton.setEnabled(true);
            mBackButton.setEnabled(false);
            mBackButton.setVisibility(View.INVISIBLE);
            mNextButton.setText("Next");
            mBackButton.setText("");
        }else if(i==mDots.length-1){
            mNextButton.setEnabled(true);
            mBackButton.setEnabled(true);
            mBackButton.setVisibility(View.VISIBLE);
            mNextButton.setText("Finish");
            mNextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(OnBoarding.this,main_page.class));

                }
            });
            mBackButton.setText("Back");
        }else{
            mNextButton.setEnabled(true);
            mBackButton.setEnabled(true);
            mBackButton.setVisibility(View.VISIBLE);
            mNextButton.setText("Next");
            mBackButton.setText("Back");
        }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };










}