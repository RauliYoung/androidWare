package com.example.tehtava_4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class display_message extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);


        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.NAME);
        String age = intent.getStringExtra(MainActivity.AGE);



        TextView textView = findViewById(R.id.textViewMessage);
        textView.setText("Hello " + name + ", you are " + age + " year old");
    }
}