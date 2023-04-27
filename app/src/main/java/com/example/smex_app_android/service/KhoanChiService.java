package com.example.smex_app_android.service;

import com.example.smex_app_android.model.KhoanChi;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface KhoanChiService extends  CRUDService<KhoanChi>{
    int totalMoneyUsed() throws ParseException;
    boolean checkUsedMoneyThisDay() throws ParseException;

    ArrayList<String> getKhoanChiStringByDay() throws ParseException;
}
