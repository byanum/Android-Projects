package com.example.b_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    Button btnHello, btnAnum, btnSecond, btnToast;
    String h1, a2, s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.text1);
        btnHello = findViewById(R.id.hello_btn);
        btnAnum = findViewById(R.id.btn_anum);
        btnSecond = findViewById(R.id.second_btn);
        btnToast = findViewById(R.id.toast_btn);
    }

    public void helloText(View view) {
        h1 = btnHello.getText().toString();
        t1.setText(h1);
    }

    public void anumFunction(View view) {
        a2 = btnAnum.getText().toString();
        t1.setText(h1+a2);
    }

    public void secondButton(View view) {
        s3 = btnSecond.getText().toString();
        btnToast.setText(h1+a2);
    }
}