package com.rishabhjaiswal.intentchangeback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void operate(View v) {

        String msg = "";
        if (v.getId() == R.id.red) {
            msg="red";
        } else if (v.getId() == R.id.green) {
            msg="green";
        } else {
            msg="blue";
        }

        Intent myIntent = new Intent(this, Main2Activity.class);
        myIntent.putExtra("RESULT_STRING", msg + "");
        startActivity(myIntent);
    }
}
