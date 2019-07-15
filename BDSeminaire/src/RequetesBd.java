import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RequetesBd {

    /**
     * Afficher toutes les informations sur tous les spectacles.
     *
     * @param conn connexion � la base de donn�es
     * @throws SQLException en cas d'erreur d'acc�s � la base de donn�es
     */
    public static void creer_seminaire(Connection conn) throws SQLException {

        int id_sem = 0;
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        //
        ResultSet rs = stmt.executeQuery("SELECT MAX(id_sem) FROM Seminaire");
        while (rs.next()) {
            id_sem = (rs.getInt(1)) + 1;
        }
        // Saisie des infos de l'animateur
        int noAnim = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez entrer le numéro de l'animateur: ");
        noAnim = sc.nextInt();

        //Saisie de la date
        String date;
        System.out.println("Veuillez entrer la date prévue pour le séminaire :");
        date = sc.nextLine();

        // Nombre de places maximum 
        int nbplaces;
        System.out.println("Veuillez entrer le nombre de places maximum autorisé pour ce séminaire : ");
        nbplaces = sc.nextInt();

        // Tarif de l'inscription
        int tarifPart = 0;
        System.out.println("Veuillez entrer le tarif par participant : ");
        
        
        //stmt.executeUpdate("INSERT INTO LesSpectacles VALUES(" + "'" + id_spec + "'" + "," + "'" + nom_spec + "'" + ")");
        System.out.println("Ajout réussi");
        System.out.println();

        // Execute the query
        //ResultSet rs = stmt.executeUpdate("INSERT INTO seminaire(noAnim,) VALUES('')");
        while (rs.next()) {
            System.out.println("Nombre d'employes : " + rs.getInt(1));
        }
        System.out.println();
        // Close the result set, statement and theconnection 
        rs.close();
        stmt.close();
    }

    public static void employes(Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();

        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");
        while (rs.next()) {
            System.out.print("empno : " + rs.getInt(1) + "");
            System.out.print("nom : " + rs.getString(2) + "");
            System.out.println("job : " + rs.getString(3));
        }
        System.out.println();
        // Close the result set, statement and theconnection 
        rs.close();
        stmt.close();
    }

    // affiche pour chaque employé son salire, sa commission et sa date d'embauche
    public static void employes2(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT distinct(ename),sal,nvl(comm,0), hiredate FROM EMP");
        while (rs.next()) {
            System.out.print("nom :" + rs.getString(1) + "");
            System.out.print("salaire : " + rs.getInt(2) + " ");
            System.out.print("commission : " + rs.getInt(3) + " ");
            System.out.println("date d'embauche : " + rs.getDate(4));
        }
        System.out.println();
        // Close the result set, statement and theconnection 
        rs.close();
        stmt.close();
    }

    // affiche pour chaque employéson supérieur hiérarchique
    public static void employes3(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select subord.ename employé, nvl(chef.ename, 'BIG BOSS') CHEF "
                + "from emp subord left outer join emp chef on subord.mgr=chef.empno "
                + "order by subord.ename");
        while (rs.next()) {
            System.out.print("employé :" + rs.getString(1) + "");
            System.out.println("chef : " + rs.getString(2) + "");
        }
        System.out.println();
        // Close the result set, statement and theconnection 
        rs.close();
        stmt.close();
    }

    // somme des revenus par département
    public static void sommeRevenus(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select distinct(deptno), sum(sal + nvl(comm,0)) revenus from emp group by deptno");
        while (rs.next()) {
            System.out.print("deptno : " + rs.getInt(1) + " ");
            System.out.println("revenus :" + rs.getInt(2) + "");
        }
        System.out.println();
        // Close the result set, statement and theconnection 
        rs.close();
        stmt.close();
    }

}
