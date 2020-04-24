package com.example.tripit.ui.dashboard;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripit.DashboardFragmentAdapter;
import com.example.tripit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DashboardFragment extends Fragment  {
//    private String[] Info;
//    int i=0;
    public ArrayList<String> Restaurant= new ArrayList<>();
    public ArrayList<String> MustTry= new ArrayList<>();
    public ArrayList<String> Location=new ArrayList<>();
    public ArrayList<String> Cuisine=new ArrayList<>();
    public ArrayList<String> CostForTwo=new ArrayList<>();
    public ArrayList<String> GoogleRating= new ArrayList<>();
    public ArrayList<String> ZomatoRating= new ArrayList<>();
    private RecyclerView recyclerView;
    public View onCreateView( LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = (inflater.inflate(R.layout.fragment_food, container,false));
        recyclerView = root.findViewById(R.id.fragview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Food1").get().
                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Restaurant.add("Restaurant=> "+ document.get("Restaurant"));
                                MustTry.add("Must Try=> " + document.get("MustTry"));
                                Location.add("Location=> " + document.get("Location"));
                                Cuisine.add("Cuisine=> " + document.get("Cuisine"));
                                CostForTwo.add("Cost For Two=> " + document.get("CostForTwo"));
                                GoogleRating.add("Google Rating (out of 5)=> " + document.get("GoogleRating(outof5)"));
                                ZomatoRating.add("Zomato Rating (out of 5)=> " + document.get("ZomatoRating(outof5)"));
                            }
                            //Log.e("res", String.valueOf(Restaurant));
                        }
                        DashboardFragmentAdapter adapter = new DashboardFragmentAdapter(Restaurant, MustTry, Location, Cuisine, CostForTwo, GoogleRating, ZomatoRating);
                        recyclerView.setAdapter(adapter);

                    }
                });
        return root;
    }
}



