package Negozio;

import java.text.SimpleDateFormat;
import java.util.Date;

import data.Negozio;

public class OrdineModel{
	private Negozio neg;
	private String negO;
	private int codiceO;
	private String dataOS;
	private String articolo;
	private int numeropezzi;
	private float prezzo;
	private float prezzo_complessivo;


	public OrdineModel(Negozio negozio){
		this.neg = negozio;
		negO = neg.getNegozioid();
		codiceO = 0;


		Date dataO = new Date();
		SimpleDateFormat x = new SimpleDateFormat("y-MM-d");
		dataOS = x.format(dataO);

		articolo = new String();
		numeropezzi = 0;
		prezzo = 0;
		prezzo_complessivo = 0;
	}
	
	public Negozio getNeg() {
		return this.neg;
	}

	public void setArticolo(String articolo) {
		this.articolo = articolo;
	}

	public void setCodiceO(int codiceO) {
		this.codiceO = codiceO;
	}

	public void setNumeroPezzi(int numeropezzi) {
		this.numeropezzi = numeropezzi;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public void setPrezzo_complessivo(float prezzo_complessivo) {
		this.prezzo_complessivo = prezzo_complessivo;
	}

	public String getDataO() {
		return dataOS;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public int getCodiceO() {
		return codiceO;
	}

	public int getNumeroPezzi() {
		return numeropezzi;
	}

	public String getArticolo() {
		return articolo;
	}

	public String getDataOS() {
		return dataOS;
	}

	public String getNegO() {
		return negO;
	}

	public float getPrezzo_complessivo() {
		return prezzo_complessivo;
	}
}