package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button showMe;
    RadioButton languageRB;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        showMe = findViewById(R.id.showSelected);
    }

    public void showData(View view) {
//        local var --> radio button Id --> radioButton dia

//        to select the id of selected radio circle
        int selectedId = radioGroup.getCheckedRadioButtonId();

        languageRB = findViewById(selectedId);

        if(selectedId==-1){
            Toast.makeText(MainActivity.this, "Nothing selected bro", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(MainActivity.this, languageRB.getText(),Toast.LENGTH_SHORT).show();
        }

    }
}