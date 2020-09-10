package com.juliusnyambok.juahaliyako;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.textfield.TextInputEditText;
import com.juliusnyambok.RecyclerView.OuterClass;
import com.juliusnyambok.RecyclerView.RecyclerViewMain;
import com.juliusnyambok.RecyclerView.RequestInterface;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostReport extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "";
    private GoogleMap mMap;
    LocationManager locationManager;
    Button sendMapCoordinates;


    //The reporting disasters page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_report);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);//will manage the location
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
            //onLocationChanged,onStatusChanged and the other methods can only when the networkprovider is working

            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {//when location changes the location variable gets the new coordinates
                    //get the device latitude
                    double latitude= location.getLatitude();
                    //get the longitude
                    double longitude=location.getLongitude();
                    //the two variables will be used in geocoding

                    //instantiate the class latitude-longitude class
                    LatLng latLng=new LatLng(latitude,longitude);
                    //instantiate the geo-coder class- will convert our coordinates into meaningful info
                    Geocoder geocoder=new Geocoder(getApplicationContext());
                    try {
                        List<Address> addressList= geocoder.getFromLocation(latitude,longitude,1);//will return a list of addresses
                        /*
                         * from this list we can get the country name, locality name and street name
                         * */
                        // += will append the items in the list
                        //will give the locality name of the place where the disaster has been reported.
                        final String disasterLocality = addressList.get(0).getLocality() + "," + addressList.get(0).getCountryName();
                        // disasterLocality+=addressList.get(0).getSubThoroughfare();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(disasterLocality));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10.2f));

                        final TextInputEditText disasterType = (TextInputEditText) findViewById(R.id.disaster_type);
                        final TextInputEditText disasterDesc = (TextInputEditText) findViewById(R.id.post_disaster_desc);
                        //final TextInputEditText location = (TextInputEditText) findViewById(R.id.location);
                        Button senddis = (Button) findViewById(R.id.postdisaster);
                        senddis.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String disasterT=disasterType.getText().toString().trim();
                                String disasterD=disasterDesc.getText().toString().trim();
                                //String locat=location.getText().toString().trim();
                                if(!TextUtils.isEmpty(disasterT) && !TextUtils.isEmpty(disasterD)  /*&& !TextUtils.isEmpty(locat)*/ ) {
                                    senddisaster(disasterT,disasterD,disasterLocality);
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

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }else if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            //onLocationChanged and onStatusChanged methods can only when the network is working
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    //get the longitude
                    double longitude=location.getLongitude();
                    //get the device latitude
                    double latitude= location.getLatitude();
                    //the two variables will be used in geocoding

                    //instantiate the class latitudelongitude class
                    LatLng latLng=new LatLng(latitude,longitude);
                    //instantiate the geocoder class- will convert our coordinates into meaningful info
                    Geocoder geocoder=new Geocoder(getApplicationContext());
                    try {
                        List<Address> addressList= geocoder.getFromLocation(latitude,longitude,1);//will return a list of addresses
                        /*
                         * from this list we can get the country name, locality name and street name
                         * */

                        // += will append the items in the list
                        //will give the locality name of the place where the disaster has been reported.
                        final String disasterLocality = addressList.get(0).getLocality() + "," + addressList.get(0).getCountryName();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(disasterLocality));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10.2f));

                        final TextInputEditText disasterType = (TextInputEditText) findViewById(R.id.disaster_type);
                        final TextInputEditText disasterDesc = (TextInputEditText) findViewById(R.id.post_disaster_desc);
                        //final TextInputEditText location = (TextInputEditText) findViewById(R.id.location);
                        Button senddis = (Button) findViewById(R.id.postdisaster);
                        senddis.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String disasterT=disasterType.getText().toString().trim();
                                String disasterD=disasterDesc.getText().toString().trim();
                                //String locat=location.getText().toString().trim();
                                if(!TextUtils.isEmpty(disasterT) && !TextUtils.isEmpty(disasterD)  /*&& !TextUtils.isEmpty(locat)*/ ) {
                                    senddisaster(disasterT,disasterD,disasterLocality);
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

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }

        /*final TextInputEditText disasterType = (TextInputEditText) findViewById(R.id.disaster_type);
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
        });*/

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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }
}

