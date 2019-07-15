package Tables;

import Connexion.ConnexionOracle;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Activites {

    private int noAct;
    private String nomAct;
    private int id_sem;
    private int duree;

    ConnexionOracle dbOrcle;
    Connection conn;

    public Activites() throws Exception {

        //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

    public void afficherTouteActivites(DefaultTableModel dt) throws Exception {
        Object[] donnees = new Object[4];
        Statement stmt;
        try {
            stmt = conn.createStatement();

            // Vision sur la semaine
            ResultSet rs = stmt.executeQuery("SELECT * FROM activites");
            while (rs.next()) {
                donnees[0] = rs.getInt(1);
                donnees[1] = rs.getString(2);
                donnees[2] = rs.getInt(3);
                donnees[3] = rs.getInt(4);
                dt.addRow(donnees);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void afficherActivités(Connection conn, int id_sem) {
//        Statement stmt;
//        try {
//            stmt = conn.createStatement();
//
//            // Vision sur la semaine
//            ResultSet rs = stmt.executeQuery("SELECT * FROM activites WHERE id_sem=" + id_sem + "");
//            while (rs.next()) {
//                this.noAct = rs.getInt(1);
//                this.nomAct = rs.getString(2);
//                this.id_sem = rs.getInt(3);
//                this.duree = rs.getInt(4);
//                System.out.println("Nom " + this.nomAct);
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public int afficherActivite(DefaultTableModel dt, int id_sem) {
        Statement stmt;
        Object[] donnees = new Object[4];
        int i = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM activites WHERE id_sem=" + id_sem + "");
            while (rs.next()) {
                this.noAct = rs.getInt(1);
                this.nomAct = rs.getString(2);
                this.id_sem = rs.getInt(3);
                this.duree = rs.getInt(4);
                
                donnees[0] = rs.getInt(1);                
                donnees[1] = rs.getString(2);
                donnees[2] = rs.getInt(3);                
                donnees[3] = rs.getInt(4);
                dt.addRow(donnees);
                
                System.out.println("Nom " + this.nomAct);
                i++;
            }
            rs.close();
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

//    public void ajouterActivité(Connection conn, int id_sem, String nomAct) throws SQLException {
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * FROM seminaire WHERE id_sem = " + id_sem + "");
//        if (!rs.next()) {
//            System.out.println("Aucun séminaire trouvé");
//        } else {
//            int noAct = 0;
//            rs.close();
//            ResultSet rs1 = st.executeQuery("SELECT MAX(noAct) FROM activites");
//            if (rs1.next()) {
//                noAct = rs1.getInt(1) + 1;
//                int nb = st.executeUpdate("INSERT INTO activites(noAct,nomAct,id_sem) VALUES('" + noAct + "','" + nomAct + "','" + id_sem + "')");
//                System.out.println(nb + " activité ajoutée");
//                rs1.close();
//            }
//        }
//        st.close();
//    }
    public int ajouterActivité(int id_sem, String nomAct) throws Exception {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM seminaire WHERE id_sem = " + id_sem + "");
        if (!rs.next()) {
            System.out.println("Aucun séminaire trouvé");
        } else {
            int noAct = 0;
            rs.close();
            ResultSet rs1 = st.executeQuery("SELECT MAX(noAct) FROM activites");
            if (rs1.next()) {
                noAct = rs1.getInt(1) + 1;
                int nb = st.executeUpdate("INSERT INTO activites(noAct,nomAct,id_sem) VALUES('" + noAct + "','" + nomAct + "','" + id_sem + "')");
                System.out.println(nb + " activité ajoutée");
                rs1.close();
                return 1;
            }
        }
        st.close();
        return -1;
    }
}
