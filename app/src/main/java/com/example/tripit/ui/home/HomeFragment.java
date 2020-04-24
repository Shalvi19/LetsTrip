package com.example.tripit.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripit.DashboardFragmentAdapter;
import com.example.tripit.HomeFragmentAdapter;
import com.example.tripit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public ArrayList<String> ShoppingPoint= new ArrayList<>();
    public ArrayList<String> Speciality= new ArrayList<>();
    public ArrayList<String> Location=new ArrayList<>();
    public ArrayList<String> Timing=new ArrayList<>();
    public ArrayList<String> NearestBus=new ArrayList<>();
    public ArrayList<String> NearestRest= new ArrayList<>();
    private RecyclerView recyclerView;
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {
        final View root = (inflater.inflate(R.layout.fragment_shopping, container,false));
        recyclerView = root.findViewById(R.id.fragview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Shopping").get().
                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                ShoppingPoint.add("Shopping Point=> "+ document.get("Shopping Point"));
                                Speciality.add("Speciality=> " + document.get("Speciality"));
                                Location.add("Location=> " + document.get("Location"));
                                Timing.add("Timing=> " + document.get("Timing"));
                                NearestBus.add("Nearest Bus Stop=> " + document.get("Nearest Bus Stop"));
                                NearestRest.add("Nearest Restaurants=> " + document.get("Nearest Restaurants"));
                            }
                        }
                        HomeFragmentAdapter adapter = new HomeFragmentAdapter(ShoppingPoint, Speciality, Location, Timing, NearestBus, NearestRest);
                        recyclerView.setAdapter(adapter);
                    }
                });
        return root;
    }
}