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
	private final Apripannello action = new Apripannello();
	private final Action action_1 = new SwingAction();


	/**
	 * Create the frame.
	 */
	public SegreteriaView(SegreteriaController sc) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		SegreteriaController=sc;
		
		JButton btnInserireNuovoArticolo = new JButton("Inserire nuovo articolo");
		/*btnInserireNuovoArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		btnInserireNuovoArticolo.setAction(action);
		contentPane.add(btnInserireNuovoArticolo, BorderLayout.WEST);
		
		JButton btnVisualizzaMovimentiMagazzino = new JButton("Visualizza Movimenti magazzino");
		btnVisualizzaMovimentiMagazzino.setAction(action_1);
		contentPane.add(btnVisualizzaMovimentiMagazzino, BorderLayout.EAST);
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

	public void openVMM() {
		SegreteriaController c1 =this.SegreteriaController;
		
		c1.openVMM();
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
	
	//Azione per aprire l'interfaccia di visualizzazzione di un ordine in base al negozio
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Visualizza Movimenti magazzino");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			openVMM();
		}
	}
}
