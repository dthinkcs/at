package com.example.myfirstmvcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText favouriteSubjectEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        favouriteSubjectEditText = (EditText) findViewById(R.id.editText2);

        Log.i("rishabh", "yolo!");
    }

    public void onButtonPressed(View view) {

        Log.i("rishabh", "button was pressed!");
       // showToast("Congrats! Keep up the deep work");
        Toast.makeText(this, "Keep up the good deep work", Toast.LENGTH_SHORT).show();

    }

    public void onEnterButtonPressed(View view) {
        // EditText favouriteSubjectEditText = (EditText) findViewById(R.id.editText2);

        //String s = favouriteSubjectEditText.getText().toString();
        //showToast("My favourite subject is " + s);

        Toast.makeText(this, "My Favourite Subject is " + favouriteSubjectEditText.getText(), Toast.LENGTH_SHORT).show();

    }

    /*
    public void showToast(String text) {
        // USE THISContext context = getApplicationContext();
        //String text = s;// CharSequence text = "Congrats Rishabh! Keep up the work!";

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    */
}
