package com.example.smex_app_android.service;
import java.util.List;


public interface CRUDService<T> {
    public boolean insert(T obj);
    public T get(int id, Class<T> clazz);
    public List<T> getAll(Class<T> clazz);
}
