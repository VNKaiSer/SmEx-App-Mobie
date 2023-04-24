package com.example.smex_app_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;

import com.example.adapter.AdapterPlan;
import com.example.entity.Plan;

import java.util.ArrayList;
import java.util.List;


public class PlanFrg extends Fragment {

    private boolean isEnable = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_plan, container, false);

        ListView listView;
        List<Plan> listPlan;
        AdapterPlan adapterPlan;
        Button btnEnable = view.findViewById(R.id.btnEnable);


        listView = view.findViewById(R.id.listPlan);

        listPlan = new ArrayList<>();
        listPlan.add(new Plan("long", 200000));
        listPlan.add(new Plan("tuyen", 100000));

        adapterPlan = new AdapterPlan(getContext(), R.layout.plan, listPlan);
        listView.setAdapter(adapterPlan);

        View parentView = adapterPlan.getView(0, null, listView);


        btnEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isEnable = !isEnable;
                adapterPlan.setEnable(isEnable);
                adapterPlan.notifyDataSetChanged();

            }
        });

        return view;
    }
}