package Negozio;

import data.DataSport;

import java.sql.SQLException;

public class StoricoNegController {

    private StoricoNegModel theModel;

    public StoricoNegController(StoricoNegModel vmm){
        theModel = vmm;
    }
    
    public StoricoNegModel getTheModel() {
        return theModel;
    }

    //metodo con il quale passando al database il numero di ordini preparo la matrice di ordini e rispettive uscite da magazzino
    public int[][] visualizza(int howManyOrders, StoricoNegModel vmm) throws SQLException {

        int[][]ordineUscita =new int[howManyOrders][2];
        String negozio=vmm.getneg();

        ordineUscita=DataSport.getInstance().getOrders(negozio,howManyOrders);
        ordineUscita=DataSport.getInstance().getExit(howManyOrders,ordineUscita);

        return ordineUscita;

    }

    // metodo con il qualce chiedo al database quante righe do ordine sono presenti per un dato negozio insetito
    public int howMany(StoricoNegModel vmm) throws SQLException {
        int howManyOrders= DataSport.getInstance().howMany(vmm.getneg());
        return howManyOrders;
    }
}
