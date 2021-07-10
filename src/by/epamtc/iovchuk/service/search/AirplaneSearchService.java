package by.epamtc.iovchuk.service.search;

import by.epamtc.iovchuk.bean.Airline;
import by.epamtc.iovchuk.bean.airplane.Airplane;

import java.util.Iterator;

public class AirplaneSearchService {

    private Airline airline;
    private double minFuelConsumption;
    private double maxFuelConsumption;

    /**
     * Find an airplane in the airline than match a given range of fuel consumption.
     *
     * <p> Return null if no airplane was found. </p>
     */
    public Airplane searchByFuelConsumption(Airline airline, double minFuelConsumption, double maxFuelConsumption) {
        if (airline == null
                && minFuelConsumption <= 0
                && maxFuelConsumption <= 0
                && minFuelConsumption > maxFuelConsumption) {
            return null;
        }

        this.airline = airline;
        this.minFuelConsumption = minFuelConsumption;
        this.maxFuelConsumption = maxFuelConsumption;

        return searchInAirplanes();
    }

    private Airplane searchInAirplanes() {
        Iterator<Airplane> airplaneIterator = airline.airplanesIterator();
        while (airplaneIterator.hasNext()) {
            Airplane airplane = airplaneIterator.next();
            if (compareWithMinFuelConsumption(airplane)
                    && compareWithMaxFuelConsumption(airplane)) {
                return airplane;
            }
        }
        return null;
    }

    private boolean compareWithMinFuelConsumption(Airplane airplane) {
        return Double.compare(
                airplane.getFuelConsumption(), minFuelConsumption) >= 0;
    }

    private boolean compareWithMaxFuelConsumption(Airplane airplane) {
        return Double.compare(
                airplane.getFuelConsumption(), maxFuelConsumption) <= 0;
    }

}