package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Number1;
    EditText Number2;
    Button Addition;
    Button Subtraction;
    Button Multiplication;
    Button Division;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referring the Views
        Number1 = (EditText) findViewById(R.id.editText1);
        Number2 = (EditText) findViewById(R.id.editText2);
        Addition = (Button) findViewById(R.id.Add);
        Subtraction = (Button) findViewById(R.id.Sub);
        Multiplication = (Button) findViewById(R.id.Mul);
        Division = (Button) findViewById(R.id.Div);
        Result = (TextView) findViewById(R.id.textView);


        Addition.setOnClickListener(this);
        Subtraction.setOnClickListener(this);
        Multiplication.setOnClickListener(this);
        Division.setOnClickListener(this);

    }

    public void onClick (View v)
    {

        float num1 = 0;
        float num2 = 0;
        float result = 0;
        String oper = "";

        if (TextUtils.isEmpty(Number1.getText().toString()) ||
                TextUtils.isEmpty(Number2.getText().toString()))
            return;

        num1 = Float.parseFloat(Number1.getText().toString());
        num2 = Float.parseFloat(Number2.getText().toString());

        switch (v.getId())
        {
            case R.id.Add:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.Sub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.Mul:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.Div:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        Result.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }
}
