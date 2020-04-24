package com.example.tripit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.tripit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirstPage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText editText;
    private Button search;
    private int[] images = {R.drawable.goa, R.drawable.lavasa, R.drawable.sikkim, R.drawable.nainital};
    private String[] title = {"Goa", "Lavasa", "Sikkim", "Nainital"};
    private RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        editText = (EditText) findViewById(R.id.editText);
        search = (Button) findViewById(R.id.button);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerAdapter(images, title);
        recyclerView.setAdapter(adapter);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        final String city = editText.getText().toString();
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DocumentReference documentReference = db.collection("Cities").document("0");
                documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else return;
                    }
                });
            }
        });
    }
}
