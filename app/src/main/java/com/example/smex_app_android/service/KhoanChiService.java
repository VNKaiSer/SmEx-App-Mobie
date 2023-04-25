package com.example.smex_app_android.service;

import com.example.smex_app_android.model.KhoanChi;
import com.example.smex_app_android.repository.KhoanChiRepository;

import java.text.ParseException;
import java.util.List;

public class KhoanChiService implements CRUDService<com.example.smex_app_android.model.KhoanChi> {
    private KhoanChiRepository khoanChiRepository;

    public KhoanChiService(){
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
