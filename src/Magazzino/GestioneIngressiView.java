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
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

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
	//private final Action action = new SwingAction();


	/**
	 * Create the frame.
	 */
	public GestioneIngressiView() {
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
		/*
		JLabel lblNuovoCodiceDi = new JLabel("Nuovo codice di magazzino:");
		lblNuovoCodiceDi.setBounds(468, 38, 172, 16);
		lblNuovoCodiceDi.setBackground(new Color(255, 0, 0));
		contentPane.add(lblNuovoCodiceDi);
		
		text_newcode = new JTextField();
		text_newcode.setBounds(652, 33, 172, 26);
		contentPane.add(text_newcode);
		text_newcode.setColumns(10);
		
		JLabel lblNuovaUbicazione = new JLabel("Nuova ubicazione:");
		lblNuovaUbicazione.setBounds(468, 82, 118, 16);
		contentPane.add(lblNuovaUbicazione);
		
		text_newub = new JTextField();
		text_newub.setBounds(652, 77, 172, 26);
		contentPane.add(text_newub);
		text_newub.setColumns(10);
		*/
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
		//btnInserisci.setAction(action);
		btnInserisci.setBounds(638, 437, 143, 43);
		contentPane.add(btnInserisci);
		
		day = new JTextField();
		day.setBounds(264, 124, 51, 26);
		contentPane.add(day);
		day.setColumns(10);
	}

	public void run() {
		try {
			GestioneIngressiView frame = new GestioneIngressiView();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			//Inserisci();
		}
	}
}
