
package Magazzino;


import Segreteria.*;
import data.Negozio;
import lib.GestioneIngressi;

public class MagazzinoController {
	
	private MagazzinoModel TheModel;
	
	public MagazzinoController(MagazzinoModel sm1){
		TheModel=sm1;
		}
	
	public void openGI() {
		//Model Gestione Ingressi
		GestioneIngressiObserved gim=new GestioneIngressiObserved();
		//Controller GestioneIngressi
		GestioneIngressiController gic= new GestioneIngressiController(gim);
		//View GestioneIngressi
		GestioneIngressiView giv= new GestioneIngressiView(gic,gim);
		//run() Gestioneingressi
		giv.run();
	}

	public void openGU() {
		//Model Nuovoarticolo
		GestioneUsciteModel gum =new GestioneUsciteModel();
		//Controller Nuovoarticolo
		GestioneUsciteController guc= new GestioneUsciteController(gum);
		//View Nuovoarticolo
		GestioneUsciteView guv= new GestioneUsciteView(guc,gum);
		//run() Nuovoarticolo
		guv.run();
	}

	public void openGA() {
		//Model Nuovoarticolo
		GestioneArticoliModel gam =new GestioneArticoliModel();
		//Controller Nuovoarticolo
		GestioneArticoliController gac= new GestioneArticoliController(gam);
		//View Nuovoarticolo
		GestioneArticoliView gav= new GestioneArticoliView(gac,gam);
		//run() Nuovoarticolo
		gav.run();
	}



}

