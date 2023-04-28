package com.example.smex_app_android.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BarChartViewCover extends View {

    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private int mPadding;
    private int mBarWidth;
    private int[] mData;
    private String[] mLabels;
    private int[] mExpenses;

    public BarChartViewCover(Context context) {
        super(context);
        init();
    }

    public BarChartViewCover(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPadding = 32;
        mBarWidth = 64;
        mData = new int[]{500, 750, 1000, 1250, 1500, 1400, 1300, 1200, 1100, 1000, 900, 800};
        mLabels = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw white background
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);

        // Draw y-axis label
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(24);
        canvas.drawText("$", mPadding / 2, mPadding, mPaint);

        int maxData = getMaxData();
        int barHeight = mHeight - mPadding * 3 - 32;

        // Draw bars
        for (int i = 0; i < mData.length; i++) {
            int barLeft = mPadding;
            int barRight = barLeft + (int) ((float) mData[i] / maxData * (mWidth - mPadding * 2));
            int barTop = mPadding + i * (mBarWidth + mPadding);
            int barBottom = barTop + mBarWidth;

            mPaint.setColor(Color.RED);
            canvas.drawRect(barLeft, barTop, barRight, barBottom, mPaint);
        }
        // Draw x-axis label
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(24);
        for (int i = 0; i < mLabels.length; i++) {
            int labelX = mPadding + i * (mBarWidth + mPadding) + mBarWidth / 2;
            int labelY = mHeight - mPadding;
            canvas.drawText(mLabels[i], labelX, labelY, mPaint);
        }



    }


    private int getMaxData() {
        int max = 0;
        for (int data : mData) {
            if (data > max) {
                max = data;
            }
        }
        return max;
    }
}


