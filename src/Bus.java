public class Bus extends Vehicle implements Serviceable {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        // Bus insurance fee: 5% of base price (higher due to passenger capacity)
        return basePrice * 0.05;
    }

    @Override
    public void performService() {
        IO.println("Performing service for Bus: " + model + " - Engine inspection, brake system check, passenger safety equipment check");
    }

    @Override
    public String toString() {
        return "Bus - " + super.toString() + String.format(", Passenger Capacity: %d, Insurance Fee: %.2f", passengerCapacity, calculateInsuranceFee());
    }
}
