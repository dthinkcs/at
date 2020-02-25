package com.rishabhjaiswal.intentcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t = findViewById(R.id.textView);
        String val = getIntent().getStringExtra("RESULT_STRING");//Extra(MainActivity.EXTRA_MESSAGE);
        t.setText("Result is " + val);
        Toast.makeText(this, val + " " + getIntent().getStringExtra("OPERATION"), Toast.LENGTH_LONG).show();

    }
}
