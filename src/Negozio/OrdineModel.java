package Negozio;

import data.Negozio;

public class OrdineModel{
	private Negozio neg;
	
	public OrdineModel(Negozio negozio){
		this.neg = negozio;
	}
	
	public Negozio getNeg() {
		return this.neg;
	}

}