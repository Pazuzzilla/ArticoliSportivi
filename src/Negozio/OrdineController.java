package Negozio;

import data.DataSport;

public class OrdineController{

	private OrdineModel om;


	public OrdineController(OrdineModel om) {

		this.om = om;
		
	}

	public Object[] aggiungi(){
		Object[] rigaO = new Object[6];

		float prezzo = 0;
		int new_ordine = 0;
		om.setPrezzo(0);
		prezzo = DataSport.getInstance().verifica(om.getArticolo(),om.getQuantità());
		om.setPrezzo(prezzo);

		// ora abbiamo il prezzo totale e lo ho settato adesso devo generare un nuovo codice per l'ordine

		new_ordine = DataSport.getInstance().new_Order();
		om.setCodiceO(new_ordine);


		om.setPrezzo_complessivo( om.getPrezzo_complessivo()+ om.getPrezzo());


		return rigaO;
	}

	//metodo invocato dalla view di Ordine per richiedere l'aggiunta di una riga di ordine nel database
	public void insert() {

		//"Negozio", "codice ordine", "data", "articolo", "quantità","Prezzo totale"

		DataSport.getInstance().InsertOrdine(om.getCodiceO(),om.getNegO(),om.getDataOS(), om.getArticolo(),om.getQuantità(),om.getPrezzo());
		//om.setPrezzo_complessivo( om.getPrezzo_complessivo()+ om.getPrezzo());

	}
}