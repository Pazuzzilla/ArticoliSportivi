package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Ordine_Negozio{
	private String codNeg;
	private int numO;
	private String art;
	private int Q;
	private Date Date;
	
	public Ordine_Negozio() {
		//costruttore vuoto
	}
	
	public Ordine_Negozio(String codNeg, int numO, String art, int Q, String Date) {
		this.codNeg = codNeg;
		this.numO = numO;
		this.Q = Q;
		this.art = art;
		this.Date = null;		
	}
		
	// metodi get
	  	public String getcodNeg() {
		    return this.codNeg;
		  }

		public int getnumO() {
		    return this.numO;
		  }
		
		public String getart() {
			return this.art;
		}
		
		public int getQ(){
			return this.Q;
		}
		
		public Date getDate() {
			return this.Date;
		}

	// metodi set
		 		  

		  public void setcodNeg(String cn) {
		    codNeg = cn;
		  }

		  public void setnumO(int Ord) {
		    numO = Ord;
		  }
		  
		  public void setart(String a) {
			  art = a;
		  }
		  
		  public void setQ(int quan) {
			  Q = quan;
		  }
		  
		  public void setDate(Date data) {
			  Date = data;
		  }
		  
		  
		  
		  public void stampa(){
			   System.out.println( codNeg+" "+numO+" "+Q+" "+art+" "+Date );
			  }
		 
		  
		  
		  
}