package com.pluralsight;

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
                    processGetByAllVehicles();
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
                    processGetByAddWehicleRequest();
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
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }
    private void displayVehicles() {

    }
}
