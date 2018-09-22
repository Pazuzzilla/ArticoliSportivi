package Magazzino;

import data.DataSport;

public class GestioneUsciteController {
	private GestioneUsciteModel gUM;
	public GestioneUsciteController(GestioneUsciteModel gum) {
		//gum.setOrdini();
		gUM = gum;
		System.out.println(gum.getOrdini());
	}

	public boolean validOrder(int ordine) {
		boolean b = false;

		b = DataSport.getInstance().validOrder(ordine);
		return b;

	}

	public boolean validForExit(int ordine) {
		boolean b = false;

		b = DataSport.getInstance().validForExit(ordine);
		return b;
	}

	public Object[][] getArticoliOrdinati(int codiceO) {
		Object[][] articoliOrdinati= DataSport.getInstance().getArticoliOrdinati(codiceO);
		return articoliOrdinati;
	}


	public boolean getEvadibilita(Object[][] articoliOrdinati, int length) {
		boolean b = true;

		for(int j = 0; j<length;j++){
			b = DataSport.getInstance().getEvadibilita(articoliOrdinati[j][0].toString(),Integer.parseInt(articoliOrdinati[j][1].toString()));
		}

		return b;
	}

	public void newCodiceUscita() {

		gUM.setCodiceBolla(DataSport.getInstance().newCodiceUscita());

	}

	public void getNegozio(int codiceO) {
		gUM.setNegozio(DataSport.getInstance().getNegozioByOrder(codiceO));
	}

	//metodo per inserire i dati di uscita
	public void spedisci(String articolo, int pezziPerArticolo) {

		String data = gUM.getData();
		String annomese = data.substring(0,7);

		DataSport.getInstance().aggiornaUscite(annomese,pezziPerArticolo);

		for (int j = 0 ;j<pezziPerArticolo ; j++){

			int codiceA = DataSport.getInstance().getCodiceArticolo(articolo);
			//"Codice Uscita", "Codice Negozio", "Articolo", "Numero Pezzi", "Data", "spedizioniere"
			DataSport.getInstance().insertUscita(gUM.getCodiceBolla(), gUM.getNegozio(),codiceA, gUM.getSpedizioniere(),gUM.getData(), gUM.getOrdineDaEvadere());
			DataSport.getInstance().updateArticolo(codiceA);

		}

	}
}
