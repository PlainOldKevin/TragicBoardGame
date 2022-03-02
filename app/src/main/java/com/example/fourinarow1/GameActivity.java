package com.example.fourinarow1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.gridlayout.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements IGame {

    Random random = new Random();
    int cm;
    final int[] board = new int[36];
    private String playerName = null;
    private int player = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        player = 0;

        playerName = getIntent().getStringExtra("input"); // get player name

        this.makeBoardArray(); // make board


    }

    @Override
    public void clearBoard() {
    }

    @Override
    public void setMove(int player, int location) {

    }

    @Override
    public int getComputerMove() { // set computer move

        cm = random.nextInt(36);

        return cm;
    }

    @Override
    public int checkForWinner() {
        return 0;
    }


    public void makeBoardArray() {


        GridLayout grid = findViewById(R.id.gridLayout2);
        int i = 0;
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                Button but = new Button(this);
                but.setId(i);
                but.setBackgroundResource(R.drawable.empty_button);
                grid.addView(but, 180, 180);
                but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (board[but.getId()] == EMPTY) {
                            if (player == 0 && board[but.getId()] != RED) {
                                but.setBackgroundResource(R.drawable.blue_button);
                                board[but.getId()] = BLUE;
                                player = 1;
                            } else {
                                int k = 0;
                                Random random1 = new Random();
                                int comp = random1.nextInt(36);
                                while (k == 0) {
                                    if (board[comp] == EMPTY) {
                                        board[comp] = RED;
                                        but.setBackgroundResource(R.drawable.red_button);
                                        k = 1;
                                    } else {
                                        comp = random1.nextInt(36);
                                    }
                                }
                                player = 0;
                            }
                        } else {
                            Toast warning = Toast.makeText(getApplicationContext(), "Unable to choose this space", Toast.LENGTH_SHORT);
                            warning.show();
                        }
                    }
                });
                i++;
            }
        }

    }

}
