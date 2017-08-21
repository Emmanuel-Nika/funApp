package com.example.emmanuelnika.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/*
 * Created by
 * Okot Emmanuel
 * Masiga David Kelvin
 * Nabwire Barbra Sandra
 * Lema James on 7/27/2017.
 */


public class Quiz extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;

    TextView score,question;

    private Questions mQuestions = new Questions();
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLenght = mQuestions.mQuestions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        r= new Random();

        answer1=(Button) findViewById(R.id.answer1);
        answer2=(Button) findViewById(R.id.answer2);
        answer3=(Button) findViewById(R.id.answer3);
        answer4=(Button) findViewById(R.id.answer4);

        // sucees= (ImageView) findViewById(R.id.imageView);

        score=(TextView) findViewById(R.id.score);
        question=(TextView) findViewById(R.id.question);

        score.setText("Score: "+mScore);

        updateQuestions(r.nextInt(mQuestionsLenght));

        answer1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(answer1.getText()== mAnswer){
                    mScore++;
                    score.setText("Score: "+ mScore);
                    updateQuestions(r.nextInt(mQuestionsLenght));
                }
                else{
                    // Toast.makeText(MainActivity.this,"TRY AGAIN",Toast.LENGTH_SHORT).show();
                    // sucees.setImageResource(R.mipmap.ic_launcher);
                    gameOver();
                }
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer2.getText()== mAnswer){
                    mScore++;
                    score.setText("Score: "+mScore);
                    updateQuestions(r.nextInt(mQuestionsLenght));
                }
                else{
                    gameOver();
                    // Toast.makeText(MainActivity.this,"TRY AGAIN",Toast.LENGTH_SHORT).show();
                }

            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer3.getText()== mAnswer){
                    mScore++;
                    score.setText("Score: "+mScore);
                    updateQuestions(r.nextInt(mQuestionsLenght));
                }
                else{
                    gameOver();
                    // Toast.makeText(MainActivity.this,"TRY AGAIN",Toast.LENGTH_SHORT).show();
                }

            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer4.getText()== mAnswer){
                    mScore++;
                    score.setText("Score: "+mScore);
                    updateQuestions(r.nextInt(mQuestionsLenght));
                }
                else{

                    gameOver();
                    //Toast.makeText(MainActivity.this,"TRY AGAIN",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void updateQuestions(int num){
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer= mQuestions.getCorrectAnswer(num);

    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Quiz.this);
        alertDialogBuilder
                .setMessage("Game Over! \nYour score is "+ mScore+" points")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                startActivity(new Intent(getApplicationContext(),Quiz.class));
                                finish();
                            }
                        }
                )

                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish();
                            }
                        }
                );
        AlertDialog alertDialog= alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {

        Intent back = new
                Intent(getApplicationContext(), Game.class);
        startActivity(back);
    }
}