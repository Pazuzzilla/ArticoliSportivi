package Magazzino;

import lib.GestioneIngressi;

public class GestioneArticoliModel {
    private String newPosizione;
    private int articolo;
    private String oldPosizione;

    public GestioneArticoliModel(){
        newPosizione = new String();
        articolo = 0;
        oldPosizione = new String();
    }

    public void setArticolo(int articolo) {
        this.articolo = articolo;
    }

    public void setOldPosizione(String oldPosizione) {
        this.oldPosizione = oldPosizione;
    }

    public void setNewPosizione(String newPosizione) {
        this.newPosizione = newPosizione;
    }

    public int getArticolo() {
        return articolo;
    }

    public String getNewPosizione() {
        return newPosizione;
    }

    public String getOldPosizione() {
        return oldPosizione;
    }
}
