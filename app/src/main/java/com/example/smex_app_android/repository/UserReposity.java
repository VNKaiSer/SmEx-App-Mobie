package com.example.smex_app_android.repository;

import android.content.Context;
import android.content.SharedPreferences;

public class UserReposity {
    private void savingPreferences(Context context){
        SharedPreferences pre = context.getSharedPreferences("loginStatus" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();

        editor.commit();
    }

    private void restorePreferences(Context context){
        SharedPreferences pre = context.getSharedPreferences("loginStatus", Context.MODE_PRIVATE);
        boolean bchk = pre.getBoolean("status", false);
    }
}
