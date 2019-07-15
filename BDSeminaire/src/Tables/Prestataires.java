package Tables;

import Connexion.ConnexionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Prestataires {
    private final int idPrest;
    private String nomPrest;
    private String adressePrest;
    private String telPrest;
    private double tarifSalle;
    private double tarifPause;
    private double tarifRepas;
    private ConnexionOracle dbOrcle;
    private Connection conn;

    

    public Prestataires() throws Exception {
        this.idPrest = 0;
                 //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }    
    
    public Prestataires(int idPrest) throws Exception {
        this.idPrest = idPrest;
                 //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

     public void afficherToutPrestataires(DefaultTableModel dt) throws Exception {
        String[] donnees = new String[7];
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Prestataire");
            
        
            while (rs.next()) {
                donnees[0] = Integer.toString(rs.getInt(1));
                donnees[1] = rs.getString(2);
                donnees[2] = rs.getString(3);
                donnees[3] = rs.getString(4);
                donnees[4] = Integer.toString(rs.getInt(5))+" €";                
                donnees[5] = Integer.toString(rs.getInt(6))+" €";
                donnees[6] = Integer.toString(rs.getInt(7))+" €";
                
                dt.addRow(donnees);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public List<Integer> afficherIdPrestatair(){
        List<Integer> donnees = new ArrayList<Integer>();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Prestataire");
            int i =0;
            while (rs.next()) {
                donnees.add(rs.getInt(1));
                i++;
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return donnees;
    }
     
    public int getIdPrest() {
        return idPrest;
    }

    public String getNomPrest() {
        return nomPrest;
    }

   
    public double getTarifSalle() {
        return tarifSalle;
    }

    public double getTarifPause() {
        return tarifPause;
    }

    public double getTarifRepas() {
        return tarifRepas;
    }
    
    
}
