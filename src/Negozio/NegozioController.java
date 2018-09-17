package Negozio;


import Login.LoginController;
import Login.LoginView;
import data.Negozio;
import data.Negozio;

public class NegozioController {
	
	private NegozioModel TheModel;
	
	public NegozioController(){
		//TheModel=sm1;
	}
	
		public void openStorico() {
			StoricoNegModel snm = new StoricoNegModel(new Negozio());
			
			StoricoNegController snc=new StoricoNegController(snm);
			 // View
			StoricoNegView snv =new StoricoNegView(snc, snm);
			
			snv.run();
		}

		public void newOrdine() {
			OrdineModel om = new OrdineModel();
			
			OrdineController oc=new OrdineController(om);
			 // View
			OrdineView ov =new OrdineView(om, oc);
			
			ov.run();
			
			
		}
}

