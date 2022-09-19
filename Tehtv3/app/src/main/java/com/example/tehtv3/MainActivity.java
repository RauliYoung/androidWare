package com.example.tehtv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    private TextView textView;
    private Counter cCounter = new Counter();
    private RadioGroup showValueAs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        showValueAs=findViewById(R.id.radioGroup);
        textView.setText(showValue(cCounter.getCurrentValue()));
        showValueAs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                textView.setText(showValue(cCounter.getCurrentValue()));
            }
        });


    }
    public void increment(View view) {
        textView.setText(cCounter.increment());
        textView.setText(showValue(cCounter.getCurrentValue()));
    }

    public void decrement(View view) {
        textView.setText(cCounter.decrement());
        textView.setText(showValue(cCounter.getCurrentValue()));
    }


    public void reset(View view) {
        cCounter.reset();
        textView.setText(showValue(cCounter.getCurrentValue()));
    }
    public String showValue (int luku) {
        int selectedId = (showValueAs).getCheckedRadioButtonId();
        if(selectedId == R.id.radioButtonDec) {
            return Integer.toString(luku);
        }else if (selectedId == R.id.radiotButtonBin) {
            return Integer.toBinaryString(luku);
        }else{
            return Integer.toHexString(luku);
        }

    }
}