package com.example.recycle_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageView i;
    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        i = findViewById(R.id.img);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);

        i.setImageResource(getIntent().getIntExtra("imagename", 0));
        t1.setText(getIntent().getStringExtra("txt"));
        t2.setText(getIntent().getStringExtra("des"));
        
    }
}