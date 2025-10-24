package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner myScanner = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    public void display() {
        init();

        int choice;
        do {
            System.out.print("\n==== " + dealership.getName() + "====");
            System.out.println("1. List All Vehicles");
            System.out.println("2. Search by price");
            System.out.println("3. Search by make/model");
            System.out.println("4. Search by year");
            System.out.println("5. Search by color");
            System.out.println("6. Search by mileage");
            System.out.println("7. Search by vehicle type");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("10. Exit");
            System.out.println("Enter your choice: ");

            choice = myScanner.nextInt();
            myScanner.nextLine();

            switch (choice) {
                case 1:
                    processGetByAllVehiclesRequest();
                    break;
                case 2:
                    processGetByPriceRequest();
                    break;
                case 3:
                    processGetByMakeModelRequest();
                    break;
                case 4:
                    processGetByYearRequest();
                    break;
                case 5:
                    processGetByColorRequest();
                    break;
                case 6:
                    processGetByMileageRequest();
                    break;
                case 7:
                    processGetByVehicleTypeRequest();
                    break;
                case 8:
                    processGetByAddVehicleRequest();
                    break;
                case 9:
                    processGetByRemoveVehicleRequest();
                case 10:
                    System.out.println("Exit");
                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 0);
    }
    public void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }
    public void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle vehicle: vehicles) {
                System.out.println(vehicle);
            }
        }
    }
    public void processGetByAllVehiclesRequest() {
        List<Vehicle> byAllVehicles = dealership.getAllVehicles();
        displayVehicles(byAllVehicles);
    }

    public void processGetByPriceRequest() {
        System.out.println("Enter min price: ");
        double min = myScanner.nextDouble();
        System.out.println("Enter max price: ");
        double max = myScanner.nextDouble();
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    public void processGetByMakeModelRequest() {
        System.out.println("Enter make: ");
        String make = myScanner.nextLine();
        System.out.println("Enter model: ");
        String model = myScanner.nextLine();
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }
    public void processGetByYearRequest() {
        System.out.println("Enter min year: ");
        int min = myScanner.nextInt();
        System.out.println("Enter max year: ");
        int max = myScanner.nextInt();
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }
    public void processGetByColorRequest() {
        System.out.println("Enter color: ");
        String color = myScanner.nextLine();
        displayVehicles(dealership.getVehiclesByColor(color));
    }
    public void processGetByMileageRequest() {
        System.out.println("Enter min mileage: ");
        int min = myScanner.nextInt();
        System.out.println("Enter max mileage: ");
        int max = myScanner.nextInt();
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }
    public void processGetByVehicleTypeRequest() {
        System.out.println("Enter vehicle type(car, truck, etc.): ");
        String vehicleType = myScanner.nextLine();
        displayVehicles(dealership.getVehiclesByType(vehicleType));
    }
    public void processGetByAddVehicleRequest() {
        System.out.println("Vin: ");
        int vin = myScanner.nextInt();
        System.out.println("Year: ");
        int year = myScanner.nextInt();
        myScanner.nextLine();
        System.out.println("Make: ");
        String make = myScanner.nextLine();
        System.out.println("Model: ");
        String model = myScanner.nextLine();
        System.out.println("Vehicle Type: ");
        String vehicleType = myScanner.nextLine();
        System.out.println("Color: ");
        String color = myScanner.nextLine();
        System.out.println("Mileage: ");
        int odometer = myScanner.nextInt();
        System.out.println("Price: ");
        double price = myScanner.nextDouble();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added!");
    }

    public void processGetByRemoveVehicleRequest(){
        System.out.println("Enter vin to remove: ");
        int vin = myScanner.nextInt();
        Vehicle toRemove = null;
        for (Vehicle vehicle: dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                toRemove = vehicle;
            }
        }
        if (toRemove != null) {
            dealership.removeVehicles(toRemove);
            System.out.println("Vehicle removed!");
        } else {
            System.out.println("Vin not found!");
        }
    }
}
