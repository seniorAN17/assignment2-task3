import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FleetApp {
    private List<Vehicle> vehicles;
    private Scanner scanner;

    public FleetApp() {
        this.vehicles = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    printAllVehicles();
                    break;
                case 2:
                    addNewCar();
                    break;
                case 3:
                    addNewBus();
                    break;
                case 4:
                    showTotalYearlyInsuranceFees();
                    break;
                case 5:
                    showVehiclesOlderThanN();
                    break;
                case 6:
                    performServiceForAllVehicles();
                    break;
                case 7:
                    IO.println("Exiting Fleet Management System. Goodbye!");
                    running = false;
                    break;
                default:
                    IO.println("Invalid choice. Please try again.");
            }

            if (running) {
                IO.println(); // Empty line for readability
            }
        }

        scanner.close();
    }

    private void showMenu() {
        IO.println("Fleet Management System");
        IO.println("1. Print all vehicles");
        IO.println("2. Add new car");
        IO.println("3. Add new bus");
        IO.println("4. Show total yearly insurance fees");
        IO.println("5. Show vehicles older than N years");
        IO.println("6. Perform service for all vehicles");
        IO.println("7. Quit");
    }

    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            IO.println("No vehicles in the fleet");
        } else {
            IO.println("All vehicles in the fleet:");
            for (Vehicle vehicle : vehicles) {
                IO.println(vehicle.toString());
            }
        }
    }

    private void addNewCar() {
        IO.println("Adding a new car:");
        String model = readString("Enter model: ");
        int year = readInt("Enter year: ");
        double basePrice = readDouble("Enter base price: ");
        int numberOfDoors = readInt("Enter number of doors: ");

        Car car = new Car(model, year, basePrice, numberOfDoors);
        vehicles.add(car);
        IO.println("Car added successfully!");
    }

    private void addNewBus() {
        IO.println("Adding a new bus:");
        String model = readString("Enter model: ");
        int year = readInt("Enter year: ");
        double basePrice = readDouble("Enter base price: ");
        int passengerCapacity = readInt("Enter passenger capacity: ");

        Bus bus = new Bus(model, year, basePrice, passengerCapacity);
        vehicles.add(bus);
        IO.println("Bus added successfully!");
    }

    private void showTotalYearlyInsuranceFees() {
        double total = 0.0;
        for (Vehicle vehicle : vehicles) {
            total += vehicle.calculateInsuranceFee();
        }
        IO.println(String.format("Total yearly insurance fees: %.2f", total));
    }

    private void showVehiclesOlderThanN() {
        int currentYear = readInt("Enter current year: ");
        int n = readInt("Enter N (years): ");

        IO.println(String.format("Vehicles older than %d years:", n));
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getAge(currentYear) > n) {
                IO.println(vehicle.toString() + " (Age: " + vehicle.getAge(currentYear) + " years)");
                found = true;
            }
        }

        if (!found) {
            IO.println("No vehicles found older than " + n + " years.");
        }
    }

    private void performServiceForAllVehicles() {
        IO.println("Performing service for all vehicles:");
        if (vehicles.isEmpty()) {
            IO.println("No vehicles in the fleet");
        } else {
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Serviceable) {
                    ((Serviceable) vehicle).performService();
                }
            }
        }
    }

    // Helper methods for reading input
    private String readString(String prompt) {
        IO.print(prompt);
        return scanner.nextLine();
    }

    private int readInt(String prompt) {
        IO.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next(); // Clear invalid input
            IO.print("Invalid input. " + prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return value;
    }

    private double readDouble(String prompt) {
        IO.print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.next(); // Clear invalid input
            IO.print("Invalid input. " + prompt);
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        return value;
    }
}
