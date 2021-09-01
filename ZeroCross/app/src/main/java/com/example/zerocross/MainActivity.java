package com.example.zerocross;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //0 - player 1 cross , 1 - player 2 zero
    private int activePlayer = 0;

    private boolean gameIsActive = true;

    private int[] gameState = {2,2,2,2,2,2,2,2,2};

    private int[][] winComb = {{0,1,2},{3,4,5},{6,7,8},{0,3,6,},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    MediaPlayer sound0,sound1,drawSound,winSound;

    public void dropIn(View view){
        ImageView field = (ImageView) view;

        int tag = Integer.parseInt(field.getTag().toString());

        if(gameState[tag] == 2 && gameIsActive){

            gameState[tag] = activePlayer;

            field.setTranslationY(-1000f);

            if(activePlayer == 0){
                field.setImageResource(R.drawable.cross);
                sound0.start();
                sound1.pause();
                sound1.seekTo(0);
                activePlayer = 1;
            }
            else{
                field.setImageResource(R.drawable.zero);
                sound1.start();
                sound0.pause();
                sound0.seekTo(0);
                activePlayer = 0;
            }

            field.animate().translationYBy(1000f).setDuration(300);

            for(int[] winningPositions : winComb){
                if(gameState[winningPositions[0]] == gameState[winningPositions[1]]
                        && gameState[winningPositions[1]] == gameState[winningPositions[2]]
                        && gameState[winningPositions[0]] != 2 ){

                    //when someone win
                    gameIsActive=false;

                    String player = "Cross";
                    if(gameState[winningPositions[0]] == 1) player ="Zero";

                    TextView textView = findViewById(R.id.winMsg);
                    textView.setText(player+" win");
                    LinearLayout layout = findViewById(R.id.linearLayout);
                    layout.setVisibility(View.VISIBLE);

                    layout.animate().rotationBy(3600f).setDuration(300);

                    winSound.start();
                    drawSound.pause();
                    drawSound.seekTo(0);
                }
                else{
                    boolean gameIsOver = true;
                    for(int fieldState : gameState){
                        if(fieldState == 2) gameIsOver = false;
                    }

                    if(gameIsOver){
                        TextView textView = findViewById(R.id.winMsg);
                        textView.setText("It's a Tie ");
                        LinearLayout layout = findViewById(R.id.linearLayout);
                        layout.setVisibility(View.VISIBLE);

                        layout.animate().rotationBy(3600f).setDuration(300);

                        drawSound.start();
                        winSound.pause();
                        winSound.seekTo(0);
                    }
                }
            }

        }


    }

    public void  playAgain(View view){


        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        layout.setVisibility(View.INVISIBLE);

        //setting game state to default
        for(int i = 0 ; i < gameState.length ; i ++){
            gameState[i] = 2;
        }

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i= 0 ; i < gridLayout.getChildCount() ; i ++){
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }

        gameIsActive=true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

         sound0 = MediaPlayer.create(this,R.raw.cross);
         sound1 = MediaPlayer.create(this,R.raw.cross);

         drawSound = MediaPlayer.create(this,R.raw.drawsound);
         winSound = MediaPlayer.create(this,R.raw.winclappingsound);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}