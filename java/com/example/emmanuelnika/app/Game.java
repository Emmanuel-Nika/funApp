package com.example.emmanuelnika.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;

/**
 * Created by
 * Okot Emmanuel
 * Masiga David Kelvin
 * Nabwire Barbra Sandra
 * Lema James on 7/27/2017.
 */

public class Game extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);

        View abcButton = findViewById(R.id.learn_abc);
        abcButton.setOnClickListener(this);
        View numButton = findViewById(R.id.learn_numbers);
        numButton.setOnClickListener(this);
        View shapeButton = findViewById(R.id.learn_shapes);
        shapeButton.setOnClickListener(this);
        View singButton = findViewById(R.id.sing_along);
        singButton.setOnClickListener(this);
        View videoButton = findViewById(R.id.videoClick);
        videoButton.setOnClickListener(this);
        View quizButton = findViewById(R.id.do_quiz);
        quizButton.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.learn_abc:
                startActivity(new Intent(this, Abc.class));
                break;
            case R.id.learn_numbers:
                startActivity(new Intent(this, Numbers.class));
                break;
            case R.id.learn_shapes:
                startActivity(new Intent(this, Shapes.class));
                break;
            case R.id.sing_along:
                startActivity(new Intent(this, SingAlong.class));
                break;
            case R.id.videoClick:
                startActivity(new Intent(this, Video.class));
                break;
            case R.id.do_quiz:
                startActivity(new Intent(this, Quiz.class));
                break;
            // More buttons go here (if any) ...
        }
    }

/*    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
*/
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
}