package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //    0==yellow 1==red 2==null
    int playerstituation[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int winnigposition[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameactive = true;
    int activeplayer = 0;

    public void dropin(View view) {
        ImageView counter = (ImageView) view;
        int tappedcounter = Integer.parseInt(counter.getTag().toString());
        if (playerstituation[tappedcounter] == 2 && gameactive == true) {
            counter.setTranslationY(-1500);
            playerstituation[tappedcounter] = activeplayer;
            String winner = "";
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.yellowdisk);
                playerstituation[tappedcounter] = 0;
                activeplayer = 1;
                winner = "YELLOW";
            } else {
                counter.setImageResource(R.drawable.reddisk);
                playerstituation[tappedcounter] = 1;
                activeplayer = 0;
                winner = "RED";
            }
            counter.animate().translationYBy(1500).setDuration(300);
            for (int[] i : winnigposition) {
                if (playerstituation[i[0]] == playerstituation[i[1]] && playerstituation[i[1]] == playerstituation[i[2]] && playerstituation[i[2]] != 2) {
                    gameactive = false;
                    Button boobs = (Button) findViewById(R.id.button);
                    TextView tiits = (TextView) findViewById(R.id.textView);
                    tiits.setText(winner + " has won");
                    tiits.setVisibility(View.VISIBLE);
                    boobs.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playAgain(View view) {
        Button boobs = (Button) findViewById(R.id.button);
        TextView Tiits = (TextView) findViewById(R.id.textView);
        Tiits.setVisibility(View.INVISIBLE);
        boobs.setVisibility(View.INVISIBLE);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView)gridLayout.getChildAt(i);
            counter.setImageDrawable(null);

        }
        for(int i=0;i<playerstituation.length;i++){
            playerstituation[i]=2;
        }
         gameactive = true;
         activeplayer = 0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
