package Magazzino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestioneArticoliView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final Action action = new SwingAction();
	private GestioneArticoliModel gAM;
	private GestioneArticoliController gAC;


	/**
	 * Create the frame.
	 */
	public GestioneArticoliView(GestioneArticoliController gac, GestioneArticoliModel gam) {
		setTitle("Gestione Articoli");
		setResizable(false);

		gAC=gac;
		gAM=gam;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArticoloDaSpostare = new JLabel("Articolo da spostare:");
		lblArticoloDaSpostare.setBounds(41, 37, 143, 16);
		contentPane.add(lblArticoloDaSpostare);
		
		textField = new JTextField();
		textField.setBounds(181, 32, 283, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPosizioneAttuale = new JLabel("Posizione Precedente:");
		lblPosizioneAttuale.setBounds(41, 86, 124, 16);
		contentPane.add(lblPosizioneAttuale);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBounds(181, 81, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNuovaPosizione = new JLabel("Nuova Posizione:");
		lblNuovaPosizione.setBounds(41, 137, 124, 16);
		contentPane.add(lblNuovaPosizione);
		
		textField_2 = new JTextField();
		textField_2.setBounds(181, 132, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(346, 86, 117, 68);
		contentPane.add(btnNewButton);
	}

	public void run() {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//metodo di cambio posizione che chiama il controllore
	public void cambioPos(){

		GestioneArticoliModel gam= this.gAM;
		GestioneArticoliController gac=this.gAC;

		gac.cambioPos();
	}




	//inner class per aggiornare la posizione
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Aggiorna");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			//cambio la posizione dell'articolo e poi metto sul textfield_2 la vecchia posizione

			int art=0;


			if(textField_2.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Inserire una nuova posizione");
			}
			else {

				try {
					art = Integer.parseInt(textField.getText().toString());
					gAM.setArticolo(art);
					gAM.setNewPosizione(textField_2.getText());
					cambioPos();
					textField_1.setText(gAM.getOldPosizione());


				} catch (NumberFormatException NFE) {
					JOptionPane.showMessageDialog(null, "Codice articolo non valido!");
				}
			}



		}
	}
}
