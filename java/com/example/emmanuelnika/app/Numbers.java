package com.example.emmanuelnika.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

/*
 * Created by
 * Okot Emmanuel
 * Masiga David Kelvin
 * Nabwire Barbra Sandra
 * Lema James on 7/27/2017.
 */

public class Numbers extends AppCompatActivity implements View.OnClickListener {
    private ImageButton pr, nx;
    private ViewFlipper viewFlipper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.num_layout);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper2);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.object_animation);
        viewFlipper.setAnimation(animation);
        pr = (ImageButton) findViewById(R.id.previous);
        nx = (ImageButton) findViewById(R.id.next);

        nx.setOnClickListener(this);
        pr.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == nx) {
            viewFlipper.showNext();
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.object_animation);
            viewFlipper.setAnimation(animation);
        } else if (v == pr) {
            viewFlipper.showPrevious();
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.object_animation);
            viewFlipper.setAnimation(animation);
        }
    }

    @Override
    public void onBackPressed() {

        Intent back = new
                Intent(getApplicationContext(), Game.class);
        startActivity(back);
    }
}
