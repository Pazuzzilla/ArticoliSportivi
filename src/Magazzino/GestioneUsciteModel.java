package Magazzino;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import data.DataSport;

public class GestioneUsciteModel {
	//"Codice Uscita", "Codice Negozio", "Articolo", "Numero Pezzi", "Data", "spedizioniere"
	private int ordineDaEvadere;
	private int codiceBolla;
	private String Spedizioniere;
	private  String Articolo;
	private String Data;
	private int codiceArt;
	private int pezziTotali;
	private String negozio;
	private int pezziPerArticolo;


	
	public GestioneUsciteModel() {
		ordineDaEvadere = 0;
		codiceArt = 0;

		Date dataO = new Date();
		SimpleDateFormat x = new SimpleDateFormat("y-MM-d");
		Data = x.format(dataO);

		codiceBolla = 0;
		Spedizioniere = new String();
		Articolo = new String();
		pezziTotali = 0;
		negozio=null;
		pezziPerArticolo = 0;

	}

	
	public List<Integer> getOrdini() {
		List <Integer> v = DataSport.getInstance().findOrdini();
		return v;
	}

	public void setArticolo(String articolo) {
		Articolo = articolo;
	}

	public void setCodiceArt(int codiceArt) {
		this.codiceArt = codiceArt;
	}

	public void setCodiceBolla(int codiceBolla) {
		this.codiceBolla = codiceBolla;
	}

	public void setData(String data) {
		Data = data;
	}

	public void setOrdineDaEvadere(int ordineDaEvadere) {
		this.ordineDaEvadere = ordineDaEvadere;
	}

	public void setSpedizioniere(String spedizioniere) {
		Spedizioniere = spedizioniere;
	}

	public String getArticolo() {
		return Articolo;
	}

	public int getCodiceArt() {
		return codiceArt;
	}

	public int getCodiceBolla() {
		return codiceBolla;
	}

	public int getOrdineDaEvadere() {
		return ordineDaEvadere;
	}

	public String getData() {
		return Data;
	}

	public String getSpedizioniere() {
		return Spedizioniere;
	}

	public void setNegozio(String negozio) {
		this.negozio = negozio;
	}

	public String getNegozio() {
		return negozio;
	}

	public void setPezziTotali(int pezziTotali) {
		this.pezziTotali = pezziTotali;
	}

	public int getPezziTotali() {
		return pezziTotali;
	}

	public void setPezziPerArticolo(int pezziPerArticolo) {
		this.pezziPerArticolo = pezziPerArticolo;
	}

	public int getPezziPerArticolo() {
		return pezziPerArticolo;
	}

}
