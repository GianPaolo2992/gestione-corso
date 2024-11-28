package repository;

import config.DbConnection;
import model.Corso;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }


}

