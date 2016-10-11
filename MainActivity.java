package com.example.mahyar.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int userOverallScoreState = 0;
    int userTurnScore = 0;
    int computerOverallScore = 0;
    int computerTurnScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

}
    public void rollClicked(View v){

        Button rollButton = (Button)findViewById(R.id.Roll);
        final TextView turnScore = (TextView)findViewById(R.id.textView5);

        final TextView winScore = (TextView)findViewById(R.id.textView6);

        winScore.setText("");
        Random rand = new Random();


        int  roll = rand.nextInt(6) + 1;

            switch (roll) {
                case 1: {
                    diceImage(roll);
                    userTurnScore = 0;
                    turnScore.setText("  your turn score:" + " " + String.valueOf(userTurnScore));
                    computerTurn();
                    break;
                }
                case 2: {
                    diceImage(roll);
                    userTurnScore += roll;
                    turnScore.setText("  your turn score:" + " " + String.valueOf(userTurnScore));
                    break;
                }
                case 3: {
                    diceImage(roll);
                    userTurnScore += roll;
                    turnScore.setText("  your turn score:" + " " + String.valueOf(userTurnScore));
                    break;
                }
                case 4: {
                    diceImage(roll);
                    userTurnScore += roll;
                    turnScore.setText("  your turn score:" + " " + String.valueOf(userTurnScore));
                    break;
                }
                case 5: {
                    diceImage(roll);
                    userTurnScore += roll;
                    turnScore.setText("  your turn score:" + " " + String.valueOf(userTurnScore));
                    break;
                }
                case 6: {
                    diceImage(roll);
                    userTurnScore += roll;
                    turnScore.setText("  your turn score:" + " " + String.valueOf(userTurnScore));
                    break;
                }
            }

        }


    public void holdClicked(View v){
        userOverallScoreState += userTurnScore;
        userTurnScore = 0;
        final TextView turnScore = (TextView)findViewById(R.id.textView3);
        turnScore.setText(String.valueOf(userOverallScoreState));
        computerTurn();
        winner();


    }

    public void resetClicked(View v){
        winner();
        final TextView winScore = (TextView)findViewById(R.id.textView6);
        userTurnScore = 0;
        userOverallScoreState = 0;
        computerOverallScore = 0;
        computerTurnScore = 0;
        final TextView PlayerScore = (TextView)findViewById(R.id.textView3);
        PlayerScore.setText(String.valueOf(userTurnScore));
        final TextView currentScore = (TextView)findViewById(R.id.textView5);
        final TextView computerScore = (TextView)findViewById(R.id.textView4);
        computerScore.setText(String.valueOf(computerTurnScore));
        currentScore.setText("");
        winScore.setText("");
    }


    public void computerTurn(){

        final TextView turnScore = (TextView)findViewById(R.id.textView5);
        int count = 0;

        Random rand = new Random();
        while (count != 1){

            computerOverallScore += computerTurnScore;
            int  roll = rand.nextInt(6) + 1;
            if (computerOverallScore > userOverallScoreState)
            {
                final TextView cScore = (TextView)findViewById(R.id.textView4);
                cScore.setText(String.valueOf(computerOverallScore));
                winner();
                return;
            }
            if (computerTurnScore >= 20)
            {
                turnScore.setText("  Computer holds");
                final TextView cScore = (TextView)findViewById(R.id.textView4);
                cScore.setText(String.valueOf(computerOverallScore));
                winner();
                return;
            }

            switch (roll) {
                case 1: {
                    diceImage(roll);
                    computerTurnScore = 0;
                    count = 1;
                    turnScore.setText("  Computer rolls 1");
                    final TextView cScore = (TextView)findViewById(R.id.textView4);
                    cScore.setText(String.valueOf(computerOverallScore));
                    winner();
                    return;

                }
                case 2: {
                    diceImage(roll);
                    computerTurnScore += roll;
                    turnScore.setText("  Computer score:" + " " + String.valueOf(computerTurnScore));
                    break;
                }
                case 3: {
                    diceImage(roll);
                    computerTurnScore += roll;
                    turnScore.setText("  Computer score:" + " " + String.valueOf(computerTurnScore));
                    break;
                }
                case 4: {
                    diceImage(roll);
                    computerTurnScore += roll;
                    turnScore.setText("  Computer score:" + " " + String.valueOf(computerTurnScore));
                    break;
                }
                case 5: {
                    diceImage(roll);
                    computerTurnScore += roll;
                    turnScore.setText("  Computer score:" + " " + String.valueOf(computerTurnScore));
                    break;
                }
                case 6: {
                    diceImage(roll);
                    computerTurnScore += roll;
                    turnScore.setText("  Computer score:" + " " + String.valueOf(computerTurnScore));
                    break;
                }

            }

        }



    }

    public void diceImage(int roll){
        ImageView image = (ImageView) findViewById(R.id.imageView);
        if (roll == 1){
            image.setImageResource(R.drawable.dice1);
        }
        else if (roll == 2){
            image.setImageResource(R.drawable.dice2);
        }
        else if (roll == 3){
            image.setImageResource(R.drawable.dice3);
        }
        else if (roll == 4){
            image.setImageResource(R.drawable.dice4);
        }
        else if (roll == 5){
            image.setImageResource(R.drawable.dice5);
        }
        else if (roll == 6){
            image.setImageResource(R.drawable.dice6);
        }

    }
    public void winner(){
        final TextView winScore = (TextView)findViewById(R.id.textView6);
        if (userOverallScoreState >= 100)
        {

            winScore.setText("You Win!");
            userTurnScore = 0;
            userOverallScoreState = 0;
            computerOverallScore = 0;
            computerTurnScore = 0;
            final TextView PlayerScore = (TextView)findViewById(R.id.textView3);
            PlayerScore.setText(String.valueOf(userTurnScore));
            final TextView currentScore = (TextView)findViewById(R.id.textView5);
            final TextView computerScore = (TextView)findViewById(R.id.textView4);
            computerScore.setText(String.valueOf(computerTurnScore));
            currentScore.setText("");

        }
        else if (computerOverallScore >= 100)
        {

            winScore.setText("Computer Wins!");
            userTurnScore = 0;
            userOverallScoreState = 0;
            computerOverallScore = 0;
            computerTurnScore = 0;
            final TextView PlayerScore = (TextView)findViewById(R.id.textView3);
            PlayerScore.setText(String.valueOf(userTurnScore));
            final TextView currentScore = (TextView)findViewById(R.id.textView5);
            final TextView computerScore = (TextView)findViewById(R.id.textView4);
            computerScore.setText(String.valueOf(computerTurnScore));
            currentScore.setText("");

        }
    }

}
