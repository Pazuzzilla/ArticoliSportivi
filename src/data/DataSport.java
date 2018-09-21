package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Articoli Sportivi", "postgres", "utente0");
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

		try (PreparedStatement st = conn.prepareStatement("SELECT *\nFROM ordine\nWHERE cod_negozio=?")) {
			st.setString(1,negID );
			rs1 = st.executeQuery();

			for(int j = 0; j < i; j++) {
				rs1.next();
				o[0][j] = rs1.getInt("codice_ordine");
				o[1][j] = rs1.getString("cod_negozio");
				o[2][j] = rs1.getString("nome_articolo");
				o[3][j] = rs1.getInt("numeropezzi");
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
	public float verifica(String articolo, int numeropezzi) {
		float prezzo=0;
		ResultSet rs1 = null;

		boolean b = false;


		// trucco per inserire la riga di ordine
		// avendo modificato le tabelle cerchiamo se e' registrato

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
		prezzo = prezzo*numeropezzi;
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

			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return oldPosizione;

	}

	// inserimento di una riga di ordine, chiamato da OrdineController
	public void InsertOrdine(int codiceO, String negO, String dataO, String articolo, int numeropezzi, float prezzo) {
		try (PreparedStatement st = conn.prepareStatement("INSERT INTO ordine(codice_ordine,cod_negozio,data_ordine,nome_articolo,numeropezzi,prezzo_tot) VALUES(?,?,?,?,?,?)")) {

			st.setInt(1, codiceO);
			st.setString(2, negO);
			st.setString(3, dataO);
			st.setString(4, articolo);
			st.setInt(5, numeropezzi);
			st.setFloat(6, prezzo);

			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Ordine non inserito, controllare dati e riprovare");
		}

	}

	public boolean verificaEsistenza(String nomeArticolo) {

		boolean b = false;
		ResultSet rs = null;
		int control = 0;

		// trucco per inserire la riga di ordine
		// avendo modificato le tabelle cerchiamo se e' registrato

		try (PreparedStatement st = conn.prepareStatement("SELECT nome FROM articolo WHERE nome=?")) {
			st.setString(1, nomeArticolo);
			rs = st.executeQuery();

			while (rs.next()){
				control++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(control>0){
			b = true;
		}
		return b;
	}


	public int new_Insert() {

		ResultSet rs1 = null;
		int nuovo_ingresso=0;
		try (PreparedStatement st = conn.prepareStatement("SELECT MAX(codice_interno) AS ultimo_ingresso\nFROM ingresso;")) {
			rs1 = st.executeQuery();

			while (rs1.next()) {
				nuovo_ingresso  = rs1.getInt("ultimo_ingresso");
			}
			nuovo_ingresso++;
			rs1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nuovo_ingresso;

	}

	// metodo per cercare ultoimo numero d'ordine
	public int new_codiceArticolo() {
		ResultSet rs1 = null;
		int nuovo_codice=0;
		try (PreparedStatement st = conn.prepareStatement("SELECT MAX(codice) AS ultimo_codice\nFROM articoloregistrato;")) {
			rs1 = st.executeQuery();

			while (rs1.next()) {
				nuovo_codice  = rs1.getInt("ultimo_codice");
			}
			nuovo_codice++;
			rs1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nuovo_codice;

	}

	// metodo per aggiungere una riga di ingresso
	public void insertIngresso(int codiceIngresso, int newCodiceArticolo, String dataOS) {
		try (PreparedStatement st = conn.prepareStatement("INSERT INTO ingresso(codice_interno,articolo,data_ingresso) VALUES(?,?,?)")) {

			st.setInt(1, codiceIngresso);
			st.setInt(2, newCodiceArticolo);
			st.setString(3, dataOS);

			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Problemi nell'inserimento in memoria dell'ingresso");
		}


	}



//metodo per inserire un articolo e registrarlo in magazzino, prima di inserirlo cerca il prezzo nella tabella articolo
	public void insertArticolo(String nomeArticolo, int codiceIngresso, String dataOS, String dataIngresso, String posizione) {
		float prezzo=0;
		String toF="T";
		ResultSet rs1 = null;


		try (PreparedStatement st = conn.prepareStatement("SELECT prezzo FROM articolo\nWHERE nome = ?;")) {
			st.setString(1, nomeArticolo);
			rs1 = st.executeQuery();

			while (rs1.next()) {
				prezzo = rs1.getFloat("prezzo");
			}

			rs1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try (PreparedStatement st1 = conn.prepareStatement("INSERT INTO articoloregistrato(nome,codice,prezzo,posizione,data_prod,presenza) VALUES(?,?,?,?,?,?)")) {

			st1.setString(1, nomeArticolo);
			st1.setInt(2, codiceIngresso);
			st1.setFloat(3, prezzo);
			st1.setString(4, posizione);
			st1.setString(5, dataIngresso);
			st1.setString(6, toF);

			st1.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Ordine non inserito, controllare dati e riprovare");
		}

	}



	//metodo per aggiornare la tabella di storicomagazzino
	public void aggiornaEntrate(String annomese, int numeroPezzi) throws SQLException {

		ResultSet rs1 = null;
		int i = 0;
		int pezziFinoAdOra=0;

		// cerca se la combinazione anno e mese corrente e' gia' presente nel sistema
		PreparedStatement st = conn.prepareStatement("SELECT * FROM storicomagazzino\nWHERE annomese = ?;");
			st.setString(1, annomese);
			rs1 = st.executeQuery();

			while (rs1.next()) {
				i++;
				pezziFinoAdOra = rs1.getInt("ingressi");
			}

			rs1.close();

			//se non è presente la variabile i sara' zero quindi inserisco la riga di questo mese
			if (i < 1){
				pezziFinoAdOra=numeroPezzi;

				try (PreparedStatement st1 = conn.prepareStatement("INSERT INTO storicomagazzino(annomese,ingressi,uscite) VALUES(?,?,?)")) {

					System.out.println( annomese+" "+pezziFinoAdOra);

					st1.setString(1, annomese);
					st1.setInt(2, pezziFinoAdOra);
					st1.setInt(3, 0);

					st.execute();

				} catch (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Ordine non inserito, controllare dati e riprovare");
				}

			}//altrimenti se la trova aggiorna le quantita'
			else {
				pezziFinoAdOra=pezziFinoAdOra+numeroPezzi;

				try (PreparedStatement st2 = conn.prepareStatement("UPDATE storicomagazzino SET ingressi=?\nWHERE annomese=?")) {
					st2.setInt(1, pezziFinoAdOra);
					st2.setString(2, annomese);

					st2.execute();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	public List<Integer> findOrdini() {
		ResultSet rs1 = null;
		List <Integer> v = new ArrayList();
		try (PreparedStatement st = conn.prepareStatement("SELECT codice_ordine FROM ordine GROUP BY codice_ordine ;")){
			rs1 = st.executeQuery();

			while(rs1.next()) {
				v.add(rs1.getInt("codice_ordine"));				
				}
			
		rs1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//System.out.println("DDDD"+v);
		return v;
	}
}
