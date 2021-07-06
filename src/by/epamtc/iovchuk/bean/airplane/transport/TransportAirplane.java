package by.epamtc.iovchuk.bean.airplane.transport;

import by.epamtc.iovchuk.bean.airplane.Airplane;

abstract public class TransportAirplane extends Airplane {

    private int cargoWeight;
    private final double maxLiftingCapacity;

    public TransportAirplane(double length, double height, double wingSpan, double maxTakeoffWeight,
                             double emptyWeight, double fuelCapacity, double fuelConsumption) {
        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight, fuelCapacity, fuelConsumption);
        maxLiftingCapacity = maxTakeoffWeight - emptyWeight;
    }

    public TransportAirplane(double length, double height, double wingSpan, double maxTakeoffWeight,
                             double emptyWeight, double fuelCapacity, double fuelConsumption, double fuelWeight) {
        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight, fuelCapacity, fuelConsumption, fuelWeight);
        maxLiftingCapacity = maxTakeoffWeight - emptyWeight;
    }

    public TransportAirplane(double length, double height, double wingSpan, double maxTakeoffWeight,
                             double emptyWeight, double fuelCapacity, double fuelConsumption, int cargoWeight) {
        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight, fuelCapacity, fuelConsumption);
        this.cargoWeight = cargoWeight;
        maxLiftingCapacity = maxTakeoffWeight - emptyWeight;
    }

    public TransportAirplane(double length, double height, double wingSpan, double maxTakeoffWeight,
                             double emptyWeight, double fuelCapacity, double fuelConsumption, double fuelWeight,
                             int cargoWeight) {
        super(length, height, wingSpan, maxTakeoffWeight, emptyWeight, fuelCapacity, fuelConsumption, fuelWeight);
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
}
