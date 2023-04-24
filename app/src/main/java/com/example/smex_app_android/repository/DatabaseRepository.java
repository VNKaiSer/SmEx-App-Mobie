package com.example.smex_app_android.repository;

import android.database.sqlite.SQLiteDatabase;


public class DatabaseRepository {
    private static DatabaseRepository instace;
    private SQLiteDatabase sqLiteDatabase;

    DatabaseRepository(){
        String path ="/data/data/com.example.smex_app_android/files/qlct.db";
        sqLiteDatabase = SQLiteDatabase.openDatabase(path, null , SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    public static DatabaseRepository getInstace() {
        if (instace == null)
            instace = new DatabaseRepository();
        return instace;
    }

    public void close(){
        if (sqLiteDatabase != null)
            sqLiteDatabase.close();
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }
}
