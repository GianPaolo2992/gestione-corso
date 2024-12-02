package view;

import model.Corso;
import model.Discente;
import model.Docente;
import service.CorsoService;
import service.DiscenteServices;
import service.DocenteService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int entityChoice;

        // Scegli se lavorare con Docente o Discente
        System.out.println("Scegli l'entità: ");
        System.out.println("1. Docente");
        System.out.println("2. Discente");
        System.out.println("3. Corso");

        entityChoice = scanner.nextInt();

        do {
            if (entityChoice == 1) {
                System.out.println("Classe Docente");
                System.out.println("***Menu***");
                System.out.println("1. Crea un nuovo docente");
                System.out.println("2. Aggiorna un docente");
                System.out.println("3. Visualizza la lista di docenti");
                System.out.println("4. Elimina un docente");
                System.out.println("9. Exit");
                System.out.print("Inserisci la tua scelta: ");

                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        createDocente();
                        break;
                    case 2:
                        updateDocente();
                        break;
                    case 3:
                        readDocente();
                        break;
                    case 4:
                        deleteDocente();
                        break;
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Scelta errata. Scegliere un numero da 1 a 4 o 9");
                }
            } else if (entityChoice == 2) {
                System.out.println("Classe Discente");
                System.out.println("***Menu***");
                System.out.println("1. Crea un nuovo discente");
                System.out.println("2. Aggiorna un discente");
                System.out.println("3. Visualizza la lista di discenti");
                System.out.println("4. Elimina un discente");
                System.out.println("9. Exit");
                System.out.print("Inserisci la tua scelta: ");

                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        createDiscente();
                        break;
                    case 2:
                        updateDiscente();
                        break;
                    case 3:
                        readDiscente();
                        break;
                    case 4:
                        deleteDiscente();
                        break;
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Scelta errata. Scegliere un numero da 1 a 4 o 9");
                }
            } else if (entityChoice == 3) {
                System.out.println("Classe Corso");
                System.out.println("***Menu***");
                System.out.println("1. Crea un nuovo corso");
                System.out.println("2. Aggiorna un corso");
                System.out.println("3. Visualizza la lista di corsi");
                  System.out.println("4. Elimina un corso");
                System.out.println("9. Exit");
                System.out.print("Inserisci la tua scelta: ");

                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        createCorso();
                        break;
                    case 2:
                        updateCorso();
                        break;
                    case 3:
                        readCorso();
                        break;

                    case 4:
                        deleteCorso();
                        break;
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Scelta errata. Scegliere un numero da 1 a 4 o 9");
                }
            }else if (entityChoice == 4) {
                System.out.println("associa il discente al Corso");
                System.out.println("***Menu***");
                System.out.println("1. Associa  discente a un nuovo corso");
                //System.out.println("2. Aggiorna  corso associato a discente");
                System.out.println("2. Visualizza la lista di corsi del discente");
                System.out.println("3. Elimina un ");
                System.out.println("9. Exit");
                System.out.print("Inserisci la tua scelta: ");

                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        associateLearnerToCourse() ;
                        break;
                    /*case 2:
                        updateCorso();
                        break;
                    case 3:
                        readCorso();
                        break;

                    case 4:
                        deleteCorso();
                        break;*/
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Scelta errata. Scegliere un numero da 1 a 4 o 9");
                }
            }
        } while (choice != 9);
        scanner.close();
    }


    private static void deleteDiscente() {
        System.out.println("Elimina il discente con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        DiscenteServices oDiscenteService = new DiscenteServices();
        oDiscenteService.delete(id);
    }

    private static void readDiscente() {
        System.out.println("ecco la lista dei discenti: ");
        DiscenteServices oDiscenteService = new DiscenteServices();
        List<Discente> listaDiscenti = oDiscenteService.read();
        int i = 0;
        while (i < listaDiscenti.size()) {
            System.out.println(listaDiscenti.get(i).getid() + " " + listaDiscenti.get(i).getCognome() + " " + listaDiscenti.get(i).getNome() + " " + listaDiscenti.get(i).getMatricola() + " " + listaDiscenti.get(i).getDataNascita());
            i++;
        }
    }

    private static void updateDiscente() {
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

    private static void createDiscente() {

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

    public static void associateLearnerToCourse() {
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

    private static void updateCorso() {
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

    private static void deleteCorso(){
        System.out.println("scegli un id per eliminare un corso ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        CorsoService oCorsoService = new CorsoService();
        oCorsoService.deleteCorso(id);

    }

    private static void readDocente() {
        System.out.println("ecco la lista dei docenti: ");
        DocenteService oDocenteService = new DocenteService();
        List<Docente> listaDocenti = oDocenteService.readDocente();
        int i = 0;
        while (i < listaDocenti.size()) {
            System.out.println(listaDocenti.get(i).getid() + " " + listaDocenti.get(i).getCognome() + " " + listaDocenti.get(i).getNome());
            i++;
        }

    }


    private static void createDocente() {
        System.out.println("inserisci nome: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.next();
        System.out.println("inserisci cognome: ");
        String cognome = scanner.next();
        DocenteService oDocenteService = new DocenteService();
        oDocenteService.create(nome, cognome);

    }

    private static void deleteDocente() {
        System.out.println("Elimina il docente con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        DocenteService oDocenteService = new DocenteService();
        oDocenteService.delete(id);

    }

    private static void updateDocente() {
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

}
