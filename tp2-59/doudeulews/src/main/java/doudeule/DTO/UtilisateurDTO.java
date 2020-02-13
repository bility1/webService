package doudeule.DTO;

import doudeule.modele.*;

public class UtilisateurDTO {
    private int idUtil;
    private String nom;
    private String prenom;






    public UtilisateurDTO() {

    }




    public static UtilisateurDTO creer(Utilisateur u) {
        UtilisateurDTO uDTO = new UtilisateurDTO();
        uDTO.setIdUtil(u.getIdUtil());
        uDTO.setNom(u.getNom());
        uDTO.setPrenom(u.getPrenom());
        return uDTO;
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
