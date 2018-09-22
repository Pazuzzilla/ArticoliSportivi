package Magazzino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;


public class GestioneUsciteView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private GestioneUsciteController gUC;
	private GestioneUsciteModel gUM;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnVisualizza;
	private JButton btnSpedisci;
	private int numerorighe;


	/**
	 * Launch the application.
	 */
/*	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneUsciteView frame = new GestioneUsciteView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public GestioneUsciteView(GestioneUsciteController guc, GestioneUsciteModel gum) {
		gUC=guc;
		gUM=gum;
		numerorighe = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 134, 246, 442);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Numero Ordine", "Codice Negozio"
			}
		));
		scrollPane.setViewportView(table);
		
		btnVisualizza = new JButton("Visualizza");
		btnVisualizza.setBounds(137, 64, 131, 23);
		btnVisualizza.setAction(action);
		contentPane.add(btnVisualizza);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(337, 134, 752, 344);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
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
			},
			new String[] {
				"Codice Uscita", "Codice Negozio", "Articolo", "Numero Pezzi", "Data", "spedizioniere"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton btnEliminaOrdine = new JButton("Elimina Ordine");
		btnEliminaOrdine.setBounds(785, 511, 131, 33);
		btnEliminaOrdine.setAction(action_1);
		contentPane.add(btnEliminaOrdine);
		
		btnSpedisci = new JButton("Spedisci");
		btnSpedisci.setBounds(928, 511, 161, 65);
		btnSpedisci.setAction(action_2);
		btnSpedisci.setEnabled(false);
		contentPane.add(btnSpedisci);
		
		JLabel lblOrdiniDaEvadere = new JLabel("Ordini da Evadere:");
		lblOrdiniDaEvadere.setBounds(24, 106, 114, 16);
		contentPane.add(lblOrdiniDaEvadere);
		
		JLabel lblNewLabel = new JLabel("Spedisci con:");
		lblNewLabel.setBounds(337, 26, 119, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(431, 21, 177, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSelezionaOrdine = new JLabel("Seleziona ordine:");
		lblSelezionaOrdine.setBounds(24, 26, 119, 16);
		contentPane.add(lblSelezionaOrdine);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 21, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
	
	
	public void run() {
		try {
			setVisible(true);
			 updateT();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


// metodo per convalida
	public boolean validOrder(int ordine){

		boolean b = false;
		b = gUC.validOrder(ordine);

		return b;
	}

//metodo per convalida
	public boolean validForExit (int ordine){

		boolean b = false;
		b = gUC.validForExit(ordine);

		return b;
	}


	private void setBolla(int codiceO) {

		//"Codice Uscita", "Codice Negozio", "Articolo", "Numero Pezzi", "Data", "spedizioniere"
		//gUM.setCodiceBolla(codiceO);
		gUM.setSpedizioniere(textField.getText());

		gUC.getNegozio(codiceO);
		gUC.newCodiceUscita();

		// cerco gli articoli relativi all'ordine e il numero di pezzi ordinati

		Object[][] articoliOrdinati = gUC.getArticoliOrdinati(codiceO);
		boolean evadibile = false;
		evadibile = gUC.getEvadibilita(articoliOrdinati, articoliOrdinati.length);
		numerorighe = articoliOrdinati.length;

		//se l'ordine risulta evadibile comincio a compilare la tabella
		if (evadibile == true){

			table_1.setModel(new DefaultTableModel(new Object[articoliOrdinati.length][6], new String[] {"Codice Uscita", "Codice Negozio", "Articolo", "Numero Pezzi", "Data", "spedizioniere"}));

			//"Codice Uscita", "Codice Negozio", "Articolo", "Numero Pezzi", "Data", "spedizioniere"
			for (int j = 0; j <  articoliOrdinati.length; j++){
				table_1.setValueAt(gUM.getCodiceBolla(),j,0);
				table_1.setValueAt(gUM.getNegozio(),j,1);
				table_1.setValueAt(articoliOrdinati[j][0],j,2);
				table_1.setValueAt(articoliOrdinati[j][1],j,3);
				table_1.setValueAt(gUM.getData(),j,4);
				table_1.setValueAt(gUM.getSpedizioniere(),j,5);
				//System.out.println(gUM.getCodiceBolla()+" "+gUM.getNegozio()+" "+articoliOrdinati[j][0]+" "+articoliOrdinati[j][1]+" "+gUM.getData()+gUM.getSpedizioniere());

			}

		}
		else{
			//JOptionPane.showMessageDialog(null, "Ordine non evadibile!");
		}
	}




//metodo per richimare il conroller e spedire il tutto
	private void spedisci() {


		//"Codice Uscita", "Codice Negozio", "Articolo", "Numero Pezzi", "Data", "spedizioniere"


		for (int j = 0; j<numerorighe;j++) {

			gUM.setArticolo(table_1.getValueAt(j,2).toString());
			gUM.setPezziPerArticolo(Integer.parseInt(table_1.getValueAt(j,3).toString()));

			gUC.spedisci(gUM.getArticolo(),gUM.getPezziPerArticolo());
		}



	}


	//serve per caricare l'ordine selezionato nella finestra di uscita
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Carica Ordine");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			boolean b = true;
			int codiceO=0;


			// se il codice non è numerico il pulsante non si disattiva
			try{
				codiceO = Integer.parseInt(textField_1.getText());
				b = false;
				b = validOrder(codiceO);

			} catch( NumberFormatException errore ){

				b = true;
				JOptionPane.showMessageDialog(null, "Ordine non valido!");
			}



			if(b == false) {
				// cerco se l'ordine è stato evaso
				b = validForExit(codiceO);
			}

			// quindi se tutti i controlli risultano veri
			//procedo a mettere la bolla provvisoria in tabella
			if (b==false){
				setBolla(codiceO);
			}


			// in base al fatto che l'ordine inserito sia valido o meno il bottone rimane visibile
			btnVisualizza.setEnabled(b);
			if (b==false){
				btnSpedisci.setEnabled(true);
			}

		}
	}






	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Spedisci");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			btnSpedisci.setEnabled(false);

			spedisci();

		}
	}



	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Elimina");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btnVisualizza.setEnabled(true);
			textField_1.setText("");
			textField.setText("");
			 updateT();
		}
	}

	public void updateT() {
		int j;
		int i = 0;
		
		Object[][] o = gUC.getOrdini();
		i = o.length;
			
		table.setModel(new DefaultTableModel(new Object[i][2], new String[]{"Ordine", "Codice Negozio"}));
		
		for (j=0;j<i;j++){
			table.setValueAt(o[j][0],j,0);
			table.setValueAt(o[j][1],j,1);
		}
	}
}
