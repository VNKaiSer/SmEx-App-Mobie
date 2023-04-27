package com.example.smex_app_android.service.impl;

import android.content.Context;

import com.example.smex_app_android.repository.UserReposity;
import com.example.smex_app_android.service.UserService;

public class UserServiceImpl implements UserService {
    private UserReposity reposity;
    private Context context;
    public UserServiceImpl(Context context){
        this.context = context;
        reposity = new UserReposity(context);
    }
    @Override
    public void saveInformation(boolean check, String userName, int money) {
        reposity.saveInformation(check, userName, money);
    }

    @Override
    public boolean checkerFirstStartApp() {
        return reposity.checkerFirstStartApp();
    }

    @Override
    public int getMoney() {
        return reposity.getMoney();
    }

    @Override
    public boolean useMoney(int money) {
        return reposity.useMoney(money);
    }

    @Override
    public String getUserName() {
        return reposity.getUserName();
    }
}
