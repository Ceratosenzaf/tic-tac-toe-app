package com.example.ticttactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 1;
    boolean gameOver = false;
    int[] table = {
            0, 0, 0,
            0, 0, 0,
            0, 0, 0
    };

    public void imageClick(View view) {
        ImageView box = (ImageView) view;
        int counter = Integer.parseInt(box.getTag().toString());

        if(table[counter] == 0 && !gameOver){
            addToBox(box, counter);
            gameOver = check();


        }
    }

    public void addToBox(ImageView box, int counter) {
        box.setTranslationY(-1500);

        if (activePlayer == 1) {
            box.setImageResource(R.drawable.x);
            table[counter] = activePlayer;
            activePlayer = 2;
        } else {
            box.setImageResource(R.drawable.o);
            table[counter] = activePlayer;
            activePlayer = 1;
        }

        box.animate().translationYBy(1500).setDuration(300);
    }

    public boolean check () {
        // rows
        if (table[0] == table[1] && table[1] == table[2] && table[0] != 0) {
            System.out.println("You Won!!!");
            return true;
        }
        if (table[3] == table[4] && table[5] == table[4] && table[3] != 0) {
            System.out.println("You Won!!!");
            return true;
        }
        if (table[6] == table[7] && table[7] == table[8] && table[7] != 0) {
            System.out.println("You Won!!!");
            return true;
        }

        // columns
        if (table[0] == table[3] && table[3] == table[6] && table[3] != 0) {
            System.out.println("You Won!!!");
            return true;
        }
        if (table[1] == table[4] && table[7] == table[4] && table[1] != 0) {
            System.out.println("You Won!!!");
            return true;
        }
        if (table[2] == table[5] && table[5] == table[8] && table[8] != 0) {
            System.out.println("You Won!!!");
            return true;
        }

        // diagonals
        if (table[0] == table[4] && table[4] == table[8] && table[0] != 0) {
            System.out.println("You Won!!!");
            return true;
        }
        if (table[2] == table[4] && table[4] == table[8] && table[8] != 0) {
            System.out.println("You Won!!!");
            return true;
        }

        //draw
        for (int i = 0; i < 9; i++) {
            if (table[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public void win () {
        playAgain();
    }

    public void draw () {
        playAgain();
    }

    public void playAgain () {
        for (int i = 0; i < 9; i++) {
            table[i] = 0;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
