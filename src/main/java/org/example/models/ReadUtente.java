package org.example.models;
import java.io.IOException;
import java.time.LocalDate;
import java.io.FileReader;
import com.opencsv.*;
import org.example.utilities.Utilities;
import java.util.ArrayList;

public class ReadUtente {
    public ArrayList<Utente> utenteList = new ArrayList<>();
    private String filename= Utilities.PathOf("utenti.csv");
    public ReadUtente(){

        CSVReader reader = null;
        try
        {
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            reader = new CSVReaderBuilder(new FileReader(filename)).withCSVParser(parser).build();
            String [] nextLine;
            boolean isFirstLine = true;
            while ((nextLine = reader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the first line (headers)
                }
                if (nextLine.length >= 5) {
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
            reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public boolean update(){
        String file_content="ID;Nome;Cognome;Nascita;Indirizzo;DocID";
        for(Utente user : utenteList){
            String newLine= "\n"+ user.getID() + ";" + user.getNome()+ ";" + user.getCognome() + ";" + user.getNascita().toString() +";" + user.getIndirizzo()+";" + user.getDocID();
            file_content+=newLine;
        }

        try{
            Utilities.write(file_content,filename);
            return true;
        }
        catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    public int getLatestId(){
        int max=0;
        for(Utente us: utenteList){
            if (us.getID()>=max) max= us.getID();
        }
        return max;
    }

}
