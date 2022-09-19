package com.example.buttonsinputs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView textView;
    private Counter cCounter = new Counter(100, -100, 0, 1);
    private RadioGroup showValueAs;
    private int selectedID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView2);

        selectedID = showValueAs.getCheckedRadioButtonId();
        showValueAs =(RadioGroup)findViewById(R.id.showHexBinDec);


    }


    public void increment(View view) {

        textView.setText(cCounter.increment());
    }

    public void decrement(View view) {

        textView.setText(cCounter.decrement());
    }


    public void reset(View view) {

        counter = 0;
        textView.setText(Integer.toString(counter));

    }


}