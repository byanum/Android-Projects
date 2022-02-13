package com.example.api_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//    EditText username, password;
    Button signPage, loginPage, loct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        username2 = findViewById(R.id.username);
//        password2 = findViewById(R.id.password);
        signPage = findViewById(R.id.takeMeToSignup);
        loginPage = findViewById(R.id.loginPage);
        loct = findViewById(R.id.locPage);
        signPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), registerActivity.class);
                startActivity(i);
            }
        });

        loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(i2);
            }
        });

        loct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(getApplicationContext(), locActivity.class);
                startActivity(i3);
            }
        });
    }
}