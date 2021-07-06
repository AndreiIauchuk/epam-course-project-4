package by.epamtc.iovchuk.bean.airplane.passanger;

import by.epamtc.iovchuk.bean.airplane.Airplane;

import java.util.EnumSet;

abstract public class PassengerAirplane extends Airplane {

    private final short passengerCapacity;
    private EnumSet<AirplaneClass> airplaneClasses;

    public PassengerAirplane(double length, double height, double wingSpan, double maxTakeoffWeight,
                             double emptyWeight, double fuelCapacity, double fuelConsumption,
                             short passengerCapacity) {
        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight, fuelCapacity, fuelConsumption);
        this.passengerCapacity = passengerCapacity;
    }

    public PassengerAirplane(double length, double height, double wingSpan, double maxTakeoffWeight,
                             double emptyWeight, double fuelCapacity, double fuelConsumption, double fuelWeight,
                             short passengerCapacity) {
        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight, fuelCapacity, fuelConsumption, fuelWeight);
        this.passengerCapacity = passengerCapacity;
    }

    public PassengerAirplane(double length, double height, double wingSpan, double maxTakeoffWeight,
                             double emptyWeight, double fuelCapacity, double fuelConsumption,
                             short passengerCapacity, EnumSet<AirplaneClass> airplaneClasses) {
        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight, fuelCapacity, fuelCapacity, fuelConsumption);
        this.passengerCapacity = passengerCapacity;
        this.airplaneClasses = airplaneClasses;
    }

    public PassengerAirplane(double length, double height, double wingSpan, double maxTakeoffWeight,
                             double emptyWeight, double fuelCapacity, double fuelConsumption, double fuelWeight,
                             short passengerCapacity, EnumSet<AirplaneClass> airplaneClasses) {
        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight, fuelCapacity, fuelConsumption, fuelWeight);
        this.passengerCapacity = passengerCapacity;
        this.airplaneClasses = airplaneClasses;
    }

    public short getPassengerCapacity() {
        return passengerCapacity;
    }

    public EnumSet<AirplaneClass> getAirplaneClasses() {
        return airplaneClasses;
    }

    public void setAirplaneClasses(EnumSet<AirplaneClass> airplaneClasses) {
        this.airplaneClasses = airplaneClasses;
    }
}
