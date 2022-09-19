package com.example.tehtava5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView created, visible, hit;
    private static final String LOGGER = "myLog";

    private Counter creations;
    private Counter hits;
    private Counter starts;

    private SharedPreferences sharedPreferences;

    private String creationCounterDataKey = "creationDataKey";
    private String visibleCounterDataKey = "visibleDataKey";
    private String hitsCounterDataKey = "hitsDataKey";

    private int creationCounterData;
    private int visibleCountData;
    private int hitsCountData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Main starts here!
        sharedPreferences = getSharedPreferences("logData", Activity.MODE_PRIVATE);
        creationCounterData = sharedPreferences.getInt(creationCounterDataKey, 0);
        visibleCountData = sharedPreferences.getInt(visibleCounterDataKey, 0);
        hitsCountData = sharedPreferences.getInt(hitsCounterDataKey, 0);



        creations = new Counter(100, -100, creationCounterData, 1);
        hits = new Counter(100, -100, hitsCountData,1);
        starts = new Counter(100, -100, visibleCountData, 1);

        created = findViewById(R.id.textViewCreationsCount);
        visible = findViewById(R.id.textViewVisiblesCount);
        hit = findViewById(R.id.textViewHitsShow);

        creations.increment();
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
        saveData(creationCounterDataKey, creations.getCurrentValue());
        saveData(visibleCounterDataKey, starts.getCurrentValue());
        saveData(hitsCounterDataKey, hits.getCurrentValue());
        updateTextView();
    }

    private void saveData(String key, int value) {
        SharedPreferences prefPut = getSharedPreferences("logData", Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putInt(key, value);
        prefEditor.commit();
        Toast.makeText(MainActivity.this, key + " count saved ", Toast.LENGTH_SHORT).show();
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