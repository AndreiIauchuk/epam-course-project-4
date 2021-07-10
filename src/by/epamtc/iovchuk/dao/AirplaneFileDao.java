package by.epamtc.iovchuk.dao;

import by.epamtc.iovchuk.bean.airplane.Airplane;
import by.epamtc.iovchuk.bean.airplane.passenger.AirplaneClass;
import by.epamtc.iovchuk.bean.airplane.passenger.PassengerAirplane;
import by.epamtc.iovchuk.bean.airplane.transport.TransportAirplane;
import by.epamtc.iovchuk.service.sort.AirplaneSortServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AirplaneFileDao implements Dao<Airplane> {

    private String filePath;
    private File file;
    private Scanner scanner;

    public AirplaneFileDao(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        file = new File(filePath);
        createFileScanner();
    }

    private void createFileScanner() throws FileNotFoundException {
        scanner = new Scanner(file);
        scanner.useDelimiter("\n");
    }

    @Override
    public List<Airplane> getAll() {
        List<Airplane> airplanes = new ArrayList<>();
        while (scanner.hasNextLine()) {
            Airplane airplane = readAirplane();
            if (airplane == null) {
                continue;
            }
            airplanes.add(airplane);
        }
        scanner.reset();
        return airplanes;
    }

    @Override
    public List<Airplane> getAllSorted(Comparator<Airplane> comparator) {
        List<Airplane> airplanes = getAll();
        new AirplaneSortServiceImpl().sort(airplanes, comparator);
        return airplanes;
    }

    @Override
    public Airplane getOne(int id) {
        while (scanner.hasNextLine()) {
            String[] airplaneParams = readAirplaneParams();
            if (airplaneParams == null) {
                continue;
            }
            int fileAirplaneId = Integer.parseInt(airplaneParams[1].trim());

            if (fileAirplaneId == id) {
                return readAirplane();
            }
        }
        return null;
    }

    private Airplane readAirplane() {
        String[] airplaneParams = readAirplaneParams();
        if (airplaneParams == null) {
            return null;
        }
        char airplaneType = airplaneParams[0].trim().charAt(0);
        int id = Integer.parseInt(airplaneParams[1].trim());
        double length = Double.parseDouble(airplaneParams[2].trim());
        double height = Double.parseDouble(airplaneParams[3].trim());
        double wingSpan = Double.parseDouble(airplaneParams[4].trim());
        double maxTakeoffWeight = Double.parseDouble(airplaneParams[5].trim());
        double emptyWeight = Double.parseDouble(airplaneParams[6].trim());
        double fuelCapacity = Double.parseDouble(airplaneParams[7].trim());
        double fuelConsumption = Double.parseDouble(airplaneParams[8].trim());
        double fuelWeight = Double.parseDouble(airplaneParams[9].trim());

        if (airplaneType == 'P') {
            short passengerCapacity = Short.parseShort(airplaneParams[10].trim());
            Set<AirplaneClass> passengerAirplaneClasses =
                    readPassengerAirplaneClasses(airplaneParams[11].trim());

            return new PassengerAirplane(id, length, height, wingSpan, maxTakeoffWeight,
                    emptyWeight, fuelCapacity, fuelConsumption, fuelWeight,
                    passengerCapacity, passengerAirplaneClasses);
        } else {
            double cargoWeight = Double.parseDouble(airplaneParams[10].trim());
            double maxLiftingCapacity = Double.parseDouble(airplaneParams[11].trim());

            return new TransportAirplane(id, length, height, wingSpan, maxTakeoffWeight,
                    emptyWeight, fuelCapacity, fuelConsumption, fuelWeight, cargoWeight,
                    maxLiftingCapacity);
        }
    }

    private String[] readAirplaneParams() {
        String airplaneParamLine = scanner.nextLine();
        if (airplaneParamLine.isEmpty()) {
            return null;
        }
        return airplaneParamLine.split(",");
    }

    private Set<AirplaneClass> readPassengerAirplaneClasses(String classesParamStr) {
        String substringClassesParamStr =
                classesParamStr.substring(1, classesParamStr.length() - 1);
        String[] airplaneParams = substringClassesParamStr.split(" ");

        Set<AirplaneClass> airplaneClasses = new HashSet<>();
        for (String param : airplaneParams) {
            switch (param.trim()) {
                case "E":
                    airplaneClasses.add(AirplaneClass.ECONOMY);
                    break;
                case "PE":
                    airplaneClasses.add(AirplaneClass.PREMIUM_ECONOMY);
                    break;
                case "B":
                    airplaneClasses.add(AirplaneClass.BUSINESS);
                    break;
                case "F":
                    airplaneClasses.add(AirplaneClass.FIRST);
            }
        }
        return airplaneClasses;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        file = new File(filePath);

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.filePath = filePath;
    }

}