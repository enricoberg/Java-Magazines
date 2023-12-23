package org.example;

import java.time.LocalDate;
import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.ArrayList;
public class ReadUtente {
    public ReadUtente(String filename){
        CSVReader reader = null;
        try
        {
            ArrayList<Utente> utenteList = new ArrayList<>();
            reader = new CSVReader(new FileReader(filename));
            String [] nextLine;
            boolean isFirstLine = true;
            while ((nextLine = reader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the first line (headers)
                }
                if (nextLine.length >= 5) { // Ensure the line has at least 5 values
                    //ID,Nome,Cognome,Nascita,Indirizzo,DocID,
                    int ID = Integer.parseInt(nextLine[0]);
                    String Nome = nextLine[1];
                    String Cognome = nextLine[2];
                    LocalDate Nascita= LocalDate.parse(nextLine[3]);
                    String Indirizzo = nextLine[4];
                    int DocID = Integer.parseInt(nextLine[5]);
                    Utente newUtente = new Utente(ID,Nome, Cognome,Nascita,Indirizzo, DocID);
                    utenteList.add(newUtente);




                }
            }
            System.out.println("Abbonamenti.csv read correctly");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
