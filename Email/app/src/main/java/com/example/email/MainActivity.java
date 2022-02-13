package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText to, subject, message;
    Button sendMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to=findViewById(R.id.to);
        subject= findViewById(R.id.subject);
        message= findViewById(R.id.Message);

        sendMessage = findViewById(R.id.sendIt);
    }

    public void send(View view) {
        String toSend = to.getText().toString();
        String toSubject = subject.getText().toString();
        String toMessage = message.getText().toString();


//        call intent
        Intent instance = new Intent(Intent.ACTION_SEND);

        instance.putExtra(Intent.EXTRA_EMAIL, new String[]{toSend});
        instance.putExtra(Intent.EXTRA_SUBJECT, toSubject);
        instance.putExtra(Intent.EXTRA_TEXT,toMessage);

        instance.setType("message/rfc822");

        startActivity(Intent.createChooser(instance, "choose email"));

    }
}