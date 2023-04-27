package com.example.smex_app_android.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.adapter.AdapterApp;
import com.example.entity.App;
import com.example.smex_app_android.R;

import java.util.ArrayList;
import java.util.List;

public class SettingGeneral extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_general);
        getSupportActionBar().hide();
        ListView listView;
        List<App> listApp = new ArrayList<>();
        AdapterApp adapterApp;

        listView = findViewById(R.id.list_app);
        Button cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(v -> {
            finish();
        });

        listApp.add(new App("Tổng quan", "Màn hình khởi động"));
        listApp.add(new App("", "Cài đặt thời gian"));
        listApp.add(new App("Hệ thống", "Chế độ nền tối"));
        listApp.add(new App("", "Màu sắc ứng dụng"));
        listApp.add(new App("Tiếng việt", "Ngôn ngữ"));
        listApp.add(new App("USD", "Loại tiền tệ"));


        adapterApp = new AdapterApp(this, R.layout.app_setting_general, listApp);
        listView.setAdapter(adapterApp);
    }
}