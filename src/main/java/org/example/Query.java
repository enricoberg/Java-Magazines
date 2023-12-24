package org.example;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Query {
    public static void getAllSubscriptions(ReadAbbonamento subs, ReadRivista mags, ReadUtente users){
        for(Abbonamento abb : subs.abbonamentoList){
            int id_abb=abb.getId_abbonamento();
            int id_rivista=abb.getId_rivista();
            int id_utente=abb.getId_utente();

            LocalDate inizio=abb.getData_inizio();
            LocalDate fine=abb.getData_fine();
            String luogo = "null";
            String nome="null";
            String available="null";
            String descrizione="null";
            long duration = ChronoUnit.DAYS.between(inizio, fine);
            for(Utente user : users.utenteList){

                if(user.getID()==id_utente) {

                    luogo=user.getIndirizzo();
                    break;
                }
            }
            for (Rivista mag : mags.rivistaList){
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
}
