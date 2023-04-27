package com.example.smex_app_android.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DualColumnChart extends View {

    private Paint mPaint;
    private float mColumnWidth;
    private float mColumnSpacing;
    private float mColumnHeight;
    private float mMaxValue;
    private float[] mThuData;
    private float[] mChiData;
    private int mNumColumns;
    private int mHeight;
    private int mWidth;

    public DualColumnChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mColumnWidth = 25;
        mColumnSpacing = 15;
        mColumnHeight = 0;
        mMaxValue = 0;
        mNumColumns = 0;
    }

    public void setData(float[] thuData, float[] chiData) {
        mThuData = thuData;
        mChiData = chiData;
        mNumColumns = thuData.length;
        for (int i = 0; i < mNumColumns; i++) {
            if (mThuData[i] > mMaxValue) {
                mMaxValue = mThuData[i];
            }
            if (mChiData[i] > mMaxValue) {
                mMaxValue = mChiData[i];
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mColumnHeight = mHeight * 0.8f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mThuData == null || mChiData == null) {
            return;
        }

        float totalColumnWidth = mColumnWidth * 2 + mColumnSpacing;
        float startX = (mWidth - (totalColumnWidth * mNumColumns - mColumnSpacing)) / 2;
        float x = startX;
        for (int i = 0; i < mNumColumns; i++) {
            float thuHeight = (mThuData[i] / mMaxValue) * mColumnHeight;
            float chiHeight = (mChiData[i] / mMaxValue) * mColumnHeight;

            // Vẽ cột thu
            mPaint.setColor(Color.BLUE);
            canvas.drawRect(x, mHeight - thuHeight, x + mColumnWidth, mHeight, mPaint);

            // Vẽ cột chi
            mPaint.setColor(Color.RED);
            canvas.drawRect(x + mColumnWidth + mColumnSpacing, mHeight - chiHeight, x + totalColumnWidth, mHeight, mPaint);

            // Vẽ tháng
            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(30);
            String month = Integer.toString(i + 1);
            float monthWidth = mPaint.measureText(month);
            float monthX = x + mColumnWidth / 2 - monthWidth / 2;
            float monthY = mHeight + 40;
            canvas.drawText(month, monthX, monthY, mPaint);

            x += totalColumnWidth;
        }

        // Vẽ đường trục x
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(2);
        canvas.drawLine(startX, mHeight, x - totalColumnWidth + mColumnWidth, mHeight, mPaint);

        // Vẽ đường trục y
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(2);
        canvas.drawLine(startX, 0, startX, mHeight, mPaint);

        // Vẽ chữ "$"
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(40);
        canvas.drawText("Tháng", mWidth - 100, mHeight - 20, mPaint);
        canvas.translate(20, 50);
    }


}
