package com.example.emmanuelnika.app;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by
 * Okot Emmanuel
 * Masiga David Kelvin
 * Nabwire Barbra Sandra
 * Lema James on 7/27/2017.
 */

public class Video extends AppCompatActivity {

    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vid_layout);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        getWindow().setFormat(PixelFormat.UNKNOWN);
        mediaController = new MediaController(this);

        button1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                VideoView video2 = (VideoView) findViewById(R.id.VideoView1);
                String videoPath = "android.resource://com.example.emmanuelnika.app/" + R.raw.bingo;
                Uri uri = Uri.parse(videoPath);
                video2.setVideoURI(uri);
                video2.setMediaController(mediaController);
                mediaController.setAnchorView(video2);
                video2.start();
            }
        });

        button2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                VideoView video2 = (VideoView) findViewById(R.id.VideoView1);
                String videoPath = "android.resource://com.example.emmanuelnika.app/" + R.raw.abc_song;
                Uri uri = Uri.parse(videoPath);
                video2.setVideoURI(uri);
                video2.setMediaController(mediaController);
                mediaController.setAnchorView(video2);
                video2.start();
            }
        });

        button3.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                VideoView video2 = (VideoView) findViewById(R.id.VideoView1);
                String videoPath = "android.resource://com.example.emmanuelnika.app/" + R.raw.numbers;
                Uri uri = Uri.parse(videoPath);
                video2.setVideoURI(uri);
                video2.setMediaController(mediaController);
                mediaController.setAnchorView(video2);
                video2.start();
            }
        });

        button4.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                VideoView video2 = (VideoView) findViewById(R.id.VideoView1);
                String videoPath = "android.resource://com.example.emmanuelnika.app/" + R.raw.animals_on_the_farm;
                Uri uri = Uri.parse(videoPath);
                video2.setVideoURI(uri);
                video2.setMediaController(mediaController);
                mediaController.setAnchorView(video2);
                video2.start();
            }
        });

        button5.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                VideoView video2 = (VideoView) findViewById(R.id.VideoView1);
                String videoPath = "android.resource://com.example.emmanuelnika.app/" + R.raw.twinkle_twinkle;
                Uri uri = Uri.parse(videoPath);
                video2.setVideoURI(uri);
                video2.setMediaController(mediaController);
                mediaController.setAnchorView(video2);
                video2.start();
            }
        });

        button6.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                VideoView video2 = (VideoView) findViewById(R.id.VideoView1);
                String videoPath = "android.resource://com.example.emmanuelnika.app/" + R.raw.rain_go_away;
                Uri uri = Uri.parse(videoPath);
                video2.setVideoURI(uri);
                video2.setMediaController(mediaController);
                mediaController.setAnchorView(video2);
                video2.start();
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent back = new
                Intent(getApplicationContext(), Game.class);
        startActivity(back);
    }
}