package com.example.externalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button save, read;
    EditText editFilename, editDatatext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = findViewById(R.id.btn_save);
        read = findViewById(R.id.btn_read);

        editFilename = findViewById(R.id.fileText);
        editDatatext = findViewById(R.id.dataText);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                get the text from screen
                String getFilename = editFilename.getText().toString();
                String getDataText = editDatatext.getText().toString();

                FileOutputStream fop;
                try{
//                create file object
                File file1 = new File("/sdcard/"+getFilename);
                file1.createNewFile();

//                create fop object
                    FileOutputStream fops = new FileOutputStream(file1);

//                    for writing the data
                    OutputStreamWriter osw = new OutputStreamWriter(fops);
                    osw.append(getDataText);
                    osw.close();

                    fops.close();

                    Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_LONG).show();
                }
               catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                get the file name only
                String filename = editFilename.getText().toString();
                StringBuffer sb = new StringBuffer();

                String aDataRow = "";
                String aBuffer = "";


                try {
                    File myFile = new File("/sdcard/"+filename);
                    FileInputStream fis = new FileInputStream(myFile);
                    BufferedReader myreader = new BufferedReader(new InputStreamReader(fis));

                    while((aDataRow = myreader.readLine()) != null){
                        aBuffer += aDataRow + "\n";

                    }
                    myreader.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),aBuffer,Toast.LENGTH_LONG).show();
            }
        });
    }
}