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

public class DashboardFragmentAdapter extends RecyclerView.Adapter<DashboardFragmentAdapter.ImageViewHolder> {
    private ArrayList<String> Restaurant;
    private ArrayList<String> MustTry;
    private ArrayList<String> Location;
    private ArrayList<String> Cuisine;
    private ArrayList<String> CostForTwo;
    private ArrayList<String> GoogleRating;
    private ArrayList<String> ZomatoRating;
    public DashboardFragmentAdapter(ArrayList<String> Restaurant, ArrayList<String> MustTry, ArrayList<String> Location, ArrayList<String> Cuisine, ArrayList<String> CostForTwo, ArrayList<String> GoogleRating, ArrayList<String> ZomatoRating){
        Log.e("My Res","Res = " + Restaurant);
        this.Restaurant = Restaurant;
        this.MustTry = MustTry;
        this.Location = Location;
        this.Cuisine = Cuisine;
        this.CostForTwo = CostForTwo;
        this.GoogleRating = GoogleRating;
        this.ZomatoRating = ZomatoRating;
    }
//    String[] Info;
//    public DashboardFragmentAdapter(String[] Info){
//        this.Info = Info;
//    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_layout,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardFragmentAdapter.ImageViewHolder holder, int position) {
        String Restaurant_id = Restaurant.get(position);
        String MustTry_id = MustTry.get(position);
        String Location_id = Location.get(position);
        String Cuisine_id = Cuisine.get(position);
        String CostForTwo_id = CostForTwo.get(position);
        String GoogleRating_id = GoogleRating.get(position);
        String ZomatoRating_id = ZomatoRating.get(position);
        holder.Restaurant.setText(Restaurant_id);
        holder.ZomatoRating.setText(ZomatoRating_id);
        holder.GoogleRating.setText(GoogleRating_id);
        holder.CostForTwo.setText(CostForTwo_id);
        holder.Cuisine.setText(Cuisine_id);
        holder.MustTry.setText(MustTry_id);
        holder.Location.setText(Location_id);
    }

    @Override
    public int getItemCount() {
        return 25;
    }
    public static class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView Restaurant,ZomatoRating,GoogleRating,CostForTwo,Cuisine,MustTry,Location;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            Restaurant = itemView.findViewById(R.id.restaurant);
            ZomatoRating = itemView.findViewById(R.id.zomatoRating);
            GoogleRating = itemView.findViewById(R.id.googleRating);
            CostForTwo = itemView.findViewById(R.id.cost);
            Cuisine = itemView.findViewById(R.id.cuisine);
            Location = itemView.findViewById(R.id.location);
            MustTry = itemView.findViewById(R.id.mustTry);
        }
    }
}
