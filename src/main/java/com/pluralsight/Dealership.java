package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
    }

    public List<Vehicle> getVehiclesByColor(String color){
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
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

    public void addVehicle(Vehicle vehicle){

    }

    public void getAllVehicles(){

    }

    public void removeVehicles(Vehicle vehicle){

    }
}
