package com.example.devicelocation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity3 extends AppCompatActivity {

//    TextView t1, t2;
//    Button b1;
//
//    FusedLocationProviderClient fusedLocationClient;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        t1= findViewById(R.id.textViewLon);
//        t2 = findViewById(R.id.textViewLat);
//        b1 = findViewById(R.id.button);
//
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
//
////        check loc is enbled or not
//        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//
//
//
//
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////if loc is enabled
//                if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
//                    getLocation();
//                }else{
//                    displayAlert();
//                }
//
//            }
//        });
//    }
//
//
//
//
//    //    when requet result comes
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 10){
////            check permitted or denied
//            if(grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                getLocation();
//            }
//            else{
//                Toast.makeText(MainActivity.this, "Enable location from Setting",Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    public void getLocation(){
//        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED){
////            // for getting permission
////            when location is accessed
//            fusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
//                @Override
//                public void onSuccess(Location location) {
////                    if loc not null then update ui
//                    if (location != null) {
//                        updateUI(location);
//                    }else{
//
//                        noLocation();
//                        //  updateUI(location);
//                    }
//                }
//            });
//
//        }else{
//            //request for permission
//            requestPermission();
//        }
//    }
//
//    //        alert
//    public void displayAlert(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("Turn on device location");
//        builder.setCancelable(false);
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
//            }
//        });
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//
//            }
//        });
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }
//
//    private void noLocation(){
//        Toast.makeText(MainActivity.this, "Location not set",Toast.LENGTH_SHORT).show();
//    }
//    private void requestPermission() {
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 10);
//    }
//
//    public void updateUI(Location location){
//        t1.setText(String.valueOf(location.getLongitude()));
//        t2.setText(String.valueOf(location.getLatitude()));
//
//    }
}