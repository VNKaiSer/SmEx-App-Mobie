package com.example.smex_app_android.unitls;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.smex_app_android.Application;
import com.example.smex_app_android.R;

import java.util.Calendar;

public class NotificationUtils {
    public static void showNotification(Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("SmEx notification");
        builder.setContentText("Đã đến lúc kê khai chi tiêu rồi");
        builder.setSmallIcon(R.drawable.notification_alt_svgrepo_com);
        Notification notification = builder.build();
        // set thoi gian thong bao
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 16);
        calendar.set(Calendar.SECOND, 0);

        Intent intent = new Intent(context, Application.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);





    }

}
