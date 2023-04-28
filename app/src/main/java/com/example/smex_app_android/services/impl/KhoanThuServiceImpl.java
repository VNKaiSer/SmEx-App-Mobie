package com.example.smex_app_android.services.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.example.smex_app_android.models.KhoanThu;
import com.example.smex_app_android.repositories.KhoanChiProvider;
import com.example.smex_app_android.repositories.KhoanThuProvider;
import com.example.smex_app_android.services.CRUDService;
import com.example.smex_app_android.services.KhoanThuService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class KhoanThuServiceImpl implements KhoanThuService {
    private KhoanThuProvider khoanChiProvider;
    private Context context;

    public KhoanThuServiceImpl(Context context) {
        khoanChiProvider = new KhoanThuProvider();
        khoanChiProvider.onCreate();
        this.context = context;

    }

    @Override
    public boolean insert(KhoanThu obj) {
        ContentValues cv = new ContentValues();
        cv.put("moTa", obj.getMoTa());
        cv.put("soTien", obj.getSoTien());
        cv.put("ngayThu", obj.getNgayThu());
        Uri uri = context.getContentResolver().insert(KhoanThuProvider.CONTENT_URI, cv);
        return (uri != null);
    }

    @Override
    public KhoanThu get(int id) throws ParseException {
//        return khoanChiProvider.get(id);
        return null;
    }

    @Override
    public List<KhoanThu> getAll() {
        List<KhoanThu> khoanChis = new ArrayList<>();
        Cursor cursor = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            cursor = context.getContentResolver().query(KhoanChiProvider.CONTENT_URI, null, null, null);
        }

        while (cursor.moveToNext()) {
//           Khoa
        }
        return khoanChis;
    }
}