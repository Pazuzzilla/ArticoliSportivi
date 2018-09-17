package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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


		try (PreparedStatement st = conn.prepareStatement("SELECT * FROM utenti\n" + "WHERE id=?")) {
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
	public void insertarticletipe(String nome, String sport, String materiale, String descrizione) throws SQLException {
		try (PreparedStatement st = conn.prepareStatement("INSERT INTO articolo(nome,sport,materiale,descrizione) VALUES(?,?,?,?)")) {

			st.setString(1, nome);
			st.setString(2, sport);
			st.setString(3, materiale);
			st.setString(4, descrizione);

			st.executeQuery();

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
				System.out.println(ordineUscita[0][i]);
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

}
