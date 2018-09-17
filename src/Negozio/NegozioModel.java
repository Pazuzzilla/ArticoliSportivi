package Negozio;

import data.Negozio;

public class NegozioModel {
	private Negozio neg;
	
	public NegozioModel(Negozio negozio){
		this.neg = negozio;
	}
	
	public Negozio getNeg() {
		return this.neg;
	}
}
