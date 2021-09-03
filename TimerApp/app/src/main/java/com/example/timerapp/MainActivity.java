package com.example.timerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekBar ;
    TextView timerTextView ;
    CountDownTimer countDownTimer;
    ImageView imageView ;
    Button myButton;

    boolean progressIsActive = false;

    public void setTimer(int progress){
        int minutes = progress / 60;
        int seconds = progress % 60;
        String secondString = String.valueOf(seconds);
        if(seconds <= 9){
            secondString = "0"+seconds;
        }

        timerTextView.setText(String.valueOf(minutes)+":"+secondString);
    }

    public void resetTimer(){
        myButton.setText("Go !");
        timerSeekBar.setProgress(30);
        timerTextView.setText("0:30");
        timerSeekBar.setEnabled(true);
        progressIsActive = true;
        countDownTimer.cancel();


    }



    public void controlTimer(View view){
        imageView.setImageResource(R.drawable.ironman1);
        if(progressIsActive) {
            progressIsActive=false;
            timerSeekBar.setEnabled(false);
            myButton.setText("Stop");

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long l) {
                    int progress = (int) l / 1000;
                    setTimer(progress);
                }

                @Override
                public void onFinish() {
                    imageView.setImageResource(R.drawable.ironman2);
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.boom);
                    mediaPlayer.start();
                    resetTimer();
                }
            }.start();
        }else{
            countDownTimer.cancel();
            timerSeekBar.setEnabled(true);
            myButton.setText("Go !");
            progressIsActive = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressIsActive= true;

        timerSeekBar = findViewById(R.id.seekBar);
        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerTextView = findViewById(R.id.timerTextView);
        myButton = findViewById(R.id.timerButton);
        imageView = findViewById(R.id.imageView);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                setTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}