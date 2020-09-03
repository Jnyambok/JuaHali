package com.juliusnyambok.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.juliusnyambok.juahaliyako.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DisasterAdapter extends RecyclerView.Adapter<DisasterAdapter.CustomViewHolder> {
    private List<DisasterModel> disasters;
    private Context myContext;

    DisasterAdapter(List<DisasterModel> disasters, Context context){
        this.myContext=context;
        this.disasters=disasters;//ah okay
    }


    class CustomViewHolder extends RecyclerView.ViewHolder{
       public final View myview;
       TextView disaster_name;
        TextView disaster_location;
        TextView disaster_description;


        CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            myview=itemView;
            disaster_name=myview.findViewById(R.id.disaster_name);
            disaster_location=myview.findViewById(R.id.disaster_location);
            disaster_description=myview.findViewById(R.id.disaster_description);


        }
    }








    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.disaster_list,null);
        return new CustomViewHolder(view);
    }//Ah okay

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
     holder.disaster_name.setText(disasters.get(position).getDisasterName());
     holder.disaster_location.setText(disasters.get(position).getLocation());
     holder.disaster_description.setText(disasters.get(position).getDescription());
    }




    @Override
    public int getItemCount() {
     return disasters.size();
    }

}

