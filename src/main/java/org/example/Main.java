
package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args){


        // SET THE PATHS FOR ALL THE CSVs
        String abbonamentiPath = "src/main/java/org/example/abbonamenti.csv";
        String rivistePath = "src/main/java/org/example/riviste.csv";
        String utentiPath = "src/main/java/org/example/utenti.csv";
        abbonamentiPath = Paths.get(System.getProperty("user.dir"), abbonamentiPath).normalize().toString();
        rivistePath = Paths.get(System.getProperty("user.dir"), rivistePath).normalize().toString();
        utentiPath = Paths.get(System.getProperty("user.dir"), utentiPath).normalize().toString();
        // INSTANTIATE OBJECTS FROM THE FILES
        ReadAbbonamento abb = new ReadAbbonamento(abbonamentiPath);
        ReadRivista riv = new ReadRivista(rivistePath);
        ReadUtente users = new ReadUtente(utentiPath);
    }
}