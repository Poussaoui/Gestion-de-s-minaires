package Tables;

import Connexion.ConnexionOracle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Animateur extends Personne{
    private int noAnim;
    private String pass;
    ConnexionOracle dbOrcle;
    Connection conn;
    
    public Animateur() throws Exception{
        //---------conx avec bd
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }
    
    public Animateur(int noAnim, String nom, String prenom) throws Exception {
        super(nom, prenom);
        this.noAnim = noAnim;
        
        //---------conx avec bd
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

    public int getNoAnim() {
        return noAnim;
    }
    
    public List<Integer> afficherIdAnimateurs(){
        List<Integer> donnees = new ArrayList<Integer>();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Animateur");
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
    
   
    
    public void afficherToutsAnimateurs(DefaultTableModel dt) throws Exception {
        String[] donnees = new String[6];
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Animateur");
            
            while (rs.next()) {
                donnees[0] = Integer.toString(rs.getInt(1));
                donnees[1] = rs.getString(2);
                donnees[2] = rs.getString(3);
                donnees[3] = rs.getString(5);
                donnees[4] = rs.getString(6);
                donnees[5] = rs.getString(7);
                dt.addRow(donnees);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void ajouter_animateur(){
        
    }
}
