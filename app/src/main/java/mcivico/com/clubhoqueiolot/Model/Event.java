package mcivico.com.clubhoqueiolot.Model;

import java.io.Serializable;

public class Event implements Serializable {
    public String id, categoria, equipL, resultat, equipV, lloc, data, hora;
    public int local, visitant;



    public Event(String id, String categoria, String equipL, String resultat, String equipV, String lloc, String data, String hora, int local, int visitant){
        super();
        this.id = id;
        this.categoria = categoria;
        this.equipL = equipL;
        this.resultat = resultat;
        this.equipV = equipV;
        this.hora = hora;
        this.lloc = lloc;
        this.data = data;
        this.local = local;
        this.visitant = visitant;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEquipL() {
        return equipL;
    }

    public void setEquipL(String equipL) {
        this.equipL = equipL;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public String getEquipV() {
        return equipV;
    }

    public void setEquipV(String equipV) {
        this.equipV = equipV;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public int getVisitant() {
        return visitant;
    }

    public void setVisitant(int visitant) {
        this.visitant = visitant;
    }
}
