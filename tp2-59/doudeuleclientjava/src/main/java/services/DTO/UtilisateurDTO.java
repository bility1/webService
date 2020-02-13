package services.DTO;


public class UtilisateurDTO {
    private int idUtil;
    private String nom;
    private String prenom;






    public UtilisateurDTO() {

    }


    public void setIdUtil(int idUtil) {
        this.idUtil = idUtil;
    }

    public int getIdUtil() {
        return idUtil;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
