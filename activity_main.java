package com.example.hppavilion.connect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.media.MediaPlayer;

import static com.example.hppavilion.connect.R.id.gridLayout1;

public class MainActivity extends AppCompatActivity {


    // 2 means a particular position is unoccupied
    int[] gameState= {2,2,2,2,2,2,2,2,2};
    int activePlayer=0;
    boolean gameIsActive=true;
    int[][] winningPositions= {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{1,4,7},{0,3,6},{2,5,8}};
    private String winner;

    public void dropIn (View view) {
        ImageView counter = (ImageView) view;


        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameIsActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.green);

                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.red);

                activePlayer = 0;

            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);
            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                    // Someone has won!

                    gameIsActive = false;

                    winner = "Red";

                    if (gameState[winningPosition[0]] == 0) {

                        winner = "Green";

                    }



        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.VISIBLE);

    }else {

        boolean gameIsOver = true;

        for (int counterState : gameState) {

        if (counterState == 2) gameIsOver = false;

        }

        if (gameIsOver) {


            LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

            layout.setVisibility(View.VISIBLE);


        }}}}}




    public void playMore (View view){


            gameIsActive = true;

            LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

            layout.setVisibility(View.INVISIBLE);

            activePlayer = 0;
            for (int i = 0; i < gameState.length; i++) {

                gameState[i] = 2;

            }
            GridLayout gridLayouta = (GridLayout) findViewById(gridLayout1);

            for (int i = 0; i < gridLayouta.getChildCount(); i++) {

                ((ImageView) gridLayouta.getChildAt(i)).setImageResource(0);

            }
        }
    public void Restart (View view){
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {

            gameState[i] = 2;

        }
        GridLayout gridLayouta = (GridLayout) findViewById(gridLayout1);

        for (int i = 0; i < gridLayouta.getChildCount(); i++) {

            ((ImageView) gridLayouta.getChildAt(i)).setImageResource(0);

        }

    }

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         MediaPlayer mp3= MediaPlayer.create(this, R.raw.music);
         mp3.start();
}

}

