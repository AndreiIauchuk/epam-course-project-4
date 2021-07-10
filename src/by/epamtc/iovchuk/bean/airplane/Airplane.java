package by.epamtc.iovchuk.bean.airplane;

abstract public class Airplane {

    private int id;
    private final double length;
    private final double height;
    private final double wingSpan;
    private final double maxTakeoffWeight;
    private final double emptyWeight;
    private final double fuelCapacity;
    private final double fuelConsumption;
    private double fuelWeight;

    public Airplane(int id, double length, double height, double wingSpan,
                    double maxTakeoffWeight, double emptyWeight, double fuelCapacity,
                    double fuelConsumption, double fuelWeight) {
        this.id = id;
        this.length = length;
        this.height = height;
        this.wingSpan = wingSpan;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.emptyWeight = emptyWeight;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
        this.fuelWeight = fuelWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public double getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public double getEmptyWeight() {
        return emptyWeight;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuelWeight() {
        return fuelWeight;
    }

    public void setFuelWeight(double fuelWeight) {
        this.fuelWeight = fuelWeight;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return airplane.id == id &&
                Double.compare(airplane.length, length) == 0 &&
                Double.compare(airplane.height, height) == 0 &&
                Double.compare(airplane.wingSpan, wingSpan) == 0 &&
                Double.compare(airplane.maxTakeoffWeight, maxTakeoffWeight) == 0 &&
                Double.compare(airplane.emptyWeight, emptyWeight) == 0 &&
                Double.compare(airplane.fuelCapacity, fuelCapacity) == 0 &&
                Double.compare(airplane.fuelConsumption, fuelConsumption) == 0 &&
                Double.compare(airplane.fuelWeight, fuelWeight) == 0;
    }

    @Override
    public int hashCode() {
        return calculateHashCode(length, height, wingSpan, maxTakeoffWeight, emptyWeight,
                fuelCapacity, fuelConsumption, fuelCapacity);
    }

    private int calculateHashCode(double... values) {
        double hash = 5;
        for (double value : values) {
            hash = 31 * hash + value;
        }

        hash = 31 * hash + id;

        return (int) hash;
    }

}