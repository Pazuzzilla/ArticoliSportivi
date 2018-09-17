package Negozio;


import Login.LoginController;
import Login.LoginView;
import data.Negozio;
import data.Negozio;

public class NegozioController {
	
	private NegozioModel TheModel;
	
	public NegozioController(){
		
	}
	
		public void openStorico() {
			Negozio neg = TheModel.getNeg();
			
			StoricoNegModel snm = new StoricoNegModel(neg);
			
			StoricoNegController snc = new StoricoNegController(snm);
			 // View
			StoricoNegView snv = new StoricoNegView(snc, snm);
			
			snv.run();
		}

		public void newOrdine() {
			Negozio neg = TheModel.getNeg();
			
			OrdineModel om = new OrdineModel(neg);
			
			OrdineController oc=new OrdineController(om);
			 // View
			OrdineView ov =new OrdineView(om, oc);
			
			ov.run();
			
			
		}
}

