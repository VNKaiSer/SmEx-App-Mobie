package com.example.smex_app_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.adapter.CustomArrayAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Home extends Fragment {

    private TextView currDay, time;
    private Button btnThemKhoanChiTieu;
    private ImageButton btnSwapFragment;
    private LinearLayout screen_home_1, screen_home_2;
    private boolean isScreenHome1Visible = true;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("start_app", getActivity().MODE_PRIVATE);
        int money = sharedPreferences.getInt("money", 0);
        String currentPrice = String.valueOf(money);
        if (money >= 1000) {
            StringBuilder temp = new StringBuilder();
            int count = 0;
            for (int j = currentPrice.length() - 1; j >= 0; j--) {
                temp.insert(0, currentPrice.charAt(j));
                count++;
                if (count == 3 && j != 0) {
                    temp.insert(0, ",");
                    count = 0;
                }
            }
            currentPrice = temp.toString();
        }

        TextView txtMoney = view.findViewById(R.id.totalMoney);
        txtMoney.setText("$" + currentPrice);
        Calendar calendar = Calendar.getInstance();
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentYear = calendar.get(Calendar.YEAR);
        btnThemKhoanChiTieu = view.findViewById(R.id.btnThemKhoanChiTieu);
        screen_home_1 = view.findViewById(R.id.screen_home_1);
        screen_home_2 = view.findViewById(R.id.screen_home_2);
        currDay = view.findViewById(R.id.currentDay);
        currDay.setText("HÔM NAY," + currentDay + "/" + currentMonth + "/" + currentYear);

        time = view.findViewById(R.id.time);
        time.setText("Tháng " + currentMonth + "/" + currentYear);


        btnThemKhoanChiTieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Spending.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });

        btnSwapFragment = view.findViewById(R.id.swaphome);

        btnSwapFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (screen_home_1.getVisibility() == View.VISIBLE) {
                    screen_home_1.setVisibility(View.GONE);
                    screen_home_2.setVisibility(View.VISIBLE);
                } else {
                    screen_home_1.setVisibility(View.VISIBLE);
                    screen_home_2.setVisibility(View.GONE);
                }
            }
        });

        //get all day in month

        List<String> listDay = new ArrayList<>();
        for (int i = 0; i < maxDay; i++) {
            listDay.add(String.valueOf(i + 1));
        }


        GridView mGridView = view.findViewById(R.id.grid_view);
        CustomArrayAdapter mAdapter = new CustomArrayAdapter(getActivity(), listDay, currentDay);
        mGridView.setAdapter(mAdapter);

        return view;
    }
}

