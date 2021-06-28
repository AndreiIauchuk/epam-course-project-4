package by.epamtc.iovchuk.bean.airplane;

abstract public class Airplane {

    private final double length;
    private final double height;
    private final double wingSpan;
    private final double emptyWeight;
    private final double fuelConsumption;
    private double fuelWeight;

    public Airplane(double length, double height, double wingSpan,
                    double emptyWeight, double fuelConsumption) {
        this.length = length;
        this.height = height;
        this.wingSpan = wingSpan;
        this.emptyWeight = emptyWeight;
        this.fuelConsumption = fuelConsumption;
    }

    public Airplane(double length, double height, double wingSpan,
                    double emptyWeight, double fuelConsumption,
                    double fuelWeight) {
        this(length, height, wingSpan, emptyWeight, fuelConsumption);
        this.fuelWeight = fuelWeight;
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
}
