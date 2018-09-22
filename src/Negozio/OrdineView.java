package Negozio;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;

public class OrdineView extends JFrame  {

	private JPanel contentPane;
	private JTextField textArt;
	private JLabel lblInserireQuantit;
	private JTextField textQ;
	private JTable table;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private OrdineModel oM;
	private OrdineController oC;
	private int numriga;
	private JTextField textField;



	/**
	 * Create the frame.
	 */
	public OrdineView(OrdineModel om, OrdineController oc) {
		setResizable(false);
		setTitle("Nuovo Ordine");
		oC = oc;
		oM = om;
		numriga = 0;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 878, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Date data1 = new Date();
		contentPane.setLayout(null);
		
		JLabel lblInserireArticoloDa = new JLabel("Inserire articolo da aggiungere all'ordine:");
		lblInserireArticoloDa.setBounds(43, 18, 260, 13);
		contentPane.add(lblInserireArticoloDa);
		
		textArt = new JTextField();
		textArt.setBounds(315, 14, 398, 19);
		contentPane.add(textArt);
		textArt.setColumns(10);
		
		lblInserireQuantit = new JLabel("Inserire numeropezzi");
		lblInserireQuantit.setBounds(43, 49, 185, 13);
		contentPane.add(lblInserireQuantit);
		
		textQ = new JTextField();
		textQ.setBounds(315, 45, 130, 19);
		contentPane.add(textQ);
		textQ.setColumns(10);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setAction(action);
		btnAggiungi.setBounds(719, 67, 101, 21);
		contentPane.add(btnAggiungi);
		
		JButton btnInviaOrdine = new JButton("Invia Ordine");
		btnInviaOrdine.setAction(action_1);
		btnInviaOrdine.setBounds(42, 392, 101, 29);
		contentPane.add(btnInviaOrdine);
		
		
		//bottone che elimina la finestra
		JButton btnEliminaOrdine = new JButton("Elimina Ordine");
		btnEliminaOrdine.setAction(action_2);
		btnEliminaOrdine.setBounds(155, 392, 149, 29);
		contentPane.add(btnEliminaOrdine);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 100, 788, 266);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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
				"Negozio", "codice ordine", "data", "articolo", "numeropezzi","Prezzo totale"
			}
		));

		scrollPane.setViewportView(table);
		
		JLabel lblPrezzoComplessivoOrdine = new JLabel("prezzo complessivo ordine:");
		lblPrezzoComplessivoOrdine.setBounds(503, 392, 185, 16);
		contentPane.add(lblPrezzoComplessivoOrdine);
		
		textField = new JTextField();
		textField.setBounds(700, 387, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	// creo righe di ordine che andranno passate alla finestra NEGOZIO

	
	public void run() {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//metodo per aggiungere una riga alla tabella articolo
	public void aggiugi(String articolo, int  numeropezzi){
		OrdineModel om = this.oM;
		OrdineController oc = this.oC;

		oM.setArticolo(articolo);
		oM.setNumeroPezzi(numeropezzi);

		oc.aggiungi();
		Object[] rigaO = new Object[6];
		//Object[] rigaO =oc.aggiungi();

		//se ha prodotto un valore uguale a zero di prezzo non e' utile ai fini dell'ordine e quindi la riga non viene inserita
		if (om.getPrezzo()==0.0) {
			JOptionPane.showMessageDialog(null, "ARTICOLO " + articolo + " non presente in magazzino");

			//System.out.println(rigaO[3] + " " + rigaO[5]);
			//System.out.println(rigaO[0] + " " + rigaO[1] + " " + rigaO[2] + " " + rigaO[3] + " " + rigaO[4] + " " + rigaO[5]);

		}
		else {
			rigaO[0] = om.getNegO();
			rigaO[1] = om.getCodiceO();
			rigaO[2] = om.getDataOS();
			rigaO[3] = om.getArticolo();
			rigaO[4] = om.getNumeroPezzi();
			rigaO[5] = om.getPrezzo();

			boolean b= false;

			//se ho gia' inserito almeno una riga di ordine
			if (numriga>0) {

				//si assicura che nessuno degli ordini prima si ripeta
				for(int j = numriga-1; j >= 0; j--){

					String z = table.getValueAt(j,3).toString();
					if (z.equals(om.getArticolo())){
						// se si ripete b viene settato true
						b=true;
					}

				}
			}

			//se non si e' ripetuto inserisce come da programma
			if (b == false) {
				for (int j = 0; j < 6; j++) {

					table.setValueAt(rigaO[j], numriga, j);

				}
				numriga++;
			}
			//altrimenti scrive un messaggio e non fa nulla
			else{
				JOptionPane.showMessageDialog(null, "ARTICOLO " + articolo + " gia' presente nell'ordine");
			}
		}
	}


	// metodo per chiedere al controller di far partire l'inserimento della riga di ordine nel database
	public void insert(){
		OrdineModel om = oM;
		OrdineController oc =oC;
		oC.insert();


	}


	// inner class per inserire articolo in tabella
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Aggiungi");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			int numeroarticoli = 0;
						
			try {
				numeroarticoli=Integer.parseInt(textQ.getText());
			}
			
			catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Compilazione Campi Errata");
	        }


			aggiugi(textArt.getText(),numeroarticoli);
			
			Object o = oM.getPrezzo_complessivo();// devo mettere sul prezzo complessivo il prezzo complessivo del modello
			String s = o.toString();
			textField.setText(s);
		}
	}
	
	
	// da settare invia ordine :i campi dell'ordine da aggiungere al database si trovano nella jTable


	//inner class per inserire l'ordine in database
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Invia ordine");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			// disabilito il bottone inserisci


			JButton b = (JButton) e.getSource();
			b.setEnabled(false);
			
			
			//per inserire passo al modello di volta in volta un articolo diverso
			//e lo faccio insertire dal controller
			//tramite una chiamaata a database
			
			for (int j = 0; j< numriga; j++){

				oM.setArticolo(table.getValueAt(j,3).toString());
				oM.setNumeroPezzi(Integer.parseInt(table.getValueAt(j,4).toString()));
				oM.setPrezzo(Float.parseFloat(table.getValueAt(j,5).toString()));

				insert();

			}
			if(oM.getArticolo() == null || oM.getPrezzo() <= 0 || oM.getNumeroPezzi() <= 0) {
				JOptionPane.showMessageDialog(null, "Errore Nella Compilazione Dei Campi! ");
				b.setEnabled(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "ordine inserito ");
				b.setEnabled(true);
			}
		}
	}



	
	//inner class per eliminare ordine
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Elimina Ordine");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {


			numriga = 0;
			oM.setPrezzo_complessivo(0);
			textField.setText("");
			
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
						"Negozio", "codice ordine", "data", "articolo", "numeropezzi","Prezzo totale"
					}
				));

		}
	}
}
