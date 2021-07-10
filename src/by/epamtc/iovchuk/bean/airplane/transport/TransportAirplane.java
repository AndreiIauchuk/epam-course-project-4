package by.epamtc.iovchuk.bean.airplane.transport;

import by.epamtc.iovchuk.bean.airplane.Airplane;

abstract public class TransportAirplane extends Airplane {

    private int cargoWeight;
    private final double maxLiftingCapacity;

    public TransportAirplane(double length, double height, double wingSpan,
                             double maxTakeoffWeight, double emptyWeight,
                             double fuelCapacity, double fuelConsumption) {

        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight,
                fuelCapacity, fuelConsumption);
        maxLiftingCapacity = maxTakeoffWeight - emptyWeight;
    }

    public TransportAirplane(double length, double height, double wingSpan,
                             double maxTakeoffWeight, double emptyWeight,
                             double fuelCapacity, double fuelConsumption,
                             double fuelWeight) {

        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight,
                fuelCapacity, fuelConsumption, fuelWeight);
        maxLiftingCapacity = maxTakeoffWeight - emptyWeight;
    }

    public TransportAirplane(double length, double height, double wingSpan,
                             double maxTakeoffWeight, double emptyWeight,
                             double fuelCapacity, double fuelConsumption,
                             int cargoWeight) {

        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight,
                fuelCapacity, fuelConsumption);
        this.cargoWeight = cargoWeight;
        maxLiftingCapacity = maxTakeoffWeight - emptyWeight;
    }

    public TransportAirplane(double length, double height, double wingSpan,
                             double maxTakeoffWeight, double emptyWeight,
                             double fuelCapacity, double fuelConsumption,
                             double fuelWeight, int cargoWeight) {

        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight,
                fuelCapacity, fuelConsumption, fuelWeight);
        this.cargoWeight = cargoWeight;
        maxLiftingCapacity = maxTakeoffWeight - emptyWeight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public double getMaxLiftingCapacity() {
        return maxLiftingCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TransportAirplane that = (TransportAirplane) o;
        return cargoWeight == that.cargoWeight &&
                Double.compare(maxLiftingCapacity, that.maxLiftingCapacity) == 0;
    }

    @Override
    public int hashCode() {
        double hash = 5;
        hash = 31 * hash + super.hashCode();
        hash = 31 * hash + cargoWeight;
        hash = 31 * hash + maxLiftingCapacity;
        return (int) hash;
    }

    @Override
    public String toString() {
        return getClass() +
                "cargoWeight=" + cargoWeight +
                ", maxLiftingCapacity=" + maxLiftingCapacity +
                ", length=" + getLength() +
                ", height=" + getHeight() +
                ", wingSpan=" + getWingSpan() +
                ", maxTakeoffWeight=" + getMaxTakeoffWeight() +
                ", emptyWeight=" + getEmptyWeight() +
                ", fuelCapacity=" + getFuelCapacity() +
                ", fuelConsumption=" + getFuelConsumption() +
                ", fuelWeight=" + getFuelWeight() +
                "}";
    }
}