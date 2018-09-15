package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSport {

	private static DataSport instance;
	private Connection conn;
	
	public static DataSport getInstance() {
		if(instance == null) {
			instance = new DataSport();
		}
		return instance;
	}
	
	private DataSport(){
		  try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Articoli sportivi", "postgres", "utente0");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getPassw(String Utente) throws SQLException, ClassNotFoundException, NullPointerException{
		  
		  ResultSet rs1 = null;

		  String Passw;

			  
			  try (PreparedStatement st = conn.prepareStatement("SELECT * FROM utenti\n" + "WHERE id=?")){
				  st.setString(1, Utente);
				  rs1=st.executeQuery();
				  
				  Passw= new String();
				  
				  while(rs1.next()) {
					  Passw =rs1.getString("password");
				  }
		
					  rs1.close();
					  conn.close();
					  return Passw;
				  }

		  }
	
}
