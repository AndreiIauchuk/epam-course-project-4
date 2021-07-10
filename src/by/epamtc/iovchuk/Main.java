package by.epamtc.iovchuk;


import by.epamtc.iovchuk.bean.Airline;
import by.epamtc.iovchuk.bean.airplane.Airplane;
import by.epamtc.iovchuk.dao.AirplaneFileDao;
import by.epamtc.iovchuk.dao.Dao;
import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.service.calculator.AirlineTotalCapacityCalculator;

import java.io.FileNotFoundException;
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

    public static void main(String[] args) {
        Airline airline = new Airline();
        Dao<Airplane> airplaneDao = null;

        try {
            airplaneDao = new AirplaneFileDao("M:\\Airplanes.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            assert airplaneDao != null;
            airline.addAirplanes(airplaneDao.getAll());
        } catch (NullException e) {
            e.printStackTrace();
        }

        Iterator<Airplane> iterator = airline.airplanesIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(new AirlineTotalCapacityCalculator().calculateTotalLiftingCapacity(airline));
        System.out.println(new AirlineTotalCapacityCalculator().calculateTotalPassengerCapacity(airline));
    }
}
