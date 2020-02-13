package doudeule.services;

import doudeule.modele.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Facade {

    private List<RendezVous> rdvs=new ArrayList<>();

    private List<Utilisateur> utils=new ArrayList<>();


    public int createRdv(String intitule, String detail){
        RendezVous r=new RendezVous(intitule,detail);
        rdvs.add(r);
        return r.getIdRdv();
    }

    public List<RendezVous> getRdvs() {
        return rdvs;
    }

    public RendezVous findRdvById(int id) {
        for (RendezVous r : rdvs) {
            if (id==r.getIdRdv()) {
                return r;
            }
        }
        return null;
    }

    public int createUtil(String nom,String prenom) {
        Utilisateur u=new Utilisateur(nom,prenom);
        utils.add(u);
        return u.getIdUtil();
    }

    public List<Utilisateur> getUtils() {
        return utils;
    }

    public Utilisateur findUtilById(int id) {
        System.out.println(""+id);
        for (Utilisateur u : utils) {
            System.out.println(">>>"+u.getIdUtil());
            if (id==u.getIdUtil()) {
                return u;
            }
        }
        return null;
    }



    public int addCreneau(int idR, Creneau c) {
        RendezVous r=findRdvById(idR);
        Creneau.generateId(c);
        r.getCreneaux().add(c);
        return c.getIdC();
    }

    public List<Creneau> getCreneaux(int idR) {
        RendezVous r =findRdvById(idR);
        return r.getCreneaux();
    }

    public void addDispo(int idR, int idC, int idU) {
        System.out.println("ici");
        RendezVous r =findRdvById(idR);
        Utilisateur u=findUtilById(idU);
        for (Creneau c: r.getCreneaux()) {
            if (c.getIdC()==idC) {
                c.getDispos().add(u);
                return;
            }
        }
    }

    public Collection<Utilisateur> getDispos(int idR, int idC) {

        RendezVous r = findRdvById(idR);
        for (Creneau c : r.getCreneaux()) {
            if (c.getIdC() == idC) {
                return c.getDispos();
            }
        }
        return null;
    }
}
