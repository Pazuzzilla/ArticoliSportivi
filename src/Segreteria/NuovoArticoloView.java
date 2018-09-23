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
	private JTextField textField_4;


	/**
	 * Create the frame.
	 */
	public NuovoArticoloView(NuovoArticoloController nac , NuovoArticoloObserved nao) {
		setTitle("Inserimento nuovo articolo");
		setResizable(false);
		
		NAO=nao;
		NAC=nac;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 608, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblInserireInformazioniRiguardanti = new JLabel("Immettere informazioni riguardanti il nuovo articolo da inserire");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblInserireInformazioniRiguardanti, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblInserireInformazioniRiguardanti, 463, SpringLayout.WEST, contentPane);
		lblInserireInformazioniRiguardanti.setFont(new Font("Al Nile", Font.PLAIN, 13));
		contentPane.add(lblInserireInformazioniRiguardanti);
		
		JLabel lblNomeArticolo = new JLabel("Nome Articolo:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNomeArticolo, 20, SpringLayout.SOUTH, lblInserireInformazioniRiguardanti);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblInserireInformazioniRiguardanti, 0, SpringLayout.WEST, lblNomeArticolo);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNomeArticolo, 23, SpringLayout.WEST, contentPane);
		contentPane.add(lblNomeArticolo);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -5, SpringLayout.NORTH, lblNomeArticolo);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNomeArticolo);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -158, SpringLayout.EAST, contentPane);
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
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -34, SpringLayout.EAST, contentPane);
		btnNewButton.setAction(action);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -34, SpringLayout.EAST, contentPane);
		btnNewButton_1.setAction(action_1);
		contentPane.add(btnNewButton_1);
		
		textField_3 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_3, 124, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_3, -5, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_3, 465, SpringLayout.EAST, lblNewLabel);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPrezzo, 20, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPrezzo, 0, SpringLayout.WEST, lblNomeArticolo);
		contentPane.add(lblPrezzo);
		
		textField_4 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_4, -5, SpringLayout.NORTH, lblPrezzo);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField_1);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
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
	
	
	public void insert() throws SQLException {
		NuovoArticoloController nac=this.NAC;	
		nac.insert(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText());
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
	
	//Classe per richiedere l'effettiva aggiunta dell'articolo nel database
	private class Inserisci extends AbstractAction {
		public Inserisci() {
			putValue(NAME, "Inserisci");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				insert();
				//textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
