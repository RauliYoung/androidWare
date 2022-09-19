package com.example.exercise31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.buttonsinputs.Counter;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Counter counter = new Counter();
    private TextView textView;
    private RadioGroup showValueAs;
    private int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText(counter.startVal());

        selectedID = showValueAs.getCheckedRadioButtonId();


    }
    public void buttonPressed(View view) {
        if (view == findViewById(R.id.buttonPlus)) {
            textView.setText(counter.increment());
        } else if (view == findViewById(R.id.buttonMinus)) {
            textView.setText(counter.decrement());
        }else if(view == findViewById(R.id.buttonReset)){
            textView.setText(counter.reset());
        }
    }

}