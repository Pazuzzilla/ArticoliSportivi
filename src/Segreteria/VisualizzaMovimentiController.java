package Segreteria;

import data.DataSport;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class VisualizzaMovimentiController {

    private VisualizzaMovimentiModel theModel;

    public VisualizzaMovimentiController(VisualizzaMovimentiModel vmm){
        theModel=vmm;
    }

    public VisualizzaMovimentiModel getTheModel() {
        return theModel;
    }

    //metodo con il quale passando al database il numero di ordini preparo la matrice di ordini e rispettive uscite da magazzino
    public int[][] visualizza(int howManyOrders, VisualizzaMovimentiModel vmm) throws SQLException {

        int[][]ordineUscita =new int[howManyOrders][2];
        String negozio=vmm.getneg();
        
        if (negozio.isEmpty()) {
        	JOptionPane.showMessageDialog(null,"Negozio Non Inserito ");
        }
        else {
        ordineUscita=DataSport.getInstance().getOrders(negozio,howManyOrders);
        ordineUscita=DataSport.getInstance().getExit(howManyOrders,ordineUscita);
        }
        return ordineUscita;

    }

    // metodo con il qualce chiedo al database quante righe do ordine sono presenti per un dato negozio insetito
    public int howMany(VisualizzaMovimentiModel vmm) throws SQLException {
        int howManyOrders= DataSport.getInstance().howMany(vmm.getneg());
        return howManyOrders;
    }
}
