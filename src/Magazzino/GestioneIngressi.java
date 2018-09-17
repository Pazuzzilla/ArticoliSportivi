package Magazzino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestioneIngressi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneIngressi frame = new GestioneIngressi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestioneIngressi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArticolo = new JLabel("Articolo:");
		lblArticolo.setBounds(44, 38, 61, 16);
		contentPane.add(lblArticolo);
		
		textField = new JTextField();
		textField.setBounds(117, 33, 238, 26);
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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(275, 124, 43, 26);
		contentPane.add(formattedTextField);
		
		JLabel label = new JLabel("/");
		label.setBounds(316, 129, 14, 16);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("/");
		lblNewLabel.setBounds(370, 129, 14, 16);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(326, 124, 43, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(380, 124, 79, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNuovoCodiceDi = new JLabel("Nuovo codice di magazzino:");
		lblNuovoCodiceDi.setBounds(468, 38, 172, 16);
		lblNuovoCodiceDi.setBackground(new Color(255, 0, 0));
		contentPane.add(lblNuovoCodiceDi);
		
		textField_4 = new JTextField();
		textField_4.setBounds(652, 33, 172, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNuovaUbicazione = new JLabel("Nuova ubicazione:");
		lblNuovaUbicazione.setBounds(468, 82, 118, 16);
		contentPane.add(lblNuovaUbicazione);
		
		textField_5 = new JTextField();
		textField_5.setBounds(652, 77, 172, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 174, 724, 227);
		contentPane.add(scrollPane);
		
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
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(638, 437, 118, 26);
		contentPane.add(btnInserisci);
	}
}
