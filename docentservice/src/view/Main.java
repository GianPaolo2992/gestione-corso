package view;


import java.util.*;



import  Controller.CorsoController;

import Controller.DiscenteController;
import Controller.DocenteController;




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
        System.out.println("4. Associa discente a corso");


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
                DocenteController docenteController = new DocenteController();
                switch (choice) {
                    case 1:
                        docenteController.createDocente();
                        break;
                    case 2:
                        docenteController.updateDocente();
                        break;
                    case 3:
                        docenteController.readDocente();
                        break;
                    case 4:
                        docenteController.deleteDocente();
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
                DiscenteController discenteController =new DiscenteController();
                switch (choice) {
                    case 1:
                        discenteController.createDiscente();
                        break;
                    case 2:
                        discenteController.updateDiscente();
                        break;
                    case 3:
                        discenteController.readDiscente();
                        break;
                    case 4:
                        discenteController.deleteDiscente();
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
                CorsoController corsoController = new CorsoController();
                switch (choice) {
                    case 1:
                        corsoController. createCorso();
                        break;
                    case 2:
                        corsoController.updateCorso();
                        break;
                    case 3:
                        corsoController.readCorso();
                        break;

                    case 4:
                        corsoController.deleteCorso();
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
                DiscenteController discenteController =new DiscenteController();

                switch (choice) {
                    case 1:
                        discenteController.associateLearnerToCourse() ;
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










}
