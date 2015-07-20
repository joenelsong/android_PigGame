package com.example.jnelson.assignment2_piggame;

/**
 * Created by Jnelson on 7/19/2015.
 */

import android.app.Activity;
import android.os.Bundle;


public class FirstActivity extends Activity {

    private PigGame game;   // Created and managed in FirstFragment

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
