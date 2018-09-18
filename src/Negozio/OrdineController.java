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





		return rigaO;
	}
}