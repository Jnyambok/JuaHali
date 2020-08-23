package com.juliusnyambok.juahaliyako;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;




public class RecyclerViewMain extends AppCompatActivity {
    private RecyclerView disastersRecyclerView;
    private DisasterAdapter disasterAdapter;
    private FloatingActionButton fab;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();




    }


    //Array List containing the contents of the cardviews.
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
