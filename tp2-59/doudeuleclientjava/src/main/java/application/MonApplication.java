package application;

import services.DTO.CreneauDTO;
import services.DTO.RdvDTO;
import services.DTO.UtilDTO;
import services.DTO.UtilisateurDTO;
import services.DouDeuleInterface;
import services.DouDeuleProxy;

public class MonApplication {


    public static void main(String[] args) {


        DouDeuleInterface douDeuleInterface = new DouDeuleProxy();
        UtilisateurDTO gerard = new UtilisateurDTO();
        gerard.setNom("Menvuça");
        gerard.setPrenom("Gerard");


        UtilisateurDTO jessica = new UtilisateurDTO();
        jessica.setNom("Nettes-de-secours");
        jessica.setPrenom("Jessica");



        int idGerard = douDeuleInterface.createUtil(gerard);
        int idJessica = douDeuleInterface.createUtil(jessica);
        RdvDTO wsi = new RdvDTO();
        wsi.setIntitule("Web-services");
        wsi.setDetail("Un module de rêve où tous les rêves se transforment en cauchemars.");

        int idRdv = douDeuleInterface.createRdv(wsi);


        UtilDTO utilDTOJessica = new UtilDTO();
        utilDTOJessica.setIdUtil(idJessica);
        UtilDTO utilDTOGerard = new UtilDTO();
        utilDTOGerard.setIdUtil(idGerard);


        CreneauDTO creneau1 = new CreneauDTO();
        creneau1.setjDebut("14/02/2020");
        creneau1.setjFin("14/02/2020");
        creneau1.sethDebut(10);
        creneau1.setmDebut(15);
        creneau1.sethFin(12);
        creneau1.setmFin(15);

        int idCreneau1 = douDeuleInterface.ajoutCreneau(idRdv,creneau1);
//       douDeuleInterface.ajoutDispo(idRdv,idCreneau1,utilDTOJessica);
//        douDeuleInterface.ajoutDispo(idRdv,idCreneau1,utilDTOGerard);

//        CreneauDTO creneau2 = new CreneauDTO();
//        creneau2.setjDebut("13/02/2020");
//        creneau2.setjFin("13/02/2020");
//        creneau2.sethDebut(13);
//        creneau2.setmDebut(30);
//        creneau2.sethFin(15);
//        creneau2.setmFin(30);
//
//        int idCreneau2 = douDeuleInterface.ajoutCreneau(idRdv,creneau2);
//
//        douDeuleInterface.ajoutDispo(idRdv,idCreneau2,utilDTOJessica);
//
//        CreneauDTO creneau3 = new CreneauDTO();
//        creneau3.setjDebut("15/02/2020");
//        creneau3.setjFin("15/02/2020");
//        creneau3.sethDebut(8);
//        creneau3.setmDebut(0);
//        creneau3.sethFin(10);
//        creneau3.setmFin(0);
//
//        int idCreneau3 = douDeuleInterface.ajoutCreneau(idRdv,creneau3);
//
//        douDeuleInterface.ajoutDispo(idRdv,idCreneau3,utilDTOGerard);

        //System.out.println(douDeuleInterface.getAllUtils().size());


    }
}
