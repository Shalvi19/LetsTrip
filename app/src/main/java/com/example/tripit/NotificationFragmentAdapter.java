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

public class NotificationFragmentAdapter extends RecyclerView.Adapter<NotificationFragmentAdapter.ImageViewHolder> {
    private ArrayList<String> Activity= new ArrayList<>();
    private ArrayList<String> Description= new ArrayList<>();
    public NotificationFragmentAdapter(ArrayList<String> Activity, ArrayList<String> Description){
        this.Activity = Activity;
        this.Description = Description;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_activities_layout,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationFragmentAdapter.ImageViewHolder holder, int position) {
        String Activity_id = Activity.get(position);
        String Description_id = Description.get(position);
        holder.Activity.setText(Activity_id);
        holder.Description.setText(Description_id);
     }

    @Override
    public int getItemCount() {
        return 25;
    }
    public static class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView Activity, Description;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            Activity = itemView.findViewById(R.id.activity);
            Description= itemView.findViewById(R.id.desc);
        }
    }
}
