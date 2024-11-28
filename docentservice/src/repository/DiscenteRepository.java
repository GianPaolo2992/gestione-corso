package repository;

import config.DbConnection;
import model.Discente;
import model.Docente;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;


public class DiscenteRepository {

    public void createDiscente(Discente oDiscente){
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            Statement statement = c.createStatement();
            statement.execute("INSERT INTO Discente VALUES ('" + oDiscente.getNome() + "','" + oDiscente.getCognome() + "','" + oDiscente.getMatricola() + "','" + oDiscente.getDataNascita() + "')");

        }catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Discente> read(){
        ArrayList<Discente> listaDiscente = new ArrayList<>();
        try{
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM discente Order BY id ASC");

            while(rs.next()) {
                Discente oDiscente = new Discente();
                oDiscente.setNome(rs.getString("nome"));
                oDiscente.setCognome(rs.getString("cognome"));
                oDiscente.setMatricola(rs.getString("matricola"));
                java.sql.Date sqlDate = rs.getDate("data_nascita");
                LocalDate localDate = (sqlDate != null) ? sqlDate.toLocalDate() : null;
                oDiscente.setDataNascita(localDate);
                listaDiscente.add(oDiscente);
            }
        }catch (SQLException | ClassNotFoundException e) {
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

    public void updateDiscente(Discente oDiscente){
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            Statement statement = c.createStatement();
            statement.execute("UPDATE discente SET nome = '" + oDiscente.getNome() + "',cognome= '" + oDiscente.getCognome() + "',matricola= '" + oDiscente.getMatricola() + "',data_nascita= '" + oDiscente.getDataNascita() + "' WHERE id = '" + oDiscente.getid() + "'");
            System.out.println("model.dao.Discente modificato");
        }catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

}

