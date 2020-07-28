package com.juliusnyambok.juahaliyako;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    private Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter(Context context){
        this.context=context;

    }
//arrays
    private int [] slide_images={
            R.drawable.danger,
            R.drawable.family,
            R.drawable.analytics
    };

    private String [] slide_headings={
            "Avoid Danger",
            "Real-Time Analysis",
            "Protect your loved ones"
    };


    private String [] slide_desc={
            "Avoid risks by connecting to a network of informative citizens who report incidents as they happen.",
            "Get real time updates and reports on potential hazards that might be happening around you.",
            "Be your loved ones' saviour by warning them about recent incidents through our detailed analysis and statistics."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {  //adding the sliding effect
        LayoutInflater layoutinflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutinflater.inflate(R.layout.slide_layout,container,false);


        ImageView slideImageView=view.findViewById(R.id.slide_image);
        TextView slideHeading=view.findViewById(R.id.slide_heading);
        TextView slideDescription=view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
