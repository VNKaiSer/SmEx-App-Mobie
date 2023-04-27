package com.example.smex_app_android.services.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.example.smex_app_android.models.KhoanChi;
import com.example.smex_app_android.models.LoaiKhoanChi;
import com.example.smex_app_android.repositories.KhoanChiProvider;
import com.example.smex_app_android.services.CRUDService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class KhoanChiServiceImpl implements CRUDService<KhoanChi> {
    private KhoanChiProvider khoanChiProvider;
    private Context context;

    public KhoanChiServiceImpl(Context context) {
        khoanChiProvider = new KhoanChiProvider();
        khoanChiProvider.onCreate();
        this.context = context;

    }

    @Override
    public boolean insert(KhoanChi obj) {
        ContentValues cv = new ContentValues();
        cv.put("loaiKhoanChi", obj.getLoaiKhoanChi().toString());
        cv.put("ngayChi", obj.getNgayChi());
        cv.put("moTa", obj.getMoTa());
        cv.put("soTien", obj.getSoTien());
        Uri uri = context.getContentResolver().insert(KhoanChiProvider.CONTENT_URI, cv);
        return (uri != null);
    }

    @Override
    public KhoanChi get(int id) throws ParseException {
//        return khoanChiProvider.get(id);
        return null;
    }

    @Override
    public List<KhoanChi> getAll(Class<KhoanChi> clazz) {
        List<KhoanChi> khoanChis = new ArrayList<>();
        Cursor cursor = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            cursor = context.getContentResolver().query(KhoanChiProvider.CONTENT_URI, null, null, null);
        }

        while (cursor.moveToNext()) {
            KhoanChi tmp = new KhoanChi(cursor.getInt(0), LoaiKhoanChi.valueOf(cursor.getString(1)), cursor.getString(2), cursor.getString(3), cursor.getDouble(4));
            khoanChis.add(tmp);
        }
        return khoanChis;
    }
}
