package com.example.tehtava_4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String NAME = "com.example.tehtava_4_1.NAME";
    public static final String AGE = "com.example.tehtava_4_1.AGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, display_message.class);
        EditText editName = (EditText) findViewById(R.id.personName);
        EditText editAge = (EditText) findViewById(R.id.personAge);
        String name = editName.getText().toString();
        String age = editAge.getText().toString();
        intent.putExtra(NAME, name);
        intent.putExtra(AGE, age);
        startActivity(intent);
    }
}