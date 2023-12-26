package org.example;
import java.io.BufferedWriter;
import java.io.FileReader;
import com.opencsv.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class ReadRivista {
    public ArrayList<Rivista> rivistaList = new ArrayList<>();
    private String filename= Main.PathOf("riviste.csv");
    public ReadRivista(){

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
                    String nome = nextLine[1];
                    String descrizione = nextLine[2];
                    double prezzo= Double.parseDouble(nextLine[3]);
                    String tipologia = nextLine[4];
                    String disponibile = nextLine[5];


                    Rivista newRivista = new Rivista(ID,nome, descrizione, prezzo, tipologia, disponibile);
                    rivistaList.add(newRivista);




                }
            }
            //System.out.println("Riviste.csv read correctly");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        for (Rivista riv : rivistaList) {
            System.out.println(riv.toString());
        }
        return null;
    }

    public boolean update(){
        String file_content="ID;Nome;Descrizione;Prezzo;Tipologia;Disponibile";
        for(Rivista riv : rivistaList){
            String newLine= "\n"+ riv.getID() + ";" + riv.getNome()+ ";" + riv.getDescrizione() + ";" + riv.getPrezzo() +";" + riv.getTipologia()+";" +riv.getDisponibile();
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
