public class Car extends Vehicle implements Serviceable {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        // Car insurance fee: 2% of base price
        return basePrice * 0.02;
    }

    @Override
    public void performService() {
        IO.println("Performing service for Car: " + model + " - Oil change, tire rotation, brake inspection");
    }

    @Override
    public String toString() {
        return "Car - " + super.toString() + String.format(", Doors: %d, Insurance Fee: %.2f", numberOfDoors, calculateInsuranceFee());
    }
}
