package Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utente{

  //variabili di istanza (campi dati)
  private String ID;
  private String passw; 

  //costruttore senza argomenti
   public Utente(){
   }

  //costruttore con due argomenti
  public Utente(String ID, String passw){
	this.ID = ID;
	this.passw = passw;
  }

  //metodi (campi operazione)
  //metodi get
  public String getID() {
    return ID;
  }

  public String getpassw() {
    return passw;
  }

  public void setID(String n) {
    ID = n;
  }

  public void setpassw(String pass) {
    passw = pass;
  }

  //metodo per la stampa
  public void stampa(){
   System.out.println(ID + "  " + passw);
  }

  //metodo per la stampa
  public String toString(){
   return ID + "  " + passw;
  }

 /* public static String[] userArray() throws SQLException, ClassNotFoundException, NullPointerException{
	  
	  ResultSet rs1 = null;
	  ResultSet le = null;
	  String Utenti[];
	  int length=0;
	  
	  Class.forName("org.postgresql.Driver");
	  
	  try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Articoli sportivi", "postgres", "utente0")){
		  
		  try (Statement st = conn.createStatement()){
			  le=st.executeQuery("SELECT count (*) FROM \"utenti\"");
			  
			  while(le.next()) {
				  length =le.getInt(1);
			  }
			  
			  try (Statement st1 =conn.createStatement()){
				  rs1 =st1.executeQuery("SELECT id from \"utenti\"");
				  
				  Utenti= new String[length];
				  
				  int i =0;
				  
				  while (rs1.next()) {
					  Utenti[i]=rs1.getString("id");
					  i++;
				  }
				  rs1.close();
				  conn.close();
				  return Utenti;
			  }
			  

		  }
		  catch(SQLException e ) {
			  System.out.println("Problema durante la connessione iniziale con la banca dati :" +e.getMessage());
			  return null;
		  }

	  }
  }*/
  
  
  
public static String getPassw(String Utente) throws SQLException, ClassNotFoundException, NullPointerException{
	  
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
