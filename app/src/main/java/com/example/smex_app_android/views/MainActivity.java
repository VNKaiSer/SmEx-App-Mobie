package com.example.smex_app_android.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Xml;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.entity.Plan;
import com.example.smex_app_android.R;
import com.example.smex_app_android.services.UserService;
import com.example.smex_app_android.services.impl.UserServiceImpl;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.xmlpull.v1.XmlSerializer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
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
        UserService userService = new UserServiceImpl(this);
        boolean startAppChecked = userService.checkerFirstStartApp();
        

        if (startAppChecked) {
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
        } else {
            Intent intent = new Intent(this, Splash.class);
            startActivity(intent);
            finish();
        }


    }

}
