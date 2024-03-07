package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Chaussure;

public class ChaussureModele {

    private String motCle;
    List<Chaussure> chaussures = new ArrayList<>();

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<Chaussure> getChaussures() {
        return chaussures;
    }

    public void setChaussures(List<Chaussure> chaussures) {
        this.chaussures = chaussures;
    }
}

