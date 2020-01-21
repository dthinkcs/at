package com.rishabhjaiswal.listviewexamplegroceries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view); // 1
        adapter = new MyAdapter(); //new MyAdapter();
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter); // 2
        recyclerView.setLayoutManager(layoutManager); // 3

    }
}
