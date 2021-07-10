package by.epamtc.iovchuk.comparator;

import by.epamtc.iovchuk.bean.airplane.Airplane;
import java.util.Comparator;

public class AirplaneComparatorBuilder {

    private Comparator<Airplane> comparator;

    public AirplaneComparatorBuilder(Comparator<Airplane> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Airplane> build() {
        return comparator;
    }

    public AirplaneComparatorBuilder compareByEmptyWeight() {
        comparator = comparator.thenComparing(new AirplaneByEmptyWeightComparator());
        return this;
    }

    public AirplaneComparatorBuilder compareByFuelCapacity() {
        comparator = comparator.thenComparing(new AirplaneByFuelCapacityComparator());
        return this;
    }

    public AirplaneComparatorBuilder compareByFuelConsumption() {
        comparator = comparator.thenComparing(new AirplaneByFuelConsumptionComparator());
        return this;
    }

    public AirplaneComparatorBuilder compareByHeight() {
        comparator = comparator.thenComparing(new AirplaneByHeightComparator());
        return this;
    }

    public AirplaneComparatorBuilder compareByLength() {
        comparator = comparator.thenComparing(new AirplaneByLengthComparator());
        return this;
    }

    public AirplaneComparatorBuilder compareByMaxTakeoffWeight() {
        comparator = comparator.thenComparing(new AirplaneByMaxTakeoffWeightComparator());
        return this;
    }

    public AirplaneComparatorBuilder compareByWingSpan() {
        comparator = comparator.thenComparing(new AirplaneByWingSpanComparator());
        return this;
    }

}