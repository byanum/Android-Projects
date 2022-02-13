package com.example.media_audio_video;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    VideoView btnVideo;

    Button start, pause, stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVideo = findViewById(R.id.btn_VideoView);

        start = findViewById(R.id.btn_start);
        pause = findViewById(R.id.btn_pause);
        stop = findViewById(R.id.btn_stop);


//        first create media controller
        MediaController m = new MediaController(this);

        m.setAnchorView(btnVideo);


//        specifying location
        Uri u = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/media/l.mp4");
        Toast.makeText(getApplicationContext()," "+u, Toast.LENGTH_LONG).show();

//        now set the created media controller
        btnVideo.setMediaController(m);
        btnVideo.setVideoURI(u);
//        btnVideo.requestFocus();
        btnVideo.start();





//        AUDIO
//        create media player not media controller
        final MediaPlayer mp = new MediaPlayer();

        try{
            mp.setDataSource(Environment.getExternalStorageDirectory().getPath());

        } catch (IOException e) {
            e.printStackTrace();
        }

//        buttons
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });
    }
}