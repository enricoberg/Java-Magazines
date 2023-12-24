package org.example;
import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.ArrayList;
public class ReadRivista {
    public ArrayList<Rivista> rivistaList = new ArrayList<>();
    public ReadRivista(String filename){
        CSVReader reader = null;
        try
        {

            reader = new CSVReader(new FileReader(filename));
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
}
