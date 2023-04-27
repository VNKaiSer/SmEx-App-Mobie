package com.example.smex_app_android.repositories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {

    public static String TABLE_NAME;
    private String[] columnNames;

    private static final String DB_NAME = "DatabaseApp.db";
    private static final int DB_VERSION = 1;

    public DataHelper(Context context, String tableName, String[] columnNames) {
        super(context, DB_NAME, null, DB_VERSION);
        TABLE_NAME= tableName;
        this.columnNames = columnNames;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder createTable = new StringBuilder();
        createTable.append("CREATE TABLE IF NOT EXISTS ")
                .append(TABLE_NAME)
                .append(" (");

        boolean isFirstColumn = true;
        for (String columnName : columnNames) {
            if (isFirstColumn) {
                isFirstColumn = false;
            } else {
                createTable.append(", ");
            }
            if (columnName.contains("ma")) {
                createTable.append(columnName)
                        .append(" INTEGER PRIMARY KEY AUTOINCREMENT");
            } else {
                createTable.append(columnName)
                        .append(" TEXT");
            }
        }
        createTable.append(");");

        db.execSQL(createTable.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
