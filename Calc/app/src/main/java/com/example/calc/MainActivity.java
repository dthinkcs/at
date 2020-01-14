package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int firstNum = 12;
    int secondNum = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       EditText firstNumEditText =  (EditText)(findViewById(R.id.firstNum));
       firstNum = Integer.parseInt(firstNumEditText.getText().toString());
       secondNum = Integer.parseInt(((EditText)findViewById(R.id.secondNum)).getText().toString());

    }

    public void operatorPressed(View view) {

        int id = view.getId();
        String toastMessage = "";
        if (id == R.id.add) {
            toastMessage = Integer.toString(firstNum + secondNum);
        }
        else if (id == R.id.sub) {
            toastMessage = Integer.toString(firstNum - secondNum);

        }
        else if (id == R.id.mul) {
            toastMessage = Integer.toString(firstNum * secondNum);

        }
        else if (id == R.id.div) {
            toastMessage = Integer.toString(firstNum / secondNum);

        }

        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
    }
}
