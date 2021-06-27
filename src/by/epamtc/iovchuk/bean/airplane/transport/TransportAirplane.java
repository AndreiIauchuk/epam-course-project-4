package by.epamtc.iovchuk.bean.airplane.transport;

import by.epamtc.iovchuk.bean.airplane.Airplane;

abstract public class TransportAirplane extends Airplane {

    private int cargoWeight;

    public TransportAirplane(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }
}
