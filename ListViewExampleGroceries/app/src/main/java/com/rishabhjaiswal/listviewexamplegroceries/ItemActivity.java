package com.rishabhjaiswal.listviewexamplegroceries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {
    private TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        String name = getIntent().getStringExtra("name");

        nameTextView = findViewById(R.id.item_name);

        nameTextView.setText(name);
    }
}
