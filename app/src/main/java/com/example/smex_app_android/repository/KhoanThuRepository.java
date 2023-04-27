package com.example.smex_app_android.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.smex_app_android.model.KhoanThu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class KhoanThuRepository implements ICRUD<KhoanThu>{
    private SQLiteDatabase sqLiteDatabase;

    public KhoanThuRepository(){
        sqLiteDatabase = DatabaseRepository.getInstace().getSqLiteDatabase();
    }

    @Override
    public boolean insert(KhoanThu obj) {
        ContentValues cv = new ContentValues();
        cv.put("maThuNhap", obj.getMaThu());
        cv.put("moTa", obj.getMoTa());
        cv.put("soTien", obj.getSoTien());
        System.out.println(""+ICRUD.formatter.format(obj.getNgayThu()));
        //cv.put("ngayThu",));
        long result = sqLiteDatabase.insert("ThuNhap", null, cv);
        return (result != -1);
    }

    @Override
    public KhoanThu get(int id) throws ParseException {
        String sql = "SELECT * FROM KhoanChi WHERE maKhoanChi = ?";
        String [] arvg = {id+""};
        Cursor query = sqLiteDatabase.rawQuery(sql, arvg);
        query.moveToNext();
        return new KhoanThu(query.getInt(0), query.getString(2),query.getDouble(3),ICRUD.formatter.parse(query.getString(1)));
    }

    @Override
    public List<KhoanThu> getAll() throws ParseException {
        List<KhoanThu> khoanThus = new ArrayList<>();
        String sql = "SELECT * FROM KhoanChi";
        Cursor query = sqLiteDatabase.rawQuery(sql, null);
        while (query.moveToNext()){
            KhoanThu tmp =  new KhoanThu(query.getInt(0), query.getString(2),query.getDouble(3),ICRUD.formatter.parse(query.getString(1)));
            khoanThus.add(tmp);
        }
        return khoanThus;
    }

}
