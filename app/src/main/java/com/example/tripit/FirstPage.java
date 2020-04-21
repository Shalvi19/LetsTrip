package com.example.tripit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tripit.R;

public class FirstPage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private int[] images = {R.drawable.goa, R.drawable.lavasa, R.drawable.sikkim, R.drawable.nainital};
    private String[] title = {"Goa", "Lavasa", "Sikkim", "Nainital"};
    private RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerAdapter(images, title);
        recyclerView.setAdapter(adapter);
    }
}
