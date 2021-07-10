package by.epamtc.iovchuk;


import by.epamtc.iovchuk.bean.Airline;
import by.epamtc.iovchuk.bean.airplane.Airplane;
import by.epamtc.iovchuk.comparator.AirplaneByLengthComparator;
import by.epamtc.iovchuk.comparator.AirplaneComparatorBuilder;
import by.epamtc.iovchuk.dao.AirplaneFileDao;
import by.epamtc.iovchuk.dao.Dao;
import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.service.calculator.AirlineTotalCapacityCalculator;
import by.epamtc.iovchuk.service.search.AirplaneSearchService;
import by.epamtc.iovchuk.service.sort.AirplaneSortServiceImpl;

import java.util.Comparator;
import java.util.Iterator;

/**
 * <strong>Авиакомпания.</strong>
 * <br>
 * Определить иерархию самолетов. Создать авиакомпанию. Посчитать общую вместимость и грузоподъемность.
 * <br>
 * Провести сортировку самолетов компании на основе одного и нескольких параметров.
 * <br>
 * Найти самолет в компании, соответствующий заданному диапазону параметров потребления горючего.
 * <br>
 * <strong>Требования:</strong>
 * <br>
 * - При реализации иерархии наследования производный класс должен расширять суперкласс новыми свойствами,
 * для чего следует разобраться в предметной области задачи.
 * <br>
 * - Классы-сущности должны быть отделены от классов с методами бизнес-логики.
 * <br>
 * - Источником данных является файл(.txt). Среди данных в файле должна быть заведомо некорректная информация.
 * Должна присутствовать обработка некорректных данных инициализации объекта
 */
public class Main {

    private static Airline airline;
    private static Dao<Airplane> airplaneDao;

    public static void main(String[] args) {
        airline = new Airline();

        fillAirlineFromFile();
        printTotalPassengerCapacity();
        printTotalLiftingCapacity();
        printAirplaneByFuelConsumption();

        printFindByDaoOneAirplane();

        printAllAirplanes();
        sortAirplanes();
        System.out.println("ОТСОРТИРОВАННЫЙ МАССИВ:");
        printAllAirplanes();
    }

    private static void fillAirlineFromFile() {
        airplaneDao = new AirplaneFileDao("M:\\Airplanes.txt");

        try {
            airline.addAirplanes(airplaneDao.getAll());
        } catch (NullException e) {
            e.printStackTrace();
        }
    }

    private static void printTotalPassengerCapacity() {
        double totalPassengerCapacity =
                new AirlineTotalCapacityCalculator()
                        .calculateTotalPassengerCapacity(airline);

        System.out.println("Общая вместимость самолетов авиакомпании = " +
                totalPassengerCapacity);
    }

    private static void printTotalLiftingCapacity() {
        double totalLiftingCapacity =
                new AirlineTotalCapacityCalculator()
                        .calculateTotalLiftingCapacity(airline);

        System.out.println("Общая грузоподъемность самолетов авиакомпании = " +
                totalLiftingCapacity);
    }

    private static void printAirplaneByFuelConsumption() {
        AirplaneSearchService searchService = new AirplaneSearchService();
        Airplane airplane =
                searchService
                        .searchByFuelConsumption(
                                airline,
                                19.9,
                                20.5);
        System.out.println(airplane);
    }

    private static void printFindByDaoOneAirplane() {
        System.out.println(airplaneDao.getOne(4));
    }

    private static void printAllAirplanes() {
        System.out.println();
        Iterator<Airplane> iterator = airline.airplanesIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void sortAirplanes() {
        airline.sortAirplanes(new AirplaneSortServiceImpl(), createComparator());
    }

    private static Comparator<Airplane> createComparator() {
        AirplaneComparatorBuilder builder =
                new AirplaneComparatorBuilder(new AirplaneByLengthComparator());

        return builder
                .compareByHeight()
                .compareByWingSpan()
                .build();
    }

}