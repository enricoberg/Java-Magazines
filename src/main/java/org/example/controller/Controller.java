package org.example.controller;
import java.util.Scanner;
public class Controller {
    public static boolean control(){
        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine();
        switch (choice) {
            case ("1"):
                Query.getAllSubscriptions();
                break;
            case("2"):
                Query.subscribe();
                break;
            case("3"):
                Query.unsubscribe();
                break;
            case("4"):
                Query.addUser();
                break;
            case("5"):
                Query.ExportCSV();
                break;
            case ("0"):
                System.out.println("Exiting...");
                return false;
            default:
                System.out.println("Sorry your choice is invalid");
        }
        return true;
    }
}
