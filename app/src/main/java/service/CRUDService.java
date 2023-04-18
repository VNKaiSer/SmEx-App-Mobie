package service;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import repository.DatabaseRepository;

public interface CRUDService<T> {
    public boolean insert(T obj);
    public T get(int id, Class<T> clazz);
    public List<T> getAll(Class<T> clazz);
}
