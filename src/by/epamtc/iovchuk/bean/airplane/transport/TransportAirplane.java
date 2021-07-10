package by.epamtc.iovchuk.bean.airplane.transport;

import by.epamtc.iovchuk.bean.airplane.Airplane;

import java.io.Serializable;

public class TransportAirplane extends Airplane implements Serializable {

    private static final long serialVersionUID = 1L;

    private double cargoWeight;
    private double maxLiftingCapacity;

    public TransportAirplane(int id, double length, double height, double wingSpan,
                             double maxTakeoffWeight, double emptyWeight,
                             double fuelCapacity, double fuelConsumption,
                             double fuelWeight, double cargoWeight, double maxLiftingCapacity) {

        super(id, length, height, wingSpan, maxTakeoffWeight, emptyWeight,
                fuelCapacity, fuelConsumption, fuelWeight);
        this.cargoWeight = cargoWeight;
        this.maxLiftingCapacity = maxLiftingCapacity;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public double getMaxLiftingCapacity() {
        return maxLiftingCapacity;
    }

    public void setMaxLiftingCapacity(double maxLiftingCapacity) {
        this.maxLiftingCapacity = maxLiftingCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportAirplane)) return false;
        if (!super.equals(o)) return false;
        TransportAirplane airplane = (TransportAirplane) o;
        return Double.compare(airplane.cargoWeight, cargoWeight) == 0
                && Double.compare(airplane.maxLiftingCapacity, maxLiftingCapacity) == 0;
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
        return getClass().getSimpleName() + "{ " +
                "id=" + getId() +
                ", cargoWeight=" + cargoWeight +
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