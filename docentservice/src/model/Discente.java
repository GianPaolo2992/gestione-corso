package model;

import java.time.LocalDate;

public class Discente {

    private String nome;
    private String cognome;
    private String matricola;
    private LocalDate data_nascita;
    private int id;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setDataNascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public LocalDate getDataNascita() {
        return data_nascita;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getid() {
        return id;
    }


}

