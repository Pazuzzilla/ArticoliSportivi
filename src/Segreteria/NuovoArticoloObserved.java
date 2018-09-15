package Segreteria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;

import javax.swing.JOptionPane;

public class NuovoArticoloObserved extends Observable {
	
	private NuovoArticoloModelImpl NAMI;
	
	public NuovoArticoloObserved(NuovoArticoloModelImpl TheModel) {
		this.NAMI=TheModel;
	}
	
	 public  boolean AlreadyExist(String Articolo) throws SQLException, ClassNotFoundException, NullPointerException{
		  boolean b = false;
		  ResultSet rs1 = null;

		  String articolo;

		  
		  Class.forName("org.postgresql.Driver");
		  
		  try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Articoli sportivi", "postgres", "utente0")){
			  
			  try (Statement st = conn.createStatement()){
				  rs1=st.executeQuery("SELECT nome FROM articolo\n" + "WHERE nome ='"+Articolo+"'");
				  
				  articolo= new String();
				  
				  while(rs1.next()) {
					  articolo =rs1.getString("nome");
				  }
		
					  rs1.close();
					  conn.close();
					  
					  if (Articolo.equals(articolo) && Articolo.isEmpty()==false) {
						  b=true;
					  }
					  else {
					  }
					
				  }
			  }
			  catch(SQLException e ) {
				  System.out.println("Problema durante la connessione iniziale con la banca dati :" +e.getMessage());
				  JOptionPane.showMessageDialog(null,"Problema durante la connessione iniziale con la banca dati ");
			  }
		return b;
		 }


}
