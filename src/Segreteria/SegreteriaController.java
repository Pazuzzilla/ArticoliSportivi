package Segreteria;


public class SegreteriaController {
	
	private SegreteriaModel TheModel;
	
	public SegreteriaController(SegreteriaModel sm1){
		TheModel=sm1;
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
}

