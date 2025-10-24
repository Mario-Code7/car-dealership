package com.pluralsight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DealershipFileManager {
    Scanner myScanner = new Scanner(System.in);
    public Dealership getDealership() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));
            String header = myScanner.nextLine();
            String[] parts = header.split("//|");
            Dealership dealership = new Dealership(parts[0], parts[1], parts[2]);

            while (myScanner.hasNextLine()) {
                String[] vehicle = myScanner.nextLine().split("\\|");
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
        } catch (IOException e)
    }
}
