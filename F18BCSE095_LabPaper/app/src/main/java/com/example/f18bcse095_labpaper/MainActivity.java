package com.example.f18bcse095_labpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name, reg;

    EditText e1;
    EditText e2;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editTextName);
        e2 = findViewById(R.id.editTextReg);
        submit = findViewById(R.id.button);
    }

    public void NextActivity(View view) {
        name = e1.getText().toString();
        reg = e2.getText().toString();

        if (name.matches("")) {
            Toast.makeText(this, "Name field is empty", Toast.LENGTH_SHORT).show();
           return;
        }

        if (reg.matches("")) {
            Toast.makeText(this, "Registration field is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent i = new Intent(MainActivity.this,MainActivity2.class);

        i.putExtra("name_key", name);
        i.putExtra("reg_key", reg);

        startActivity(i);
    }
}