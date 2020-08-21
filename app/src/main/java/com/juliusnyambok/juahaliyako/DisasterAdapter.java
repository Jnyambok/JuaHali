package com.juliusnyambok.juahaliyako;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DisasterAdapter extends RecyclerView.Adapter<com.juliusnyambok.juahaliyako.MyHolder> {
    private ArrayList<com.juliusnyambok.juahaliyako.Disasters> disastersData;
    private Context myContext;
    DisasterAdapter(ArrayList<com.juliusnyambok.juahaliyako.Disasters> myDisasterData, Context context){
        this.myContext=context;
        this.disastersData=myDisasterData;
    }
    @NonNull
    @Override
    public com.juliusnyambok.juahaliyako.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.disaster_list,null);
        return new com.juliusnyambok.juahaliyako.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final com.juliusnyambok.juahaliyako.MyHolder holder, int position) {
        holder.disasterName.setText(disastersData.get(position).getDisasterName());
        holder.disasterLocation.setText(disastersData.get(position).getDisasterLocation());
        holder.disasterDescription.setText(disastersData.get(position).getDisasterDescription());
        holder.disasterImage.setImageResource(disastersData.get(position).getDisasterImage());


        holder.setItemClickListener(new com.juliusnyambok.juahaliyako.ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                String gName=disastersData.get(position).getDisasterName();
                String gLocation=disastersData.get(position).getDisasterLocation();
                String gDescription=disastersData.get(position).getDisasterDescription();
                BitmapDrawable bitmapDrawable=(BitmapDrawable)holder.disasterImage.getDrawable();
                Bitmap bitmap=bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
                byte[] bytes=stream.toByteArray();
                //get data with intent
                Intent intent=new Intent(myContext,DescriptionActivity.class);
                intent.putExtra("iName",gName);
                intent.putExtra("iLocation",gLocation);
                intent.putExtra("iDescription",gDescription);
                intent.putExtra("iImage",bytes);
                myContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return disastersData.size();
    }




  /* public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myDisasterImage;
        private TextView myDisasterName;
        private TextView myDisasterLocation;
        private TextView myDisasterDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            myDisasterImage=itemView.findViewById(R.id.disaster_image);
            myDisasterName=itemView.findViewById(R.id.disaster_name);
            myDisasterLocation=itemView.findViewById(R.id.disaster_location);
            myDisasterDescription=itemView.findViewById(R.id.disaster_description);
           /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int disasterPosition=getAdapterPosition();
                    Disasters currentDisaster=disastersData.get(disasterPosition);
                   if(disasterPosition==0){
                        Intent donutIntent=new Intent(myContext,DonutActivity.class);
                        donutIntent.putExtra("dTitle",currentDessert.getRecipeTitle());
                        donutIntent.putExtra("dImage",currentDessert.getRecipeImage());
                        donutIntent.putExtra("dDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(donutIntent);
                    }else{
                        Toast.makeText(myContext,"Create an activity for this",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        public void bindTo(Disasters currentDisaster) {
            Glide.with(myContext).load(currentDisaster.getDisasterImage()).into(myDisasterImage);
            myDisasterName.setText(currentDisaster.getDisasterName());
            myDisasterLocation.setText(currentDisaster.getDisasterLocation());
            myDisasterDescription.setText(currentDisaster.getDisasterDescription());
        }
    }*/
}

