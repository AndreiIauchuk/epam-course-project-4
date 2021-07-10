package by.epamtc.iovchuk.bean.airplane.transport;

import by.epamtc.iovchuk.bean.airplane.Airplane;

import java.io.Serializable;

public class TransportAirplane extends Airplane implements Serializable {

    private static final long serialVersionUID = 1L;

    private int cargoWeight;

    public TransportAirplane(int id, double length, double height, double wingSpan,
                             double maxTakeoffWeight, double emptyWeight,
                             double fuelCapacity, double fuelConsumption,
                             double fuelWeight, int cargoWeight) {

        super(id, length, height, wingSpan, maxTakeoffWeight, emptyWeight,
                fuelCapacity, fuelConsumption, fuelWeight);
        this.cargoWeight = cargoWeight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TransportAirplane that = (TransportAirplane) o;
        return cargoWeight == that.cargoWeight;
    }

    @Override
    public int hashCode() {
        double hash = 5;
        hash = 31 * hash + super.hashCode();
        hash = 31 * hash + cargoWeight;
        return (int) hash;
    }

    @Override
    public String toString() {
        return getClass() +
                "cargoWeight=" + cargoWeight +
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