package repository;

import config.DbConnection;
import model.Docente;

import java.sql.*;
import java.util.ArrayList;
/*
Scopo:
DocenteRepository gestisce direttamente l'interazione con il database, utilizzando JDBC per eseguire query SQL.
Fornisce metodi CRUD che sono chiamati dal servizio.

Metodi Principali:

createDocente: Inserisce un nuovo record di docente nel database.

readDocente: Recupera tutti i record di docenti dal database.

deleteDocente: Elimina un record di docente dal database.

updateDocente: Aggiorna un record di docente nel database.
*/

/*
DocenteService fornisce metodi di livello superiore che contengono la logica aziendale e
utilizzano DocenteRepository per interagire con il database.

DocenteRepository esegue direttamente le operazioni SQL utilizzando JDBC.
*/
public class DocenteRepository {
    public void createDocente(Docente oDocente) {

        try {
            Connection c = DbConnection.openConnection();//La connessione (java.sql.Connection) è un'interfaccia che rappresenta una sessione con un database specifico. È usata per inviare comandi SQL e ricevere risultati.
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();//Un oggetto Statement (java.sql.Statement) è usato per eseguire un comando SQL statico e restituire i risultati che produce.
            stmt.execute("INSERT INTO DocenteTest VALUES('" + oDocente.getNome() + "','" + oDocente.getCognome() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }



    public ArrayList<Docente> readDocente () {
        ArrayList<Docente> listaDocenti = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DocenteTest ORDER BY id asc");//Un oggetto ResultSet (java.sql.ResultSet) è un contenitore per i risultati restituiti da una query SQL. Contiene i dati restituiti dal database e permette di navigare attraverso i risultati.
            while (rs.next()) {
                Docente oDocente = new Docente();
                oDocente.setNome(rs.getString("nome"));
                oDocente.setCognome(rs.getString("cognome"));
                oDocente.setid(rs.getInt("id"));
                listaDocenti.add(oDocente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaDocenti;
    }
    public void deleteDocente(Docente oDocente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM DocenteTest WHERE id = '" + oDocente.getid() + "'");
            System.out.println("model.dao.Docente eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateDocente(Docente oDocente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE DocenteTest SET nome='"+oDocente.getNome()+"', cognome='"+oDocente.getCognome()+"' WHERE id ="  + oDocente.getid());
            System.out.println("model.dao.Docente aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }








}




