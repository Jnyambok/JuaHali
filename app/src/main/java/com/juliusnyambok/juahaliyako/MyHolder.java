package com.juliusnyambok.juahaliyako;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView disasterImage;
    TextView disasterName,disasterLocation,disasterDescription;
    ItemClickListener itemClickListener;


     MyHolder(@NonNull View itemView) {

       //Binding the resources from the respective layout files
        super(itemView);
        this.disasterImage=itemView.findViewById(R.id.disaster_image);
        this.disasterName=itemView.findViewById(R.id.disaster_name);
        this.disasterLocation=itemView.findViewById(R.id.disaster_location);
        this.disasterDescription=itemView.findViewById(R.id.disaster_description);


        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
         this.itemClickListener.onItemClickListener(view,getLayoutPosition());

    }
    public void setItemClickListener(ItemClickListener ic){
         this.itemClickListener=ic;
    }

}
