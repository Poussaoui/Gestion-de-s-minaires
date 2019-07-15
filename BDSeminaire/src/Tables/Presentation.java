package Tables;

import Connexion.ConnexionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Presentation {

    private final int noPr;
    private String titre;
    private String support;
    private double montant;

    private ConnexionOracle dbOrcle;
    private Connection conn;

    public Presentation() throws Exception {
        this.noPr = 0;

        //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

    public Presentation(int noPr) throws Exception {
        this.noPr = noPr;

        //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

    public Presentation(int noPr, String titre, String support, double montant) throws Exception {
        this.noPr = noPr;
        this.titre = titre;
        this.support = support;
        this.montant = montant;

        //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

    public void afficherToutPresentations(DefaultTableModel dt) throws Exception {
        Object[] donnees = new Object[6];
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_sem, nomAct, nomConf,titre, support, montant "
                    + "FROM Presentation natural join conferenciers natural join Activites natural join Seminaire");

            while (rs.next()) {
                donnees[0] = rs.getInt(1);
                donnees[1] = rs.getString(2);
                donnees[2] = rs.getString(3);
                donnees[3] = rs.getString(4);
                donnees[4] = rs.getString(5);
                donnees[5] = rs.getInt(6) + " €";
                dt.addRow(donnees);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void afficher(Connection conn, int noAct, int noconf) throws SQLException {
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * FROM activites WHERE noAct = " + noAct + " ");
//        if (!rs.next()) {
//            System.out.println("Activité non trouvé");
//        } else {
//            rs.close();
//            ResultSet rs1 = st.executeQuery("SELECT * FROM conferenciers WHERE noConf = " + noconf + " ");
//            if (!rs1.next()) {
//                System.out.println("Conférencier non trouvé");
//            } else {
//                rs1.close();
//                ResultSet rs2 = st.executeQuery("SELECT id_sem, nomAct, nomConf,titre, support, montant "
//                        + "FROM Presentation natural join conferenciers natural join Activites natural join Seminaire");
//                while (rs2.next()) {
//                    System.out.print("Seminaire : " + rs2.getInt(1) + "\t");
//                    System.out.print("Activité : " + rs2.getString(2) + "\t");
//                    System.out.print("Nom Conférencier : " + rs2.getString(3) + "\t");
//                    System.out.print("Titre : " + rs2.getString(4) + "\t");
//                    System.out.print("Support : " + rs2.getString(5) + "\t");
//                    System.out.println("Montant de la prestation : " + rs2.getInt(6));
//                }
//                rs2.close();
//            }
//            st.close();
//        }
//    }

    public int afficher(DefaultTableModel dt, int noAct, int noconf) throws Exception {
        int i = 0;
        Object[] donnees = new Object[6];
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_sem, nomAct, nomConf,titre, support, montant "
                    + "FROM Presentation natural join conferenciers natural join Activites natural join Seminaire WHERE noAct = "+noAct+" AND noConf = "+noconf+"");

            while (rs.next()) {
                donnees[0] = rs.getInt(1);
                donnees[1] = rs.getString(2);
                donnees[2] = rs.getString(3);
                donnees[3] = rs.getString(4);
                donnees[4] = rs.getString(5);
                donnees[5] = rs.getInt(6) + " €";
                dt.addRow(donnees);
                i++;
            }
            rs.close();
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}
