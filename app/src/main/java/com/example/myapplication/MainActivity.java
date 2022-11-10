package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Boolean isLogin;
    public static String KEY = "Login_Key";
    public static SharedPreferences sharedPreferences;
    private final String sharedPrefFile = "com.example.myapplication";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        isLogin = sharedPreferences.getBoolean(KEY, false);
        if(isLogin){
            Intent intent = new Intent(MainActivity.this, Welcome.class);
            startActivity(intent);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        stonkCounters = findViewById(R.id.stonkCounter);
//        stonkCounters.setText(stonkCounter.toString());

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((TextView) findViewById(R.id.username)).getText().toString().equals("a")
                        && ((TextView) findViewById(R.id.password)).getText().toString().equals("b")
                ){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(KEY,true);
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, Welcome.class);
                    startActivity(intent);
                }
            }
        });
    }
    public static void logout(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY,false);
        editor.apply();
    }
}
