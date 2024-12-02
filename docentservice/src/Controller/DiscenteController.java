package Controller;

import model.Corso;
import model.Discente;
import service.CorsoService;
import service.DiscenteServices;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiscenteController {
    public  void deleteDiscente() {
        System.out.println("Elimina il discente con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        DiscenteServices oDiscenteService = new DiscenteServices();
        oDiscenteService.delete(id);
    }

    public  void readDiscente() {
        System.out.println("ecco la lista dei discenti: ");
        DiscenteServices oDiscenteService = new DiscenteServices();
        List<Discente> listaDiscenti = oDiscenteService.read();
        int i = 0;
        while (i < listaDiscenti.size()) {
            System.out.println(listaDiscenti.get(i).getid() + " " + listaDiscenti.get(i).getCognome() + " " + listaDiscenti.get(i).getNome() + " " + listaDiscenti.get(i).getMatricola() + " " + listaDiscenti.get(i).getDataNascita());
            i++;
        }
    }

    public  void updateDiscente() {
        System.out.println("inserisci l'id del discente da modificare:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("inserisc nome");
        String nome = scanner.nextLine();
        System.out.println("inserisci Cognome");
        String cognome = scanner.nextLine();
        System.out.println("inserisci matricola");
        String matricola = scanner.nextLine();


        System.out.println("inserisci la data di inizio del corso (formato: dd-MM-yyyy)");
        String dataNascitaInput = scanner.nextLine(); // Specificare il formato della data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate data_nascita = LocalDate.parse(dataNascitaInput, formatter);

        DiscenteServices oDiscenteServices = new DiscenteServices();
        oDiscenteServices.update(id, nome, cognome, matricola, data_nascita);
    }

    public  void createDiscente() {

        System.out.println("inserisci nome");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        System.out.println("inserisci Cognome");
        String cognome = scanner.nextLine();
        System.out.println("inserisci matricola");
        String matricola = scanner.nextLine();
        System.out.println("inserisci data di nascita dd-mm-yyyy");
        String dataNascitaInput = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate dataNascita = LocalDate.parse(dataNascitaInput, formatter);
      /*  // Visualizzazione della lista dei corsi disponibili
        System.out.println("ecco la lista dei corsi disponibili:");
        CorsoService corsoService = new CorsoService();
        List<Corso> listaCorsi = corsoService.readCorso();
        for (Corso corso : listaCorsi) {
            System.out.println(corso.getid() + " - " + corso.getNomeCorso());
        }

        // Inserimento degli ID dei corsi associati
        System.out.println("Inserisci gli ID dei corsi a cui il discente sarà iscritto (separati da virgola):");
        String corsiInput = scanner.nextLine();
        String[] corsiIds = corsiInput.split(",");
        List<Corso> corsiAssociati = new ArrayList<>();
        for (String id : corsiIds) {
            int corsoId = Integer.parseInt(id.trim());
            for (Corso corso : listaCorsi) {
                if (corso.getid() == corsoId) {
                    corsiAssociati.add(corso);
                    break;
                }
            }
        }*/
        DiscenteServices oDiscenteServices = new DiscenteServices();
        oDiscenteServices.create(nome, cognome, matricola, dataNascita/*,corsiAssociati*/);
    }

    public  void associateLearnerToCourse() {
        Scanner scanner = new Scanner(System.in);

        // Visualizzazione della lista dei discenti disponibili
        System.out.println("Ecco la lista dei discenti disponibili:");
        DiscenteServices discenteService = new DiscenteServices();
        List<Discente> listaDiscenti = discenteService.read(); // Assumi che questo metodo esista
        for (Discente discente : listaDiscenti) {
            System.out.println(discente.getid() + " - " + discente.getNome() + " " + discente.getCognome());
        }

        // Selezione del discente
        System.out.println("Inserisci l'ID del discente da associare ai corsi:");
        int discenteId = Integer.parseInt(scanner.nextLine());
        Discente discenteSelezionato = null;
        for (Discente discente : listaDiscenti) {
            if (discente.getid() == discenteId) {
                discenteSelezionato = discente;
                break;
            }
        }

        if (discenteSelezionato == null) {
            System.out.println("Discente non trovato.");
            return;
        }

        // Visualizzazione della lista dei corsi disponibili
        System.out.println("Ecco la lista dei corsi disponibili:");
        CorsoService corsoService = new CorsoService();
        List<Corso> listaCorsi = corsoService.readCorso();
        for (Corso corso : listaCorsi) {
            System.out.println(corso.getid() + " - " + corso.getNomeCorso());
        }

        // Inserimento degli ID dei corsi associati
        System.out.println("Inserisci gli ID dei corsi a cui il discente sarà iscritto (separati da virgola):");
        String corsiInput = scanner.nextLine();
        String[] corsiIds = corsiInput.split(",");
        List<Corso> corsiAssociati = new ArrayList<>();
        for (String id : corsiIds) {
            int corsoId = Integer.parseInt(id.trim());
            for (Corso corso : listaCorsi) {
                if (corso.getid() == corsoId) {
                    corsiAssociati.add(corso);
                    break;
                }
            }
        }

        // Associazione del discente ai corsi selezionati
        for (Corso corso : corsiAssociati) {
            discenteSelezionato.aggiungiCorso(corso);
            corso.aggiungiDiscente(discenteSelezionato);
            discenteService.associateLearnerToCourse( corso.getid(),discenteSelezionato);
        }

        System.out.println("Discente " + discenteSelezionato.getNome() + " " + discenteSelezionato.getCognome() + " è stato associato ai corsi selezionati.");
    }
}
