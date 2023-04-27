package com.example.smex_app_android.repository;

import android.content.Context;
import android.content.SharedPreferences;

public class UserReposity {
    private SharedPreferences pre;
    private Context context;
    public UserReposity(Context context){
        this.context = context;
        this.pre = context.getSharedPreferences("user_info", context.MODE_PRIVATE);

    }
    public void saveInformation(boolean check, String userName, int money){
        SharedPreferences.Editor editor = pre.edit();
        editor.putBoolean("isMoney", check);
        editor.putInt("money", money);
        editor.putString("username",userName);
        editor.apply();
    }



    public boolean checkerFirstStartApp(){
        return pre.getBoolean("isMoney", false);
    }

    public int getMoney(){
        return pre.getInt("money", 0);
    }

    public boolean useMoney(int money){
        if (getMoney() - money < 0){
            return false;
        }

        SharedPreferences.Editor editor = pre.edit();
        editor.putInt("money", getMoney() - money);
        editor.apply();
        return true;
    }


}
