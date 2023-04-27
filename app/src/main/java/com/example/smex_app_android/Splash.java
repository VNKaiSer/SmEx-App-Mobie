package com.example.smex_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class Splash extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();

        sharedPreferences = getSharedPreferences("start_app", MODE_PRIVATE);
        Button startApp = findViewById(R.id.start);
        EditText moneyEditText = findViewById(R.id.money);
        EditText usernameEditText = findViewById(R.id.userName);


        startApp.setOnClickListener(v -> {
            String moneyString = moneyEditText.getText().toString();
            int moneyInt = Integer.parseInt(moneyString);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isMoney", true);
            editor.putInt("money", moneyInt);
            editor.putString("username", usernameEditText.getText().toString());
            editor.apply();
            Intent intent = new Intent(Splash.this, MainActivity.class);
            startActivity(intent);
            finish();
        });


    }
}