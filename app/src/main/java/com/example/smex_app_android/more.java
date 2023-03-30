package com.example.smex_app_android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.entity.App;

import java.util.ArrayList;
import java.util.List;

public class more extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        getSupportActionBar().hide();
        ListView listView;
        List<App> listApp = new ArrayList<>();
        AdapterApp adapterApp;

        listView = findViewById(R.id.listApp);

        listApp.add(new App("info.jpg", "Cài dặt chung"));
        listApp.add(new App("info.jpg", "Hướng dẫn sử dụng"));
        listApp.add(new App("info.jpg", "Câu hỏi thường gặp"));
        listApp.add(new App("info.jpg", "Mời bạn"));
        listApp.add(new App("info.jpg", "Đánh giá ứng dụng"));
        listApp.add(new App("info.jpg", "Hỗ trợ kĩ thuật Zalo"));


        adapterApp = new AdapterApp(more.this, R.layout.app_manager, listApp);
        listView.setAdapter(adapterApp);



    }
}