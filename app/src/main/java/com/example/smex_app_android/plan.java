package com.example.smex_app_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;

import com.example.entity.Plan;

import java.util.ArrayList;
import java.util.List;

public class plan extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        ListView listView;
        List<Plan> listPlan;
        AdapterPlan adapterPlan;
        Button btnEnable = findViewById(R.id.btnEnable);


        listView = findViewById(R.id.listPlan);

        listPlan = new ArrayList<>();
        listPlan.add(new Plan("long", 2342));
        listPlan.add(new Plan("tuyen", 2342));

        adapterPlan = new AdapterPlan(plan.this, R.layout.plan, listPlan);
        listView.setAdapter(adapterPlan);

        View parentView = adapterPlan.getView(0, null, listView);
        SeekBar seekBar = parentView.findViewById(R.id.seekbar);

        if (!seekBar.isEnabled()) {
            // If it's disabled, enable it programmatically
            seekBar.setEnabled(true);
        }

        btnEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("click");
                seekBar.setEnabled(true);
            }
        });


    }
}