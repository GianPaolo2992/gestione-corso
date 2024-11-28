package service;

import model.Corso;
import model.Docente;
import repository.CorsoRepository;

import java.time.LocalDate;


public class CorsoService {

    private CorsoRepository corsoRepository = new CorsoRepository();


    public void create(String nome_corso, LocalDate data_inizio, String durata, Docente docente) {
        Corso oCorso = new Corso();

        oCorso.setNomeCorso(nome_corso);
        oCorso.setDatainizio(data_inizio);
        oCorso.setDurata(durata);
        oCorso.setDocente(docente);
        corsoRepository.createCorso(oCorso);
    }
}
