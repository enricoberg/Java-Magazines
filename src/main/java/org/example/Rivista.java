package org.example;

public class Rivista {
    private int ID;
    private String Nome,Descrizione,Tipologia,Disponibile;
    private double Prezzo;

    public Rivista(int ID_rivista,String Nome_rivista,String Descrizione_rivista, double Prezzo_rivista, String Tipologia_rivista, String Disponibile_rivista){
        ID=ID_rivista;
        Nome=Nome_rivista;
        Descrizione=Descrizione_rivista;
        Tipologia=Tipologia_rivista;
        Disponibile=Disponibile_rivista;
        Prezzo=Prezzo_rivista;
    }

    @Override
    public String toString() {
        return "Rivista ={" +
                "ID=" + ID +
                ", Nome='" + Nome + '\'' +
                ", Descrizione='" + Descrizione + '\'' +
                ", Tipologia='" + Tipologia + '\'' +
                ", Disponibile='" + Disponibile + '\'' +
                ", Prezzo=" + Prezzo +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public String getTipologia() {
        return Tipologia;
    }

    public void setTipologia(String tipologia) {
        Tipologia = tipologia;
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

    public void setPrezzo(double prezzo) {
        Prezzo = prezzo;
    }
}
