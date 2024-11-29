package repository;

import config.DbConnection;
import model.Discente;


import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;


public class DiscenteRepository {

    public void createDiscente(Discente oDiscente) {
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "INSERT INTO discente (nome,cognome,matricola,data_nascita) VALUES (?,?,?,?)";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1,oDiscente.getNome());
            pstmt.setString(2,oDiscente.getCognome());
            pstmt.setString(3, oDiscente.getMatricola());
            pstmt.setDate(4,java.sql.Date.valueOf(oDiscente.getDataNascita()));
            pstmt.executeUpdate();

            System.out.println("Discente creato con successo");



        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Discente> read() {
        ArrayList<Discente> listaDiscente = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM discente Order BY id ASC");

            while (rs.next()) {
                Discente oDiscente = new Discente();
                oDiscente.setid(rs.getInt("id"));
                oDiscente.setNome(rs.getString("nome"));
                oDiscente.setCognome(rs.getString("cognome"));
                oDiscente.setMatricola(rs.getString("matricola"));
                java.sql.Date sqlDate = rs.getDate("data_nascita");
                LocalDate localDate = (sqlDate != null) ? sqlDate.toLocalDate() : null;
                oDiscente.setDataNascita(localDate);
                listaDiscente.add(oDiscente);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaDiscente;
    }

    public void deleteDiscente(Discente oDiscente) {
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            String query = "DELETE FROM discente WHERE id = ?";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setInt(1, oDiscente.getid());
            pstmt.executeUpdate();
            System.out.println("Discente eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateDiscente(Discente oDiscente) {
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
             String query= "UPDATE discente SET nome = ?,cognome= ?,matricola= ?,data_nascita= ? WHERE id = ?";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1,oDiscente.getNome());
            pstmt.setString(2,oDiscente.getCognome());
            pstmt.setString(3,oDiscente.getMatricola());
            pstmt.setDate(4,java.sql.Date.valueOf(oDiscente.getDataNascita()));
            pstmt.setInt(5,oDiscente.getid());
            pstmt.executeUpdate();
            System.out.println("model.dao.Discente modificato");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

}

