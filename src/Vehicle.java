public abstract class Vehicle {
    protected String model;
    protected int year;
    protected double basePrice;

    public Vehicle(String model, int year, double basePrice) {
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return String.format("%s (Year: %d, Base Price: %.2f)", model, year, basePrice);
    }
}
