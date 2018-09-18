package Magazzino;

import lib.GestioneIngressi;

public class GestioneArticoliModel {
    private String newPosizione;
    private String articolo;
    private String oldPosizione;

    public GestioneArticoliModel(){
        newPosizione = new String();
        articolo = new String();
        oldPosizione = new String();
    }

    public void setArticolo(String articolo) {
        this.articolo = articolo;
    }

    public void setOldPosizione(String oldPosizione) {
        this.oldPosizione = oldPosizione;
    }

    public void setNewPosizione(String newPosizione) {
        this.newPosizione = newPosizione;
    }

    public String getArticolo() {
        return articolo;
    }

    public String getNewPosizione() {
        return newPosizione;
    }

    public String getOldPosizione() {
        return oldPosizione;
    }
}
