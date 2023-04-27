package com.example.smex_app_android.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import com.example.smex_app_android.model.KhoanChi;
import com.example.smex_app_android.model.LoaiKhoanChi;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


public class KhoanChiRepository implements ICRUD<KhoanChi> {
    private SQLiteDatabase sqLiteDatabase;

    public KhoanChiRepository(){
        sqLiteDatabase = DatabaseRepository.getInstace().getSqLiteDatabase();
    }


    @Override
    public boolean insert(KhoanChi obj) {
        ContentValues cv = new ContentValues();
        cv.put("loaiKhoanChi", obj.getLoaiKhoanChi().toString());
        cv.put("ngayChi", obj.getNgayChi());
        cv.put("moTa", obj.getMoTa());
        cv.put("soTien", obj.getSoTien());
        long result = sqLiteDatabase.insert("KhoanChi", null, cv);
        return (result != -1);
    }

    @Override
    public KhoanChi get(int id) throws ParseException {
        String sql = "SELECT * FROM KhoanChi WHERE maKhoanChi = ?";
        String [] arvg = {id+""};
        Cursor query = sqLiteDatabase.rawQuery(sql, arvg);
        query.moveToNext();
        return new KhoanChi(query.getInt(0), LoaiKhoanChi.valueOf(query.getString(1)), query.getString(2), query.getString(3), query.getDouble(4));
    }

    @Override
    public List<KhoanChi> getAll() throws ParseException {
        List<KhoanChi> khoanChis = new ArrayList<>();
        String sql = "SELECT * FROM KhoanChi";
        Cursor query = sqLiteDatabase.rawQuery(sql, null);
        while (query.moveToNext()){
           KhoanChi tmp =  new KhoanChi(query.getInt(0), LoaiKhoanChi.valueOf(query.getString(1)), query.getString(2), query.getString(3), query.getDouble(4));
            khoanChis.add(tmp);
        }
        return khoanChis;
    }

    public int totalMoneyUsed() throws ParseException {


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

        System.out.println(totalMoney.get());

        return totalMoney.get();
    }

    public boolean checkUserMoneyThisDay() throws ParseException {
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
}
