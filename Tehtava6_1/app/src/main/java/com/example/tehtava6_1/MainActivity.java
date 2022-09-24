package com.example.tehtava6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_PRESIDENT_INFO = "com.example.tehtava6_1.PRESIDENT_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewPresidents = findViewById(R.id.listViewPresidents);

        listViewPresidents.setAdapter(new ArrayAdapter<>(
                this,
                R.layout.president_layout,
                PresidentData.getInstance().getPresidents()
        ));

        listViewPresidents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("item_click", "clicked " + i);
                Intent nextActivity = new Intent(MainActivity.this, PresidentDetailsActivity.class);
                nextActivity.putExtra(EXTRA_PRESIDENT_INFO, i);
                startActivity(nextActivity);

            }
        });

    }

}