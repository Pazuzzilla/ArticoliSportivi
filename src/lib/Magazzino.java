package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;

public class Magazzino extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Magazzino frame = new Magazzino();
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
	public Magazzino() {
		setTitle("Magazzino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnGestioneIngressi = new JButton("Gestione Ingressi");
		btnGestioneIngressi.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnGestioneIngressi);
		
		JButton btnGestioneUscite = new JButton("Gestione Uscite");
		btnGestioneUscite.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnGestioneUscite);
		
		JButton btnGestioneUbicazioni = new JButton("Gestione Ubicazioni");
		btnGestioneUbicazioni.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(btnGestioneUbicazioni);
	}

}
