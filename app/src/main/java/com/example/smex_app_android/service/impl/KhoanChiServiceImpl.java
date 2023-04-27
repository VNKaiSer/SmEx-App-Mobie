package com.example.smex_app_android.service.impl;

import com.example.smex_app_android.model.KhoanChi;
import com.example.smex_app_android.repository.KhoanChiRepository;
import com.example.smex_app_android.service.CRUDService;

import java.text.ParseException;
import java.util.List;

public class KhoanChiServiceImpl implements CRUDService<KhoanChi> {
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
    public List<KhoanChi> getAll(Class<KhoanChi> clazz) {
        return null;
    }
}
