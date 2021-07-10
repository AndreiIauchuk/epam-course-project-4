package by.epamtc.iovchuk.service.sort;

import by.epamtc.iovchuk.bean.airplane.Airplane;
import by.epamtc.iovchuk.exception.FirstOverLastIndexException;
import by.epamtc.iovchuk.exception.OutOfBoundsException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class AirplaneSortServiceImpl implements SortService<Airplane> {


    public void sort(List<Airplane> airplanes, Comparator<Airplane> comparator) {
        if (checkNull(airplanes)
                || checkBlank(airplanes)
                || checkSingleElement(airplanes)) {
            return;
        }

        int firstElementIndex = 0;
        int lastElementIndex = airplanes.size() - 1;

        try {
            quickSortIterate(airplanes, firstElementIndex, lastElementIndex, comparator);
        } catch (FirstOverLastIndexException | OutOfBoundsException ignored) {
        }

    }

    private void quickSortIterate(List<Airplane> airplanes,
                                  int firstElementIndex,
                                  int lastElementIndex,
                                  Comparator<Airplane> comparator)
            throws OutOfBoundsException, FirstOverLastIndexException {

        Airplane pivotValue = airplanes.get(firstElementIndex);
        int leftIndex = firstElementIndex;
        int rightIndex = lastElementIndex;

        while (leftIndex < rightIndex) {

            while (comparator.compare(airplanes.get(rightIndex), pivotValue) >= 0
                    && leftIndex < rightIndex) {
                rightIndex--;
            }

            if (leftIndex != rightIndex) {
                airplanes.set(leftIndex, airplanes.get(rightIndex));
                leftIndex++;
            }

            while (comparator.compare(airplanes.get(leftIndex), pivotValue) <= 0
                    && leftIndex < rightIndex) {
                leftIndex++;
            }

            if (leftIndex != rightIndex) {
                airplanes.set(rightIndex, airplanes.get(leftIndex));
                rightIndex--;
            }
        }

        airplanes.set(leftIndex, pivotValue);

        if (firstElementIndex < leftIndex) {
            sort(airplanes, firstElementIndex, leftIndex - 1, comparator);
        }

        if (leftIndex < lastElementIndex) {
            sort(airplanes, leftIndex + 1, lastElementIndex, comparator);
        }

    }

    public void sort(List<Airplane> airplanes, int firstElementIndex,
                     int lastElementIndex, Comparator<Airplane> comparator)
            throws OutOfBoundsException, FirstOverLastIndexException {

        if (checkNull(airplanes)
                || checkBlank(airplanes)
                || checkSingleElement(airplanes)) {
            return;
        }

        if (checkOutOfBounds(airplanes, firstElementIndex)
                || checkOutOfBounds(airplanes, lastElementIndex)) {
            throw new OutOfBoundsException();
        }

        if (firstElementIndex > lastElementIndex) {
            throw new FirstOverLastIndexException();
        }

        if (firstElementIndex == lastElementIndex) {
            return;
        }

        quickSortIterate(airplanes, firstElementIndex, lastElementIndex, comparator);
    }

    private boolean checkNull(Collection<Airplane> airplanes) {
        return (airplanes == null);
    }

    private boolean checkBlank(Collection<Airplane> airplanes) {
        return (airplanes.isEmpty());
    }

    private boolean checkSingleElement(Collection<Airplane> airplanes) {
        return (airplanes.size() == 1);
    }

    private boolean checkOutOfBounds(Collection<Airplane> airplanes, int index) {
        return (index >= airplanes.size()
                || index < 0);
    }

}