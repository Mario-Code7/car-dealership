package com.pluralsight;

public class Program {
    public static void main(String[] args) {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();

        if (dealership != null) {
            UserInterface ui = new UserInterface(dealership);
            ui.display();
            dealershipFileManager.saveDealership(dealership);
        } else {
            System.out.println("Error! Sorry could not find file.");
        }
    }
}
