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
        ArrayList<Vehicle> getResults = new ArrayList<>();
        for(Vehicle vehicle: inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                getResults.add(vehicle);
            }
        }
        return getResults;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> getResults = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                getResults.add(vehicle);
            }
        }
        return getResults;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> getResults = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                getResults.add(vehicle);
            }
        }
        return getResults;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> getResults = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                getResults.add(vehicle);
            }
        }
        return getResults;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> getResults = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                getResults.add(vehicle);
            }
        }
        return getResults;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> getResults = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                getResults.add(vehicle);
            }
        }
        return getResults;
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

    public void removeVehicles(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
