package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Segreteria.SegreteriaController;
import Segreteria.SegreteriaModel;
import Segreteria.SegreteriaView;
import data.DataSport;

//controller della classe login che fa interrogazioni sul database
public class LoginController {
	 private LoginObservedModel Login;
	 
	 //collegamento al modello osservabile
	 public LoginController(LoginObservedModel o) {
		 Login=o;
	 }
	  
	 //metodo per accreditare dopo interrogazione su database
	 public  boolean accredita (LoginObservedModel m1) throws ClassNotFoundException, NullPointerException, SQLException {
		boolean b=false;
		String ID= m1.getID();
		String pass = m1.getpassw();
		String passw= DataSport.getInstance().getPassw(ID);
		
		if(pass.equals(passw) && m1.getpassw().isEmpty()==false) {
				
			String temp = null; 
			temp = ID.substring(0, 3);
				
			switch (temp) {
					
				//CASISTICA NEGOZIO
				case "NEG": 	
					JOptionPane.showMessageDialog(null,"Utente di Negozio");
					b=true;
					break;
				case "MAG": 
					JOptionPane.showMessageDialog(null,"Utente di Magazzino");
					break;
				case "SEG":	
					JOptionPane.showMessageDialog(null,"Utente di Segreteria");
					
					//Model SEGRETERIA
					SegreteriaModel sm=new SegreteriaModel();	
					//Controller SEGRETERIA
					SegreteriaController sc= new SegreteriaController(sm);
					//View SEGRETERIA
					SegreteriaView sv =new SegreteriaView(sc,sm);
					
					//run SEGRETERIA
					sv.run();
					
					
				
					break;
				default: 
					break;
			}
				
		}
		else {
			System.out.println("Utente non trovato");
			JOptionPane.showMessageDialog(null,"Informazioni inserite non valide riprovare");
		}
		return b;
	 }
	 
	
	 
}
