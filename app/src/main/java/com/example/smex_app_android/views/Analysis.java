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
        float[] thuData = {2000, 1000, 1500, 2000, 600, 1500, 3000, 2000, 500, 8000, 2000, 1200};
        float[] chiData = {1000, 500, 1000, 900, 300, 800, 1400, 1500, 200, 3000, 1000, 1300};

        return view;
    }
}