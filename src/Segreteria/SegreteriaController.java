package Segreteria;


import data.Negozio;
import data.Negozio;

public class SegreteriaController {

	
	public SegreteriaController(){

		}
	
	public void Openna() {
		//Model Nuovoarticolo
		NuovoArticoloObserved nao=new NuovoArticoloObserved(new NuovoArticoloModelImpl());
		//Controller Nuovoarticolo
		NuovoArticoloController nac= new NuovoArticoloController(nao);
		//View Nuovoarticolo
		NuovoArticoloView nav= new NuovoArticoloView(nac,nao);
		//run() Nuovoarticolo
		nav.run();
	}

	public void openVMM() {
		//Model Nuovoarticolo
		VisualizzaMovimentiModel vmm =new VisualizzaMovimentiModel(new Negozio());
		//Controller Nuovoarticolo
		VisualizzaMovimentiController vmc= new VisualizzaMovimentiController(vmm);
		//View Nuovoarticolo
		VisualizzaMovimentiView vmv= new VisualizzaMovimentiView(vmc,vmm);
		//run() Nuovoarticolo
		vmv.run();
	}

}

