package com.example.jnelson.assignment2_piggame;

/**
 * Created by Jnelson on 7/19/2015.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class FirstActivity extends ActionBarActivity {

    private PigGame game;   // Created and managed in FirstFragment
    private String player1name = "";
    private String player2name = "";

    public void SetName1(String s) {        player1name = s;    }
    public void SetName2(String s) {        player2name = s;    }

    public PigGame getGame() {
        return game;
    }

    public void setGame(PigGame game) {
        this.game = game;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_activity);
    }
}
