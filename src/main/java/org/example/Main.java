package org.example;
import java.time.LocalDate;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public int obsoleteMagazine=0;
    public static void main(String[] args){

        // INSTANTIATE OBJECTS FROM THE FILES

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Magazine Administration System.");
        while(true) {
            System.out.println("Please press:\n-1 to view all magazines\n-2 to subscribe to an existing magazine\n-3 to cancel a subscription\n-4 to add new user\n-5 to export available magazines list in CSV\n-0 to exit the program");
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
                    return;
                default:
                    System.out.println("Sorry your choice is invalid");
            }
        }


    }

    public static String PathOf(String filename){
        String resourcePath="src/main/resources/";
        resourcePath= resourcePath + filename;
        resourcePath= Paths.get(System.getProperty("user.dir"), resourcePath).normalize().toString();
        return resourcePath;
    }

}
