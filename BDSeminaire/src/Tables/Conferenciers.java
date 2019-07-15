package Tables;

import Connexion.ConnexionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Conferenciers extends Personne{
    
    private final int noConf;
    private ConnexionOracle dbOrcle;
    private Connection conn;

    public Conferenciers() throws Exception {
        noConf = 0;
        //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

    public Conferenciers(int noConf, String nom, String prenom) throws Exception {
        super(nom, prenom);
        this.noConf = noConf;
        
        //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }
    
    
    public void afficherToutConferencier(DefaultTableModel dt) throws Exception {
        String[] donnees = new String[6];
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Conferenciers");
            while (rs.next()) {
                donnees[0] = Integer.toString(rs.getInt(1));
                donnees[1] = rs.getString(2);
                donnees[2] = rs.getString(3);
                donnees[3] = rs.getString(4);
                donnees[4] = rs.getString(5);
                donnees[5] = rs.getString(6);
                dt.addRow(donnees);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
