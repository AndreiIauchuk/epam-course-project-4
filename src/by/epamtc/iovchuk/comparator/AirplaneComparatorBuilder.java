package by.epamtc.iovchuk.comparator;

import by.epamtc.iovchuk.bean.airplane.Airplane;
import java.util.Comparator;

public class AirplaneComparatorBuilder {

    private final Comparator<Airplane> comparator;

    public AirplaneComparatorBuilder(Comparator<Airplane> comparator) {
        this.comparator = comparator;
    }

    public Comparator<? extends Airplane> build() {
        return comparator;
    }

    public AirplaneComparatorBuilder compareByEmptyWeight() {
        comparator.thenComparing(new AirplaneByEmptyWeightComparator());
        return this;
    }

    public AirplaneComparatorBuilder compareByFuelCapacity() {
        comparator.thenComparing(new AirplaneByFuelCapacityComparator());
        return this;
    }

    public AirplaneComparatorBuilder compareByFuelConsumption() {
        comparator.thenComparing(new AirplaneByFuelConsumptionComparator());
        return this;
    }

    public AirplaneComparatorBuilder compareByHeight() {
        comparator.thenComparing(new AirplaneByHeightComparator());
        return this;
    }

    public AirplaneComparatorBuilder compareByLength() {
        comparator.thenComparing(new AirplaneByLengthComparator());
        return this;
    }

    public AirplaneComparatorBuilder compareByMaxTakeoffWeight() {
        comparator.thenComparing(new AirplaneByMaxTakeoffWeightComparator());
        return this;
    }

    public AirplaneComparatorBuilder compareByWingSpan() {
        comparator.thenComparing(new AirplaneByWingSpanComparator());
        return this;
    }

}