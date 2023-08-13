package com.example.doctorbhai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HealthVideoActivity extends AppCompatActivity {

    LinearLayout laysong1 ,laysong2, laysong3 ,laysong4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_video);

        laysong1 = findViewById(R.id.laySong1);
        laysong2 = findViewById(R.id.laySong2);
        laysong3 = findViewById(R.id.laySong3);
        laysong4 = findViewById(R.id.laySong4);

        laysong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoPlayerActivity.video_url = "https://www.youtube.com/embed/b3n32s2kwq0";
                Intent intent = new Intent(HealthVideoActivity.this, VideoPlayerActivity.class);
                startActivity(intent);
            }
        });
        laysong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoPlayerActivity.video_url = "https://www.youtube.com/embed/kKvv7JadVvc";
                Intent intent = new Intent(HealthVideoActivity.this, VideoPlayerActivity.class);
                startActivity(intent);
            }
        });
        laysong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoPlayerActivity.video_url = "https://www.youtube.com/embed/Rts0JgREN8U";
                Intent intent = new Intent(HealthVideoActivity.this, VideoPlayerActivity.class);
                startActivity(intent);
            }
        });
        laysong4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoPlayerActivity.video_url = "https://www.youtube.com/embed/u05PQ6ZPJPc";
                Intent intent = new Intent(HealthVideoActivity.this, VideoPlayerActivity.class);
                startActivity(intent);
            }
        });


    }
}