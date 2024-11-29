package service;

import model.Corso;
import model.Docente;
import repository.CorsoRepository;

import java.time.LocalDate;
import java.util.List;


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

    public List<Corso> readCorso(){

        return corsoRepository.readCorso();

    }
    public void updateCorso(int id,String nome_corso, LocalDate data_inizio, String durata, Docente docente){
        Corso oCorso = new Corso();
        oCorso.setid(id);
        oCorso.setNomeCorso(nome_corso);
        oCorso.setDatainizio(data_inizio);
        oCorso.setDurata(durata);
        oCorso.setDocente(docente);
        corsoRepository.updateCorso(oCorso);
    }

    public void deleteCorso(int id){
        Corso oCorso = new Corso();
        oCorso.setid(id);
        corsoRepository.deleteCorso(oCorso);
    }
}
