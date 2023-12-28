package org.example.models;

import java.time.LocalDate;

public class Rivista {
    private int ID;
    private String Nome, Descrizione, Tipologia, Disponibile, Taglia, Marca;
    private double Prezzo;
    private LocalDate Inserimento;

    public Rivista(int ID_rivista, String Nome_rivista, String Descrizione_rivista, double Prezzo_rivista, String Tipologia_rivista, String Disponibile_rivista, LocalDate data_inserimento, String size, String brand) {
        ID = ID_rivista;
        Nome = Nome_rivista;
        Descrizione = Descrizione_rivista;
        Tipologia = Tipologia_rivista;
        Disponibile = Disponibile_rivista;
        Prezzo = Prezzo_rivista;
        Inserimento = data_inserimento;
        Taglia = size;
        Marca = brand;
    }

    @Override
    public String toString() {
        return "{" +
                "ID=" + ID +
                ", Nome='" + Nome + '\'' +
                ", Descrizione='" + Descrizione + '\'' +
                ", Tipologia='" + Tipologia + '\'' +
                ", Disponibile='" + Disponibile + '\'' +
                ", Prezzo=" + Prezzo +
                ", Data inserimento= '" + Inserimento + '\'' +
                ", Taglia='" + Taglia + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }


    public String getMarca() {
        return Marca;
    }

    public String getNome() {
        return Nome;
    }


    public String getTaglia() {
        return Taglia;
    }

    public String getDescrizione() {
        return Descrizione;
    }


    public String getTipologia() {
        return Tipologia;
    }


    public String getDisponibile() {
        return Disponibile;
    }

    public void setDisponibile(String disponibile) {
        Disponibile = disponibile;
    }

    public double getPrezzo() {
        return Prezzo;
    }

    public LocalDate getInserimento() {
        return Inserimento;
    }


}
