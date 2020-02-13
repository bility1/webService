package services.DTO;


import java.util.ArrayList;
import java.util.List;

public class CreneauDTO {
    private int idC;
    private String jDebut;
    private int hDebut;
    private int mDebut;
    private String jFin;
    private int hFin;
    private int mFin;
    List<Integer> dispos=new ArrayList<>();


    public void setIdC(int idC) {
        this.idC = idC;
    }

    public void setDispos(List<Integer> dispos) {
        this.dispos = dispos;
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

    public List<Integer> getDispos() {
        return dispos;
    }


}
