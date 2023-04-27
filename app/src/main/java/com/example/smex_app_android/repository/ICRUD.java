package com.example.smex_app_android.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public interface ICRUD<T> {
     boolean insert(T obj);
     T get(int id) throws ParseException;
     List<T> getAll() throws ParseException;
     DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

}
