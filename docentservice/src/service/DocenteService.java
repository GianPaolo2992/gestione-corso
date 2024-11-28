package service;

import model.Docente;
import repository.DocenteRepository;

import java.util.List;

public class DocenteService {

    private DocenteRepository docenteRepository = new DocenteRepository();

    public void create(String nome, String cognome) {
        Docente oDocente = new Docente();
        oDocente.setCognome(cognome);
        oDocente.setNome(nome);
        docenteRepository.createDocente(oDocente);
    }

    //readDocente: Recupera tutti i docenti dal database usando docenteRepository.readDocente().
    public List<Docente> readDocente(){
        return docenteRepository.readDocente();
    }

    //delete: Elimina un docente dal database usando docenteRepository.deleteDocente().
    public void delete(int id) {
        Docente oDocente = new Docente();
        oDocente.setid(id);
        docenteRepository.deleteDocente(oDocente);
    }

    //update: Aggiorna le informazioni di un docente nel database usando docenteRepository.updateDocente().
    public void update(int id, String nome, String cognome) {
        Docente oDocente = new Docente();
        oDocente.setNome(nome);
        oDocente.setCognome(cognome);
        oDocente.setid(id);
        docenteRepository.updateDocente(oDocente);
    }


}


