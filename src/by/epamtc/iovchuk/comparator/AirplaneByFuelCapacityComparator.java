package by.epamtc.iovchuk.comparator;

import by.epamtc.iovchuk.bean.airplane.Airplane;

import java.io.Serializable;
import java.util.Comparator;

public class AirplaneByFuelCapacityComparator
        implements Comparator<Airplane>, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public int compare(Airplane airplane1, Airplane airplane2) {
        return Double.compare(airplane1.getFuelCapacity(), airplane2.getFuelCapacity());
    }

}