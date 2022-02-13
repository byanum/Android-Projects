package com.example.wifi;

import static java.lang.System.out;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
// WIFI
    Button enable, disable;

//    Bluetooth
    Button b_enable, b_disable, b_discover;



//Bluetooth
    private static final int Request_Enable = 0;
    private static final int Request_Discover = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enable = findViewById(R.id.btn_enable);
        disable = findViewById(R.id.btn_disable);

        b_enable = findViewById(R.id.btn_blue_enable);
        b_disable = findViewById(R.id.btn_blue_disable);
        b_discover = findViewById(R.id.btn_blue_discover);

// WIFI
        enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager w = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                w.setWifiEnabled(true);

            }
        });

// WIFI
        disable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager w = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                w.setWifiEnabled(false);


            }
        });


//        Bluetooth

//        Use built in bluetooth adapter
        BluetoothAdapter b = BluetoothAdapter.getDefaultAdapter();

        if(b == null){
            out.append("not supported");
        }

        b_enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!b.isEnabled()){
                    Intent i_enable = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

//                    this requires permission of bluetooth connect!
                    startActivityForResult(i_enable, Request_Enable);
                }

            }
        });

        b_disable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b.disable();
                out.append("bluetooth is off");

            }
        });


        b_discover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(!b.isDiscovering()){
                   Toast.makeText(getApplicationContext(),"not discover", Toast.LENGTH_SHORT);

                   Intent i_discover = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                   startActivityForResult(i_discover, Request_Discover);
               }

            }
        });


//        oncreate
    }


}