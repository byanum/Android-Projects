package com.example.a_lab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toast.makeText(getApplicationContext(),"Hi", Toast.LENGTH_SHORT).show();

        builder = new AlertDialog.Builder(this);
    }

    public void Alert(View view) {

        builder.setMessage("Welcome to the party F18BCSE095").setNeutralButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent i = new Intent(WelcomeActivity.this, SendMessageActivity.class);
                        startActivity(i);
                    }
                }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent previous = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(previous);
            }
        });

//        Creating alert dialog
        AlertDialog alert = builder.create();
        alert.setTitle("Alert");
        alert.show();
    }
}