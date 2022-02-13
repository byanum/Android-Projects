package com.example.phonecall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText number;
    Button callBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
        callBtn=findViewById(R.id.call);

    }

    public void Call(View view) {
        String value1= number.getText().toString();

//        call intent
        Intent instance = new Intent(Intent.ACTION_CALL);
        instance.setData(Uri.parse("tel:"+value1));
        startActivity(instance);

    }
}