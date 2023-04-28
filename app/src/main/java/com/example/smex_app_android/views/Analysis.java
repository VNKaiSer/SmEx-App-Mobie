package com.example.smex_app_android.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smex_app_android.R;


public class Analysis extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_analysis, container, false);
        BarChartView chart = view.findViewById(R.id.bieuDo);
        BarChartViewCover chartViewCover = view.findViewById(R.id.bieuDoChi);

        return view;
    }
}