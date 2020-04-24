package com.example.tripit.ui.place;

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

import com.example.tripit.HomeFragmentAdapter;
import com.example.tripit.PlaceFragmentAdapter;
import com.example.tripit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class PlaceFragment extends Fragment {
    public ArrayList<String> Plcaes= new ArrayList<>();
    public ArrayList<String> Location= new ArrayList<>();
    public ArrayList<String> Fees=new ArrayList<>();
    public ArrayList<String> Time=new ArrayList<>();
    private RecyclerView recyclerView;
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {
        final View root = (inflater.inflate(R.layout.fragment_place, container,false));
        recyclerView = root.findViewById(R.id.fragview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Places").get().
                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Plcaes.add("Place=> "+ document.get("Places to Visit in Jaipur"));
                                Fees.add("Entry Fees=> " + document.get("Entry Fees"));
                                Location.add("Location=> " + document.get("Location"));
                                Time.add("Timing to Visit=> " + document.get("Visiting Hours"));
                                }
                        }
                        PlaceFragmentAdapter adapter = new PlaceFragmentAdapter(Plcaes,Fees, Location, Time);
                        recyclerView.setAdapter(adapter);
                    }
                });
        return root;
    }
}