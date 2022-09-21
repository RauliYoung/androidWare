package com.example.tehtava6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class PresidentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president_details);

        Bundle b = getIntent().getExtras();
        int i = b.getInt(MainActivity.EXTRA_PRESIDENT_INFO, 0);

        TextView textViewName = findViewById(R.id.textViewName);

        textViewName.setText("Name is " + PresidentData.getInstance().getPresidents().get(i).getNimi());

    }
}