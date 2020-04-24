package com.example.tripit.ui.notifications;

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
import com.example.tripit.NotificationFragmentAdapter;
import com.example.tripit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    public ArrayList<String> Activity= new ArrayList<>();
    public ArrayList<String> Description= new ArrayList<>();
    private RecyclerView recyclerView;
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {
        final View root = (inflater.inflate(R.layout.fragment_activities, container,false));
        recyclerView = root.findViewById(R.id.fragview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Activities").get().
                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Activity.add("Activities in Jaipur=> "+ document.get("Entertaining and Fun Things to Do in Jaipur"));
                                Description.add("Short Description=> " + document.get("Short Description"));
                            }
                        }
                        NotificationFragmentAdapter adapter = new NotificationFragmentAdapter(Activity, Description);
                        recyclerView.setAdapter(adapter);
                    }
                });
        return root;
    }
}