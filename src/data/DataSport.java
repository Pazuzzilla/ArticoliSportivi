package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

public class DataSport {

	private static DataSport instance;
	private Connection conn;

	public static DataSport getInstance() {
		if (instance == null) {
			instance = new DataSport();
		}
		return instance;
	}

	private DataSport() {
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


	//getPass metodo invocato da LoginController
	public String getPassw(String Utente) throws SQLException, ClassNotFoundException, NullPointerException {

		ResultSet rs1 = null;

		String Passw;


		try (PreparedStatement st = conn.prepareStatement("SELECT * FROM utenti\nWHERE id=?")) {
			st.setString(1, Utente);
			rs1 = st.executeQuery();

			Passw = new String();

			while (rs1.next()) {
				Passw = rs1.getString("password");
			}

			rs1.close();
			//conn.close();
			return Passw;
		}

	}


	//getPass metodo invocato da LoginController
	public String getNegozio(String Utente) throws SQLException, ClassNotFoundException, NullPointerException {

		ResultSet rs1 = null;

		String Passw;


		try (PreparedStatement st = conn.prepareStatement("SELECT * FROM utenti\nWHERE id=?")) {
			st.setString(1, Utente);
			rs1 = st.executeQuery();

			Passw = new String();

			while (rs1.next()) {
				Passw = rs1.getString("negozio");
			}

			rs1.close();
			//conn.close();
			return Passw;
		}

	}


	//AlreadyExist  Metodo invocato da NuovoArticoloController
	public boolean AlreadyExist(String Articolo) throws SQLException, ClassNotFoundException, NullPointerException {
		boolean b = false;
		ResultSet rs1 = null;

		String articolo;

		try (PreparedStatement st = conn.prepareStatement("SELECT nome FROM articolo\n" + "WHERE nome =?")) {

			st.setString(1, Articolo);
			rs1 = st.executeQuery();

			articolo = new String();

			while (rs1.next()) {
				articolo = rs1.getString("nome");
			}

			rs1.close();
			//conn.close();

			if (Articolo.equals(articolo) && Articolo.isEmpty() == false) {
				b = true;
			} else {
			}

		}

		return b;
	}

	// insertarticletipe metodo di inserimento tipo articolo
	public void insertarticletipe(String nome, String sport, String materiale, String descrizione, float prezzo) throws SQLException {
			try (PreparedStatement st = conn.prepareStatement("INSERT INTO articolo(nome,sport,materiale,descrizione,prezzo) VALUES(?,?,?,?,?)")) {

				st.setString(1, nome);
				st.setString(2, sport);
				st.setString(3, materiale);
				st.setString(4, descrizione);
				st.setFloat(5,prezzo);


				boolean b;

				b=st.execute();

				if(b==true){
					JOptionPane.showMessageDialog(null,"Errore inserimento ");
				}
		}

	}

	//metodo per ottenere il numero esatto di ordini associati a un negozio
	public int howMany(String negozio) throws SQLException {
		int theMany = 0;
		ResultSet rs = null;
		try (PreparedStatement st = conn.prepareStatement("SELECT codice_ordine\nFROM ordine\nWHERE cod_negozio=?\nGROUP BY codice_ordine")) {

			st.setString(1, negozio);
			rs = st.executeQuery();

			while (rs.next()) {
				theMany++;
			}

			rs.close();
			//conn.close();

			return theMany;

		}

	}

	// metodo per richiedere i codici degli ordini associati a un negozio
	public int[][] getOrders(String negozio, int howManyOrders) throws SQLException {
		ResultSet rs = null;
		int[][] ordineUscita = new int[2][howManyOrders];
		int i = 0;
		try (PreparedStatement st = conn.prepareStatement("SELECT codice_ordine\nFROM ordine\nWHERE cod_negozio=?\nGROUP BY codice_ordine")) {

			st.setString(1, negozio);
			rs = st.executeQuery();

			while (rs.next()) {
				ordineUscita[0][i] = rs.getInt("codice_ordine");
				i++;
			}

			rs.close();
			//conn.close();
			return ordineUscita;

		}

	}

	//metodo per passare le uscite e associarle agli ordini
	public int[][] getExit(int howMany, int[][] ordineUscita) throws SQLException {
		ResultSet rs = null;
		int i = 0;
		for (i = 0; i < howMany; i++) {
			try (PreparedStatement st = conn.prepareStatement("SELECT bolla\nFROM uscita\nWHERE cod_ordine=?\nGROUP BY bolla")) {

				//System.out.println(ordineUscita[0][i]);
				st.setInt(1, ordineUscita[0][i] );
				rs = st.executeQuery();

				while (rs.next()) {
					ordineUscita[1][i] = rs.getInt("bolla");
				}
			}
		}

		rs.close();
		return ordineUscita;
	}

	// metodo per storico negozio
	public Object[][] getStoNeg(String negID){
		
		int i = 0;
		ResultSet rs = null;
		ResultSet rs1 = null;
		
		try (PreparedStatement st = conn.prepareStatement("SELECT *\nFROM Ordine\nWHERE cod_negozio=?")) {
			st.setString(1,negID );
			rs = st.executeQuery();
			
			while(rs.next()){
				i++;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object[][] o = new Object[6][i];
		
		try (PreparedStatement st = conn.prepareStatement("SELECT *\nFROM Ordine\nWHERE cod_negozio=?")) {
			st.setString(1,negID );
			rs1 = st.executeQuery();
			
			for(int j = 0; j < i; j++) {
				rs1.next();
				o[0][j] = rs1.getInt("codice_ordine");
				o[1][j] = rs1.getString("cod_negozio");
				o[2][j] = rs1.getString("nome_articolo");
				o[3][j] = rs1.getInt("quantità");
				o[4][j]	= rs1.getDate("data_ordine");
				o[5][j] = rs1.getFloat("prezzo_tot");
			}
			rs1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}


	// metodo usato da OrdineController per verificare se un articolo esiste in magazzino e in caso prenderne il prezzo totale per l'ordine
	public float verifica(String articolo, int quantità) {
		float prezzo=0;
		ResultSet rs1 = null;

		boolean b = false;


		// trucco per inserire la riga di ordine
		// avendo modificato le tabelle cerchiamo se è registrato

		try (PreparedStatement st = conn.prepareStatement("SELECT nome FROM articolo WHERE nome=?")) {
			st.setString(1, articolo);
			b = st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (b == true) {

			try (PreparedStatement st = conn.prepareStatement("SELECT nome,prezzo FROM articolo WHERE nome=?")) {
				st.setString(1, articolo);
				rs1 = st.executeQuery();

				while (rs1.next()) {
					prezzo = rs1.getFloat("prezzo");
				}

				rs1.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		prezzo = prezzo*quantità;
		return prezzo;
	}



	// metodo richiamato da OrdineController per calcolare il codice del nuovo ordine da inserire
	public int new_Order() {

		ResultSet rs1 = null;
		int nuovo_ordine=0;
		try (PreparedStatement st = conn.prepareStatement("SELECT MAX(codice_ordine) AS ultimo_ordine\nFROM ordine;")) {
			rs1 = st.executeQuery();

			while (rs1.next()) {
				nuovo_ordine  = rs1.getInt("ultimo_ordine");
			}
			nuovo_ordine++;
			rs1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nuovo_ordine;

	}


	//metodo di interrogazione a databae chiamato da GestioneArticoliConttroller per settare la nuova posizione di articoli
	//e ottenere quella vecchia
	public String setNewPosition(String articolo, String posizione) {

		ResultSet rs1 = null;
	    String oldPosizione= new String();

		try (PreparedStatement st = conn.prepareStatement("SELECT * \nFROM articoloregistrato\nWHERE codice=?;")) {
			st.setString(1, articolo);
			rs1 = st.executeQuery();

			while (rs1.next()) {
				oldPosizione  = rs1.getString("posizione");
			}

			if (oldPosizione.isEmpty()){
				JOptionPane.showMessageDialog(null,"codice non trovato");
			}

			rs1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		try (PreparedStatement st = conn.prepareStatement("UPDATE articoloregistrato SET posizione=?\nWHERE codice=?")) {
			st.setString(1, posizione);
			st.setString(2, articolo);

			st.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return oldPosizione;

	}

	// inserimento di una riga di ordine, chiamato da OrdineController
	public void InsertOrdine(int codiceO, String negO, String dataO, String articolo, int quantità, float prezzo) {
		try (PreparedStatement st = conn.prepareStatement("INSERT INTO ordine(codice_ordine,cod_negozio,data_ordine,nome_articolo,quantità,prezzo_tot) VALUES(?,?,?,?,?,?)")) {

			st.setInt(1, codiceO);
			st.setString(2, negO);
			st.setString(3, dataO);
			st.setString(4, articolo);
			st.setInt(5, quantità);
			st.setFloat(6, prezzo);

			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Ordine non inserito, controllare dati e riprovare");
		}

	}
}
