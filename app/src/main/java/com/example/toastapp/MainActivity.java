package com.example.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)(findViewById(R.id.editText));
    }

    public void okButtonPressed(View view) {
        Toast.makeText(this, "Wow! Your Favourite Subject is " + editText.getText(), Toast.LENGTH_SHORT).show();
    }
}
