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
		lblArticolo.setBounds(44, 38, 61, 16);
		contentPane.add(lblArticolo);
		
		textField = new JTextField();
		textField.setBounds(117, 33, 342, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantit = new JLabel("Quantità:");
		lblQuantit.setBounds(44, 82, 61, 16);
		contentPane.add(lblQuantit);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 77, 118, 26);
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
		
		JButton btnInserisci = new JButton("Inserisci");
		btnInserisci.setAction(action_1);
		btnInserisci.setBounds(753, 449, 143, 43);
		contentPane.add(btnInserisci);
		
		day = new JTextField();
		day.setBounds(264, 124, 51, 26);
		contentPane.add(day);
		day.setColumns(10);
		
		JButton btnAggiungiAIngresso = new JButton("aggiungi ingresso");
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
	// metodo per verificare se la data inserita come data di produzione è valida
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


	public void aggiugi(String articolo, int  quantità){
		GestioneIngressiModel gim = this.gIM;
		GestioneIngressiController gic = this.gIC;

		gim.setNomeArticolo(articolo);
		gim.setPosizione(text_newub.getText());
		boolean b=gic.aggiungi();
		Object[] rigaO = new Object[6];

		//se ha prodotto un valore uguale a zero di prezzo non è utile ai fini dell'ordine e quindi la riga non viene inserita

		rigaO[0] = gim.getCodiceIngresso();
		rigaO[1] = gim.getNewCodiceArticolo();
		rigaO[2] = gim.getNomeArticolo();
		rigaO[3] = gim.getDataIngresso();
		rigaO[4] = gim.getDataOS();
		rigaO[5] = gim.getPosizione();


			if (b == true) {
				//"codice ingresso", "codice articolo", "nome articolo", "data produzione", "data ingresso","posizione"
				for (int j = 0; j < Integer.parseInt(textField_1.getText()) ; j++) {

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














	// Classe per inserire degli articoli nella schermata di entrata articoli
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Aggiungi ingresso");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			boolean b=false;


			// prima di iniziare l'inserimento viene verificata la data di inserimento inserita dall'utente
			b = isDateValid(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), Integer.parseInt(year.getText()));

			try{
				Integer.parseInt(textField_1.getText());

			} catch( NumberFormatException errore ){
				JOptionPane.showMessageDialog(null, "quantità non valida");
				b = false;

			}
			if(b == true){
				String dataProd= year.getText()+"-"+month.getText()+"-"+day.getText();
				gIM.setDataIngresso(dataProd);

				aggiugi(textField.getText(),Integer.parseInt(textField_1.getText()));
			}
			else{
				JOptionPane.showMessageDialog(null, "data non valida");
			}

		}
	}












	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Inserisci");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {


		}
	}


	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Elimina");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			//numriga = 0;
			textField.setText("");
			textField_1.setText("");

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
	}
}
