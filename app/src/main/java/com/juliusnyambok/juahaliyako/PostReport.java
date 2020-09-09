package com.juliusnyambok.juahaliyako;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.juliusnyambok.RecyclerView.OuterClass;
import com.juliusnyambok.RecyclerView.RecyclerViewMain;
import com.juliusnyambok.RecyclerView.RequestInterface;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostReport extends AppCompatActivity {

    private static final String TAG = "";



    //The reporting disasters page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_post_report);



        final TextInputEditText disasterType = (TextInputEditText) findViewById(R.id.disaster_type);
        final TextInputEditText disasterDesc = (TextInputEditText) findViewById(R.id.post_disaster_desc);
        final TextInputEditText location = (TextInputEditText) findViewById(R.id.location);
        Button senddis = (Button) findViewById(R.id.postdisaster);
        senddis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String disasterT=disasterType.getText().toString().trim();
                String disasterD=disasterDesc.getText().toString().trim();
                String locat=location.getText().toString().trim();
                if(!TextUtils.isEmpty(disasterT) && !TextUtils.isEmpty(disasterD)  && !TextUtils.isEmpty(locat) ) {
                    senddisaster(disasterT,disasterD,locat);
                }
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


       public void senddisaster(String disasterT,String disasterD,String locat) {
           Retrofit retrofit = new Retrofit.Builder()                                         //The Retrofit class generates an implementation of the GitHubService interface.
                   .baseUrl("https://frozen-sea-84149.herokuapp.com/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
           RequestInterface requestInterface = retrofit.create(RequestInterface.class);
           Call<OuterClass> call = requestInterface.setDisasters(disasterT,locat,disasterD);
           call.enqueue(new Callback<OuterClass>() {
               @Override
               public void onResponse(Call<OuterClass> call, Response<OuterClass> response) {
                   Log.d(TAG, "post submitted to API." + response.body().toString());
                   Toast.makeText(PostReport.this, "Your disaster has been posted", Toast.LENGTH_SHORT).show();
                   Intent intent=new Intent(PostReport.this,RecyclerViewMain.class);
                   startActivity(intent);

               }

               @Override
               public void onFailure(Call<OuterClass> call, Throwable t) {
                   Log.d("TAG","Response = Your api call haijafika ata bado bro");
               }
           });

       }









}

