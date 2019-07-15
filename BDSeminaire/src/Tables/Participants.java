package Tables;

import Connexion.ConnexionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import javax.swing.table.DefaultTableModel;

public class Participants extends Personne {
    
    private int noPart;
    private String nomPart;
    private String prenomPart;
    private String adressePart;
    private String telPart;
    private String mailPart;

    ConnexionOracle dbOrcle;
    Connection conn;

    public Participants() throws Exception {
//---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }
    public Participants(int noPart, String nom, String prenom) throws Exception {
        super(nom, prenom);
        this.noPart = noPart;
        //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }
    /*
    noPart INTEGER constraint nopart_pk primary key,
	nomPart VARCHAR(30) not null,
	prenomPart VARCHAR(30) not null,
	adressePart VARCHAR(70) ,
	telPart VARCHAR(13),
	mailPart VARCHAR(30)
        
        */
    public Participants(String nom, String prenom) throws Exception {
        super(nom, prenom);
         //---------conx avec bd 
        dbOrcle = new ConnexionOracle();
        conn = dbOrcle.connexion();
    }
    
    
    
    public void afficherToutParticipants(DefaultTableModel dt) throws Exception {
        String[] donnees = new String[6];
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Participants");
                   
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
    
//    public static void inserer_participant(Connection conn, String nom, String prenom) throws SQLException{
//        Statement st = conn.createStatement();
//        int nopart = 0;
//        ResultSet rs = st.executeQuery("SELECT MAX(nopart) FROM participants");
//        if(rs.next()){
//            nopart = rs.getInt(1) + 1;
//            int nb = st.executeUpdate("INSERT INTO participants(noPart, nomPart, prenomPart) VALUES('" + nopart + "','" + nom + "','" + prenom + "')");
//            System.out.println(nb + " partcipant ajouté");
//        }
//        rs.close();
//        st.close();
//    }
    
       public int inserer_participant(String nom, String prenom) throws SQLException{
        Statement st = conn.createStatement();
        int nopart = 0;
        int i = 0;
        ResultSet rs = st.executeQuery("SELECT MAX(nopart) FROM participants");
        if(rs.next()){
            nopart = rs.getInt(1) + 1;
            int nb = st.executeUpdate("INSERT INTO participants(noPart, nomPart, prenomPart) VALUES('" + nopart + "','" + nom + "','" + prenom + "')");
            System.out.println(nb + " partcipant ajouté");
            i++;
        }
        rs.close();
        st.close();
        return i;
    }
    
       public List<Integer> afficherIdParticipant(){
        List<Integer> donnees = new ArrayList<Integer>();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Participants");
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
    // affichage de PArticipants
//    public void Afiicher_Participants(Connection conn,int noPart){
//    Statement stmt;
//        try {
//            stmt = conn.createStatement();
//            // Vision sur la semaine
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Participants WHERE noPart ="+noPart);
//            while (rs.next()) {
//                this.noPart = rs.getInt(1);
//                this.nomPart = rs.getString(2);
//                this.prenomPart = rs.getString(3);
//                this.adressePart = rs.getString(4);
//                this.telPart = rs.getString(5);
//                this.mailPart = rs.getString(6);
//    
//                System.out.println("no :"+this.noPart+" nomPart:"+this.nomPart+"......................");
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
       // affichage de PArticipants
    public int Afficher_Participants(DefaultTableModel dt,int noPart){
    Statement stmt;
    Object[] donnees = new Object[6];
    int i=0;
        try {
            stmt = conn.createStatement();
            // Vision sur la semaine
            ResultSet rs = stmt.executeQuery("SELECT * FROM Participants WHERE noPart ="+noPart);
            while (rs.next()) {
                this.noPart = rs.getInt(1);
                this.nomPart = rs.getString(2);
                this.prenomPart = rs.getString(3);
                this.adressePart = rs.getString(4);
                this.telPart = rs.getString(5);
                this.mailPart = rs.getString(6);
                
                donnees[0] = rs.getInt(1);
                donnees[1] = rs.getString(2);
                donnees[2] = rs.getString(3);
                donnees[3] = rs.getString(4);
                donnees[4] = rs.getString(5);
                donnees[5] = rs.getString(6);
                dt.addRow(donnees);
                
                i++;
                System.out.println("no :"+this.noPart+" nomPart:"+this.nomPart+"......................");
                return i;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Seminaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
}
