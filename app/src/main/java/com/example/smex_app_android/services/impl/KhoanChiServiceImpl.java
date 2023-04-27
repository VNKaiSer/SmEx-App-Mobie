package com.example.smex_app_android.services.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;

import com.example.smex_app_android.models.KhoanChi;
import com.example.smex_app_android.models.LoaiKhoanChi;
import com.example.smex_app_android.repositories.KhoanChiProvider;
import com.example.smex_app_android.services.CRUDService;
import com.example.smex_app_android.services.KhoanChiService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class KhoanChiServiceImpl implements KhoanChiService {
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
    public List<KhoanChi> getAll() {
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

    public int totalMoneyUsed() {


        AtomicInteger totalMoney = new AtomicInteger();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate currentDate = LocalDate.now();
            int monthC = currentDate.getMonthValue();
            int yearC = currentDate.getYear();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                getAll().forEach(
                        s->{
                            DateTimeFormatter formatter = null;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

                                LocalDate date = LocalDate.parse(s.getNgayChi(), formatter);
                                int month = date.getMonthValue();
                                int year = date.getYear();
                                if (month == monthC && year == yearC){
                                    totalMoney.addAndGet((int) s.getSoTien());
                                }
                            }
                        }
                );
            }
        }
        return totalMoney.get();
    }

    public boolean checkUsedMoneyThisDay() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDate currentDate = LocalDate.now();
            int monthC = currentDate.getMonthValue();
            int yearC = currentDate.getYear();
            for (KhoanChi s :
                    getAll()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                LocalDate date = LocalDate.parse(s.getNgayChi(), formatter);
                int month = date.getMonthValue();
                int year = date.getYear();
                if (month == monthC && year == yearC) return true;
            }
        }
        return false;

    }

    public ArrayList<String> getKhoanChiStringByDay() {
        ArrayList<String> data = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate currentDate = LocalDate.now();
            int monthC = currentDate.getMonthValue();
            int yearC = currentDate.getYear();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                AtomicInteger stt = new AtomicInteger(1);
                getAll().forEach(
                        s->{
                            DateTimeFormatter formatter = null;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

                                LocalDate date = LocalDate.parse(s.getNgayChi(), formatter);
                                int month = date.getMonthValue();
                                int year = date.getYear();
                                if (month == monthC && year == yearC){
                                    data.add((stt.getAndIncrement()) + " - " + s.getLoaiKhoanChi() +" - " + s.getSoTien() +" $");
                                }
                            }
                        }
                );
            }
        }
        return data;
    }
}
