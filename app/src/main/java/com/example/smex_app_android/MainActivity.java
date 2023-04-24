package com.example.smex_app_android;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final int HOME_REQUEST_CODE = 1;
    private static final int ANALYSIS_REQUEST_CODE = 2;
    private static final int PLAN_REQUEST_CODE = 3;
    private static final int SETTING_REQUEST_CODE = 4;

    BottomNavigationView bottomNavigationView;
    Home home = new Home();
    Analysis analysis = new Analysis();
    PlanFrg plan = new PlanFrg();
    Setting setting = new Setting();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, home).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, home).commit();
                        return true;
                    case R.id.analysis:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, analysis).commit();
                        return true;
                    case R.id.plan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, plan).commit();
                        return true;
                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, setting).commit();
                        return true;
                    default:
                        return false;


                }

            }
        });


    }
}
