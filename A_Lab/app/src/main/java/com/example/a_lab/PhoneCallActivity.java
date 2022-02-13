package com.example.a_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneCallActivity extends AppCompatActivity {

    EditText phone;
    Button callb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);

        phone = findViewById(R.id.pnumber);
        callb = findViewById(R.id.phone_btn);

        callb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getNumber = phone.getText().toString();

                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse(getNumber));
                startActivity(i);
            }
        });
    }
}