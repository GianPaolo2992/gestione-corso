package Controller;

import model.Corso;
import model.Docente;
import service.CorsoService;
import service.DocenteService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CorsoController {
    public static void createCorso() {

        System.out.println("inserisci il nome del corso");
        Scanner scanner = new Scanner(System.in);
        String nome_corso = scanner.nextLine();

        System.out.println("inserisci la data di inizio del corso (formato: dd-MM-yyyy)");
        String dataInizioInput = scanner.nextLine(); // Specificare il formato della data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate data_inizio = LocalDate.parse(dataInizioInput, formatter);

        System.out.println("inserisci la durata del corso");
        String durata = scanner.nextLine();

        System.out.println("ecco la lista dei docenti: ");

        DocenteService oDocenteService = new DocenteService();
        List<Docente> listaDocenti = oDocenteService.readDocente();
        int i = 0;
        while (i < listaDocenti.size()) {
            System.out.println(listaDocenti.get(i).getid() + " " + listaDocenti.get(i).getCognome() + " " + listaDocenti.get(i).getNome());
            i++;
        }

        System.out.println("scegli uno dei docenti: ");
        int id = scanner.nextInt();
        Docente docente = listaDocenti.get(id - 2);

      /*  // Visualizzazione della lista dei corsi disponibili
        System.out.println("ecco la lista dei corsi disponibili:");
        DiscenteServices discenteService = new DiscenteServices();
        List<Discente> listaDiscente = discenteService.read();
        for (Discente discente : listaDiscente) {
            System.out.println(discente.getid() + " - " + discente.getNome());
        }

        // Inserimento degli ID dei corsi associati
        System.out.println("Inserisci gli ID dei corsi a cui il discente sarà iscritto (separati da virgola):");
        String discenteInput = scanner.nextLine();
        String[] discenteIds = discenteInput.split(",");
        List<Discente> discentiAssociati = new ArrayList<>();
        for (String id_discente : discenteIds) {
            int discenteId = Integer.parseInt(id_discente.trim());
            for (Discente discente : listaDiscente) {
                if (discente.getid() == discenteId) {
                    discentiAssociati.add(discente);
                    break;
                }
            }
        }*/


        CorsoService oCorsoService = new CorsoService();
        oCorsoService.create(nome_corso, data_inizio, durata, docente/*,discentiAssociati*/);

    }

    public static void readCorso(){
        System.out.println("ecco la lista dei corsi");
        CorsoService oCorsoService = new CorsoService();
        List<Corso> listaCorso = oCorsoService.readCorso();
        int i = 0;
        while(i<listaCorso.size()){
            System.out.println(listaCorso.get(i).getid()+" "+
                    listaCorso.get(i).getNomeCorso()+" "+
                    listaCorso.get(i).getDataInizio()+" "+
                    listaCorso.get(i).getDurata()+" "+
                    listaCorso.get(i).getDocente().getNome()+" "+
                    listaCorso.get(i).getDocente().getCognome());
            i++;
        }
    }

    public static void updateCorso() {
        System.out.println("inserisci l'id del Corso da modificare:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("inserisci il nome del corso");
        String nome_corso = scanner.nextLine();

        System.out.println("inserisci la data di inizio del corso (formato: dd-MM-yyyy)");
        String dataInizioInput = scanner.nextLine(); // Specificare il formato della data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate data_inizio = LocalDate.parse(dataInizioInput, formatter);
        System.out.println("inserisci Durata");
        String durata = scanner.nextLine();
        System.out.println("ecco la lista dei docenti: ");

        DocenteService oDocenteService = new DocenteService();
        List<Docente> listaDocenti = oDocenteService.readDocente();
        int i = 0;
        while (i < listaDocenti.size()) {
            System.out.println(listaDocenti.get(i).getid() + " " + listaDocenti.get(i).getCognome() + " " + listaDocenti.get(i).getNome());
            i++;
        }

        System.out.println("scegli uno dei docenti: ");
        int id_docente = scanner.nextInt();
        Docente docente = listaDocenti.get(id_docente - 2);

        CorsoService oCorsoService = new CorsoService();
        oCorsoService.updateCorso(id,nome_corso, data_inizio, durata, docente);
    }

    public static void deleteCorso(){
        System.out.println("scegli un id per eliminare un corso ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        CorsoService oCorsoService = new CorsoService();
        oCorsoService.deleteCorso(id);

    }


}
