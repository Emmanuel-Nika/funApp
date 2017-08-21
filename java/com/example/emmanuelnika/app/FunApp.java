package com.example.emmanuelnika.app;

import android.app.Activity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by
 * Okot Emmanuel
 * Masiga David Kelvin
 * Nabwire Barbra Sandra
 * Lema James on 7/27/2017.
 */

public class FunApp extends Activity implements OnClickListener {

    TextView tvView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);

        ImageView welcome = findViewById(R.id.welcome1);
        welcome.setImageResource(R.drawable.sun);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.welcome_animation);
        welcome.setAnimation(animation);

        tvView = findViewById(R.id.tvView);

        Intent intent = getIntent();

        String uName = intent.getStringExtra("UserName");

        tvView.setText("Hello! " + uName );

        // Set up click listeners for all the buttons
        View newButton = findViewById(R.id.new_button);
        newButton.setOnClickListener(this);
        View settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(this);
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_button:
                startActivity(new Intent(this, Game.class));
                break;
            case R.id.settings_button:
                startActivity(new Intent(this, Prefs.class));
                break;
            case R.id.about_button:
                startActivity(new Intent(this, About.class));
                break;
            case R.id.exit_button:

                AlertDialog.Builder alertDialogBuilder = new
                        AlertDialog.Builder(this);
                alertDialogBuilder.setMessage(R.string.decision);
                alertDialogBuilder.setPositiveButton(R.string.positive_button,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent positveActivity = new
                                        Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(positveActivity);
                            }
                        });
                alertDialogBuilder.setNegativeButton(R.string.negative_button,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent negativeActivity = new
                                        Intent(getApplicationContext(),FunApp.class);
                                startActivity(negativeActivity);
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                break;
            // More buttons go here (if any) ...
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Music.play(this, R.raw.main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Music.stop(this);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder = new
                AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.decisionExit);
        alertDialogBuilder.setPositiveButton(R.string.positive_button,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent negativeActivity = new
                                Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(negativeActivity);
                    }
                });
        alertDialogBuilder.setNegativeButton(R.string.negative_button,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent negativeActivity = new
                                Intent(getApplicationContext(),FunApp.class);
                        startActivity(negativeActivity);
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}