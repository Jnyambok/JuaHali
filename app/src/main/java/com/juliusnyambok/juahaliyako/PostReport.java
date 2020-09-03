package com.juliusnyambok.juahaliyako;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.juliusnyambok.RecyclerView.RecyclerViewMain;

public class PostReport extends AppCompatActivity {

//The reporting disasters page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_report);

        Button postdisaster = findViewById(R.id.postdisaster);
        postdisaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PostReport.this, RecyclerViewMain.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "Disaster has been posted successfully!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        Button back=findViewById(R.id.back_to_disasters);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PostReport.this,RecyclerViewMain.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "You haven't posted a disaster!", Toast.LENGTH_LONG);
                toast.show();
            }
        });






    }











}