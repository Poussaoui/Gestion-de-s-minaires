package Tables;

import Connexion.ConnexionOracle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Salle {

    private int noSalle;
    private int nbPlace;
    private int id_prest;
    
    private ConnexionOracle dbOrcle;
    private Connection conn;

    public Salle() throws Exception {
//---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

    public Salle(int noSalle) throws Exception {
        this.noSalle = noSalle;
        //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

    public Salle(int noSalle, int nbPlace) {
        this.noSalle = noSalle;
        this.nbPlace = nbPlace;
    }

    public int getNoSalle() {
        return noSalle;
    }

    public int getNbPlace() {
        return nbPlace;
    }

     public void afficherToutesSalles(DefaultTableModel dt) throws Exception {
        String[] donnees = new String[3];
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM salle");
           
            while (rs.next()) {
                donnees[0] = Integer.toString(rs.getInt(1));
                donnees[1] = Integer.toString(rs.getInt(2));
                donnees[2] = Integer.toString(rs.getInt(3));
                dt.addRow(donnees);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public List<Integer> afficherIdSalle(int id){
        List<Integer> donnees = new ArrayList<Integer>();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT noSalle FROM salles WHERE id_prest = "+id);
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
    public Salle choisir_salle(Connection conn, int id_prest) throws Exception {
        Salle salle = null;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM prestataire natural join salles WHERE id_prest = " + id_prest + " ");
        if (!rs.next()) {
            System.out.println("Prestataire non trouvé");
        } else {
            rs.close();
            salle.noSalle = rs.getInt("noSalle");
            salle = new Salle(salle.noSalle);
            int nb = st.executeUpdate("UPDATE salle SET noSalle = " + salle.getNoSalle() + " WHERE id_prest = " + id_prest + " ");
            System.out.println(nb + " Mise à jour réussi");
        }
        st.close();
        return salle;
    }
}
