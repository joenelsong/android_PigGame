package com.example.jnelson.assignment2_piggame;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jnelson on 7/19/2015.
 */
public class FirstFragment extends Fragment
                           implements OnClickListener {
    private boolean logging = true;

    private int PLAYTOSCORE = 100;
    private int SIDESONDIE = 6;
    private int NUMBEROFDICE = 1;
    private PigGame game; // Game Object

    private boolean twoPaneLayout;
    private EditText player1Name;
    private EditText player2Name;
    private Button startGame;

    private FirstActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.first_fragment, container, false);

        // Set this fragment to listen for the Play button's click event
        startGame = (Button) view.findViewById(R.id.start);
        startGame.setOnClickListener(this);

        player1Name = (EditText) view.findViewById(R.id.player1name);
        player2Name = (EditText) view.findViewById(R.id.player2name);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Get a references from the host activity
        activity = (FirstActivity)getActivity();

        // Make a new game object, use saved state if it exists
        if(savedInstanceState != null) {// Load Player and Temporary round scores
            game.getPlayers()[0].setmScore(savedInstanceState.getInt("mPlayer1_Score_save"));
            game.getPlayers()[1].setmScore(savedInstanceState.getInt("mPlayer2_Score_save"));
            game.setmTempScore(savedInstanceState.getInt("mTempScore_save"));
            ////UpdateScores(); // Update Scores UIs

            game.setmActivePlayerIndex(savedInstanceState.getInt("mActivePlayerIndex_Save"));
            //UpdateActivePlayer(); // Update UI

            game.setmDie(savedInstanceState.getInt("mDie_Save1"),0);
            //if (NUMBEROFDICE > 1) { game.setmDie(savedInstanceState.getInt("mDie_Save2"),1); }
            //if (NUMBEROFDICE > 1) { game.setmDie(savedInstanceState.getInt("mDie_Save3"),2); }
            ////UpdateDie(mDice[0], 1); // Update Die UI

            game.setmWinnerIndex(savedInstanceState.getInt("mWinnerIndex_save")); //Update Game State

        }
        if (logging) Log.d("FirstFragment", "Finish: OnActivityCreate()");

        else {
            game = new PigGame(PLAYTOSCORE, SIDESONDIE);
        }
        // Give the host activity a reference to the game object
        activity.setGame(game);

        // Check to see if FirstActivity has loaded a single or dual pane layout
        twoPaneLayout = activity.findViewById(R.id.second_fragment) != null;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.start) {
            Toast.makeText(getActivity(), "Staring Game", Toast.LENGTH_SHORT).show();
            game.getPlayers()[0].setmName(player1Name.getText().toString());  // Save Player1 entered name with game object
            game.getPlayers()[0].setmName(player2Name.getText().toString());  // Save Player2 entered name with game object
        }
            if(!twoPaneLayout) {
                Intent intent = new Intent(activity, SecondActivity.class);
                //int humanHandNum = game.getHumanHand().ordinal();
                //intent.putExtra("humanHand", humanHandNum);  // send state to 2nd activity
                startActivity(intent);
            }
    }

}


