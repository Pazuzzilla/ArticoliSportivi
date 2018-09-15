package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;

public class LoginObservedModel extends Observable {
	 private Utente theModel;
	 public LoginObservedModel(Utente m){
		 theModel= m;
		 }
	 /*
	 public int getValue(){
		 return theModel.getValue();
		 }
	 public void inc(){
		 theModel.inc();
		 setChanged();
	 }
	 */
	 public String getID() {
		 String id=theModel.getID();
		 return id;
	 }
	 
	 public String getpassw() {
		 String p=theModel.getpassw();
		 return p;
	 }
	 
	 public void setID(String i) {
		 theModel.setID(i);
	 }
	 public void setpassw(String i) {
		 theModel.setpassw(i);
	 }
	 
	 public  String getPassw(String Utente) throws SQLException, ClassNotFoundException, NullPointerException{
		  
		  ResultSet rs1 = null;

		  String Passw;

		  
		  Class.forName("org.postgresql.Driver");
		  
		  try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Articoli sportivi", "postgres", "utente0")){
			  
			  try (Statement st = conn.createStatement()){
				  rs1=st.executeQuery("SELECT * FROM utenti\n" + "WHERE id='"+ Utente +"'");
				  
				  Passw= new String();
				  
				  while(rs1.next()) {
					  Passw =rs1.getString("password");
				  }
		
					  rs1.close();
					  conn.close();
					  return Passw;
				  }

			  }
			  catch(SQLException e ) {
				  System.out.println("Problema durante la connessione iniziale con la banca dati :" +e.getMessage());
				  return null;
			  }

		  }
	  
}
