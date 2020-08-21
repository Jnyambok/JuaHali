package com.juliusnyambok.juahaliyako;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;




public class RecyclerViewMain extends AppCompatActivity {
    private RecyclerView disastersRecyclerView;
    private DisasterAdapter disasterAdapter;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_main);

        disastersRecyclerView=findViewById(R.id.recycler_disaster);
        disastersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        disasterAdapter=new DisasterAdapter(getMyList(), this);
        disastersRecyclerView.setAdapter(disasterAdapter);

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewMain.this,PostReport.class);
                startActivity(intent);
            }
        });





    }

    private ArrayList<Disasters> getMyList() {
        ArrayList<Disasters> disasters=new ArrayList<>();

        Disasters d=new Disasters();
        d.setDisasterName("Earthquake");
        d.setDisasterLocation("Muranga");
        d.setDisasterDescription("Strong Earthquake");
        d.setDisasterImage(R.drawable.dis);
        disasters.add(d);

        d=new Disasters();
        d.setDisasterName("Landslide");
        d.setDisasterLocation("Muranga");
        d.setDisasterDescription("Strong Earthquake");
        d.setDisasterImage(R.drawable.dis);
        disasters.add(d);

        d=new Disasters();
        d.setDisasterName("Storm");
        d.setDisasterLocation("Muranga");
        d.setDisasterDescription("Strong Earthquake");
        d.setDisasterImage(R.drawable.dis);
        disasters.add(d);

        d=new Disasters();
        d.setDisasterName("Floods");
        d.setDisasterLocation("Muranga");
        d.setDisasterDescription("Strong Earthquake");
        d.setDisasterImage(R.drawable.dis);
        disasters.add(d);

        return disasters;
    }











}
