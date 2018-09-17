package Segreteria;

import data.Negozio;

public class VisualizzaMovimentiModel{
private Negozio iG;
private int[][] ordineUscita;
private int howMany;

    public VisualizzaMovimentiModel(Negozio ig){

        this.iG=ig;
        String[][]ordineUscita;
        howMany=0;
    }

    public void setiG(String i) {
        iG.setNegozioid(i);
    }


    public String getneg() {
        return iG.getNegozioid();
    }

    public void setOrdineUscita(int[][] ordineUscita1) {
        this.ordineUscita=ordineUscita1;
    }

    public int[][] getOrdineUscita() {
        return ordineUscita;
    }

    public int getHowMany() {
        return howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }
}
