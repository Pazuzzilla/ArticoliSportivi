package Magazzino;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GestioneIngressiModel {

    private String dataProd;
    private String dataOS;
    private int codiceIngresso;
    private int newCodiceArticolo;
    private String posizione;
    private String nomeArticolo;
    private int numeropezzi;




    public GestioneIngressiModel(){
        numeropezzi =0;
        dataProd=new String();

        Date dataO = new Date();
        SimpleDateFormat x = new SimpleDateFormat("y-MM-d");
        dataOS = x.format(dataO);

        codiceIngresso=0;
        newCodiceArticolo=0;
        posizione = new String();
        nomeArticolo = new String();
    }

    public void setNumeroPezzi(int numeropezzi) {
        this.numeropezzi = numeropezzi;
    }

    public void setDataIngresso(String dataIngresso) {
        this.dataProd = dataIngresso;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public void setCodiceIngresso(int codiceIngresso) {
        this.codiceIngresso = codiceIngresso;
    }

    public void setDataOS(String dataOS) {
        this.dataOS = dataOS;
    }

    public void setNewCodiceArticolo(int newCodiceArticolo) {
        this.newCodiceArticolo = newCodiceArticolo;
    }

    public void setNomeArticolo(String nomeArticolo) {
        this.nomeArticolo = nomeArticolo;
    }

    public String getDataIngresso() {
        return dataProd;
    }

    public String getPosizione() {
        return posizione;
    }

    public String getDataOS() {
        return dataOS;
    }

    public int getCodiceIngresso() {
        return codiceIngresso;
    }

    public int getNewCodiceArticolo() {
        return newCodiceArticolo;
    }

    public String getNomeArticolo() {
        return nomeArticolo;
    }

    public int getNumeroPezzi() {
        return numeropezzi;
    }
}
