package Magazzino;

import java.util.List;

import data.DataSport;

public class GestioneUsciteModel {
	
	public GestioneUsciteModel() {
		
	}
	
	public void setOrdini() {	
	}
	
	public List<Integer> getOrdini() {
		List <Integer> v = DataSport.getInstance().findOrdini();
		return v;
	}
	
}
