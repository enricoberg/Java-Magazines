package org.example.controller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.example.models.*;
import org.example.utilities.Utilities;

public class Query {
    public static void getAllSubscriptions() {
        System.out.println("RESULTS:\n[");
        int count = 0;
        int size = Database.abb.abbonamentoList.size();
        for (Abbonamento sub : Database.abb.abbonamentoList) {
            int id_abb = sub.getId_abbonamento();
            int id_rivista = sub.getId_rivista();
            int id_utente = sub.getId_utente();

            LocalDate inizio = sub.getData_inizio();
            LocalDate fine = sub.getData_fine();
            String luogo = "null";
            String nome = "null";
            String available = "null";
            String descrizione = "null";
            long duration = ChronoUnit.DAYS.between(inizio, fine);

            for (Utente user : Database.users.utenteList) {

                if (user.getID() == id_utente) {

                    luogo = user.getIndirizzo();
                    break;
                }
            }
            for (Rivista mag : Database.riv.rivistaList) {
                if (mag.getID() == id_rivista) {
                    available = mag.getDisponibile();
                    nome = mag.getNome();
                    descrizione = mag.getDescrizione();
                    break;
                }
            }
            if (nome.equals("null") || luogo.equals("null")) continue;

            System.out.println("{\n" +
                    "\t\"id_abbonamento\": \"" + id_abb + "\",\n" +
                    "\t\"nome\":  \"" + nome + "\",\n" +
                    "\t\"descrizione\":  \"" + descrizione + "\",\n" +
                    "\t\"data_inizio\":  \"" + inizio + "\",\n" +
                    "\t\"durata\":" + duration + ",\n" +
                    "\t\"luogo\":  \"" + luogo + "\",\n" +
                    "\t\"disponibile\":  \"" + available + "\"");
            count++;
            if (count != size) System.out.println("},");
            else System.out.println("}\n]");
        }
        System.out.println();
    }

    public static void subscribe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert the ID of the user that wants to suscribe");
        int id_utente = Utilities.ValidatedUserInteger();
        //CHECK IF THE USER INSERTED ALREADY EXISTS
        boolean found = false;
        for (Utente user : Database.users.utenteList) {
            if (user.getID() == id_utente) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The user does not exist");
            return;
        }
        System.out.println("Please insert the ID of the magazine requested");
        int id_rivista = Utilities.ValidatedUserInteger();
        found = false;
        //CHECK THE MAGAZINE IS AVAILABLE FOR SUBSCRIPTION
        for (Rivista mag : Database.riv.rivistaList) {
            if (mag.getID() == id_rivista && mag.getDisponibile().equals("Si")) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The magazine is not available for subscriptions");
            return;
        }
        try {
            Abbonamento abbnew = new Abbonamento(Database.abb.getLatestId() + 1, id_rivista, id_utente, LocalDate.now(), LocalDate.now().plusMonths(6));
            Database.abb.abbonamentoList.add(abbnew);
            for (Rivista mag : Database.riv.rivistaList) {
                if (mag.getID() == id_rivista) mag.setDisponibile("No");
            }
            Database.abb.update();
            Database.riv.update();
            System.out.println("Subscription added correctly");
        } catch (Exception e) {
            System.out.println("Impossible to close subscription.. ");
        }
        System.out.println();
    }

    public static void unsubscribe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert the ID of the subscription you want to cancel");
        int id_sub = Utilities.ValidatedUserInteger();
        boolean found = false;
        try {
            for (Abbonamento sub : Database.abb.abbonamentoList) {
                if (id_sub == sub.getId_abbonamento()) {
                    found = true;
                    Database.abb.abbonamentoList.remove(sub);
                    Database.abb.update();
                    break;
                }

            }
            System.out.println("Subscription successfully cancelled!");
            if (!found) System.out.println("Sorry, the subscription you want to cancel does not exist..");
        } catch (Exception e) {
            System.out.println("Something went wrong canceling the subscription..");
        }
        System.out.println();
    }

    public static void addUser() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Insert the first name of the user");
            String nome = Utilities.ValidatedUserString();
            System.out.println("Insert the second name of the user");
            String cognome = Utilities.ValidatedUserString();
            System.out.println("Insert the date of birth (in format yyyy-mm-dd) of the user");
            LocalDate nascita = Utilities.ValidatedUserDate();
            System.out.println("Insert the address of the user");
            String indirizzo = Utilities.ValidatedUserString();
            System.out.println("Insert the document ID of the user");
            int docId = Utilities.ValidatedUserInteger();
            System.out.println("Press y if you want to add a user with a specific ID, otherwise let the app decide");
            String decision = scanner.nextLine();

            int customId = 1001;

            if (decision.equals("y") || decision.equals("yes")) {
                while(true) {
                    System.out.println("Insert the desired ID for the user");
                    customId = Utilities.ValidatedUserInteger();
                    if (!UserExists(customId)) break;
                    System.out.println("The user specified already exists");
                }
            } else {
                while (UserExists(customId)) {
                    customId++;
                }
            }
            Utente nuovoUtente = new Utente(customId, nome, cognome, nascita, indirizzo, docId);
            Database.users.utenteList.add(nuovoUtente);
            System.out.println(Database.users.update() ? "User added correctly" : "Impossible to add such user");
        } catch (Exception e) {
            System.out.println("Impossible to create the user");
        }
        System.out.println();
    }

    public static boolean UserExists(int id) {

        for (Utente us : Database.users.utenteList) {
            if (us.getID() == id) return true;
        }
        return false;
    }


    public static void ExportCSV() {
        String file_content = "ID;Inserimento;Tipologia;Marca;Taglia;Prezzo";
        for (Rivista riv : Database.riv.rivistaList) {
            //SKIP ALL NOT AVAILABLE MAGAZINES
            if (!riv.getDisponibile().equals("Si")) continue;
            //CREATE NEW LINE FOR EACH AVAILABLE MAGAZINE
            String newLine = "\n" + riv.getID() + ";" + riv.getInserimento().toString() + ";" + riv.getTipologia() + ";" + riv.getMarca() + ";" + riv.getTaglia() + ";" + riv.getPrezzo();
            file_content += newLine;
        }
        LocalDate currentDate = LocalDate.now();
        // Format the current date in desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        String formattedDate = currentDate.format(formatter);
        String filename = Utilities.PathOf("exports/riviste_" + formattedDate + ".csv");
        //FIRST CHECK IF THE DIRECTORY EXISTS AND IF NOT, CREATES IT
        String directoryPath = Utilities.PathOf("exports");
        File directory = new File(directoryPath);
        boolean isDirectoryCreated;
        if (!directory.exists()) isDirectoryCreated = directory.mkdirs();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(file_content);
            System.out.println("Export completed successfully. Filename= riviste_" + formattedDate + ".csv");
        } catch (IOException e) {
            System.out.println("Error exporting the CSV");
        }
        System.out.println();
    }
}
