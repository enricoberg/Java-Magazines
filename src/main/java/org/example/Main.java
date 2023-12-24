
package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // INSTANTIATE OBJECTS FROM THE FILES
        ReadAbbonamento abb = new ReadAbbonamento(PathOf("abbonamenti.csv"));
        ReadRivista riv = new ReadRivista(PathOf("riviste.csv"));
        ReadUtente users = new ReadUtente(PathOf("utenti.csv"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Magazine Administration System.");
        while(true) {
            System.out.println("Please press:\n-1 to view all magazines\n-0 to exit the program");
            String choice = scanner.nextLine();
            switch (choice) {
                case ("1"):
                    Query.getAllSubscriptions(abb,riv,users);
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
