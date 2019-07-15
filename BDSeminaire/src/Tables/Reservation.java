package Tables;

import Connexion.ConnexionOracle;
import Enum.Statut;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Reservation {

    private int noPart;
    private Statut statut;
    private ConnexionOracle dbOrcle;
    private Connection conn;

    public Reservation() throws Exception{
//---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

     public void afficherToutReservations(DefaultTableModel dt) throws Exception {
        Object[] donnees = new Object[3];
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Reservations");
                   
            while (rs.next()) {
                donnees[0] = rs.getInt(1);
                donnees[1] = rs.getInt(2);
                donnees[2] = rs.getString(3);
                dt.addRow(donnees);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public int Afficher_Reservation(DefaultTableModel dt, int id_sem) throws Exception {
        Object[] donnees = new Object[3];
        Statement stmt;
        Participants particip = new Participants();
        int i =0;
        try {
            stmt = conn.createStatement();
            // Vision sur la semaine
            ResultSet rs = stmt.executeQuery("SELECT * FROM Reservations WHERE id_sem=" + id_sem);
            while (rs.next()) {
                this.noPart = rs.getInt(1);
                String statut = rs.getString("statut");
                //this.statut = (Statut) statut;
                System.out.println("statut:" + this.statut);
                particip.Afficher_Participants(new DefaultTableModel(),this.noPart);
                donnees[0] = rs.getInt(1);
                donnees[1] = rs.getInt(2);
                donnees[2] = rs.getString(3);
                dt.addRow(donnees);
                
                i++; 
            }
            rs.close();
            stmt.close();
            
            return i;            
        } catch (SQLException ex) {
            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public List<Integer> afficherId(){
        List<Integer> donnees = new ArrayList<Integer>();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM seminaire");
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
    
//    public static void annuler_reservation(Connection conn, int noPart, int idSem) throws SQLException {
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * "
//                + "FROM reservations "
//                + "WHERE nopart = " + noPart + "AND id_sem = " + idSem + " ");
//        if (!rs.next()) {
//            System.out.println("Aucune réservation trouvé");
//        }// Si la réservation existe alors on l'annule
//        else {
//            int nopart = rs.getInt("nopart");
//            int id_sem = rs.getInt("id_sem");
//            int nb = st.executeUpdate("UPDATE reservations SET statut = 'annule' WHERE nopart= " + noPart + "AND id_sem = " + id_sem + " ");
//            System.out.println(nb + " Mise(s) à jour réussie(s)");
//            System.out.println("Réservation annulée");
//        }
//        rs.close();
//        st.close();
//    }
    public int annuler_reservation(int noPart, int idSem) throws SQLException {
        Statement st = conn.createStatement();
        int i = 0 ;
        ResultSet rs = st.executeQuery("SELECT * "
                + "FROM reservations "
                + "WHERE nopart = " + noPart + "AND id_sem = " + idSem + " ");
        if (!rs.next()) {
            System.out.println("Aucune réservation trouvé");
        }// Si la réservation existe alors on l'annule
        else {
            int nopart = rs.getInt("nopart");
            int id_sem = rs.getInt("id_sem");
            int nb = st.executeUpdate("UPDATE reservations SET statut = 'annule' WHERE nopart= " + noPart + "AND id_sem = " + id_sem + " ");
            System.out.println(nb + " Mise(s) à jour réussie(s)");
            System.out.println("Réservation annulée");
            i++;            
        }
        rs.close();
        st.close();
        return i;
    }

//    public static void nbReservations(Connection conn, int idSem) throws SQLException {
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * FROM seminaire WHERE id_sem = " + idSem + " ");
//        if (!rs.next()) {
//            System.out.println("Ce séminaire n'existe pas");
//        } else {
//            ResultSet rs1 = st.executeQuery("SELECT COUNT(*) as NbreParticipants FROM reservations natural join seminaire "
//                    + "WHERE id_sem = " + idSem + " AND statut = 'inscrit' ");
//
//            while (rs1.next()) {
//                int nbRes = rs1.getInt(1);
//                System.out.println("Nombre de réservation = " + nbRes);
//            }
//            rs1.close();
//        }
//        rs.close();
//        st.close();
//    }
    public int nbReservations(int idSem) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM seminaire WHERE id_sem = " + idSem + " ");
        int nbRes = 0;
        if (!rs.next()) {
            System.out.println("Ce séminaire n'existe pas");
        } else {
            ResultSet rs1 = st.executeQuery("SELECT COUNT(*) as NbreParticipants FROM reservations natural join seminaire "
                    + "WHERE id_sem = " + idSem + " AND statut = 'inscrit' ");

            while (rs1.next()) {
                nbRes = rs1.getInt(1);
                System.out.println("Nombre de réservation (inscrit) = " + nbRes);
            }
            rs1.close();
        }
        rs.close();
        st.close();
        return nbRes;
    }
}
