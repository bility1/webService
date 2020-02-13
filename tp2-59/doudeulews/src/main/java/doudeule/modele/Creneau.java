package doudeule.modele;

import java.util.ArrayList;
import java.util.List;

public class Creneau {
    private static int IDSC=1;
    private int idC;
    private String jDebut;
    private int hDebut;
    private int mDebut;
    private String jFin;
    private int hFin;
    private int mFin;
    List<Utilisateur> dispos=new ArrayList<>();


    public static void generateId(Creneau c){
        c.idC=IDSC++;
    }

    public int getIdC() {
        return idC;
    }

    public String getjDebut() {
        return jDebut;
    }

    public void setjDebut(String jDebut) {
        this.jDebut = jDebut;
    }

    public int gethDebut() {
        return hDebut;
    }

    public void sethDebut(int hDebut) {
        this.hDebut = hDebut;
    }

    public int getmDebut() {
        return mDebut;
    }

    public void setmDebut(int mDebut) {
        this.mDebut = mDebut;
    }

    public String getjFin() {
        return jFin;
    }

    public void setjFin(String jFin) {
        this.jFin = jFin;
    }

    public int gethFin() {
        return hFin;
    }

    public void sethFin(int hFin) {
        this.hFin = hFin;
    }

    public int getmFin() {
        return mFin;
    }

    public void setmFin(int mFin) {
        this.mFin = mFin;
    }

    public List<Utilisateur> getDispos() {
        return dispos;
    }

    public void setDispos(List<Utilisateur> dispos) {
        this.dispos = dispos;
    }
}
