package com.example.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;


import com.example.smex_app_android.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
public class CustomArrayAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList;
    private int mCurrentDay;

    public CustomArrayAdapter(Context context, List<String> list, int currentDay) {
        mContext = context;
        mList = list;
        mCurrentDay = currentDay;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.grid_item, null);
        }

        TextView tvDayOfMonth = view.findViewById(R.id.text_view);

        String dayOfMonth = mList.get(position);
        tvDayOfMonth.setText(dayOfMonth);
        if (Integer.parseInt(dayOfMonth) == mCurrentDay) {
            tvDayOfMonth.setTextColor(ContextCompat.getColor(mContext, R.color.white));
            tvDayOfMonth.setBackgroundColor(Color.parseColor("#068EE0"));


        } else if (Integer.parseInt(dayOfMonth) > mCurrentDay) {
            tvDayOfMonth.setTextColor(ContextCompat.getColor(mContext, R.color.black));
        } else {
            tvDayOfMonth.setTextColor(ContextCompat.getColor(mContext, R.color.white));
            tvDayOfMonth.setBackgroundColor(Color.parseColor("#068EE0"));
        }


        return view;
    }

}
