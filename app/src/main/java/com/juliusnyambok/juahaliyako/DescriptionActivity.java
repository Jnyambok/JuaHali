package com.juliusnyambok.juahaliyako;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {
    TextView dName,dLocation,dDescription;
    ImageView dImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ActionBar actionBar= getSupportActionBar();

        dName=findViewById(R.id.disaster_name_desc);
        dLocation=findViewById(R.id.disaster_location_desc);
        dDescription=findViewById(R.id.disaster_description_desc);
        dImage=findViewById(R.id.disaster_image_desc);


        Intent intent=getIntent();

        String mName=intent.getStringExtra("iName");
        String mLocation=intent.getStringExtra("iLocation");
        String mDescription=intent.getStringExtra("iDescription");
        byte[] mBytes=getIntent().getByteArrayExtra("iImage");

        //decode image
        Bitmap bitmap= BitmapFactory.decodeByteArray(mBytes,0,mBytes.length);
        actionBar.setTitle(mName);


        dName.setText(mName);
        dLocation.setText(mLocation);
        dDescription.setText(mDescription);
        dImage.setImageBitmap(bitmap);
    }
}