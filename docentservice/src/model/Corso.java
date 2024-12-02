package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*crea nuovo corso:
1. far aggiungere all'utente i campi descrittivi di corso
2. far visualizzare la lista dei docenti esistenti e fare inserire all'utente l'identificativo del docente.
3. salva corso

4.lista corsi:
far visualizzare la lista dei corsi ed il nome ed il cognome del docente che tiene il corso
*/
public class Corso {
    private int id;
    private String nome_corso;
    private LocalDate data_inizio;
    private String durata;
    private Docente docente;
    private List<Discente> listaDiscenti;

    public Corso(){
        this.listaDiscenti = new ArrayList<>();
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getid() {
        return id;
    }

    public void setNomeCorso(String nome) {
        this.nome_corso = nome;
    }

    public String getNomeCorso() {
        return nome_corso;
    }

    public void setDatainizio(LocalDate data_inizio) {
        this.data_inizio = data_inizio;
    }

    public LocalDate getDataInizio() {
        return data_inizio;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public String getDurata() {
        return durata;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setListaDiscenti(List<Discente> listaDiscenti){
        this.listaDiscenti = listaDiscenti;
    }

    public List<Discente> getListaDiscenti(){
        return listaDiscenti;
    }

    public void aggiungiDiscente(Discente discente){
        if (!listaDiscenti.contains(discente)){
            listaDiscenti.add(discente);
            discente.aggiungiCorso(this);
        }
    }


}


