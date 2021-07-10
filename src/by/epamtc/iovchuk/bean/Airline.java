package by.epamtc.iovchuk.bean;

import by.epamtc.iovchuk.bean.airplane.Airplane;
import by.epamtc.iovchuk.bean.airplane.passenger.PassengerAirplane;
import by.epamtc.iovchuk.bean.airplane.transport.TransportAirplane;
import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.service.sort.SortService;

import java.util.*;

public class Airline {

    private final List<Airplane> airplanes;

    public Airline() {
        airplanes = new ArrayList<>();
    }

    public Airline(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    /**
     * Adds a given airplane to the list of airplanes.
     *
     * @param airplane airplane to be added
     * @return true if the airplane added to a list
     * @throws NullException if the airplane is null
     */
    public boolean addAirplane(Airplane airplane) throws NullException {
        if (checkNull(airplane)) {
            throw new NullException();
        }
        return airplanes.add(airplane);
    }

    /**
     * Adds a given airplanes to the list of airplanes.
     *
     * @param airplanes airplanes to be added
     * @return true if the airplane added to a list
     * @throws NullException if the airplane is null
     */
    public boolean addAirplanes(Collection<Airplane> airplanes) throws NullException {
        if (checkNull(airplanes)) {
            throw new NullException();
        }
        return this.airplanes.addAll(airplanes);
    }

    /**
     * Removes a given airplane from the list of airplanes.
     * Return false if the given airplane is null.
     *
     * @param airplane airplane to be removed
     * @return true if the airplane removed from a list
     */
    public boolean removeAirplane(Airplane airplane) throws NullException {
        if (checkNull(airplane)) {
            throw new NullException();
        }
        return airplanes.remove(airplane);
    }

    public void sortAirplanes(SortService<Airplane> sortService,
                              Comparator<Airplane> comparator) {
        sortService.sort(airplanes, comparator);
    }

    /**
     * Returns an iterator over airplanes list.
     */
    public Iterator<Airplane> airplanesIterator() {
        return airplanes.iterator();
    }

    /**
     * Returns an iterator over passenger airplanes list.
     */
    public Iterator<PassengerAirplane> passengerAirplanesIterator() {
        List<PassengerAirplane> passengerAirplanes = new ArrayList<>();
        for (Airplane airplane : airplanes) {
            if (airplane instanceof PassengerAirplane) {
                passengerAirplanes.add((PassengerAirplane) airplane);
            }
        }
        return passengerAirplanes.iterator();
    }

    /**
     * Returns an iterator over transport airplanes list.
     */
    public Iterator<TransportAirplane> transportAirplanesIterator() {
        List<TransportAirplane> transportAirplanes = new ArrayList<>();
        for (Airplane airplane : airplanes) {
            if (airplane instanceof TransportAirplane) {
                transportAirplanes.add((TransportAirplane) airplane);
            }
        }
        return transportAirplanes.iterator();
    }

    /**
     * Checks if the given airplane is not null. If null throws NullException.
     */
    private boolean checkNull(Object o) {
        return (o == null);
    }

}