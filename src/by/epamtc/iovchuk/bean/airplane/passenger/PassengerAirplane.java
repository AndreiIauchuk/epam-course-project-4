package by.epamtc.iovchuk.bean.airplane.passenger;

import by.epamtc.iovchuk.bean.airplane.Airplane;

import java.util.EnumSet;
import java.util.Objects;

abstract public class PassengerAirplane extends Airplane {

    private final short passengerCapacity;
    private final EnumSet<AirplaneClass> airplaneClasses;

    public PassengerAirplane(double length, double height, double wingSpan,
                             double maxTakeoffWeight, double emptyWeight,
                             double fuelCapacity, double fuelConsumption,
                             short passengerCapacity, EnumSet<AirplaneClass> airplaneClasses) {

        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight, fuelCapacity,
                fuelCapacity, fuelConsumption);
        this.passengerCapacity = passengerCapacity;
        this.airplaneClasses = airplaneClasses;
    }

    public PassengerAirplane(double length, double height, double wingSpan,
                             double maxTakeoffWeight, double emptyWeight,
                             double fuelCapacity, double fuelConsumption,
                             double fuelWeight, short passengerCapacity,
                             EnumSet<AirplaneClass> airplaneClasses) {

        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight, fuelCapacity,
                fuelConsumption, fuelWeight);
        this.passengerCapacity = passengerCapacity;
        this.airplaneClasses = airplaneClasses;
    }

    public short getPassengerCapacity() {
        return passengerCapacity;
    }

    public EnumSet<AirplaneClass> getAirplaneClasses() {
        return airplaneClasses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerAirplane that = (PassengerAirplane) o;
        return passengerCapacity == that.passengerCapacity &&
                Objects.equals(airplaneClasses, that.airplaneClasses);
    }

    @Override
    public int hashCode() {
        double hash = 5;
        hash = 31 * hash + super.hashCode();
        hash = 31 * hash + passengerCapacity;
        hash = 31 * hash + airplaneClasses.hashCode();
        return (int) hash;
    }

    @Override
    public String toString() {
        return getClass() +
                "passengerCapacity=" + passengerCapacity +
                ", airplaneClasses=" + airplaneClasses +
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