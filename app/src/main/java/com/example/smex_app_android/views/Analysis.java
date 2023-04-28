package com.example.smex_app_android.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smex_app_android.R;
import com.example.smex_app_android.services.UserService;
import com.example.smex_app_android.services.impl.UserServiceImpl;


public class Analysis extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_analysis, container, false);
        BarChartView chart = view.findViewById(R.id.bieuDo);
        BarChartViewCover chartViewCover = view.findViewById(R.id.bieuDoChi);
        UserService service = new UserServiceImpl(getContext());
        TextView nameAvatar = view.findViewById(R.id.nameAvatar);
        nameAvatar.setText(service.getUserName().substring(0, 1).toUpperCase());
        return view;
    }
}