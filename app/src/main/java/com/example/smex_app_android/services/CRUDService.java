package com.example.smex_app_android.services;
import java.text.ParseException;
import java.util.List;


public interface CRUDService<T> {
    public boolean insert(T obj);
    public T get(int id) throws ParseException;
    public List<T> getAll();
}
