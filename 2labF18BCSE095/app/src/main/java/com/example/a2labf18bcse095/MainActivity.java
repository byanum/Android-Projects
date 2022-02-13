package com.example.a2labf18bcse095;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText name, phone;
    Spinner department;
    Button buttonSubmit;


    String [] departments = {"SE", "CS", "EE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =  findViewById(R.id.et_name);
        phone = findViewById(R.id.et_phone);
        department = findViewById(R.id.sp_department);
        buttonSubmit = findViewById(R.id.btn_submit);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,departments);

        department.setAdapter(adapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sname = name.getText().toString();
                String snumber = phone.getText().toString();

                String depart = department.getSelectedItem().toString();

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("name",sname);
                intent.putExtra("number",snumber);
                intent.putExtra("department",depart);

//                can be called without creating object
//                static method
                startActivity(intent);
            }
        });
    }

}