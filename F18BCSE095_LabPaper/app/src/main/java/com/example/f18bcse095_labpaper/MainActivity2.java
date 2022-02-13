package com.example.f18bcse095_labpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView t1, t2, t3, t4;
    String name, reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);

        Intent i = getIntent();

        name = i.getStringExtra("name_key");
        reg = i.getStringExtra("reg_key");

        t1.setTextColor(Color.YELLOW);
        t2.setTextColor(Color.YELLOW);

        t3.setTextColor(Color.RED);
        t4.setTextColor(Color.RED);

        t1.setText("Name");
        t2.setText(name);
        t3.setText("Reg No");
        t4.setText(reg);

    }
}