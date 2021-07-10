package by.epamtc.iovchuk.dao;

import java.util.Comparator;
import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    List<T> getAllSorted(Comparator<T> comparator);

    T getOne(int id);

}