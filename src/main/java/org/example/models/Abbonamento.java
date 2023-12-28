package org.example.models;

import java.time.LocalDate;

public class Abbonamento {
    private int id_abbonamento, id_rivista, id_utente;
    LocalDate data_inizio, data_fine;

    public Abbonamento(int abbonamento, int rivista, int utente, LocalDate inizio, LocalDate fine) {

        id_abbonamento = abbonamento;
        id_rivista = rivista;
        id_utente = utente;
        data_inizio = inizio;
        data_fine = fine;


    }

    @Override
    public String toString() {
        return "{" +
                "id_abbonamento=" + id_abbonamento +
                ", id_rivista=" + id_rivista +
                ", id_utente=" + id_utente +
                ", data_inizio=" + data_inizio +
                ", data_fine=" + data_fine +
                '}';
    }

    public int getId_abbonamento() {
        return id_abbonamento;
    }

    public LocalDate getData_inizio() {
        return data_inizio;
    }

    public LocalDate getData_fine() {
        return data_fine;
    }


    public int getId_rivista() {
        return id_rivista;
    }


    public int getId_utente() {
        return id_utente;
    }


}
