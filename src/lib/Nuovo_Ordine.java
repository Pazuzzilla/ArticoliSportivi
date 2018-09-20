package lib;
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

public class Nuovo_Ordine extends JFrame  {

	private JPanel contentPane;
	private JTextField textField;
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
	public Nuovo_Ordine() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 878, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		Date data1 = new Date();

		
		JLabel lblInserireCodiceNegozio = new JLabel("Inserire codice negozio:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblInserireCodiceNegozio, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblInserireCodiceNegozio, 38, SpringLayout.WEST, contentPane);
		contentPane.add(lblInserireCodiceNegozio);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -5, SpringLayout.NORTH, lblInserireCodiceNegozio);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblInserireCodiceNegozio);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -487, SpringLayout.EAST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblInserireArticoloDa = new JLabel("Inserire articolo da aggiungere all'ordine:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblInserireArticoloDa, 9, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblInserireArticoloDa, 0, SpringLayout.WEST, lblInserireCodiceNegozio);
		contentPane.add(lblInserireArticoloDa);
		
		textArt = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArt, 6, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArt, 6, SpringLayout.EAST, lblInserireArticoloDa);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArt, -390, SpringLayout.EAST, contentPane);
		contentPane.add(textArt);
		textArt.setColumns(10);
		
		lblInserireQuantit = new JLabel("Inserire numero pezzi");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblInserireQuantit, 16, SpringLayout.SOUTH, lblInserireArticoloDa);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblInserireQuantit, 0, SpringLayout.WEST, lblInserireCodiceNegozio);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblInserireQuantit, -749, SpringLayout.EAST, contentPane);
		contentPane.add(lblInserireQuantit);
		
		textQ = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textQ, -5, SpringLayout.NORTH, lblInserireQuantit);
		sl_contentPane.putConstraint(SpringLayout.WEST, textQ, 6, SpringLayout.EAST, lblInserireQuantit);
		sl_contentPane.putConstraint(SpringLayout.EAST, textQ, -613, SpringLayout.EAST, contentPane);
		contentPane.add(textQ);
		textQ.setColumns(10);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAggiungi, 473, SpringLayout.EAST, textQ);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAggiungi, -39, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAggiungi, 0, SpringLayout.NORTH, lblInserireQuantit);
		contentPane.add(btnAggiungi);
		
		JButton btnInviaOrdine = new JButton("Invia Ordine");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnInviaOrdine, 0, SpringLayout.WEST, btnAggiungi);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnInviaOrdine, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnInviaOrdine);
		
		
		//bottone che elimina la finestra
		JButton btnEliminaOrdine = new JButton("Elimina Ordine");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEliminaOrdine, 0, SpringLayout.NORTH, btnInviaOrdine);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEliminaOrdine, -6, SpringLayout.WEST, btnInviaOrdine);
		contentPane.add(btnEliminaOrdine);
	
		btnEliminaOrdine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 12, SpringLayout.SOUTH, btnAggiungi);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, -815, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 278, SpringLayout.SOUTH, btnAggiungi);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -27, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane);
		
		//table = new JTable();
		//scrollPane.setViewportView(table);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Negozio", "codice ordine", "data", "articolo", "numero pezzi"
			}
		));
     
	
	}
	
	// creo righe di ordine che andranno passate alla finestr NEGOZIO
	public Ordine_Negozio GetOrder() {
		Ordine_Negozio ON = new Ordine_Negozio();
		Date Data = new Date();
		ON.setcodNeg(textField.getText());
		ON.setart(textArt.getText());
		ON.setDate(Data);
		ON.setQ(Integer.parseInt(textQ.getText()));

		
		return ON;
	}
	
	
	public void run() {
		try {
			Nuovo_Ordine frame = new Nuovo_Ordine();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
