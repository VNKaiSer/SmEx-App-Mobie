package com.example.smex_app_android.repositories;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smex_app_android.Application;

import java.text.ParseException;
import java.util.Date;


public class KhoanChiProvider extends ContentProvider {

    private static final String PROVIDER_NAME = "com.example.smex.KhoanChiProvider";
    private static final String _PATH = "KhoanChi";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/" + _PATH);

    private SQLiteDatabase database;

    @Override
    public boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            context = Application.getInstance(); // get application context instead
        }
        DataHelper dbHelper = new DataHelper(context, "KhoanChi",
                new String[]{"maKhoanChi", "loaiKhoanChi", "ngayChi", "moTa", "soTien"});
        database = dbHelper.getWritableDatabase();

        // Check if the table exists and create it if it doesn't
        if (!isTableExists(DataHelper.TABLE_NAME)) {
            dbHelper.onCreate(database);
        }

        return database != null;
    }

    private boolean isTableExists(String tableName) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{tableName});
        boolean tableExists = cursor.getCount() > 0;
        cursor.close();
        return tableExists;
    }


    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(DataHelper.TABLE_NAME);
        Cursor cursor = queryBuilder.query(database, projection, selection, selectionArgs,
                null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long rowId = database.insert(DataHelper.TABLE_NAME, null, values);
        if (rowId > 0) {
            Uri insertedUri = ContentUris.withAppendedId(CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(insertedUri, null);
            return insertedUri;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = database.delete(DataHelper.TABLE_NAME, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection,
                      @Nullable String[] selectionArgs) {
        int count = database.update(DataHelper.TABLE_NAME, values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    public SQLiteDatabase getReadableDatabase() {
        return database;
    }

    public int totalMoneyUsed() throws ParseException {
        int thang = new Date().getMonth();
        //getAll().forEach();
        return 0;
    }
}
