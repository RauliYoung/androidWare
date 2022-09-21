package com.example.tehtava6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewPresidents = findViewById(R.id.listViewPresidents);
        listViewPresidents.setAdapter(new ArrayAdapter<President>(
            this, R.layout.president_layout,
                GlobalModel.getInstance().getPresidents()
        ));



    }
}