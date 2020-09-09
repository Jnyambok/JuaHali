package com.juliusnyambok.RecyclerView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.juliusnyambok.juahaliyako.R;

public class DescriptionActivity extends AppCompatActivity {
    TextView dName,dLocation,dDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


        dName=findViewById(R.id.disaster_name_desc);
        dLocation=findViewById(R.id.disaster_location_desc);
        dDescription=findViewById(R.id.disaster_description_desc);



        Intent intent=getIntent();

        String mName=intent.getStringExtra("iName");
        String mLocation=intent.getStringExtra("iLocation");
        String mDescription=intent.getStringExtra("iDesc");





        dName.setText(mName);
        dLocation.setText(mLocation);
        dDescription.setText(mDescription);

    }
}