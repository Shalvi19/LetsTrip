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

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.ImageViewHolder> {
    private ArrayList<String> ShoppingPoint= new ArrayList<>();
    private ArrayList<String> Speciality= new ArrayList<>();
    private ArrayList<String> Location=new ArrayList<>();
    private ArrayList<String> Timing=new ArrayList<>();
    private ArrayList<String> NearestBus=new ArrayList<>();
    private ArrayList<String> NearestRest= new ArrayList<>();
    public HomeFragmentAdapter(ArrayList<String> ShoppingPoint, ArrayList<String> Speciality, ArrayList<String> Location, ArrayList<String> Timing, ArrayList<String> NearestBus, ArrayList<String> NearestRest){
        this.ShoppingPoint = ShoppingPoint;
        this.Speciality = Speciality;
        this.Location = Location;
        this.Timing = Timing;
        this.NearestBus = NearestBus;
        this.NearestRest = NearestRest;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_shopping_layout,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFragmentAdapter.ImageViewHolder holder, int position) {
        String ShoppingPoint_id = ShoppingPoint.get(position);
        String Speciality_id = Speciality.get(position);
        String Location_id = Location.get(position);
        String Timing_id = Timing.get(position);
        String NearestBus_id = NearestBus.get(position);
        String NearestRest_id = NearestRest.get(position);
        holder.ShoppingPoint.setText(ShoppingPoint_id);
        holder.Speciality.setText(Speciality_id);
        holder.Timing.setText(Timing_id);
        holder.NearestBus.setText(NearestBus_id);
        holder.NearestRest.setText(NearestRest_id);
        holder.Location.setText(Location_id);
    }

    @Override
    public int getItemCount() {
        return 25;
    }
    public static class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView ShoppingPoint,Speciality,Location,Timing,NearestBus,NearestRest;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            ShoppingPoint = itemView.findViewById(R.id.shopPoint);
            Speciality= itemView.findViewById(R.id.speciality);
            Location = itemView.findViewById(R.id.location);
            Timing = itemView.findViewById(R.id.timing);
            NearestBus = itemView.findViewById(R.id.bus);
            NearestRest = itemView.findViewById(R.id.res);
        }
    }
}
