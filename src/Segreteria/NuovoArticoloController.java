package Segreteria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class NuovoArticoloController {

	private NuovoArticoloObserved NAO;
	
	public NuovoArticoloController(NuovoArticoloObserved nao) {
		NAO= nao;
	}
	
	public void Exist(String Articolo) {
		boolean b=false;
		NuovoArticoloObserved nao=this.NAO;
		try {
			b=nao.AlreadyExist(Articolo);
		} catch (ClassNotFoundException | NullPointerException | SQLException e) {
			JOptionPane.showMessageDialog(null,"Problema con AlreadyExist ");
			e.printStackTrace();
		}
		if (b==true) {
			JOptionPane.showMessageDialog(null,"Articolo già presente nel sistema! ");
		}
		else {
			JOptionPane.showMessageDialog(null,"Articolo non presente nel sistema ");
		}
	}
/*	
	 public  boolean AlreadyExist(String Articolo) throws SQLException, ClassNotFoundException, NullPointerException{
		  boolean b = false;
		  ResultSet rs1 = null;

		  String articolo;

		  
		  Class.forName("org.postgresql.Driver");
		  
		  try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Articoli sportivi", "postgres", "utente0")){
			  
			  try (Statement st = conn.createStatement()){
				  rs1=st.executeQuery("SELECT nome FROM articolo\n" + "WHERE nome ='"+ Articolo +"'");
				  
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
			  }
		return b;

		 

		  }
	*/
	
	
}
