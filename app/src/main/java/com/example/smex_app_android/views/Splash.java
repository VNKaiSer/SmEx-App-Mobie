package com.example.smex_app_android.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.smex_app_android.R;
import com.example.smex_app_android.services.UserService;
import com.example.smex_app_android.services.impl.UserServiceImpl;

import java.util.Objects;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();


        Button startApp = findViewById(R.id.start);
        EditText moneyEditText = findViewById(R.id.money);
        EditText usernameEditText = findViewById(R.id.userName);
        UserService service = new UserServiceImpl(this);

        startApp.setOnClickListener(v -> {
            String moneyString = moneyEditText.getText().toString();
            int moneyInt = Integer.parseInt(moneyString);
            service.saveInformation(true, usernameEditText.getText().toString(),moneyInt);
            Intent intent = new Intent(Splash.this, MainActivity.class);
            startActivity(intent);
            finish();
        });


    }
}