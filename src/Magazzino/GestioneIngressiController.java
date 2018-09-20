package Magazzino;

import data.DataSport;
import lib.GestioneIngressi;

import javax.swing.*;

public class GestioneIngressiController {

    private GestioneIngressiModel gIM;

    public GestioneIngressiController(GestioneIngressiModel gim){
        this.gIM = gim;

    }


    public boolean aggiungi(){
        Object[] rigaO = new Object[6];

        int new_ingresso = 0;
        int new_codice = 0;
        boolean b = false;

        b =  DataSport.getInstance().verificaEsistenza(gIM.getNomeArticolo());


        if( b == true) {
            // ora abbiamo il prezzo totale e lo ho settato adesso devo generare un nuovo codice per l'ordine

            new_ingresso = DataSport.getInstance().new_Insert();
            gIM.setCodiceIngresso(new_ingresso);

            new_codice = DataSport.getInstance().new_codiceArticolo();
            gIM.setNewCodiceArticolo(new_codice);

        }
        else{
            JOptionPane.showMessageDialog(null, "Articolo non esistente");
        }

        return b;
    }
}
