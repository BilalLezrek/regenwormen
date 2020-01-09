
package repository;

import domein.Domeincontroller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SpelerMapper {
    Domeincontroller dc;
    public boolean voegGebruikerToe(Domeincontroller dc)
    {
        this.dc = dc;
        try (Connection conn = DriverManager.getConnection(Mapper.JDBC_URL)) {
            PreparedStatement queryNieuweGebruiker = conn.prepareStatement("INSERT INTO speler(Spelernaam, Geboortedatum, Score) VALUES (?,?,?)");
//            queryNieuweGebruiker.setString(1, this.dc.getNaam()));
//            queryNieuweGebruiker.setDate(2, speler.getGeboorteDatum());
//            queryNieuweGebruiker.setInt(3, speler.getScore());
            queryNieuweGebruiker.executeUpdate();
            return true;
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
            return false;
        }
    }
}
