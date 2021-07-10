package by.epamtc.iovchuk.service.calculator;

import by.epamtc.iovchuk.bean.Airline;
import by.epamtc.iovchuk.bean.airplane.passenger.PassengerAirplane;
import by.epamtc.iovchuk.bean.airplane.transport.TransportAirplane;

import java.util.Iterator;

/**
 * Calculator service for total capacities calculations.
 */
public class AirlineTotalCapacityCalculator {

    /**
     * Calculate the total passenger capacity
     * of all passenger aircraft in given airline.
     *
     * @return total passenger capacity
     */
    public int calculateTotalPassengerCapacity(Airline airline) {
        int totalPassengerCapacity = 0;
        Iterator<PassengerAirplane> passengerAirplaneIterator =
                airline.passengerAirplanesIterator();
        while (passengerAirplaneIterator.hasNext()) {
            totalPassengerCapacity +=
                    passengerAirplaneIterator.next().getPassengerCapacity();
        }
        return totalPassengerCapacity;
    }

    /**
     * Calculate the total lifting capacity
     * of all transport aircraft in given airline.
     *
     * @return total lifting capacity
     */
    public double calculateTotalLiftingCapacity(Airline airline) {
        double totalLiftingCapacity = 0;
        Iterator<TransportAirplane> transportAirplaneIterator =
                airline.transportAirplanesIterator();
        while (transportAirplaneIterator.hasNext()) {
            totalLiftingCapacity +=
                    transportAirplaneIterator.next().getMaxLiftingCapacity();
        }
        return totalLiftingCapacity;
    }
}
