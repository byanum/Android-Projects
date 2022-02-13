package com.example.paper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void Login(View view) {
        String sname = username.getText().toString();
        String spassword = password.getText().toString();

        Intent i = new Intent(MainActivity.this, WelcomeActivity.class);


        // putExtras() to store certain data as a key value pair or Bundle data object.
//        i.putExtra("username",sname);
//        i.putExtra("password",spassword);

        startActivity(i);



    }
}