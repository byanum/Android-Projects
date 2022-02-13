package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox React, Flutter, AndroidL;
    Button sendIt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        React = findViewById(R.id.checkbox1);
        Flutter = findViewById(R.id.checkbox2);
        AndroidL = findViewById(R.id.checkbox3);

        sendIt = findViewById(R.id.click);

    }

    public void PressBtn(View view) {
        int totalAmount = 0;

//        modify data without creating a new object.
        StringBuilder s = new StringBuilder();

        s.append("sup bro");

        if(React.isChecked()){
            s.append("\n React selected");
            totalAmount=+100;
        }
        if(Flutter.isChecked()){
            s.append("\n Flutter selected");
            totalAmount+=50;
        }
        if(AndroidL.isChecked()){
            s.append("\n Working in android");
        }

        s.append("total is "+totalAmount);
        Toast.makeText(getApplicationContext(), s.toString(), Toast.LENGTH_SHORT).show();

    }
}