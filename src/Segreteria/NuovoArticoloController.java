package Segreteria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import data.DataSport;

public class NuovoArticoloController {

	private NuovoArticoloObserved NAO;
	
	public NuovoArticoloController(NuovoArticoloObserved nao) {
		NAO= nao;
	}
	
	// verifica se l'articolo è nel database
	public void Exist(String Articolo) {
		boolean b=false;
		NuovoArticoloObserved nao=this.NAO;
		try {
			b=DataSport.getInstance().AlreadyExist(Articolo);
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

	//inserimento articolo tramite query su database
	public void insert(String nome,String sport, String materiale, String descrizione ) throws SQLException {
			DataSport.getInstance().insertarticletipe(nome,sport,materiale,descrizione);
			JOptionPane.showMessageDialog(null,"Articolo inserito ");

	}
	
}
