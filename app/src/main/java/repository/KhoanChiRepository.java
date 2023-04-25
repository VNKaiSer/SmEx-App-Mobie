package repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.KhoanChi;
import model.LoaiKhoanChi;

public class KhoanChiRepository implements ICRUD<KhoanChi> {
    private SQLiteDatabase sqLiteDatabase;

    public KhoanChiRepository(){
        sqLiteDatabase = DatabaseRepository.getInstace().getSqLiteDatabase();
    }


    @Override
    public boolean insert(KhoanChi obj) {
        ContentValues cv = new ContentValues();
        cv.put("maKhoanChi", obj.getMaKhoanChi());
        cv.put("maLoai", obj.getLoaiKhoanChi().toString());
        cv.put("ngayChi", ICRUD.formatter.format(obj.getNgayChi()));
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
        return new KhoanChi(query.getInt(1), LoaiKhoanChi.valueOf(query.getString(2)), ICRUD.formatter.parse(query.getString(3)), query.getString(4),query.getDouble(5));
    }

    @Override
    public List<KhoanChi> getAll() throws ParseException {
        List<KhoanChi> khoanChis = new ArrayList<>();
        String sql = "SELECT * FROM KhoanChi";
        Cursor query = sqLiteDatabase.rawQuery(sql, null);
        while (query.moveToNext()){
           KhoanChi tmp =  new KhoanChi(query.getInt(1), LoaiKhoanChi.valueOf(query.getString(2)), ICRUD.formatter.parse(query.getString(3)), query.getString(4), query.getDouble(5));
            khoanChis.add(tmp);
        }
        return khoanChis;
    }
}
