package com.example.smex_app_android.service.impl;

import com.example.smex_app_android.model.KhoanChi;
import com.example.smex_app_android.repository.KhoanChiRepository;
import com.example.smex_app_android.service.KhoanChiService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class KhoanChiServiceImpl implements KhoanChiService {
    private KhoanChiRepository khoanChiRepository;

    public KhoanChiServiceImpl(){
        khoanChiRepository = new KhoanChiRepository();
    }

    @Override
    public boolean insert(KhoanChi obj) {
        return khoanChiRepository.insert(obj);
    }

    @Override
    public KhoanChi get(int id) throws ParseException {
        return khoanChiRepository.get(id);
    }

    @Override
    public List<KhoanChi> getAll(Class<KhoanChi> clazz) throws ParseException {
        return khoanChiRepository.getAll();
    }

    @Override
    public int totalMoneyUsed() throws ParseException {
        return khoanChiRepository.totalMoneyUsed();
    }

    @Override
    public boolean checkUsedMoneyThisDay() throws ParseException {
        return khoanChiRepository.checkUsedMoneyThisDay();
    }

    @Override
    public ArrayList<String> getKhoanChiStringByDay() throws ParseException {
        return khoanChiRepository.getKhoanChiStringByDay();
    }
}
