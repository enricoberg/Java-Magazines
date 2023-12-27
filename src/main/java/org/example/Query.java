package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Query {
    public static void getAllSubscriptions(){
        for(Abbonamento sub: Database.abb.abbonamentoList){
            int id_abb=sub.getId_abbonamento();
            int id_rivista=sub.getId_rivista();
            int id_utente=sub.getId_utente();

            LocalDate inizio=sub.getData_inizio();
            LocalDate fine=sub.getData_fine();
            String luogo = "null";
            String nome="null";
            String available="null";
            String descrizione="null";
            long duration = ChronoUnit.DAYS.between(inizio, fine);
            for(Utente user : Database.users.utenteList){

                if(user.getID()==id_utente) {

                    luogo=user.getIndirizzo();
                    break;
                }
            }
            for (Rivista mag : Database.riv.rivistaList){
                if(mag.getID()==id_rivista){
                    available=mag.getDisponibile();
                    nome=mag.getNome();
                    descrizione=mag.getDescrizione();
                    break;
                }
            }
            if(nome.equals("null") || luogo.equals("null")) continue;

            System.out.println("{" +
                    "id_abbonamento=" + id_abb +
                    ", nome=" + nome +
                    ", descrizione=" + descrizione +

                    ", data_inizio=" + inizio +
                    ", durata=" + duration +
                    ", luogo=" + luogo +
                    ", disponibile=" + available +
                    '}');

        }
    }

    public static void subscribe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert the ID of the user that wants to suscribe");
                    int id_utente= scanner.nextInt();
                    scanner.nextLine();
                    //CHECK IF THE USER INSERTED ALREADY EXISTS
                    boolean found=false;
                    for(Utente user : Database.users.utenteList){
                        if(user.getID()==id_utente) found=true;
                    }
                    if (!found) {
                        System.out.println("The user does not exist");
                        return;
                    }
                    System.out.println("Please insert the ID of the magazine requested");
                    int id_rivista= scanner.nextInt();
                    scanner.nextLine();
                    found=false;
                    //CHECK THE MAGAZINE IS AVAILABLE FOR SUBSCRIPTION
                    for(Rivista mag : Database.riv.rivistaList){
                        if(mag.getID()==id_rivista && mag.getDisponibile().equals("Si")) found=true;
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
                    }
                    catch(Exception e) {
                        System.out.println("Impossible to close subscription.. ");
                    }
    }

    public static void unsubscribe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert the ID of the subscription you want to cancel");
        int id_sub= scanner.nextInt();
        boolean found=false;
        try {
            for (Abbonamento sub : Database.abb.abbonamentoList) {
                if (id_sub == sub.getId_abbonamento()) {
                    found = true;
                    Database.abb.abbonamentoList.remove(sub);
                    Database.abb.update();
                    break;
                }

            }
            if (!found) System.out.println("Sorry, the subscription you want to cancel does not exist..");
        }
        catch(Exception e){
            System.out.println("Something went wrong canceling the subscription..");
        }
    }

    public static void addUser(){
        Scanner scanner = new Scanner(System.in);
        try {
        System.out.println("Insert the first name of the user");
        String nome = scanner.nextLine();
        System.out.println("Insert the second name of the user");
        String cognome = scanner.nextLine();
        System.out.println("Insert the date of birth (in format yyyy-mm-dd) of the user");
        LocalDate nascita = LocalDate.parse(scanner.nextLine());
        System.out.println("Insert the address of the user");
        String indirizzo = scanner.nextLine();
        System.out.println("Insert the document ID of the user");
        int docId= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Press y if you want to add a user with a specific ID, otherwise let the app decide");
        String decision = scanner.nextLine();
        int customId=1001;

            if (decision.equals("y") || decision.equals("yes")) {
                System.out.println("Insert the desired ID for the user");
                customId = scanner.nextInt();
                scanner.nextLine();
            } else {
                while (UserExists(customId)) {
                    customId++;
                }
            }
            Utente nuovoUtente = new Utente(customId, nome, cognome, nascita, indirizzo, docId);
            Database.users.utenteList.add(nuovoUtente);
            System.out.println(Database.users.update() ? "User added correctly" : "Impossible to add such user");
        }
        catch(Exception e){
            System.out.println("Impossible to create the user");
        }
    }

    public static boolean UserExists(int id){

        for(Utente us : Database.users.utenteList){
            if(us.getID()==id) return true;
        }
        return false;
    }
    public ReadRivista obsoleteMagazine(int id, ReadRivista riv){
        for(Rivista i : riv.rivistaList){
            if (i.getID()==id) i.setDisponibile("No");
        }
        return riv;
    }
    public static void ExportCSV(){
        String file_content="ID;Inserimento;Tipologia;Marca;Taglia;Prezzo";
        for(Rivista riv : Database.riv.rivistaList){
            //SKIP ALL NOT AVAILABLE MAGAZINES
            if(!riv.getDisponibile().equals("Si")) continue;
            //CREATE NEW LINE FOR EACH AVAILABLE MAGAZINE
            String newLine= "\n"+ riv.getID() + ";" + riv.getInserimento().toString()+ ";" + riv.getTipologia() + ";" + riv.getMarca() +";" + riv.getTaglia()+";" +riv.getPrezzo();
            file_content+=newLine;
        }
        LocalDate currentDate = LocalDate.now();
        // Format the current date in desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        String formattedDate = currentDate.format(formatter);
        String filename=Main.PathOf("exports/riviste_"+ formattedDate + ".csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(file_content);
            System.out.println("Export completed successfully. Filename= riviste_" + formattedDate + ".csv");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Error exporting the CSV");
        }
    }
}
