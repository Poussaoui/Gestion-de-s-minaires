
import Tables.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionSgbd {

    private static final String configurationFile = "BD.properties";

    public static void main(String args[]) throws Exception {
        try {

            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();

            // Load the database driver
            Class.forName(jdbcDriver);// Get a connection to the database
            // Print information about connection warnings
            try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
                System.out.println("Connecté");
                //Seminaire seminaire = new Seminaire(1);
                //Seminaire.confirmer_seminaire(conn);
                //Seminaire.max_depenses_prevues(conn,1);
                //Seminaire.min_recettes_prevues(conn, 1);
                //Seminaire.annuler_seminaire(conn, 2);
                //Seminaire.confirmer_seminaire(conn, 2);
                //Reservation.annuler_reservation(conn,116, 2);
                //Participants.inserer_participant(conn,"Maaa", "Dan");
                //Reservation.nbReservations(conn, 5);
                //Seminaire.nbInscrits(conn, 2);
                //Seminaire.afficher_act_et_conf(conn, 1);
                //Presentation.afficher(conn, 110, 115);
                //Activites a = new Activites();
                //a.affichier_Activites(conn, 2);
                //Participants p = new Participants();
                //p.Afiicher_Participants(conn, 115);
                //Reservation r = new Reservation();
                //r.Afiicher_Reservation(conn, 1);
                //Seminaire s = new Seminaire();
                //s.affichier_seminaire(conn, 1);
                //s.vision_semaine(conn, "SemActu");
                //a.ajouterActivité(conn, 2, "Conférence");
                //int p = Seminaire.max_depenses_prevues(conn, 1);
              
                Seminaire s = new Seminaire();        
                int r = s.depenses_realisees(1);
                System.out.println(r);
                // Print information about connection warnings
                SQLWarningsExceptions
                        .printWarnings(conn);
            }
        } catch (SQLException se) {

            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
        } catch (ClassNotFoundException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
