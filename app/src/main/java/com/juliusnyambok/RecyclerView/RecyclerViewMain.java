package com.juliusnyambok.RecyclerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.juliusnyambok.juahaliyako.PostReport;
import com.juliusnyambok.juahaliyako.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RecyclerViewMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private RecyclerView disastersRecyclerView;//the disaster recycler view
    private DisasterAdapter disasterAdapter; //the disaster adapter
//    private RelativeLayout cardview;
    SwipeRefreshLayout swipeRefreshLayout;
    private FloatingActionButton fab;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.recycler_view_main);
        setNavigationViewListener();

     //   RecyclerView recyclerView=findViewById(R.id.recycler_disaster);

        swipeRefreshLayout=findViewById(R.id.swiper);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
                Toast.makeText(RecyclerViewMain.this, "Page Refreshed! ", Toast.LENGTH_SHORT).show();
                getDisasterResponse();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        //Adding the swiper refresh layout.
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewMain.this, PostReport.class);
                startActivity(intent);
            }
        });



//         disaster_name=findViewById(R.id.disaster_name);
//         disaster_location=findViewById(R.id.disaster_location);
//         disaster_description=findViewById(R.id.disaster_description);
//









        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //methods for inititalizing the toolbar thats in the Recycler View Main Layout

        navigationView.setNavigationItemSelectedListener(this);









        getDisasterResponse();



    }




    private void getDisasterResponse() {
        Retrofit retrofit=new Retrofit.Builder()                                         //The Retrofit class generates an implementation of the GitHubService interface.
                .baseUrl("https://frozen-sea-84149.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        RequestInterface requestInterface=retrofit.create(RequestInterface.class);           //Each Call from the created GitHubService can make a synchronous or asynchronous HTTP request to the remote webserver.
        Call<OuterClass> call=requestInterface.getDisasters();
        call.enqueue(new Callback<OuterClass>() {
            @Override
            public void onResponse(Call<OuterClass> call, Response<OuterClass> response) {


                   if(response.body()==null){
                       Log.d("TAG","Response = Your shit is empty");
                   }
              else {
                       Toast.makeText(RecyclerViewMain.this, "Refresh Page for new disasters", Toast.LENGTH_SHORT).show();
                       generateDisasterList(response.body());
                       Log.d("TAG", "Response = " +response.body());

                     //  disasterAdapter=new DisasterAdapter(RecyclerViewMain.this,DisasterModel);
                   }

            }

            @Override
            public void onFailure(Call<OuterClass> call, Throwable t) {
                Log.d("TAG","Response = Your api call haijafika ata bado bro");
            }
        });
    }

    private void generateDisasterList(OuterClass response) {           //Inflating the recycler view with the responses from the JSON response
        disastersRecyclerView=findViewById(R.id.recycler_disaster);
        disasterAdapter=new DisasterAdapter(response.getDisaster(),this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(RecyclerViewMain.this);
        disastersRecyclerView.setLayoutManager(layoutManager);
        disastersRecyclerView.setAdapter(disasterAdapter);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Uri contentUri= Uri.parse("https://play.google.com/store/apps/details?id=my.example.Juahali");
        if (item.getItemId() == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Check out this informative application that lets you inform and lets you be informed about disasters on playstore "+ contentUri);
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        }



        else if (item.getItemId()==R.id.nav_chat){
            String email = "juahalifeedback@gmail.com";
                    String subject ="HAPPY WITH THE APP";
                    String body = "Hello my name is........... ";
                    String chooserTitle = "Choose your appropriate email application to talk with us";
            Uri uri = Uri.parse("mailto:" + email)
                    .buildUpon()
                    .appendQueryParameter("subject", subject)
                    .appendQueryParameter("body", body)

                    .build();

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);
            startActivity(Intent.createChooser(emailIntent, chooserTitle));


        }





                return true;
    }

    private void setNavigationViewListener() {
    }
}
