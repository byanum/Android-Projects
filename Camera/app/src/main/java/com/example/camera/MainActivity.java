package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int CamRequest = 1888;
    ImageView btnImage;
    Button btnCapture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImage = findViewById(R.id.btn_imageView);

        btnCapture = findViewById(R.id.btn_capture);

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, CamRequest);

            }
        });
    }

//    developer's function
    protected  void result(int reqCode, int resultCode, Intent i){
        if (reqCode == CamRequest) {

//            android.graphics.Bitmap
            Bitmap bbs = (Bitmap) i.getExtras().get("data");
            btnImage.setImageBitmap(bbs);
        }
    }
}