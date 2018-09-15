package Segreteria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.Action;

public class NuovoArticoloView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final Action action = new Verifica();
	private final Action action_1 = new Inserisci();
	private NuovoArticoloController NAC;
	private NuovoArticoloObserved NAO;
	private JTextField textField_3;


	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuovoArticoloView frame = new NuovoArticoloView();
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
	public NuovoArticoloView(NuovoArticoloController nac , NuovoArticoloObserved nao) {
		
		NAO=nao;
		NAC=nac;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 608, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblInserireInformazioniRiguardanti = new JLabel("Inserire informazioni riguardanti il nuovo articolo da inserire");
		lblInserireInformazioniRiguardanti.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblInserireInformazioniRiguardanti, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblInserireInformazioniRiguardanti, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblInserireInformazioniRiguardanti, 445, SpringLayout.WEST, contentPane);
		contentPane.add(lblInserireInformazioniRiguardanti);
		
		JLabel lblNomeArticolo = new JLabel("Nome Articolo:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNomeArticolo, 25, SpringLayout.SOUTH, lblInserireInformazioniRiguardanti);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNomeArticolo, 23, SpringLayout.WEST, contentPane);
		contentPane.add(lblNomeArticolo);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -5, SpringLayout.NORTH, lblNomeArticolo);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNomeArticolo);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -5, SpringLayout.EAST, lblInserireInformazioniRiguardanti);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSport = new JLabel("sport:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSport, 14, SpringLayout.SOUTH, lblNomeArticolo);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSport, 0, SpringLayout.WEST, lblNomeArticolo);
		contentPane.add(lblSport);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -5, SpringLayout.NORTH, lblSport);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMateriale = new JLabel("materiale/i:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMateriale, 15, SpringLayout.SOUTH, lblSport);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMateriale, 0, SpringLayout.WEST, lblNomeArticolo);
		contentPane.add(lblMateriale);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, -5, SpringLayout.NORTH, lblMateriale);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, -344, SpringLayout.EAST, contentPane);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("descrizione:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 20, SpringLayout.SOUTH, lblMateriale);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNomeArticolo);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Verifica Esistenza");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, -5, SpringLayout.NORTH, lblNomeArticolo);
		btnNewButton.setAction(action);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, contentPane);
		btnNewButton_1.setAction(action_1);
		contentPane.add(btnNewButton_1);
		
		textField_3 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, textField_3);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_3, -5, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_3, 465, SpringLayout.EAST, lblNewLabel);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
	

	public void run() {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//metodo richiamato dalla private class Verifica; 
	//passa la domanda al controller che possiede il metodo di controllo a database
	public void Exist(String articolo) throws ClassNotFoundException, NullPointerException, SQLException {
		 NuovoArticoloController Nac= this.NAC;
		 //NuovoArticoloObserved Nao = this.NAO;
		 Nac.Exist(articolo);
		
	}
	
	
	//Classe per Verificare l'esistenza di un articolo in magazzino
	private class Verifica extends AbstractAction {
		public Verifica() {
			putValue(NAME, "Verifica");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Exist(textField.getText());
			} catch (ClassNotFoundException | NullPointerException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
	private class Inserisci extends AbstractAction {
		public Inserisci() {
			putValue(NAME, "Inserisci");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}

}