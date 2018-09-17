package data;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Login.LoginController;
import Login.LoginObservedModel;
import Login.LoginView;
import Login.Utente;
import lib.Negozio;
import lib.Nuovo_Ordine;


public class MainClass  {
	
	public static void main(String[] args) {
		
		 // Model
		 LoginObservedModel m1=new LoginObservedModel(new Utente());
		 // Controller
		 LoginController c1=new LoginController(m1);
		 // View
		 LoginView v1=new LoginView(c1,m1);
		 // GUI setup
		 v1.run();
	}
	
	/*
	public static void main(String[] args) throws ClassNotFoundException, NullPointerException, SQLException  {
		
		//creo la mia interfaccia di login e la faccio partire
		Login myfr= new Login();
		myfr.run();
		//nuovo utente che conterrà i dati dell'utente che vuole autenticarsi
		Utente Ut =new Utente();
		boolean accreditato=false;
		
		
		
		while(accreditato==false) {
			
			//while per inserimento dati dell'utente
			while(myfr.isVisible()) {
				Ut = myfr.getUtente();
				System.out.println(Ut.getID());
				System.out.println(Ut.getpassw());
			}
			
			myfr.setVisible(true);
			System.out.println("Sei Uscito");
	
			//Ut.stampa();
			//String Username=Ut.getID();
			//String Pass= Ut.getPassw(Ut.getID());
			
			String dbpssw = null; // variabile per il database
			dbpssw = Ut.getPassw(Ut.getID()); // mi da la password dal database
			
			
			
			
			// FASE ACCREDITAMENTO E SELEZIONE INTERFACCIA UTENTE
			if(dbpssw.equals(Ut.getpassw()) && Ut.getpassw().isEmpty()==false) {
				
				myfr.dispose();;
				accreditato=true;
				String temp = null; 
				temp = Ut.getID();
				temp = temp.substring(0, 3);
				System.out.println(temp);
				
				switch (temp) {
					
					//CASISTICA NEGOZIO
					case "NEG": 	
						//devo fare in modo che sia il main ad acchiappare il bottone?
						Negozio myfrneg= new Negozio();
						//Nuovo_Ordine myfrnewo=new Nuovo_Ordine();
						myfrneg.run();
						while (myfrneg.isVisible()) {
							System.out.println("y");
									
						
							
						}
				
						
									
						break;
					case "MAG": System.out.println("MAG");
						break;
					case "SEG":	System.out.println("SEG");
						break;
					default: 
						break;
				}
					
			}
			else {
				System.out.println("Utente non trovato");
				JOptionPane.showMessageDialog(null,"Informazioni inserite non valide riprovare");
				myfr.setVisible(true);
			}
			
		}//while accreditato end
		
	}
	*/
}
