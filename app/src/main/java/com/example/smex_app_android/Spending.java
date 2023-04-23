package com.example.smex_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Spending extends AppCompatActivity {
    private List<Integer> mThumbIds = new ArrayList<>();
    private List<String> mThumbNames = new ArrayList<>();
    private Button btnTime, spen1, spen2, spen3, spen4, spen5, btnHuy;
    private TextView time;
    private EditText money;

    private int mYear, mMonth, mDay, mHour, mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending);
        getSupportActionBar().hide();

        btnHuy = findViewById(R.id.cancel);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
                Animation anim = AnimationUtils.loadAnimation(Spending.this, R.anim.slide_in_down);
                rootView.startAnimation(anim);
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // Display MainActivity when animation starts
                        Intent intent = new Intent(Spending.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        rootView.setVisibility(View.GONE); // Hide the view when animation is finished
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });


        mThumbIds.add(R.drawable.baseline_restaurant_24);
        mThumbIds.add(R.drawable.baseline_living_24);
        mThumbIds.add(R.drawable.baseline_directions_car_24);
        mThumbIds.add(R.drawable.baseline_beach_access_24);
        mThumbIds.add(R.drawable.baseline_beach_access_24);
        mThumbIds.add(R.drawable.baseline_child_care_24);
        mThumbIds.add(R.drawable.baseline_card_giftcard_24);
        mThumbIds.add(R.drawable.baseline_home_24);
        mThumbIds.add(R.drawable.baseline_monitor_heart_24);
        mThumbIds.add(R.drawable.baseline_more_horiz_24);
        mThumbIds.add(R.drawable.baseline_more_horiz_24);

        mThumbNames.add("Ăn tiệm");
        mThumbNames.add("Sinh hoạt");
        mThumbNames.add("Đi lại");
        mThumbNames.add("Trang phục");
        mThumbNames.add("Hưởng thụ");
        mThumbNames.add("Con cái");
        mThumbNames.add("Hiếu hỉ");
        mThumbNames.add("Nhà cửa");
        mThumbNames.add("Sức khỏe");
        mThumbNames.add("Bản thân");
        mThumbNames.add("Khác");

        spen1 = findViewById(R.id.spen1);
        spen2 = findViewById(R.id.spen2);
        spen3 = findViewById(R.id.spen3);
        spen4 = findViewById(R.id.spen4);
        spen5 = findViewById(R.id.spen5);
        money = findViewById(R.id.edtMoney);
        List<Button> btns = new ArrayList<>(
                Arrays.asList(spen1, spen2, spen3, spen4, spen5)
        );
        for (Button btn : btns) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    money.setText(btn.getText());
                }
            });
        }
        GridView mGridView = findViewById(R.id.grid_view);
        ImageAdapter mAdapter = new ImageAdapter(this, R.layout.sub_title, mThumbIds, mThumbNames);
        mGridView.setAdapter(mAdapter);
        mGridView.setScrollContainer(false);
        mGridView.setVerticalScrollBarEnabled(false);
        mGridView.setHorizontalScrollBarEnabled(false);
        btnTime = findViewById(R.id.time);
        time = findViewById(R.id.time_text);
        money = findViewById(R.id.edtMoney);

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int mYear,
                                          int mMonth, int mDay) {

                        time.setText(mDay + "/" + mMonth + "/" + mYear);
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(Spending.this,
                        dateSetListener, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });

    }
}