package com.example.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Integer stonkCounter;
    private String KEY = "COUNT_KEY";
    TextView stonkCounters;
    private SharedPreferences sharedPreferences;
    private final String sharedPrefFile = "com.example.myapplication";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        stonkCounter = sharedPreferences.getInt(KEY, 0);

        stonkCounters = findViewById(R.id.stonkCounter);
        stonkCounters.setText(stonkCounter.toString());

        findViewById(R.id.stonk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stonkCounter++;
                stonkCounters.setText(stonkCounter.toString());
                saveCount();

            }
        });
        findViewById(R.id.notStonk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stonkCounter--;
                stonkCounters.setText(stonkCounter.toString());
                saveCount();
            }
        });
    }
    private void saveCount(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putInt(KEY, stonkCounter);
        editor.apply();
    }
}
