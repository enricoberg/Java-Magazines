package org.example.models;
import java.time.LocalDate;
import java.io.FileReader;
import com.opencsv.*;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.example.Main;

public class ReadAbbonamento {
    public ArrayList<Abbonamento> abbonamentoList = new ArrayList<>();
    private String filename= Main.PathOf("abbonamenti.csv");

    public ReadAbbonamento(){

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
                if (nextLine.length >= 5) { // Ensure the line has at least 5 values

                    int ID = Integer.parseInt(nextLine[0]);
                    int ID_rivista = Integer.parseInt(nextLine[1]);
                    int id_utente = Integer.parseInt(nextLine[2]);
                    LocalDate Data_Inizio= LocalDate.parse(nextLine[3]);
                    LocalDate Data_Fine = LocalDate.parse(nextLine[4]);
                    Abbonamento newAbbonamento = new Abbonamento(ID,ID_rivista,id_utente,Data_Inizio,Data_Fine);
                    abbonamentoList.add(newAbbonamento);




                }
            }
            //System.out.println("Abbonamenti.csv read correctly");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public int getLatestId(){
        int max=0;
        for(Abbonamento abb: abbonamentoList){
            if (abb.getId_abbonamento()>=max) max=abb.getId_abbonamento();
        }
        return max;
    }

    public boolean update(){
        String file_content="ID;ID_rivista;id_utente;Data_inizio;Data_Fine";
        for(Abbonamento abb : abbonamentoList){
            String newLine= "\n"+ abb.getId_abbonamento() + ";" + abb.getId_rivista() + ";" + abb.getId_utente() + ";" + abb.getData_inizio().toString() +";" + abb.getData_fine().toString();
            file_content+=newLine;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(file_content);
            return true;
        } catch (IOException e) {
            //e.printStackTrace();
            return false;
        }
    }

}

