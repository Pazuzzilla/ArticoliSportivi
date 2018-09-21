package Magazzino;

import lib.GestioneIngressi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GestioneIngressiView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField month;
	private JTextField year;
	private JTextField text_newcode;
	private JTextField text_newub;
	private JTable table;
	private JTextField day;
	private GestioneIngressiController gIC;
	private GestioneIngressiModel gIM;
	private final Action action = new SwingAction_1();
	private final Action action_1 = new SwingAction_2();
	private final Action action_2 = new SwingAction();
	private JButton btnAggiungiAIngresso;
	private int numeropezzi;
	


	/**
	 * Create the frame.
	 */
	public GestioneIngressiView(GestioneIngressiController gac , GestioneIngressiModel gim) {
		this.gIC = gac;
		this.gIM = gim;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 917, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArticolo = new JLabel("Articolo:");
		lblArticolo.setBounds(27, 38, 61, 16);
		contentPane.add(lblArticolo);
		
		textField = new JTextField();
		textField.setBounds(125, 33, 317, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantit = new JLabel("Numero Pezzi:");
		lblQuantit.setBounds(27, 82, 106, 16);
		contentPane.add(lblQuantit);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 77, 138, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDataDiProduzione = new JLabel("Data di produzione(dd/mm/yyyy)");
		lblDataDiProduzione.setBounds(44, 129, 219, 16);
		contentPane.add(lblDataDiProduzione);
		
		JLabel label = new JLabel("/");
		label.setBounds(316, 129, 14, 16);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("/");
		lblNewLabel.setBounds(370, 129, 14, 16);
		contentPane.add(lblNewLabel);
		
		month = new JTextField();
		month.setBounds(326, 124, 43, 26);
		contentPane.add(month);
		month.setColumns(10);
		
		year = new JTextField();
		year.setBounds(380, 124, 79, 26);
		contentPane.add(year);
		year.setColumns(10);
		
		
		
		
		JLabel lblNuovaUbicazione = new JLabel("Nuova ubicazione:");
		lblNuovaUbicazione.setBounds(325, 82, 118, 16);
		contentPane.add(lblNuovaUbicazione);
		
		text_newub = new JTextField();
		text_newub.setBounds(454, 77, 172, 26);
		contentPane.add(text_newub);
		text_newub.setColumns(10);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 174, 879, 263);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},

			},
			new String[] {
					"codice ingresso", "codice articolo", "nome articolo", "data produzione", "data ingresso","posizione"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton  btnInserisci = new JButton("Inserisci");
		btnInserisci.setAction(action_1);
		btnInserisci.setBounds(753, 449, 143, 43);
		contentPane.add(btnInserisci);
		
		day = new JTextField();
		day.setBounds(264, 124, 51, 26);
		contentPane.add(day);
		day.setColumns(10);
		
		btnAggiungiAIngresso = new JButton("aggiungi ingresso");
		btnAggiungiAIngresso.setAction(action);
		btnAggiungiAIngresso.setBounds(707, 33, 189, 29);
		contentPane.add(btnAggiungiAIngresso);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.setAction(action_2);
		btnElimina.setBounds(624, 449, 117, 29);
		contentPane.add(btnElimina);
	}

	public void run() {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// metodo per verificare se la data inserita come data di produzione e' valida
	public static boolean isDateValid (int day, int month, int year) {
		GregorianCalendar cal = new GregorianCalendar(year, month - 1, day);
		cal.setLenient(false);

		try {
			cal.get(Calendar.DATE);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}


	public void aggiugi(String articolo, int  quantita){
		GestioneIngressiModel gim = this.gIM;
		GestioneIngressiController gic = this.gIC;

		gim.setNomeArticolo(articolo);
		gim.setPosizione(text_newub.getText());
		boolean b=gic.aggiungi();
		Object[] rigaO = new Object[6];

		//se ha prodotto un valore uguale a zero di prezzo non e' utile ai fini dell'ordine e quindi la riga non viene inserita

		rigaO[0] = gim.getCodiceIngresso();
		rigaO[1] = gim.getNewCodiceArticolo();
		rigaO[2] = gim.getNomeArticolo();
		rigaO[3] = gim.getDataIngresso();
		rigaO[4] = gim.getDataOS();
		rigaO[5] = gim.getPosizione();

		table.setModel(new DefaultTableModel(new Object[quantita][6], new String[]{"codice ingresso", "codice articolo", "nome articolo", "data produzione", "data ingresso","posizione"}));

			if (b == true) {
				//"codice ingresso", "codice articolo", "nome articolo", "data produzione", "data ingresso","posizione"
				for (int j = 0; j < quantita ; j++) {

					//questa la setto qui per rendere il tutto progressivo
					rigaO[1] = gim.getNewCodiceArticolo();


					table.setValueAt(rigaO[0],j,0);
					table.setValueAt(rigaO[1],j,1);
					table.setValueAt(rigaO[2],j,2);
					table.setValueAt(rigaO[3],j,3);
					table.setValueAt(rigaO[4],j,4);
					table.setValueAt(rigaO[5],j,5);

					int codplus=gim.getNewCodiceArticolo();
					codplus++;
					gim.setNewCodiceArticolo(codplus);


				}
			}

			//System.out.println(rigaO[3] + " " + rigaO[5]);
			//System.out.println(rigaO[0] + " " + rigaO[1] + " " + rigaO[2] + " " + rigaO[3] + " " + rigaO[4] + " " + rigaO[5]);


		else {


		}
	}



	//metidi richiamato dalla inner class di inserimento per aggiornare gli ingressi e il magazzino
	private void insertIngresso() {

		GestioneIngressiModel gim = gIM;
		GestioneIngressiController gic = gIC;

		//gic.insertIngresso();


		for (int j = 0; j< numeropezzi; j++){

			gim.setNewCodiceArticolo(Integer.parseInt(table.getValueAt(j,1).toString()));

			//System.out.println("codice articolo: "+gim.getNewCodiceArticolo());
			//System.out.println("codice ingresso: "+gim.getCodiceIngresso());

			//System.out.println(Integer.parseInt(table.getValueAt(j,0).toString()));

			gic.insertArticolo();
			gic.insertIngresso();

		}

	}



	//metodo per chiedere al controller di aggiornare le entrate di questo mese
	public void aggiornaEntrate(){

		GestioneIngressiModel gim = gIM;
		GestioneIngressiController gic = gIC;

		String data = gim.getDataOS();
		String annomese = data.substring(0,7);

		gic.aggiornaEntrate(annomese);

	}









	// inner Class per inserire degli articoli nella schermata di entrata articoli
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Aggiungi ingresso");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			btnAggiungiAIngresso.setEnabled(false);

			boolean b  = false;
			boolean b1 = false;

			// prima di iniziare l'inserimento viene verificato che i campi che voglio come integer siano di quel tipo
			// e subito dopo se la data di produzione e' valida come tipo di dato Date


			try{
				numeropezzi = Integer.parseInt(textField_1.getText());
				Integer.parseInt(day.getText());
				Integer.parseInt(month.getText());
				Integer.parseInt(year.getText());
				gIM.setNumeroPezzi(numeropezzi);
				b1 = true;

			} catch( NumberFormatException errore ){

				b1 = false;

			}
			// se gli interi sono giusti gestisco le date
			if(b1 == true) {
				b = isDateValid(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), Integer.parseInt(year.getText()));
			}

			//continuo con l'inserimento
			if(b == true){
				String dataProd= year.getText()+"-"+month.getText()+"-"+day.getText();
				gIM.setDataIngresso(dataProd);

				aggiugi(textField.getText(),Integer.parseInt(textField_1.getText()));
			}
			else{
				JOptionPane.showMessageDialog(null, "Informazioni inserite non valide!");
			}

		}
	}





	//inner class per lanciare l'update del magazzino
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Inserisci");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {


			// inserisco i dati
			insertIngresso();
			//aggiorno le entrate

			System.out.println(gIM.getNumeroPezzi());
			aggiornaEntrate();
			//resetto la finestra
			reset();


		}
	}




    //metodo per resettare la finestra
	public void reset(){

		textField.setText("");
		textField_1.setText("");
		day.setText("");
		month.setText("");
		year.setText("");
		text_newub.setText("");
		btnAggiungiAIngresso.setEnabled(true);

		table.setModel(new DefaultTableModel(
				new Object[][] {
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
				},
				new String[] {
						"codice ingresso", "codice articolo", "nome articolo", "data produzione", "data ingresso","posizione"
				}
		));

	}



	// inner Class per eliminare i dati visibili in tabella
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Elimina");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			//numriga = 0;
			reset();

		}
	}
}
