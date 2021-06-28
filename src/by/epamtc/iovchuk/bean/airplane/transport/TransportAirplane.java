package by.epamtc.iovchuk.bean.airplane.transport;

import by.epamtc.iovchuk.bean.airplane.Airplane;

abstract public class TransportAirplane extends Airplane {

    private int cargoWeight;

    public TransportAirplane(double length, double height, double wingSpan,
                             double emptyWeight, double fuelConsumption) {
        super(length, height, wingSpan, emptyWeight, fuelConsumption);
    }

    public TransportAirplane(double length, double height, double wingSpan,
                             double emptyWeight, double fuelConsumption,
                             double fuelWeight) {
        super(length, height, wingSpan, emptyWeight, fuelConsumption, fuelWeight);
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }
}
