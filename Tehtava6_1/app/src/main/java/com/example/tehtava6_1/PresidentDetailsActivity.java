package com.example.tehtava6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class PresidentDetailsActivity extends AppCompatActivity {

    private TextView textViewName, textViewAlku, textViewLoppu, textViewLempiNimi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president_details);

        Bundle b = getIntent().getExtras();

        int i = b.getInt(MainActivity.EXTRA_PRESIDENT_INFO, 0);

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewAlku = findViewById(R.id.textViewAlku);
        TextView textViewLoppu = findViewById(R.id.textViewLoppu);
        TextView textViewLempiNimi = findViewById(R.id.textViewLempiNimi);
        Log.i("Index", "number " + i);

        textViewName.setText(PresidentData.getInstance().getPresidents().get(i).getNimi());
        textViewAlku.setText(Integer.toString(PresidentData.getInstance().getPresidents().get(i).getKaudenAlkuVuosi()));
        textViewLoppu.setText(Integer.toString(PresidentData.getInstance().getPresidents().get(i).getKaudenLoppuVuosi()));
        textViewLempiNimi.setText(PresidentData.getInstance().getPresidents().get(i).getLempiNimi());


    }

}