package repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public interface ICRUD<T> {
     boolean insert(T obj);
     T get(int id) throws ParseException;
     List<T> getAll() throws ParseException;
     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

}
