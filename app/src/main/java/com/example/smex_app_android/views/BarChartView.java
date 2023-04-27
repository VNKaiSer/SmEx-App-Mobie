package com.example.smex_app_android.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BarChartView extends View {
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private int mPadding;
    private int mBarWidth;
    private int[] mData;
    private String[] mLabels;
    private int[] mExpenses;

    public BarChartView(Context context) {
        super(context);
        init();
    }

    public BarChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPadding = 32;
        mBarWidth = 64;
        mData = new int[]{1000, 1500, 2000, 2500, 3000, 2800, 2600, 2400, 2200, 2000, 1800, 1600};
        mLabels = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        mExpenses = new int[]{500, 750, 1000, 1250, 1500, 1400, 1300, 1200, 1100, 1000, 900, 800};
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
            int barLeft = mPadding + i * (mBarWidth + mPadding);
            int barRight = barLeft + mBarWidth;
            int barTop = mPadding + (int) ((1 - (float) mData[i] / maxData) * barHeight);
            int barBottom = mHeight - mPadding * 2 - 32;

            mPaint.setColor(Color.BLUE);
            canvas.drawRect(barLeft, barTop, barRight, barBottom, mPaint);

            // Draw expense bar
            int expenseBarLeft = barLeft + mBarWidth / 4;
            int expenseBarRight = barRight - mBarWidth / 4;
            int expenseBarTop = mPadding + (int) ((1 - (float) mExpenses[i] / maxData) * barHeight);
            int expenseBarBottom = mHeight - mPadding * 2 - 32;

            mPaint.setColor(Color.RED);
            canvas.drawRect(expenseBarLeft, expenseBarTop, expenseBarRight, expenseBarBottom, mPaint);
        }

        // Draw x-axis label
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(24);
        for (int i = 0; i < mLabels.length; i++) {
            int labelX = mPadding + i * (mBarWidth + mPadding) + mBarWidth / 2;
            int labelY = mHeight - mPadding;
            canvas.drawText(mLabels[i], labelX, labelY, mPaint);
        }

        mPaint.setColor(Color.BLUE);
        canvas.drawRect(mPadding, mHeight - mPadding, mPadding + 32, mHeight - mPadding + 32, mPaint);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(24);
        canvas.drawText("Thu", mPadding + 48, mHeight - mPadding + 24, mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawRect(mPadding + 128, mHeight - mPadding, mPadding + 160, mHeight - mPadding + 32, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("Chi", mPadding + 176, mHeight - mPadding + 24, mPaint);
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


