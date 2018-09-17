package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

<<<<<<< HEAD
import Negozio.NegozioController;
import Negozio.NegozioModel;
import Negozio.NegozioView;
=======
import Magazzino.MagazzinoController;
import Magazzino.MagazzinoModel;
import Magazzino.MagazzinoView;
>>>>>>> d8f395d27a5aff8661d634864977dadcd524f02f
import Segreteria.SegreteriaController;
import Segreteria.SegreteriaModel;
import Segreteria.SegreteriaView;
import data.DataSport;
import data.Negozio;

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
					Negozio negozio = new Negozio();
					negozio.setNegozioid(DataSport.getInstance().getNegozio(ID));
					JOptionPane.showMessageDialog(null,"Utente di Negozio di: "+negozio.getNegozioid());

					//b=true;
					
					NegozioModel nm = new NegozioModel();
					
					NegozioController nc = new NegozioController();
					
					NegozioView nv = new NegozioView(nc,nm);
					
					nv.run();
					
					
					break;
				case "MAG": 
					JOptionPane.showMessageDialog(null,"Utente di Magazzino");

					//Model SEGRETERIA
					MagazzinoModel mm=new MagazzinoModel();
					//Controller SEGRETERIA
					MagazzinoController mc= new MagazzinoController(mm);
					//View SEGRETERIA
					MagazzinoView mv =new MagazzinoView(mc,mm);

					//run SEGRETERIA
					mv.run();

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
