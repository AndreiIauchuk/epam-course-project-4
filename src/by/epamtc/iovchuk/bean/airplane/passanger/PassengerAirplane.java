package by.epamtc.iovchuk.bean.airplane.passanger;

import by.epamtc.iovchuk.bean.airplane.Airplane;

import java.util.EnumSet;

abstract public class PassengerAirplane extends Airplane {

    private short passengerCapacity;
    private EnumSet<AirplaneClass> airplaneClasses;

    public PassengerAirplane(double length, double height, double wingSpan,
                             double emptyWeight, double fuelConsumption,
                             short passengerCapacity, EnumSet<AirplaneClass> airplaneClasses) {
        super(length, height, wingSpan, emptyWeight, fuelConsumption);
        this.passengerCapacity = passengerCapacity;
        this.airplaneClasses = airplaneClasses;

    }

    public PassengerAirplane(double length, double height, double wingSpan,
                             double emptyWeight, double fuelConsumption,
                             double fuelWeight, short passengerCapacity,
                             EnumSet<AirplaneClass> airplaneClasses) {
        this(length, height, wingSpan, emptyWeight, fuelConsumption, passengerCapacity, airplaneClasses);
    }

    public short getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(short passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public EnumSet<AirplaneClass> getAirplaneClasses() {
        return airplaneClasses;
    }

    public void setAirplaneClasses(EnumSet<AirplaneClass> airplaneClasses) {
        this.airplaneClasses = airplaneClasses;
    }
}
