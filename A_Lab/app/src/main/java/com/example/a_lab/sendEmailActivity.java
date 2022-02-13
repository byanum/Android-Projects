package com.example.a_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sendEmailActivity extends AppCompatActivity {

    EditText to, subject, message;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        to = findViewById(R.id.to);
        subject  = findViewById(R.id.subject);
        message = findViewById(R.id.message);

        send = findViewById(R.id.email_btn);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String to1 = to.getText().toString();
                    String subject2 = subject.getText().toString();
                    String message3 = message.getText().toString();

                    Intent i = new Intent(Intent.ACTION_SEND);

                    i.putExtra(Intent.EXTRA_EMAIL,new String[]{to1});
                    i.putExtra(Intent.EXTRA_SUBJECT,subject2);
                    i.putExtra(Intent.EXTRA_TEXT,message3);

                    i.setType("message/rfc822");

                    startActivity(Intent.createChooser(i,"Chooser"));


                Toast.makeText(getApplicationContext(),"sent email",Toast.LENGTH_SHORT).show();
            }
        });

    }
}