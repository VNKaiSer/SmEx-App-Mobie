package com.example.smex_app_android.services;

public interface UserService {
    void saveInformation(boolean check, String userName, int money);
    boolean checkerFirstStartApp();
    int getMoney();
    boolean useMoney(int money);
    String getUserName();
}
