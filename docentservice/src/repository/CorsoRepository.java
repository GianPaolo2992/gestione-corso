package repository;

import config.DbConnection;
import model.Corso;

import model.Discente;
import model.Docente;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CorsoRepository {





    public void createCorso(Corso oCorso) {
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "INSERT INTO corso(nome_corso,data_inizio,durata,id_docente) VALUES(?,?,?,?)";

            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1, oCorso.getNomeCorso());
            pstmt.setDate(2, java.sql.Date.valueOf(oCorso.getDataInizio()));
            pstmt.setString(3, oCorso.getDurata());
            pstmt.setInt(4, oCorso.getDocente().getid());
            pstmt.executeUpdate();
            System.out.println("Corso creato con successo");

         /*   ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()){
                int id_corso = rs.getInt(1);
                oCorso.setid(id_corso);

                for(Discente discente : oCorso.getListaDiscenti()){
                    String JQuery =  " INSERT INTO rel_corso_discenti(id_corso,id_discente) VALUES(?,?)";
                    PreparedStatement jpstmt = c.prepareStatement(JQuery);
                    jpstmt.setInt(1,id_corso);
                    jpstmt.setInt(2,discente.getid());
                    jpstmt.executeUpdate();
                    jpstmt.close();
                }
            }*/


        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }





    public ArrayList<Corso> readCorso() {
        ArrayList<Corso> listaCorso = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT c.*, d.nome, d.cognome, d.id FROM corso c JOIN docentetest d ON c.id_docente = d.id ORDER BY c.id asc");//Un oggetto ResultSet (java.sql.ResultSet) è un contenitore per i risultati restituiti da una query SQL. Contiene i dati restituiti dal database e permette di navigare attraverso i risultati.
            while (rs.next()) {
                Corso oCorso = new Corso();
                oCorso.setid(rs.getInt("id"));
                oCorso.setNomeCorso(rs.getString("nome_corso"));
                java.sql.Date sqlDate = rs.getDate("data_inizio");
                LocalDate localDate = (sqlDate != null) ? sqlDate.toLocalDate() : null;
                oCorso.setDatainizio(localDate);
                oCorso.setDurata(rs.getString("durata"));
                Docente docente = new Docente();
                docente.setid(rs.getInt("id_docente"));
                docente.setNome(rs.getString("nome"));
                docente.setCognome(rs.getString("cognome"));
                oCorso.setDocente(docente);
                listaCorso.add(oCorso);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaCorso;
    }

    public void updateCorso(Corso oCorso){
        try{
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "UPDATE corso SET nome_corso =?,data_inizio = ?,durata = ? , id_docente = ? WHERE id = ?";

            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1,oCorso.getNomeCorso());
            pstmt.setDate(2, java.sql.Date.valueOf(oCorso.getDataInizio()));
            pstmt.setString(3,oCorso.getDurata());
            pstmt.setInt(4,oCorso.getDocente().getid());
            pstmt.setInt(5,oCorso.getid());
            pstmt.executeUpdate();
            System.out.println("model.dao.Corso aggiornato");

        }  catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void deleteCorso(Corso oCorso){
        try{
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "DELETE FROM corso WHERE id = ?";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setInt(1,oCorso.getid());
            pstmt.executeUpdate();


        }catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }






}

