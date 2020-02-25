package com.rishabhjaiswal.intentcalc;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.rishabh.lab2q1.MESSAGE";
    EditText e1; // = findViewById(R.id.editText);
    EditText e2; // = findViewById(R.id.editText2);
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);

    }
//    public void onClick(View v) {
//        Intent myIntent = new Intent(this, Main2Activity.class);
//        myIntent.putExtra(EXTRA_MESSAGE, "Hi");
//        startActivity(myIntent);
//
//    }

    public void operation(View v) {
        int num1 = 0;
        int num2 = 0;
        try{
            num1 = Integer.parseInt(e1.getText().toString());
        }catch (NumberFormatException ex) {
            //handle exception here
            Toast.makeText(this, "Invalid num1", Toast.LENGTH_SHORT).show();
            return;
        }

        try{
            num2 = Integer.parseInt(e2.getText().toString());
        }catch (NumberFormatException ex) {
            //handle exception here
            Toast.makeText(this, "Invalid num2", Toast.LENGTH_SHORT).show();
            return;

        }
        String oper = "";
        if (v.getId() == R.id.add) {
            result = num1 + num2;
            oper = "Addition";

        } else if (v.getId() == R.id.subtract) {
            result = num1 - num2;
            oper = "Subtraction";
        }
        else if (v.getId() == R.id.multiply) {
            result = num1 * num2;
            oper = "Multiplication";
        }
        final String oper2 = oper;

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("ARE YOU SURE");
        alertDialogBuilder.setMessage("click yes to exit!").setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        MainActivity.this.finish();

                        Intent myIntent = new Intent(getBaseContext(), Main2Activity.class);
                        myIntent.putExtra("RESULT_STRING", result + "");
                        myIntent.putExtra("OPERATION", oper2);
                        startActivity(myIntent);


                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog= alertDialogBuilder.create();
        alertDialog.show();
//
//        Intent myIntent = new Intent(this, Main2Activity.class);
//        myIntent.putExtra("RESULT_STRING", result + "");
//        myIntent.putExtra("OPERATION", oper);
//        startActivity(myIntent);


    }


}
