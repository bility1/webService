package doudeule.DTO;

import doudeule.modele.*;

import java.util.List;
import java.util.stream.Collectors;


public class RdvDTO {
    private int idRdv;
    private String intitule;
    private String detail;


    public static List<RdvDTO> listRdv(List<RendezVous> lr) {
        List<RdvDTO> ldto=lr.stream().map(e -> creer(e)).collect(Collectors.toList());
        return ldto;
    }

    public static RdvDTO creer(RendezVous r) {
        return new RdvDTO(r);
    }

    public RdvDTO() {}

    private RdvDTO(RendezVous r) {
        this.idRdv=r.getIdRdv();
        this.intitule=r.getIntitule();
        this.detail=r.getDetail();
    }

    public int getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(int idRdv) {
        this.idRdv = idRdv;
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
}
