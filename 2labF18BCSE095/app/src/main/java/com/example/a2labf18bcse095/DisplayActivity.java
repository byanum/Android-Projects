package com.example.a2labf18bcse095;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView t1, t2, t3;
    String sname, snumber, depart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        t1 = (TextView) findViewById(R.id.d_name);
        t2 = (TextView) findViewById(R.id.d_phone);
        t3 = (TextView) findViewById(R.id.d_depart);

        Intent intent = getIntent();

//        which string to put: previous there were three
         sname =  intent.getStringExtra("name");
         snumber =  intent.getStringExtra("number");
         depart =  intent.getStringExtra("department");
        t1.setText(sname);
        t2.setText(snumber);
        t3.setText(depart);
    }
}