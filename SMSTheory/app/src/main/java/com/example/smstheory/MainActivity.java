package com.example.smstheory;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber, message;
    Button sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        casting
        message = findViewById(R.id.message);
        phoneNumber = findViewById(R.id.phoneNumber);
        sendMessage = findViewById(R.id.sendBtn);



//        getSendMessage().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String number = phoneNumber.getText().toString();
//                String msg = message.getText().toString();
//
////                Creating intent
//
//                Intent instance = new Intent(getApplicationContext(),MainActivity.class);
//                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0,instance,0);
//
////                get sms manager and create its instance
//                SmsManager smsInstance = SmsManager.getDefault();
//                smsInstance.sendTextMessage(number, null, msg, pi, null);
//
//                Toast.makeText(getApplicationContext(), "Message Sent Bro", Toast.LENGTH_LONG).show();
//
//
//            }
//        });
    }



    public void sendMessage(View view) {
        String number = phoneNumber.getText().toString();
        String msg = message.getText().toString();

//                Creating intent

        Intent instance = new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0,instance,0);

//                get sms manager and create its instance
        SmsManager smsInstance = SmsManager.getDefault();
        smsInstance.sendTextMessage(number, null, msg, pi, null);

        Toast.makeText(getApplicationContext(), "Message Sent Bro", Toast.LENGTH_LONG).show();

    }
}