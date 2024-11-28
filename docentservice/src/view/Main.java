package view;

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
            }else if (entityChoice == 3) {
                System.out.println("Classe Corso");
                System.out.println("***Menu***");
                System.out.println("1. Crea un nuovo corso");
              /*  System.out.println("2. Aggiorna un discente");
                System.out.println("3. Visualizza la lista di discenti");
                System.out.println("4. Elimina un discente");*/
                System.out.println("9. Exit");
                System.out.print("Inserisci la tua scelta: ");

                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        createCorso();
                        break;
                    /*case 2:
                        updateDiscente();
                        break;
                    case 3:
                        readDiscente();
                        break;
                    case 4:
                        deleteDiscente();
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

    private static  void readDiscente() {
        System.out.println("ecco la lista dei discenti: ");
        DiscenteServices oDiscenteService = new DiscenteServices();
        List<Discente> listaDiscenti= oDiscenteService.read();
        int i = 0;
        while(i<listaDiscenti.size()){
            System.out.println(listaDiscenti.get(i).getid()+" "+listaDiscenti.get(i).getCognome()+" "+listaDiscenti.get(i).getNome()+" "+listaDiscenti.get(i).getMatricola()+" "+listaDiscenti.get(i).getDataNascita());
            i++;}
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
        System.out.println("inserisci data di nascita yyyy-mm-dd");
        String dataNascitaInput = scanner.nextLine();
        LocalDate dataNascita = LocalDate.parse(dataNascitaInput, DateTimeFormatter.ISO_LOCAL_DATE);

        DiscenteServices oDiscenteServices = new DiscenteServices();
        oDiscenteServices.update(id,nome,cognome,matricola,dataNascita);
    }

    private static void createDiscente() {

        System.out.println("inserisci nome");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        System.out.println("inserisci Cognome");
        String cognome = scanner.nextLine();
        System.out.println("inserisci matricola");
        String matricola = scanner.nextLine();
        System.out.println("inserisci data di nascita yyyy-mm-dd");
        String dataNascitaInput = scanner.nextLine();
        LocalDate dataNascita = LocalDate.parse(dataNascitaInput, DateTimeFormatter.ISO_LOCAL_DATE);

        DiscenteServices oDiscenteServices = new DiscenteServices();
        oDiscenteServices.create(nome,cognome,matricola,dataNascita);


    }

    public static void createCorso(){

        System.out.println("inserisci il nome del corso");
        Scanner scanner = new Scanner(System.in);
        String nome_corso = scanner.nextLine();

        System.out.println("inserisci la data di inizio del corso (formato: dd-MM-yyyy)");
        String dataInizioInput = scanner.nextLine(); // Specificare il formato della data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate data_inizio = LocalDate.parse(dataInizioInput,formatter);

        System.out.println("inserisci la durata del corso");
        String durata = scanner.nextLine();

        System.out.println("ecco la lista dei docenti: ");

        DocenteService oDocenteService = new DocenteService();
        List<Docente> listaDocenti= oDocenteService.readDocente();
        int i = 0;
        while(i<listaDocenti.size()){
            System.out.println(listaDocenti.get(i).getid()+" "+listaDocenti.get(i).getCognome()+" "+listaDocenti.get(i).getNome());
            i++;
        }

        System.out.println("scegli uno dei docenti: ");
        int id =scanner.nextInt();
        Docente docente = listaDocenti.get(id-2);



        CorsoService oCorsoService = new CorsoService();
        oCorsoService.create(nome_corso,data_inizio,durata,docente);

    }

    private static void readDocente() {
        System.out.println("ecco la lista dei docenti: ");
        DocenteService oDocenteService = new DocenteService();
        List<Docente> listaDocenti= oDocenteService.readDocente();
        int i = 0;
        while(i<listaDocenti.size()){
            System.out.println(listaDocenti.get(i).getid()+" "+listaDocenti.get(i).getCognome()+" "+listaDocenti.get(i).getNome());
            i++;}

    }


    private static void createDocente () {
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
