package Magazzino;

import data.DataSport;
import lib.GestioneIngressi;

public class GestioneArticoliController {

    private GestioneArticoliModel gAM;

    public GestioneArticoliController(GestioneArticoliModel gam){
        this.gAM=gam;

    }

    public void cambioPos() {

        int articolo=gAM.getArticolo();
        String newPosizione = gAM.getNewPosizione();
        String oldPosizione = DataSport.getInstance().setNewPosition(articolo, newPosizione);
        gAM.setOldPosizione(oldPosizione);
    }
}
