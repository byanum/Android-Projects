package com.example.a_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SendMessageActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton choice;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        Toast.makeText(getApplicationContext(),"Hi Send Message", Toast.LENGTH_SHORT ).show();
        radioGroup = findViewById(R.id.radioGroup);
        send = findViewById(R.id.send_btn);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId){
                    case R.id.radioButton:
                        Intent i1 = new Intent(SendMessageActivity.this,SendSmsActivity.class);
                        startActivity(i1);
                        break;

                    case R.id.radioButton2:
                        Intent i2 = new Intent(SendMessageActivity.this,sendEmailActivity.class);
                        startActivity(i2);
                        break;

                    case R.id.radioButton3:
                        Intent i3 = new Intent(SendMessageActivity.this,PhoneCallActivity.class);
                        startActivity(i3);
                        break;
                }
            }
        });

//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//                int selectedID = radioGroup.getCheckedRadioButtonId();
//                choice = findViewById(selectedID);

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {

                        switch(checkedId){
                            case R.id.radioButton2:
                                Intent i1 = new Intent(getApplicationContext(),SendSmsActivity.class);
                                startActivity(i1);
                                break;

                            case R.id.radioButton:
                                Intent i2 = new Intent(getApplicationContext(),sendEmailActivity.class);
                                startActivity(i2);
                                break;

                            case R.id.radioButton3:
                                Intent i3 = new Intent(getApplicationContext(),PhoneCallActivity.class);
                                startActivity(i3);
                                break;
                        }
                    }
                });

//
//            }
//        });

    }
}