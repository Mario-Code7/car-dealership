package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class DealershipFileManager {
    public Dealership getDealership() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));

            String header = bufferedReader.readLine();
            String[] parts = header.split("\\|");

            Dealership dealership = new Dealership(parts[0], parts[1], parts[2]);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] vehicle = line.split("\\|");
                int vin = Integer.parseInt(vehicle[0]);
                int year = Integer.parseInt(vehicle[1]);
                String make = vehicle[2];
                String model = vehicle[3];
                String vehicleType = vehicle[4];
                String color = vehicle[5];
                int odometer = Integer.parseInt(vehicle[6]);
                double price = Double.parseDouble(vehicle[7]);

                dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
            }
            return dealership;
        } catch (IOException e) {
            System.out.println("Error loading your dealership file: " + e.getMessage());
            return null;
        }
    }
    public void saveDealership(Dealership dealership){
        try(PrintWriter printWriter = new PrintWriter(new FileWriter("inventory.csv"))) {
            printWriter.println(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            for (Vehicle vehicle: dealership.getAllVehicles()) {
                printWriter.println(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
            }
        } catch (IOException e) {
            System.out.println("Error saving your dealership file details: " + e.getMessage());
        }
    }
}