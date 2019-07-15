package Tables;

import Connexion.ConnexionOracle;
import java.util.Date;
import Enum.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Seminaire {

    private int id_sem;
    private int id_prest;
    private int noSalle;
    private int noAnim;
    private String theme;
    private int nbmaxp;
    private String type_sem;
    private Date date_sem;
    private String dejeuner;
    private int tarifPart;
    private String etat;
    private Activites[] activites;
    public static boolean programme;

    private ConnexionOracle dbOrcle;
    private Connection conn;

    public Seminaire() throws Exception {
        //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

    public Seminaire(int id_sem) throws Exception {
        this.id_sem = id_sem;
        //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

    public Seminaire(int id_sem, String theme, String type_sem) throws Exception {
        this.id_sem = id_sem;
        this.theme = theme;
        this.type_sem = type_sem;
        //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }

    public Seminaire(int id_sem, int id_prest, int noSalle, int noAnim, String theme, int nbmaxp, String type_sem, Date date_sem, String dejeuner, int tarifPart,String etat) throws Exception {
        this.id_sem = id_sem;
        this.id_prest = id_prest;
        this.noSalle = noSalle;
        this.noAnim = noAnim;
        this.theme = theme;
        this.nbmaxp = nbmaxp;
        this.type_sem = type_sem;
        this.date_sem = date_sem;
        this.dejeuner = dejeuner;
        this.tarifPart = tarifPart;
        this.etat = etat;
        //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }
    
    
    public int getId_sem() {
        return id_sem;
    }

    public String getTheme() {
        return theme;
    }

    public String getType_sem() {
        return type_sem;
    }

    public String hasDejeuner() {
        return dejeuner;
    }

    public String getEtat() {
        return etat;
    }

    public int ajouter_seminaire_sans_programme(Seminaire seminaire) throws SQLException {

        int id_sem = seminaire.id_sem;
        int i = 0;
        // Get a statement from the connection
        Statement st = conn.createStatement();
        // Si l'animateur existe alors
        ResultSet rs = st.executeQuery("SELECT * FROM animateur WHERE noAnim = " + seminaire.noAnim + " ");
        if (!rs.next()) {
            System.out.println("Animateur non trouvé");
        } else {
            rs.close();
            ResultSet rs1 = st.executeQuery("SELECT MAX(id_sem) FROM Seminaire");
            while (rs1.next()) {
                seminaire.id_sem = (rs1.getInt(1)) + 1;
            }
            if (programme) {
                System.out.println("Programme initial:");
                // Insertion des activités
            } else {
                int nb = st.executeUpdate("INSERT INTO Seminaire(id_sem,id_prest,noSalle,noAnim,theme,type_sem,dejeuner,tarifPart,nbmaxPart,dateSem,etat) "
                + "VALUES('" + seminaire.id_sem + "','" + seminaire.id_prest + "','" + seminaire.noSalle + "','" + seminaire.noAnim + "','" + seminaire.theme + "','"+ seminaire.type_sem + "','" + seminaire.dejeuner + "','" + seminaire.tarifPart + "','" + seminaire.nbmaxp + "','" + seminaire.date_sem +"','" + " " + "')");
                i++;
            }
        }
        return i;
    }

    //********************************************
    public void creer_seminaire(Connection conn, Seminaire seminaire, String tp) throws Exception {
        boolean programme = false; 
        // Get a statement from the connection
        Statement st = conn.createStatement();

        ResultSet rs1 = st.executeQuery("SELECT MAX(id_sem) FROM Seminaire");
        while (rs1.next()) {
            seminaire.id_sem = (rs1.getInt(1)) + 1;
        }
        
        if (programme) {
            System.out.println("Programme initial:");
            // Insertion des activités
            
        } else {
            // Conférenciers
        }
        int nb = st.executeUpdate("INSERT INTO Seminaire(id_sem,id_prest,noSalle,noAnim,theme,type_sem,dejeuner,tarifPart,nbmaxPart,dateSem,etat) "
                + "VALUES('" + seminaire.id_sem + "','" + seminaire.id_prest + "','" + seminaire.noSalle + "','" + seminaire.noAnim + "','" + seminaire.theme + "','"+ seminaire.type_sem + "','" + seminaire.dejeuner + "','" + seminaire.tarifPart + "','" + seminaire.nbmaxp + "','" + seminaire.date_sem +"','" + " '" + "')");      
      
    }

    public int annuler_seminaire(int id_sem) throws Exception {
        int i = 0;
        try {
            // Sélection du séminaire de id = id_sem
            Statement st = conn.createStatement();
            // Sélection du séminaire de id = id_sem
            ResultSet rs = st.executeQuery("SELECT * FROM seminaire WHERE id_sem = " + id_sem + " ");
            if (!rs.next()) {
                System.out.println("Aucun séminaire trouvé");
            } else {
                id_sem = rs.getInt("id_sem");
                // Annulation de ce séminaire
                int nb = st.executeUpdate("UPDATE seminaire SET etat = 'annulé' WHERE id_sem = " + id_sem);
                System.out.println(nb + " mise(s) à jour réussie(s)");
                System.out.println("Le séminaire " + id_sem + " a été annulé ");
                i++;
            }
            rs.close();
            return i;
        } catch (Exception ex) {
            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public void confirmer_seminaire(int id_sem) throws SQLException, Exception {
        
        Statement stmt = conn.createStatement();
        // Sélection du séminaire de id = id_sem
        ResultSet rs = stmt.executeQuery("SELECT * "
                + "FROM seminaire "
                + "WHERE id_sem = " + id_sem + " ");
        if (!rs.next()) {
            System.out.println("Aucun séminaire trouvé");
        } else {
            int nbInscrits = new Reservation().nbReservations(id_sem);
            int nbmaxPart = rs.getInt("nbmaxPart");
            if(nbInscrits > nbmaxPart){
                int nb = stmt.executeUpdate("UPDATE seminaire SET etat = 'confirmé' WHERE id_sem = " + id_sem + " ");
                System.out.println(nb + " mise(s) à jour réussie(s)");
                System.out.println("Le séminaire " + id_sem + " a été confirmé ");
            }
            else{
                System.out.println("Le nombre d'inscrits : " + nbInscrits + " est inérieur au nombre de partcipants = " + nbmaxPart);
            }
        }
        rs.close();
        stmt.close();
    }

    public int max_recettes_prevues(int id_sem) throws SQLException {
        int maxRecette = 0;
        Statement stmt = conn.createStatement();
        // Sélection du séminaire de id = id_sem
        ResultSet rs = stmt.executeQuery("SELECT tarifPart * nbmaxPart as recettesMaxPrevues FROM seminaire WHERE id_sem = " + id_sem + "");
        if (!rs.next()) {
            System.out.println("Aucun séminaire trouvé");
        } else {
            maxRecette = rs.getInt(1);
            System.out.println("Maximum des recetttes prévues = " + maxRecette);

        }
        rs.close();
        stmt.close();
        return maxRecette;
    }

    public int min_recettes_prevues(int id_sem) throws SQLException {
        int minRecette = 0;
        Statement stmt = conn.createStatement();
        // Sélection du séminaire de id = id_sem
        ResultSet rs = stmt.executeQuery("SELECT(tarifPart * nbmaxPart)/2 as recettesMaxPrevues FROM seminaire WHERE id_sem = " + id_sem + "");
        if (!rs.next()) {
            System.out.println("Aucun séminaire trouvé");
        } else {
            System.out.println("Minimum des recetttes prévues = " + rs.getInt(1));
            minRecette = rs.getInt(1);

        }
        rs.close();
        stmt.close();
        return minRecette;
    }

    public int max_depenses_prevues(int id_sem) throws SQLException {
        int dep = 0;
        String req = " ";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM seminaire WHERE id_sem = " + id_sem + " ");
        if (!rs.next()) {
            System.out.println("Aucun séminaire trouvé");
        } else {
            id_sem = rs.getInt("id_sem");
            String type_sem = rs.getString("type_sem");
            String dej = rs.getString("dejeuner");
            try {
                if (type_sem.equals("JR")) {
                    req = "SELECT id_sem,(nbmaxPart*(tarifDej+tarifPause*2) +tarifSalle+ montantfin) as depenses\n"
                            + "FROM (SELECT id_sem,nbmaxPart,id_prest,tarifDej,tarifSalle,tarifPause \n"
                            + "FROM Prestataire NATURAL JOIN Seminaire) NATURAL JOIN (SELECT id_sem, sum(montant) as montantfin FROM Seminaire NATURAL JOIN Activites NATURAL JOIN Presentation\n"
                            + "GROUP BY id_sem) "
                            + "WHERE id_sem = " + id_sem + " ";
                } else {
                    if (dej.equals("oui")) {
                        req = "SELECT id_sem,(nbmaxPart*(tarifDej+tarifPause) +tarifSalle+ montantfin) as depenses\n"
                                + "FROM (SELECT id_sem,nbmaxPart,id_prest,tarifDej,tarifSalle,tarifPause \n"
                                + "FROM Prestataire NATURAL JOIN Seminaire) NATURAL JOIN (SELECT id_sem, sum(montant) as montantfin FROM Seminaire NATURAL JOIN Activites NATURAL JOIN Presentation\n"
                                + "GROUP BY id_sem) "
                                + "WHERE id_sem = " + id_sem + " ";
                    } else {
                        req = "SELECT id_sem,((nbmaxPart*(+tarifPause))/2 +tarifSalle+ montantfin) as depenses\n"
                                + "FROM (SELECT id_sem,nbmaxPart,id_prest,tarifDej,tarifSalle,tarifPause \n"
                                + "FROM Prestataire NATURAL JOIN Seminaire) NATURAL JOIN (SELECT id_sem, sum(montant) as montantfin FROM Seminaire NATURAL JOIN Activites NATURAL JOIN Presentation\n"
                                + "GROUP BY id_sem) "
                                + "WHERE id_sem = " + id_sem + " ";
                    }
                }
                ResultSet rs1 = stmt.executeQuery(req);

                while (rs1.next()) {
                    dep = rs1.getInt(2);
                    System.out.println("Dépenses max = " + rs1.getInt(2));
                }
                rs1.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        rs.close();
        stmt.close();
        return dep;
    }

    public int min_depenses_prevues(int id_sem) throws SQLException {
        int dep = 0;
        String req = " ";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM seminaire WHERE id_sem = " + id_sem + " ");
        if (!rs.next()) {
            System.out.println("Aucun séminaire trouvé");
        } else {
            id_sem = rs.getInt("id_sem");
            String type_sem = rs.getString("type_sem");
            String dej = rs.getString("dejeuner");
            try {
                if (type_sem.equals("JR")) {
                    req = "SELECT id_sem,((nbmaxPart*(tarifDej+tarifPause*2) )/2+tarifSalle+ montantfin) as depenses\n"
                            + "FROM (SELECT id_sem,nbmaxPart,id_prest,tarifDej,tarifSalle,tarifPause \n"
                            + "FROM Prestataire NATURAL JOIN Seminaire) NATURAL JOIN (SELECT id_sem, sum(montant) as montantfin FROM Seminaire NATURAL JOIN Activites NATURAL JOIN Presentation\n"
                            + "GROUP BY id_sem) "
                            + "WHERE id_sem = " + id_sem + " ";
                } else {
                    if (dej.equals("oui")) {
                        req = "SELECT id_sem,((nbmaxPart*(tarifDej+tarifPause))/2 +tarifSalle+ montantfin) as depenses\n"
                                + "FROM (SELECT id_sem,nbmaxPart,id_prest,tarifDej,tarifSalle,tarifPause \n"
                                + "FROM Prestataire NATURAL JOIN Seminaire) NATURAL JOIN (SELECT id_sem, sum(montant) as montantfin FROM Seminaire NATURAL JOIN Activites NATURAL JOIN Presentation\n"
                                + "GROUP BY id_sem) "
                                + "WHERE id_sem = " + id_sem + " ";
                    } else {
                        req = "SELECT id_sem,((nbmaxPart*(tarifPause))/2 +tarifSalle+ montantfin) as depenses\n"
                                + "FROM (SELECT id_sem,nbmaxPart,id_prest,tarifDej,tarifSalle,tarifPause \n"
                                + "FROM Prestataire NATURAL JOIN Seminaire) NATURAL JOIN (SELECT id_sem, sum(montant) as montantfin FROM Seminaire NATURAL JOIN Activites NATURAL JOIN Presentation\n"
                                + "GROUP BY id_sem) "
                                + "WHERE id_sem = " + id_sem + " ";
                    }
                }
                ResultSet rs1 = stmt.executeQuery(req);

                while (rs1.next()) {
                    dep = rs1.getInt(2);
                    System.out.println("Dépenses min = " + dep);
                }
                rs1.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        rs.close();
        stmt.close();
        return dep;
    }

    public int recettes_realisees(int id_sem) throws SQLException {
        int recettes = 0;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT id_sem,tarifPart *nbpart as recettes "
                + "FROM Seminaire natural join(SELECT id_sem,count(*) as nbpart  FROM Reservations \n"
                + "WHERE statut = 'inscrit' GROUP BY id_sem)\n"
                + "WHERE id_sem= " + id_sem);
        while (rs.next()) {
            recettes = rs.getInt(2);
            System.out.println("Recettes réalisées = " + recettes);
        }
        rs.close();
        st.close();
        return recettes;
    }

    public int depenses_realisees(int id_sem) throws SQLException {
        int depenses = 0;
        String req = " ";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM seminaire WHERE id_sem = " + id_sem + " ");
        if (!rs.next()) {
            System.out.println("Aucun séminaire trouvé");
        } else {
            id_sem = rs.getInt("id_sem");
            String type_sem = rs.getString("type_sem");
            String dej = rs.getString("dejeuner");
            try {
                if (type_sem.equals("JR")) {
                    req = "SELECT (nbpart*(tarifDej+tarifPause*2) +tarifSalle+ montantfin) as depenses\n"
                            + "FROM (SELECT id_sem, sum(montant) as montantfin FROM Seminaire NATURAL JOIN Activites NATURAL JOIN Presentation\n"
                            + "GROUP BY id_sem) NATURAL JOIN (SELECT id_sem,id_prest,nbpart,etat,tarifDej,tarifSalle,tarifPause \n"
                            + "FROM Prestataire NATURAL JOIN (SELECT id_sem,id_prest,etat,nbpart FROM Seminaire NATURAL JOIN (SELECT id_sem,count(*) as nbpart  FROM Reservations \n"
                            + "WHERE statut = 'inscrit' \n"
                            + "GROUP BY id_sem))) "
                            + "WHERE id_sem = " + id_sem + " ";
                } else {
                    if (dej.equals("oui")) {
                        req = "SELECT (nbpart*(tarifDej+tarifPause) +tarifSalle+ montantfin) as depenses\n"
                                + "FROM (SELECT id_sem, sum(montant) as montantfin FROM Seminaire NATURAL JOIN Activites NATURAL JOIN Presentation\n"
                                + "GROUP BY id_sem) NATURAL JOIN (SELECT id_sem,id_prest,nbpart,etat,tarifDej,tarifSalle,tarifPause \n"
                                + "FROM Prestataire NATURAL JOIN (SELECT id_sem,id_prest,etat,nbpart FROM Seminaire NATURAL JOIN (SELECT id_sem,count(*) as nbpart  FROM Reservations \n"
                                + "WHERE statut = 'inscrit' \n"
                                + "GROUP BY id_sem))) "
                                + "WHERE id_sem = " + id_sem + " ";
                    } else {
                        req = "SELECT (nbpart*(tarifPause) +tarifSalle+ montantfin) as depenses\n"
                                + "FROM (SELECT id_sem, sum(montant) as montantfin FROM Seminaire NATURAL JOIN Activites NATURAL JOIN Presentation\n"
                                + "GROUP BY id_sem) NATURAL JOIN (SELECT id_sem,id_prest,nbpart,etat,tarifDej,tarifSalle,tarifPause \n"
                                + "FROM Prestataire NATURAL JOIN (SELECT id_sem,id_prest,etat,nbpart FROM Seminaire NATURAL JOIN (SELECT id_sem,count(*) as nbpart  FROM Reservations \n"
                                + "WHERE statut = 'inscrit' \n"
                                + "GROUP BY id_sem))) "
                                + "WHERE id_sem = " + id_sem + " ";
                    }
                }
                ResultSet rs1 = stmt.executeQuery(req);
                while (rs1.next()) {
                    depenses = rs1.getInt(1);
                    System.out.println("Dépenses réalisées = " + depenses);
                }
                rs1.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        rs.close();
        stmt.close();
        return depenses;
    }

    // Nombre d'inscrits pour un séminaire confirmé
    public int nbInscrits(int idSem) throws SQLException {
        int nbInscrits = 0;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM seminaire WHERE id_sem =" + idSem);
        if (!rs.next()) {
            System.out.println("Ce séminaire n'existe pas");
        } else {
            ResultSet rs1 = st.executeQuery("SELECT  COUNT(*) FROM Seminaire natural join Reservations "
                    + "WHERE id_sem = " + idSem + " AND etat = 'confirmé' AND statut = 'inscrit' ");
            while (rs1.next()) {
                nbInscrits = rs1.getInt(1);
                System.out.println("Nombre d'inscrits = " + nbInscrits);
            }
            rs1.close();
            return nbInscrits;
        }
        rs.close();
        st.close();
        return nbInscrits;
    }

    // Afficher les activités et conférenciers
    public void afficher_act_et_conf(Connection conn, int idSem) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM seminaire WHERE id_sem = " + idSem + " ");
        if (!rs.next()) {
            System.out.println("Ce séminaire n'existe pas");
        } else {
            try (ResultSet rs1 = st.executeQuery("SELECT noAct,nomAct,nomConf,prenomConf "
                    + "FROM activites natural join presentation natural join conferenciers "
                    + "WHERE id_sem = " + idSem + "")) {
                while (rs1.next()) {
                    String s = "\t";
                    System.out.print("Numéro Activité : " + rs1.getInt("noAct") + s);
                    System.out.print("Nom Activité : " + rs1.getString("nomAct") + s);
                    System.out.print("Nom Conférencier : " + rs1.getString("nomConf") + s);
                    System.out.println("Prenom Conférencier : " + rs1.getString("prenomConf"));
                }
            }
        }
        rs.close();
        st.close();
    }

    public List<Integer> afficherIdSeminaire() {
        List<Integer> donnees = new ArrayList<Integer>();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM seminaire");
            int i = 0;
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

    public void afficherToutSeminaire(DefaultTableModel dt) {
        Object[] donnees = new Object[8];
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM seminaire");

            while (rs.next()) {
                donnees[0] = rs.getInt(1);
                donnees[1] = rs.getString(5);
                donnees[2] = rs.getString(6);
                donnees[3] = rs.getString(7);
                donnees[4] = rs.getInt(8) + " €";
                donnees[5] = rs.getInt(9);
                donnees[6] = rs.getDate(10);
                donnees[7] = rs.getString(11);
                dt.addRow(donnees);
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int afficherToutSeminaireConfirme(DefaultTableModel dt) {
        Object[] donnees = new Object[8];
        Statement stmt;
        int i = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM seminaire WHERE dateSem BETWEEN SYSDATE AND SYSDATE + 30");

            while (rs.next()) {
                donnees[0] = rs.getInt(1);
                donnees[1] = rs.getString(5);
                donnees[2] = rs.getString(6);
                donnees[3] = rs.getString(7);
                donnees[4] = rs.getInt(8) + " €";
                donnees[5] = rs.getInt(9);
                donnees[6] = rs.getDate(10);
                donnees[7] = rs.getString(11);
                dt.addRow(donnees);
                i++;
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    public void afficherToutSeminaireAnnuler(DefaultTableModel dt) {
        Object[] donnees = new Object[8];
        Statement stmt;
        int i = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM seminaire WHERE etat = 'annulé' ");

            while (rs.next()) {
                donnees[0] = rs.getInt(1);
                donnees[1] = rs.getString(5);
                donnees[2] = rs.getString(6);
                donnees[3] = rs.getString(7);
                donnees[4] = rs.getInt(8) + " €";
                donnees[5] = rs.getInt(9);
                donnees[6] = rs.getDate(10);
                donnees[7] = rs.getString(11);
                dt.addRow(donnees);
                i++;
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public int afficherSeminaire(DefaultTableModel dt,int id) {
        Object[] donnees = new Object[8];
        Statement stmt;
        int ii = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM seminaire WHERE id_sem = " + id);

            while (rs.next()) {
                donnees[0] = rs.getInt(1);
                donnees[1] = rs.getString(5);
                donnees[2] = rs.getString(6);
                donnees[3] = rs.getString(7);
                donnees[4] = rs.getInt(8) + " €";
                donnees[5] = rs.getInt(9);
                donnees[6] = rs.getDate(10);
                donnees[7] = rs.getString(11);
                dt.addRow(donnees);
                ii++;
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ii;
    }
    
    public int vision_semaine(DefaultTableModel dt) {
        Object[] donnees = new Object[8];
        Statement stmt;
        int ii = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM seminaire WHERE dateSem BETWEEN SYSDATE AND SYSDATE + 7");

            while (rs.next()) {
                donnees[0] = rs.getInt(1);
                donnees[1] = rs.getString(5);
                donnees[2] = rs.getString(6);
                donnees[3] = rs.getString(7);
                donnees[4] = rs.getInt(8) + " €";
                donnees[5] = rs.getInt(9);
                donnees[6] = rs.getDate(10);
                donnees[7] = rs.getString(11);
                dt.addRow(donnees);
                ii++;
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ii;
    }
    
    public int vision_semaine1mois(DefaultTableModel dt) {
        Object[] donnees = new Object[8];
        Statement stmt;
        int ii = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM seminaire WHERE dateSem BETWEEN SYSDATE AND SYSDATE + 30");

            while (rs.next()) {
                donnees[0] = rs.getInt(1);
                donnees[1] = rs.getString(5);
                donnees[2] = rs.getString(6);
                donnees[3] = rs.getString(7);
                donnees[4] = rs.getInt(8) + " €";
                donnees[5] = rs.getInt(9);
                donnees[6] = rs.getDate(10);
                donnees[7] = rs.getString(11);
                dt.addRow(donnees);
                ii++;
            }
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ii;
    }

//    public void vision_semaine(String choix) throws SQLException {
//        int id_sem;
//        Statement stmt;
//        ResultSet rs;
//
//        String reqChoix1 = "SELECT * FROM seminaire WHERE dateSem BETWEEN SYSDATE AND SYSDATE + 7";
//        String reqChoix2 = "SELECT * FROM seminaire WHERE dateSem BETWEEN SYSDATE AND SYSDATE - 7";
//        String reqChoix3 = "SELECT * FROM seminaire WHERE dateSem BETWEEN SYSDATE AND SYSDATE + 7 OR BETWEEN SYSDATE AND SYSDATE - 7";
//
//        try {
//            stmt = conn.createStatement();
//            // Vision sur la semaine
//            if ("SemActu".equals(choix)) {
//                rs = stmt.executeQuery(reqChoix1);
//            } else if ("SemPass".equals(choix)) {
//                rs = stmt.executeQuery(reqChoix2);
//            } else {
//                rs = stmt.executeQuery(reqChoix3);
//            }
//
//            while (rs.next()) {
//                id_sem = rs.getInt(1);
//                System.out.println("ID Seminaire :" + id_sem);
//                afficherSeminaire(new DefaultTableModel(), id_sem);
//            }
//            rs.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//    }


    public int nbmaxPart(int idSem) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT nbmaxPart FROM seminaire WHERE id_sem = " + id_sem);
        if (!rs.next()) {
            System.out.println("Ce séminaire n'existe pas");
        } else {
            nbmaxp = rs.getInt(1);
            System.out.println("nombre max :" + nbmaxp);
        }
        rs.close();
        st.close();
        return nbmaxp;
    }

    public int nbPlaces(int id_sem) {
        return nbmaxp;
    }

    public int Tarif(int id_sem) {
        return tarifPart;
    }

    
    public float tauxRemplissage(int id_sem) throws SQLException, Exception {
        Statement st = conn.createStatement();
        int a = 0, b = 0;
        float taux = 0;
        ResultSet rs = st.executeQuery("SELECT nbmaxPart FROM seminaire WHERE id_sem = " + id_sem + " ");
        if (!rs.next()) {
            System.out.println("Ce séminaire n'existe pas");
        } else {

            a = new Reservation().nbReservations(id_sem);
            b = rs.getInt(1);
        }
        float c = (a / b) * 100;

        rs.close();
        st.close();
        return c;
    }

    public float tauxRempliSupport(int id_sem) throws SQLException {
        Statement st = conn.createStatement();
        int a = 0, b = 0;
        float taux = 0;
        ResultSet rs = st.executeQuery("SELECT * FROM seminaire WHERE id_sem = " + id_sem + " ");
        if (!rs.next()) {
            System.out.println("Ce séminaire n'existe pas");
        } else {
            ResultSet rs1, rs2;
            rs1 = st.executeQuery("select count(*) from \n"
                    + "(select id_sem ,support from (select id_sem ,noAct from Activites) "
                    + "natural join Presentation\n"
                    + "support= null and where id_sem= " + id_sem + "");
            rs2 = st.executeQuery("select count(*) from \n"
                    + "(select id_sem ,support from (select id_sem ,noAct from Activites) "
                    + "natural join Presentation\n"
                    + " where id_sem= " + id_sem + "");
            a = rs1.getInt(1);
            b = rs2.getInt(1);
        }
        float c = (a / b) * 100;

        rs.close();
        st.close();
        return c;
    }
    
    public String bilan_budgetaire(int id_sem) throws SQLException, Exception {
        int resultat = 0;
        String resultatComptable = null;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM seminaire WHERE id_sem= " + id_sem);
        if (!rs.next()) {
            System.out.println("Ce séminaire n'existe pas");
        } else {
            etat = rs.getString("etat");
            if (etat.equals("confirmé")) {

                resultat = depenses_realisees(id_sem) - recettes_realisees(id_sem);
                if(resultat > 0) {
                    resultatComptable = "Gain de : " + resultat;
                }
                else 
                    resultatComptable = "Perte de : " + resultat;
            }
            System.out.println(resultatComptable);
        }
        rs.close();
        st.close();
        return resultatComptable;
    }
    
    public void prevenir_prestataire(int id_sem) throws SQLException, Exception {
        int nbParticipants = new Reservation().nbReservations(id_sem);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM seminaire WHERE id_sem= " + id_sem);
        if (!rs.next()) {
            System.out.println("Ce séminaire n'existe pas");
        } else {
            id_prest = rs.getInt("id_prest");
            etat = rs.getString("etat");
            System.out.println("Envoi du message au prestaire " + id_prest + "le séminaire " + id_sem + " a été " + etat);
            System.out.println("Nombre de particpants = " + nbParticipants);
        }
        rs.close();
        st.close();
    }
}
