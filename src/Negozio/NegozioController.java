package Negozio;


import Login.LoginController;
import Login.LoginView;
import data.DataSport;
import data.Negozio;
import data.Negozio;

public class NegozioController {
	
	private NegozioModel TheModel;
	
	public NegozioController(NegozioModel nm){
		this.TheModel=nm;
	}
	
		public void openStorico() {
			Negozio neg = TheModel.getNeg();
			
			//StoricoNegModel snm = new StoricoNegModel(neg);
			
			//StoricoNegController snc = new StoricoNegController(snm);
			 // View

			String s = null;
			s =  neg.getNegozioid();
			
			Object [][] o = DataSport.getInstance().getStoNeg(s);
			
			StoricoNegView snv = new StoricoNegView(o);
			
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

