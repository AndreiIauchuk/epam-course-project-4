package by.epamtc.iovchuk.bean;

import by.epamtc.iovchuk.bean.airplane.Airplane;
import by.epamtc.iovchuk.bean.airplane.passanger.PassengerAirplane;
import by.epamtc.iovchuk.bean.airplane.transport.TransportAirplane;
import by.epamtc.iovchuk.exception.NullException;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Airline {

    private Set<PassengerAirplane> passengerAirplanes;

    private Set<TransportAirplane> transportAirplanes;

    /**
     * Adds a given passenger airplane to the set of passenger airplanes.
     *
     * @param passengerAirplane passenger airplane to be added
     * @return true if the passenger airplane added to a set
     * @throws NullException if the passenger airplane is null
     */
    public boolean addAirplane(PassengerAirplane passengerAirplane) throws NullException {
        nullCheck(passengerAirplane);
        return passengerAirplanes.add(passengerAirplane);
    }

    /**
     * A version of addAirplane used to add a transport airplane to a set.
     */
    public boolean addAirplane(TransportAirplane transportAirplane) throws NullException {
        nullCheck(transportAirplane);
        return transportAirplanes.add(transportAirplane);
    }

    /**
     * Removes a given passenger airplane from the set of passenger airplanes.
     * Return false if the given passenger airplane is null.
     *
     * @param passengerAirplane passenger airplane to be removed
     * @return true if the passenger airplane removed from a set
     */
    public boolean removeAirplane(PassengerAirplane passengerAirplane) {
        if (passengerAirplane == null) {
            return false;
        }

        return passengerAirplanes.remove(passengerAirplane);
    }

    /**
     * A version of removeAirplane used to remove a transport airplane from a set.
     */
    public boolean removeAirplane(TransportAirplane transportAirplane) {
        if (transportAirplane == null) {
            return false;
        }

        return transportAirplanes.remove(transportAirplane);
    }

    /**
     * Calculate the total passenger capacity of all passenger aircraft.
     *
     * @return total passenger capacity
     */
    public int calculateTotalCapacity() {
        int totalPassengerCapacity = 0;

        for (PassengerAirplane airplane : passengerAirplanes) {
            totalPassengerCapacity += airplane.getPassengerCapacity();
        }

        return totalPassengerCapacity;
    }

    /**
     * Calculate the total lifting capacity of all transport aircraft.
     *
     * @return total lifting capacity
     */
    public double calculateTotalLiftingCapacity() {
        double totalLiftingCapacity = 0;

        for (TransportAirplane airplane : transportAirplanes) {
            totalLiftingCapacity += airplane.getMaxLiftingCapacity();
        }

        return totalLiftingCapacity;
    }

    /**
     * Returns an iterator over the passenger airplanes set.
     */
    public Iterator<PassengerAirplane> passengerAirplanesIterator() {
        return passengerAirplanes.iterator();
    }

    /**
     * Returns an iterator over the transport airplanes set.
     */
    public Iterator<TransportAirplane> transportAirplanesIterator() {
        return transportAirplanes.iterator();
    }

    /**
     * Returns an iterator over all airplanes set.
     */
    public Iterator<Airplane> allAirplanesIterator() {
        Set<Airplane> allAirplanes = new HashSet<>(passengerAirplanes);
        allAirplanes.addAll(transportAirplanes);
        return  allAirplanes.iterator();
    }

    /**
     * Checks if the given airplane is not null. If null throws NullException.
     */
    private void nullCheck(Airplane airplane) throws NullException {
        if (airplane == null) {
            throw new NullException("Airplane");
        }
    }

}
