package Negozio;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

public class OrdineView extends JFrame  {

	private JPanel contentPane;
	private JTextField textArt;
	private JLabel lblInserireQuantit;
	private JTextField textQ;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nuovo_Ordine frame = new Nuovo_Ordine();
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
	public OrdineView(OrdineModel om, OrdineController oc) {
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
		textArt.setBounds(315, 14, 230, 19);
		contentPane.add(textArt);
		textArt.setColumns(10);
		
		lblInserireQuantit = new JLabel("Inserire quantità");
		lblInserireQuantit.setBounds(43, 49, 185, 13);
		contentPane.add(lblInserireQuantit);
		
		textQ = new JTextField();
		textQ.setBounds(315, 45, 130, 19);
		contentPane.add(textQ);
		textQ.setColumns(10);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(719, 67, 101, 21);
		contentPane.add(btnAggiungi);
		
		JButton btnInviaOrdine = new JButton("Invia Ordine");
		btnInviaOrdine.setBounds(719, 392, 87, 21);
		contentPane.add(btnInviaOrdine);
		
		
		//bottone che elimina la finestra
		JButton btnEliminaOrdine = new JButton("Elimina Ordine");
		btnEliminaOrdine.setBounds(614, 392, 99, 21);
		contentPane.add(btnEliminaOrdine);
	
		btnEliminaOrdine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 100, 788, 266);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(scrollPane);
		
		//table = new JTable();
		//scrollPane.setViewportView(table);
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
			},
			new String[] {
				"Negozio", "codice ordine", "data", "articolo", "quantità","Prezzo totale"
			}
		));
     
	
	}
	
	// creo righe di ordine che andranno passate alla finestr NEGOZIO

	
	public void run() {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
