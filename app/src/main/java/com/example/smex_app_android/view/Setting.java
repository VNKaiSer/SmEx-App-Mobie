package com.example.smex_app_android.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.adapter.AdapterApp;
import com.example.entity.App;
import com.example.smex_app_android.R;

import java.util.ArrayList;
import java.util.List;


public class Setting extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.activity_more, container, false);
        ListView listView;
        List<App> listApp = new ArrayList<>();
        AdapterApp adapterApp;

        listView = view.findViewById(R.id.listApp);

        listApp.add(new App("baseline_settings_suggest_24", "Cài dặt chung"));
        listApp.add(new App("baseline_menu_book_24", "Hướng dẫn sử dụng"));
        listApp.add(new App("baseline_question_mark_24", "Câu hỏi thường gặp"));
        listApp.add(new App("baseline_share_24", "Mời bạn"));
        listApp.add(new App("baseline_star_half_24", "Đánh giá ứng dụng"));
        listApp.add(new App("baseline_question_mark_24", "Hỗ trợ kĩ thuật Zalo"));


        adapterApp = new AdapterApp(getContext(), R.layout.app_manager, listApp);
        listView.setAdapter(adapterApp);
        listView.setOnItemClickListener((adapterView, view1, i, l) -> {
           if(i == 0){
               Intent intent = new Intent(getContext(), SettingGeneral.class);
               startActivity(intent);
           }
        });

        return  view;
    }
}