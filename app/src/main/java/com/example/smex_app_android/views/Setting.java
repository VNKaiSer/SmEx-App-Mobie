package com.example.smex_app_android.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.AdapterApp;
import com.example.entity.App;
import com.example.smex_app_android.R;
import com.example.smex_app_android.services.UserService;
import com.example.smex_app_android.services.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class Setting extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_more, container, false);
        ListView listView;
        List<App> listApp = new ArrayList<>();
        AdapterApp adapterApp;

        listView = view.findViewById(R.id.list_view_app);
        Button chuyen = view.findViewById(R.id.chuyen);
        chuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingGeneral.class);
                startActivity(intent);
            }
        });

        listApp.add(new App("baseline_settings_suggest_24", "Cài dặt chung"));
        listApp.add(new App("baseline_menu_book_24", "Hướng dẫn sử dụng"));
        listApp.add(new App("baseline_question_mark_24", "Câu hỏi thường gặp"));
        listApp.add(new App("baseline_share_24", "Mời bạn"));
        listApp.add(new App("baseline_star_half_24", "Đánh giá ứng dụng"));
        listApp.add(new App("baseline_question_mark_24", "Hỗ trợ kĩ thuật Zalo"));

        adapterApp = new AdapterApp(getContext(), R.layout.app_manager, listApp);
        listView.setAdapter(adapterApp);
        UserService service = new UserServiceImpl(getContext());
        TextView nameAvatar = view.findViewById(R.id.nameAvatar);
        nameAvatar.setText(service.getUserName().substring(0, 1).toUpperCase());


        return view;
    }
}