package Tables;

public abstract class Personne {
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String mail;

    public Personne() {
    }
    
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    
    
}
