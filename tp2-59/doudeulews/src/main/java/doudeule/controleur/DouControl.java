package doudeule.controleur;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import doudeule.controleur.*;
import doudeule.DTO.*;
import doudeule.modele.*;
import doudeule.services.*;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doudeule")
public class DouControl {

    Facade facade=new Facade();


    /**
     * Permet de récupérer la liste des évènements
     * @return
     */
    @GetMapping(value="/rdv", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RdvDTO>> getAllRdv() {
        return ResponseEntity.ok(RdvDTO.listRdv(facade.getRdvs()));
    }

    /**
     * Permet de créer un évènement
     * @param rdv
     * @return
     */

    @PostMapping(value="/rdv")
    public ResponseEntity<String> createRdv(@RequestBody RdvDTO rdv) {

        int rid=facade.createRdv(rdv.getIntitule(),rdv.getDetail());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(rid).toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * Permet de récupérer un évènement donné
     * @param id
     * @return
     */
    @GetMapping(value="/rdv/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RdvDTO> getRdv(@PathVariable  int id) {
        RendezVous rdv = facade.findRdvById(id);
        if (rdv!=null) {
            return ResponseEntity.ok(RdvDTO.creer(rdv));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Permet d'ajouter un créneau à un évènement donné
     * @param id
     * @param c
     * @return
     */
    @PostMapping(value="/rdv/{id}/creneau")
    public ResponseEntity<String> ajoutDispo(@PathVariable int id,@RequestBody Creneau c) {
        int idC=facade.addCreneau(id,c);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(idC).toUri();
        return ResponseEntity.created(location).build();
    }


    /**
     * Permet de récupéré la liste des créneau pour un évènement donné
     * @param id
     * @return
     */
    @GetMapping(value="/rdv/{id}/creneau", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CreneauDTO>> getCreneaux(@PathVariable int id){
        List<CreneauDTO> lc= facade.getCreneaux(id).stream().map(e -> CreneauDTO.creer(e)).collect(Collectors.toList());
        return ResponseEntity.ok(lc);
    }

    /**
     * Permet d'ajouter une dispo d'un utilisateur pour un évènement donné et un créneau donné
     * @param idR
     * @param idC
     * @param udto
     * @return
     */
    @PutMapping(value="/rdv/{idR}/creneau/{idC}/dispo")
    public ResponseEntity<String> ajoutDispo(@PathVariable int idR, @PathVariable int idC, @RequestBody UtilDTO udto) {
        facade.addDispo(idR,idC,udto.getIdUtil());
        return ResponseEntity.ok().build();
    }


    /**
     * Permet  d'avoir la collection des personnes disponibles pour un créneau donné d'un évènement donné
     * @param idR
     * @param idC
     * @return
     */

    @GetMapping(value="rdv/{idR}/creneau/{idC}/dispo")
    public ResponseEntity<Collection<UtilisateurDTO>> getDispos(@PathVariable("idR") int idR, @PathVariable("idC") int idC) {
        return ResponseEntity.ok(facade.getDispos(idR,idC).stream().map(e -> UtilisateurDTO.creer(e)).collect(Collectors.toList()));
    }


    /**
     * Permet de récupérer la liste des utilisateurs du service
     * @return
     */

    @GetMapping(value="/utilisateur", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UtilisateurDTO>> getAllUtils() {
        return ResponseEntity.ok(facade.getUtils().stream().map(e -> UtilisateurDTO.creer(e)).collect(Collectors.toList()));
    }


    /**
     * Permet de récupérer un utilisateur en particulier
     * @param id
     * @return
     */

    @GetMapping(value="/utilisateur/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UtilisateurDTO> getUtilById(@PathVariable int id) {
        return ResponseEntity.ok(UtilisateurDTO.creer(facade.findUtilById(id)));
    }

    /**
     * Permet de créer un utilisateur
     * @param util
     * @return
     */
    @PostMapping(value="/utilisateur")
    public ResponseEntity<String> createUtil(@RequestBody UtilisateurDTO util) {

        int uid=facade.createUtil(util.getNom(),util.getPrenom());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(uid).toUri();
        return ResponseEntity.created(location).build();
    }


}
