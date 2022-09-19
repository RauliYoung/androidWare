package com.example.tehtava5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tehtv3.Counter;

public class MainActivity extends AppCompatActivity {

    private TextView created, visible, hit;
    private static final String LOGGER = "myLog";
    private Counter creations = new Counter();
    private Counter hits = new Counter();
    private Counter starts = new Counter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creations.increment();

         created = findViewById(R.id.textViewCreationsCount);
         visible = findViewById(R.id.textViewVisiblesCount);
         hit = findViewById(R.id.textViewHitsShow);

         updateTextView();

        Button hitMe = findViewById(R.id.buttonHitMe);
        hitMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hits.increment();
                hit.setText(Integer.toString(hits.getCurrentValue()));
            }
        });

        Button reset = findViewById(R.id.buttonReset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creations.reset();
                hits.reset();
                starts.reset();
                updateTextView();
            }
        });


    }

    public void updateTextView() {
        created.setText(Integer.toString(creations.getCurrentValue()));
        visible.setText(Integer.toString(starts.getCurrentValue()));
        hit.setText(Integer.toString(hits.getCurrentValue()));
    }



    @Override
    protected void onStart() {
        super.onStart();
        starts.increment();
        Log.d(LOGGER, "From start");
        updateTextView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOGGER, "From resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOGGER, "From pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOGGER, "From stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOGGER, "From restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOGGER, "From destroy");
    }
}