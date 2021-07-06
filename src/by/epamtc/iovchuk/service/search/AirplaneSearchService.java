package by.epamtc.iovchuk.service.search;

import by.epamtc.iovchuk.bean.Airline;
import by.epamtc.iovchuk.bean.airplane.Airplane;

import java.util.Iterator;

public class AirplaneSearchService {

    private Airline airline;
    private double fuelConsumption;

    /**
     * Search an airplane by its fuel consumption.
     *
     * <p> Return null if no airplane was found. </p>
     */
    public Airplane searchByFuelConsumption(Airline airline, double fuelConsumption) {
        if (airline == null && fuelConsumption <= 0) {
            return null;
        }

        this.airline = airline;
        this.fuelConsumption = fuelConsumption;

        return searchInAllAirplanes();
    }

    private Airplane searchInAllAirplanes() {
        Iterator<Airplane> allAirplanesIterator = airline.allAirplanesIterator();
        while (allAirplanesIterator.hasNext()) {
            Airplane airplane = allAirplanesIterator.next();

            if (Double.compare(airplane.getFuelConsumption(), fuelConsumption) == 1) {
                return airplane;
            }

        }

        return null;
    }
}
