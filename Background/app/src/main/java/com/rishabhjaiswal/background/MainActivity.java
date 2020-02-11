package com.rishabhjaiswal.background;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout mConstraintLayout;
    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConstraintLayout = findViewById(R.id.constraintLayout);
       // mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.green));

        e = findViewById(R.id.editText);
    }

    public void press(View v) {
        String s = e.getText().toString();
        if (s.equals("")) {
            s = "0";
        }
        double d = Double.parseDouble(s);

        Toast.makeText(this, (d*72.12) + "INR", Toast.LENGTH_SHORT).show();
    }

}
