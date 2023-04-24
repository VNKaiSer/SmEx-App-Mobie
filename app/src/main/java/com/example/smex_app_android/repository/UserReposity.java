package com.example.smex_app_android.repository;

import android.content.Context;
import android.content.SharedPreferences;

public class UserReposity {
    private void getInformation(Context context){
        SharedPreferences pre = context.getSharedPreferences("user" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();

        editor.commit();
    }



    private void restorePreferences(Context context){
        SharedPreferences pre = context.getSharedPreferences("user", Context.MODE_PRIVATE);
    }
}
