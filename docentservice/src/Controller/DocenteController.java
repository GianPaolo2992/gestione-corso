package Controller;

import model.Docente;
import service.DocenteService;

import java.util.List;
import java.util.Scanner;

public class DocenteController {


    public  void createDocente() {
        System.out.println("inserisci nome: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.next();
        System.out.println("inserisci cognome: ");
        String cognome = scanner.next();
        DocenteService oDocenteService = new DocenteService();
        oDocenteService.create(nome, cognome);

    }

    public  void deleteDocente() {
        System.out.println("Elimina il docente con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        DocenteService oDocenteService = new DocenteService();
        oDocenteService.delete(id);

    }

    public  void updateDocente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id del docente da modificare:");
        int id = scanner.nextInt();
        System.out.println("inserisci il nuovo nome:");
        String nome = scanner.next();
        System.out.println("inserisci il nuovo cognome:");
        String cognome = scanner.next();
        DocenteService oDocenteService = new DocenteService();
        oDocenteService.update(id, nome, cognome);

    }

    public  void readDocente() {
        System.out.println("ecco la lista dei docenti: ");
        DocenteService oDocenteService = new DocenteService();
        List<Docente> listaDocenti = oDocenteService.readDocente();
        int i = 0;
        while (i < listaDocenti.size()) {
            System.out.println(listaDocenti.get(i).getid() + " " + listaDocenti.get(i).getCognome() + " " + listaDocenti.get(i).getNome());
            i++;
        }

    }
}
