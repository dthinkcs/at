package com.rishabhjaiswal.intentchangeback;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        v = findViewById(R.id.root).getRootView();

        String val = getIntent().getStringExtra("RESULT_STRING");
        if (val.equals("red"))
            v.setBackgroundColor(0xFFFF0000);
        else if (val.equals("green"))
            v.setBackgroundColor(Color.rgb(0, 255, 0));
        else if (val.equals("blue"))
            v.setBackgroundColor(Color.rgb(0, 0, 255));

    }
}
