package data;


import Login.LoginController;
import Login.LoginObservedModel;
import Login.LoginView;
import Login.Utente;
import lib.Negozio;
import lib.Nuovo_Ordine;


public class MainClass  {
	
	public static void main(String[] args) {
		
		 // Model
		 LoginObservedModel m1=new LoginObservedModel(new Utente());
		 // Controller
		 LoginController c1=new LoginController(m1);
		 // View
		 LoginView v1=new LoginView(c1,m1);
		 // GUI setup
		 v1.run();
	}
	

}
