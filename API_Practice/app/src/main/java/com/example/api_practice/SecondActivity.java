package com.example.api_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rv = findViewById(R.id.rcview);
        rv.setLayoutManager(new LinearLayoutManager(this));

        String arr[]= {"a","b","c"};
        rv.setAdapter(new rcviewAdapter(arr));
    }
}