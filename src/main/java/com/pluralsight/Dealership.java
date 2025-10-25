package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> allResults = new ArrayList<>();
        for(Vehicle vehicle: inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                allResults.add(vehicle);
            }
        }
        return allResults;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> allResults = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                allResults.add(vehicle);
            }
        }
        return allResults;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> allResults = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                allResults.add(vehicle);
            }
        }
        return allResults;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> allResults = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                allResults.add(vehicle);
            }
        }
        return allResults;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> allResults = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                allResults.add(vehicle);
            }
        }
        return allResults;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> allResults = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                allResults.add(vehicle);
            }
        }
        return allResults;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    @Override
    public String toString() {
        return "Dealership: " + name + "|"+ address + "|" + phone;
    }
}
