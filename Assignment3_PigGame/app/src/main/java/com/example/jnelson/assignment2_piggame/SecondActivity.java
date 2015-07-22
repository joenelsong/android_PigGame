package com.example.jnelson.assignment2_piggame;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity
{
    private boolean logging = true;
    private PigGame game;
    public void SetGame(PigGame g)    {        this.game = g;    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (logging) Log.d("SecondFragment", "Start: OnCreate()");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (logging) Log.d("SecondFragment", "Start: onNewIntent()");
        setIntent(intent);
        super.onNewIntent(intent);
    }

    @Override
    protected void onResume() {
        if (logging) Log.d("SecondFragment", "Start: onResume()");
        super.onResume();

        // Get the game state sent from the FirstActivity
        Intent intent = getIntent();
        // Get Extra saved values?

        if (game == null)   // We might already have a game object
            game = new PigGame(6, 1);
        //game.setHumanHand(humanHand);

        // Pass the fragment a game ref while calling the method invokes game play
        SecondFragment secondFragment = (SecondFragment)getFragmentManager().findFragmentById(R.id.second_fragment);
        //secondFragment.computerMove(game);
    }
}
