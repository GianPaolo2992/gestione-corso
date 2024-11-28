package service;

import com.sun.istack.internal.NotNull;
import model.Discente;

import repository.DiscenteRepository;


import java.time.LocalDate;
import java.util.List;

public class DiscenteServices {


    private DiscenteRepository discenteRepository = new DiscenteRepository();

    public void create(String nome, String cognome, String matricola, LocalDate data_nascita) {
        Discente oDiscente = new Discente();
        oDiscente.setCognome(cognome);
        oDiscente.setNome(nome);
        oDiscente.setMatricola(matricola);
        oDiscente.setDataNascita(data_nascita);
        discenteRepository.createDiscente(oDiscente);
    }

    public List<Discente> read() {
        return discenteRepository.read();
    }

    public void delete(int id) {
        Discente oDiscente = new Discente();
        oDiscente.setid(id);
        discenteRepository.deleteDiscente(oDiscente);
    }

    public void update(int id, String nome, String cognome, String matricola, LocalDate data_nascita) {
        Discente oDiscente = new Discente();
        oDiscente.setNome(nome);
        oDiscente.setCognome(cognome);
        oDiscente.setMatricola(matricola);
        oDiscente.setDataNascita(data_nascita);
        oDiscente.setid(id);
        discenteRepository.updateDiscente(oDiscente);
    }


}
