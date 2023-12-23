package org.example;
import java.time.LocalDate;
public class Utente {

    private int ID, DocID;
    private String Nome, Cognome, Indirizzo;
    private LocalDate Nascita;

    public Utente(int id_utente, String nome_utente, String Cognome_utente, LocalDate nascita_utente, String indirizzo_utente, int docID_utente){
        ID=id_utente;
        DocID=docID_utente;
        Nome=nome_utente;
        Cognome=Cognome_utente;
        Indirizzo=indirizzo_utente;
        Nascita=nascita_utente;
    }

    @Override
    public String toString() {
        return "Utente = {" +
                "ID=" + ID +
                ", DocID=" + DocID +
                ", Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", Indirizzo='" + Indirizzo + '\'' +
                ", Nascita=" + Nascita +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDocID() {
        return DocID;
    }

    public void setDocID(int docID) {
        DocID = docID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getIndirizzo() {
        return Indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        Indirizzo = indirizzo;
    }

    public LocalDate getNascita() {
        return Nascita;
    }

    public void setNascita(LocalDate nascita) {
        Nascita = nascita;
    }
}
