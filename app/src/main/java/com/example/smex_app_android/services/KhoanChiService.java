package com.example.smex_app_android.services;

import com.example.smex_app_android.models.KhoanChi;

import java.util.ArrayList;

public interface KhoanChiService extends CRUDService<KhoanChi>{
    int totalMoneyUsed();
    boolean checkUsedMoneyThisDay();
    ArrayList<String> getKhoanChiStringByDay();
}
