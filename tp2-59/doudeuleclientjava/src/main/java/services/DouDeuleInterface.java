package services;

import services.DTO.CreneauDTO;
import services.DTO.RdvDTO;
import services.DTO.UtilDTO;
import services.DTO.UtilisateurDTO;

import java.util.Collection;
import java.util.List;

public interface DouDeuleInterface {


    /**
     * Permet de récupérer tous les évènements
     * @return
     */
    List<RdvDTO>  getAllRdv();

    /**
     * Permet de créer un évènement
     * @param rdv
     * @return : id de l'évènement créé
     */
    int createRdv(RdvDTO rdv);


    /**
     * Permet de récupérer un Rdv pour un id donné
     * @param id
     * @return
     */
    RdvDTO getRdv(int id);


    /**
     * Permet d'ajouter un créneau pour un rdv donné
     * @param id
     * @param c
     * @return
     */

    int ajoutCreneau(int id, CreneauDTO c);

    /**
     * permet de récupérer la liste des créneaux pour un rdv donné
     * @param id
     * @return
     */
    List<CreneauDTO> getCreneaux(int id);


    /**
     * Permet d'ajouter un utilisateur dans un créneau donné pour un rdv donné
     * @param idR
     * @param idCreneau
     * @param udto
     */
    void ajoutDispo(int idR, int idCreneau, UtilDTO udto);


    /**
     * Permet de récupérer la liste des utilisateurs du service
     * @return
     */

    List<UtilisateurDTO> getAllUtils();

    /**
     * Permet de créer un nouvel utilisateur
     * @param util
     * @return
     */
    int createUtil(UtilisateurDTO util);


    /**
     * Permet de récupérer la liste des utilisateurs disponibles pour un rdv donné et un créneau donné
     * @param idRdv
     * @param idCreneau
     * @return
     */
    Collection<UtilisateurDTO> getUtilisateursDisponiblesPour(int idRdv, int idCreneau);
}
