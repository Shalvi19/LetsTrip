package com.example.tripit;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;

public class PlaceFragmentAdapter extends RecyclerView.Adapter<PlaceFragmentAdapter.ImageViewHolder> {
    private ArrayList<String> Plcaes= new ArrayList<>();
    private ArrayList<String> Location= new ArrayList<>();
    private ArrayList<String> Fees=new ArrayList<>();
    private ArrayList<String> Time=new ArrayList<>();
    public PlaceFragmentAdapter(ArrayList<String> Places, ArrayList<String> Location, ArrayList<String> Fees, ArrayList<String> Time){
        this.Plcaes = Places;
        this.Fees = Fees;
        this.Location = Location;
        this.Time = Time;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_place_layout,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceFragmentAdapter.ImageViewHolder holder, int position) {
        String Place_id = Plcaes.get(position);
        String Fee_id = Fees.get(position);
        String Location_id = Location.get(position);
        String Time_id = Time.get(position);
        holder.Places.setText(Place_id);
        holder.Fees.setText(Fee_id);
        holder.Time.setText(Time_id);
        holder.Location.setText(Location_id);
    }

    @Override
    public int getItemCount() {
        return 25;
    }
    public static class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView Places, Fees, Location, Time;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            Places = itemView.findViewById(R.id.place);
            Fees= itemView.findViewById(R.id.fee);
            Location = itemView.findViewById(R.id.location);
            Time = itemView.findViewById(R.id.time);
           }
    }
}
