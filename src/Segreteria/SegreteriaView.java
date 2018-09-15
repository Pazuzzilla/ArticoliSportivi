package Segreteria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.LoginController;
import Login.LoginObservedModel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class SegreteriaView extends JFrame {

	private JPanel contentPane;
	private SegreteriaController SegreteriaController;
	private SegreteriaModel SegreteriaModel;
	private final Apripannello action = new Apripannello();

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegreteriaView frame = new SegreteriaView();
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
	public SegreteriaView(SegreteriaController sc, SegreteriaModel sm) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		SegreteriaController=sc;
		SegreteriaModel=sm;
		
		JButton btnInserireNuovoArticolo = new JButton("Inserire nuovo articolo");
		/*btnInserireNuovoArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		btnInserireNuovoArticolo.setAction(action);
		contentPane.add(btnInserireNuovoArticolo, BorderLayout.NORTH);
	}
	
	public void run() {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void OpenNA() {
		SegreteriaController c1 =this.SegreteriaController;
		
		c1.Openna();
	}
	
	//Azione per far Partire l'inerfaccia di nuovoarticolo
	private class Apripannello extends AbstractAction {
		public Apripannello() {
			putValue(NAME, "Inserire nuovo articolo");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			OpenNA();
		}
	}
	
}
