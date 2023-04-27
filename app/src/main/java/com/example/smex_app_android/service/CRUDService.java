package com.example.smex_app_android.service;
import java.text.ParseException;
import java.util.List;


public interface CRUDService<T> {
    public boolean insert(T obj);
    public T get(int id) throws ParseException;
    public List<T> getAll(Class<T> clazz) throws ParseException;
}
