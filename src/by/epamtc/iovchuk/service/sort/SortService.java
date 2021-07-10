package by.epamtc.iovchuk.service.sort;

import by.epamtc.iovchuk.bean.airplane.Airplane;
import by.epamtc.iovchuk.exception.FirstOverLastIndexException;
import by.epamtc.iovchuk.exception.OutOfBoundsException;

import java.util.Comparator;
import java.util.List;

public interface SortService<T> {

    void sort(List<T> airplanes, Comparator<T> comparator);

    void sort(List<Airplane> airplanes, int firstElementIndex,
              int lastElementIndex, Comparator<Airplane> comparator)
            throws OutOfBoundsException, FirstOverLastIndexException;

}