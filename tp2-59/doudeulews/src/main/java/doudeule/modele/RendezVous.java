package doudeule.modele;

import java.util.ArrayList;
import java.util.List;

public class RendezVous {
    private static int IDSING=1;
    private int idRdv;
    private String intitule;
    private String detail;
    private List<Creneau> creneaux;

    public RendezVous() {
        this.idRdv=IDSING++;
        this.creneaux=new ArrayList<>();
    }

    public RendezVous(String intitule, String detail) {
        this();
        this.intitule = intitule;
        this.detail = detail;
    }

    public int getIdRdv() {
        return idRdv;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<Creneau> getCreneaux() {
        return creneaux;
    }

    public void setCreneaux(List<Creneau> creneaux) {
        this.creneaux = creneaux;
    }
}
