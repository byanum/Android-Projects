package com.example.externalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ContentHandler;

public class InternalStorageActivity extends AppCompatActivity {
    Button save, read;
    EditText filename, editData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        save = findViewById(R.id.btn_save);
        read = findViewById(R.id.btn_read);

        filename = findViewById(R.id.fileText);
        editData = findViewById(R.id.dataText);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getFileName = filename.getText().toString();
                String getData = editData.getText().toString();

                FileOutputStream fos;
                try {
                    fos = openFileOutput(getFileName, Context.MODE_PRIVATE);

                    fos.write(getData.getBytes());
                    fos.close();

                    Toast.makeText(getApplicationContext(),getFileName + " saved",
                            Toast.LENGTH_LONG).show();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getfilename = filename.getText().toString();
                StringBuffer sBuffer = new StringBuffer();

                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(getfilename)));

                    String s;


                    while((s = br.readLine())!=null){
                        sBuffer.append(br +"/n");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),sBuffer.toString(),Toast.LENGTH_LONG).show();

            }
        });
    }
}