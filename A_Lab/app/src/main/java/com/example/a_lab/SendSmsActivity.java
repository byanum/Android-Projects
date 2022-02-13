package com.example.a_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSmsActivity extends AppCompatActivity {

    Button sendSMS;
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        Toast.makeText(getApplicationContext(),"sms",Toast.LENGTH_SHORT).show();

        phone = findViewById(R.id.message_ed);
        sendSMS = findViewById(R.id.send_sms);

        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getNumber = phone.getText().toString();

                Intent intent =  new Intent(getApplicationContext(),SendSmsActivity.class);
                PendingIntent pi =  PendingIntent.getActivity(getApplicationContext(),0,intent, 0);


                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(getNumber,null,"Sent by phone",pi, null);


                Toast.makeText(getApplicationContext(),"sms sent successfully",Toast.LENGTH_SHORT).show();

            }
        });
    }
}